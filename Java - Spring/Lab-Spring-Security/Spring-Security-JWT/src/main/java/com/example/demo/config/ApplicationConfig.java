package com.example.demo.config;
//New
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.example.demo.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
	
	//this area is use to set up user authentication by Authentication Manager

	private final UserRepository userRepository;
	
/* == Retrieving a username, a password, and other attributes for authenticating
with a username and password - Work as User DAO == */
	
/*	public UserDetailsService userDetailsService() {
		UserDetailsService userdetail = new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Not found user !"));
			}
		};
		return userdetail;
	} */
	
	@Bean
	public UserDetailsService userDetailsService() {
		return username -> userRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("Not found user !"));
	}
	
	//Define the method authenticationProvider to authenticate user
	@Bean
	public AuthenticationProvider authenticationProvider() {		
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	//Register authentication provider 
	//This will call this AuthenticationProvider Bean for authentication
	@Bean 
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config ) throws Exception {
		return config.getAuthenticationManager();
	}
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//   }
	
}
