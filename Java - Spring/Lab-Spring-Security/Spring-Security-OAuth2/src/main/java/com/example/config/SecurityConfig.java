package com.example.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityConfigFilter(HttpSecurity http) throws Exception {
		
		
//		========= Set for default login with form and social link =========
//		http
//			.csrf(c -> c.disable())
//			.authorizeHttpRequests(a -> a
//					.requestMatchers("/home").permitAll()
//					.anyRequest().authenticated()					
//					)
//			.oauth2Login(o -> o.defaultSuccessUrl("/login_success",true))
//			.httpBasic(withDefaults())
//			.formLogin(withDefaults())
//			;
		
		
		http
		.authorizeHttpRequests(a -> a
				.requestMatchers("/oauth_login", "/errors/**").permitAll()
				.anyRequest().authenticated()
			)
//			.exceptionHandling(e -> e
//				.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//			) //not use this 
			.oauth2Login(o -> o
					.loginPage("/oauth_login")
					.defaultSuccessUrl("/login_success",true)
					.failureUrl("/loginFailure")
					.authorizationEndpoint(enpoint -> enpoint //Custom Authorization Endpoint
							.baseUri("/oauth2/authorize-client") /* modified the baseUri to /oauth2/authorize-client
							 										instead of the default /oauth2/authorization.*/
							.authorizationRequestRepository(authorizationRequestRepository())
							)
					.tokenEndpoint(token -> token //Custom Token Endpoint
							.accessTokenResponseClient(accessTokenResponseClient())
							)
					.redirectionEndpoint(redirect -> redirect
							.baseUri("/oauth2/redirect/*")) //the default uri: login/oauth2/code/*
					);
		

		return http.build();
	}
	
	

	
	@Bean
	public AuthorizationRequestRepository<OAuth2AuthorizationRequest> 
	  authorizationRequestRepository() {
	 
	    return new HttpSessionOAuth2AuthorizationRequestRepository();
	}
	
	
	@Bean
	public OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> accessTokenResponseClient(){
		
		return new DefaultAuthorizationCodeTokenResponseClient();
	}
	
	

	
	

}
