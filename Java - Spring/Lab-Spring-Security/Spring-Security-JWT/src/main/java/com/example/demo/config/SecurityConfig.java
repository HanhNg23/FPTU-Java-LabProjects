package com.example.demo.config;
//New

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;

import static com.example.demo.user.Role.ADMIN;
import static com.example.demo.user.Role.USER;
import static com.example.demo.user.Role.MANAGER;
import static com.example.demo.user.Permission.ADMIN_CREATE;
import static com.example.demo.user.Permission.ADMIN_DELETE;
import static com.example.demo.user.Permission.ADMIN_READ;
import static com.example.demo.user.Permission.ADMIN_UPDATE;
import static com.example.demo.user.Permission.MANAGER_CREATE;
import static com.example.demo.user.Permission.MANAGER_UPDATE;
import static com.example.demo.user.Permission.MANAGER_DELETE;
import static com.example.demo.user.Permission.MANAGER_READ;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

	private final AuthenticationProvider authenticationProvider;
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userrepo;
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final LogoutHandler logoutHandler;
	/*UserDetialsManager implements UserDetailsService to manage and store all UserDetails instances
	  InMemoryUserDetailsManager implements UserDetailsManager - store and manage UserDetails in thread-local
	*/
	 
	public UserDetailsService userDetailsService() {
		User user1 = User.builder()
				.email("user1")
				.password(passwordEncoder.encode("pass"))
				.role(USER)
				.build();
		User user2 = User.builder()
				.email("user2")
				.password(passwordEncoder.encode("pass2"))
				.role(ADMIN)
				.build();
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(user1);
		userrepo.save(user2);
		
		return manager;
		//we can retunr in shortway : return new InMemoryUserDetailsManager(user1, user2);	
	}
	
	
	//@Bean
	public AuthenticationManager authManager(HttpSecurity http) throws Exception{
		AuthenticationManagerBuilder authenticationManagerBuilder = 
				http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.authenticationProvider(authenticationProvider);
		
		return authenticationManagerBuilder.build();
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http
			.csrf().disable()
			.authorizeHttpRequests()
				.requestMatchers("/api/v*/auth/**").permitAll()
				
				.requestMatchers("/api/v1/management/**").hasAnyRole(ADMIN.name(), MANAGER.name())
				.requestMatchers(HttpMethod.GET, "/api/v1/management/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())
				.requestMatchers(HttpMethod.POST, "/api/v1/management/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
				.requestMatchers(HttpMethod.PUT, "/api/v1/management/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name())
				.requestMatchers(HttpMethod.DELETE, "/api/v1/management/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name())
				.anyRequest().authenticated()
			.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//STATELESS TO DO NOT REMEMBER the authentication in security context of authenticated user
			.and()
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
			.logout()
				.logoutUrl("url")
				.addLogoutHandler(logoutHandler)
				.logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())// .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
				.logoutSuccessUrl("/api/v1/auth/myhome").permitAll()
			
			;
		return http.build();
	}
	
}
