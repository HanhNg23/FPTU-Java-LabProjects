package com.example.demo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserService;

import lombok.AllArgsConstructor;

/* The configuration creates a Servlet Filter known as the springSecurityFilterChain,
 * which is responsible for all the security (protecting the application URLs,
 * validating submitted username and passwords, redirecting to the log in form,
 * and so on) within your application*/
//Recommend source: https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {
	
	private final AppUserService appUserService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder; 
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
		.csrf((csrf) -> csrf.disable())
		.authorizeHttpRequests((auth) ->
			auth
				.requestMatchers("/api/v*/registration/**").permitAll()
				.anyRequest().authenticated()
				)
		.formLogin(withDefaults());

		return http.build();

	}
	


	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(bCryptPasswordEncoder);
		provider.setUserDetailsService(appUserService); //this will set SecurityContext 
		return provider;
	}
	
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.authenticationProvider(daoAuthenticationProvider());
    }
	


}
