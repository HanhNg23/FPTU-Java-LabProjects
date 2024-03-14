package com.example.demo.config;
//New
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import com.example.demo.token.Token;
import com.example.demo.token.TokenRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

/*While using logoutSuccessUrl will suffice for most cases, 
 *you may need to do something different from redirecting to a URL once
  logout is complete. LogoutSuccessHandler is the Spring Security component
  for customizing logout success actions.
*/
//Custom LogoutSuccessHandler
@Service
@AllArgsConstructor
public class LogoutService implements LogoutHandler {
private TokenRepository tokenRepo ;
	
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		final String authHeader = request.getHeader("Authorization");
		final String jwts;
		
		if(authHeader == null || !authHeader.startsWith("Bearer ")) {
			return;
		}
		jwts = authHeader.substring(7);
		Token storedToken = tokenRepo.findByToken(jwts).orElse(null);
		if(storedToken != null) {
			storedToken.setExpired(true); //because the token is client can not access to delete so that we have to set true for Expired and Revoked of Token Properties
			storedToken.setRevoked(true);
			tokenRepo.save(storedToken);
			SecurityContextHolder.clearContext();	
		}
	}

	
	
	
}
