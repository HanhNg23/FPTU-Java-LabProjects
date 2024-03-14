package com.example.demo.config;
//New
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.example.demo.token.TokenRepository;
import com.freethebrain.config.AppProperties;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	private final JwtService jwtService;
	private final UserDetailsService userDetailsService;
	private final TokenRepository tokenRepository;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
									HttpServletResponse response, 
									FilterChain filterChain)
			throws ServletException, IOException {

		
		final String authHeader;
		final String accessToken;
		final String refreshToken;
		final String jwts ;
		final String userMail;
		
		authHeader = request.getHeader("Authorization");

		
		
		// Check Token exists
		//Bearer:<token string here start at index 7>
		if(authHeader != null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
			
		
			
		jwts = authHeader.substring(7);
		userMail = jwtService.extractUsername(jwts);
		//Let authentication processing
		if(userMail != null && SecurityContextHolder.getContext().getAuthentication() == null 
				/*this user has not been authenticated yet*/) {
			UserDetails userdetails =  this.userDetailsService.loadUserByUsername(userMail);
			
			
			System.out.println("USER DETAILS Load FROM UserMail In Token " + userdetails.toString());
			
			//check token expiration in database
			boolean isTokenDBValid = tokenRepository.findByToken(jwts)
											.map((t) -> !t.isExpired() && !t.isRevoked()).orElse(false); 
			
			//check token expiration in authHeader
			boolean isTokenClientValid = jwtService.isTokenValid(jwts, userdetails); 
			
			if(isTokenDBValid && isTokenClientValid ) {
				UsernamePasswordAuthenticationToken authenicationToken = new UsernamePasswordAuthenticationToken(
						userdetails,
						null, //not get password 
						userdetails.getAuthorities());
				
				//Save to the security context for subrequests require authentication
				authenicationToken.setDetails(
						new WebAuthenticationDetailsSource().buildDetails(request)); //for what
				//When authenticated successfully --> save in SecurityContextHoleder
				SecurityContextHolder.getContext().setAuthentication(authenicationToken);
				System.out.println("[AuthenticationFilter] SecurityContext Get Authentication: " +  SecurityContextHolder.getContext().getAuthentication());

			}

		}
		filterChain.doFilter(request, response);
	}

}
