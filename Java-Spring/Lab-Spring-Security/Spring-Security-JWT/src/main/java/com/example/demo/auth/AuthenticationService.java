package com.example.demo.auth;
//New

import java.io.IOException;
import java.net.http.HttpHeaders;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.config.JwtService;
import com.example.demo.token.Token;
import com.example.demo.token.TokenRepository;
import com.example.demo.token.TokenType;
import com.example.demo.user.Role;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final PasswordEncoder passwordEncoder;
	private final UserRepository repository;
	private final AuthenticationManager authMana;
	private final JwtService jwtService;
	private final TokenRepository tokenRepo;
	
	
	public AuthenticationResponse register(RegisterRequest request) {
		
	System.out.format("FName: %s - LName: %s - Email: %s - Pass: %s \n",
						request.getFirstname(),
						request.getLastname(),
						request.getEmail(),
						request.getPassword() );
		
	User user = User.builder()
			.firstname(request.getFirstname())
			.lastname(request.getLastname())
			.email(request.getEmail())
			.password(passwordEncoder.encode(request.getPassword()))
			.role(Role.ADMIN)
			.build();
	
	System.out.println("NEW_USER : " + user.toString());
	
	User savedUser = repository.save(user); //Should create a UserService class for validate before save, update, delete, show
	String jwtsToken = jwtService.generateTokenForUser(user);
	String refreshToken = jwtService.generateRefreshTokenForUser(user);
	this.saveUserToken(savedUser, jwtsToken);
	
	AuthenticationResponse authenResponse = AuthenticationResponse
			.builder()
			.accessToken(jwtsToken)
			.refreshToken(refreshToken)
			.extraStatement("AUTHENTICATION: " + user.toString())
			.build();
	
	return authenResponse;
}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		
		/*In order to set the authentication on the request and hence,
		 *make it available for all subsequent requests from the client,
		 *----> we need to manually "set the SecurityContext" containing the
		 *Authentication in the HTTP session:*/
		System.out.format("Email: %s - Pass: %s \n",
				request.getEmail(),
				request.getPassword() 
				);
		Authentication authReq =
				new UsernamePasswordAuthenticationToken(
						request.getEmail(),
						request.getPassword());
		authReq = authMana.authenticate(authReq);


		SecurityContext securitycontext = SecurityContextHolder.getContext();
		System.out.println(" SE_CONTEXT securitycontext: " + securitycontext.toString());
		
		// retrieve the currently authenticated principal via a static call to the SecurityContextHolder:
		Authentication currentAuthentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(" SE_current_Authen::: " + 
							" - getPrincipleName: " + currentAuthentication.getName()+
							" - getDetails: " + currentAuthentication.getDetails().toString()+
							" - getPrincipal:" + currentAuthentication.getPrincipal().toString()+
							" - getCredentials" + currentAuthentication.getCredentials().toString()+
							" - getAuthorities" + currentAuthentication.getAuthorities().toString()
				);
		
		User user = repository.findByEmail(request.getEmail())
				.orElseThrow();
		
		String jwtsToken = jwtService.generateTokenForUser(user);
		String refresToken = jwtService.generateRefreshTokenForUser(user);
		this.revokeAllUserTokens(user);
		this.saveUserToken(user, jwtsToken);
		AuthenticationResponse authenResponse = AuthenticationResponse
				.builder()
				.accessToken(jwtsToken)
				.refreshToken(refresToken)
				.extraStatement("AUTHENTICATE OK :"  + user.toString() )
				.build();
		
		return authenResponse;
		
	}
	
	
	private void saveUserToken(User user, String jwtToken) {
		Token token = Token.builder()
				.user(user)
				.token(jwtToken)
				.tokenType(TokenType.BEARER)
				.expired(false)
				.revoked(false)
				.build();
		tokenRepo.save(token);

	}
	
	private void revokeAllUserTokens(User user) {
		List<Token> validUserTokens = tokenRepo.findAllValidTokenByUser(user.getId());
		
		if(validUserTokens.isEmpty()) {
			return;
		}
		validUserTokens.forEach(token -> {
			token.setExpired(true);
			token.setRevoked(true);
		});
		tokenRepo.saveAll(validUserTokens);
	}
	
	public void refreshToken( HttpServletRequest request,
	          HttpServletResponse response) throws IOException{
		final String authHeader = request.getHeader("Authorization");
	    final String refreshToken;
	    final String userEmail;
	    
	    if(authHeader == null || !authHeader.startsWith("Bearer ")) {
	    	return;
	    }
	    refreshToken = authHeader.substring(7);
	    userEmail = jwtService.extractUsername(refreshToken);
	    if(userEmail != null) {
	    	User user = repository.findByEmail(userEmail).orElseThrow();
	    	
	    	
	    	if(jwtService.isTokenValid(refreshToken, user)) {
	    		String newAccessToken = jwtService.generateTokenForUser(user);
	    		this.revokeAllUserTokens(user);
	    		this.saveUserToken(user, newAccessToken);
	    		AuthenticationResponse authResponse = AuthenticationResponse.builder()
	    				.accessToken(newAccessToken)
	    				.refreshToken(refreshToken)
	    				.build();
	    		 new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
	    	}
	    	
	    }
	    
		
		
		
		
	}
	
	
	
	
	
	
	
}
