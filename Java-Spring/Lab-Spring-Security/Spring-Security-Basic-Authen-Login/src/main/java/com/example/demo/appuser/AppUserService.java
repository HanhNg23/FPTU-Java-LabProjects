package com.example.demo.appuser;

import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.registration.token.ConfirmationToken;
import com.example.demo.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService{
	private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
	private final static String DUPLICATE_USER_MSG = "email already has already registered please turn back to login";
	private final AppUserRepository appUserRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ConfirmationTokenService confirmationTokenService;
	
 @Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
	return appUserRepository.findByEmail(email)
			.orElseThrow(() -> 
			new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
}
 
 public String signUpUser(AppUser appUser) throws Exception  {
	 System.out.println(appUser.toString());
	// TODO: Check if user has existed
	 
	 boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
	 if(userExists) {
		 throw new IllegalStateException(DUPLICATE_USER_MSG);
	 }
		 //have registered but not be enabled
		 //--> have not login because token is expired --> refresh token
	 
	// TODO: Encrypt password and update new password to encrypted password
	String encodedPassword = bCryptPasswordEncoder
							.encode(appUser.getPassword());
	 appUser.setPassword(encodedPassword);
	 //save new signed user to the repository for manage
	 
	// TODO: Save new user account to app user repository
	 appUserRepository.save(appUser);
	 
	 // TODO: Send confirmation Token
	 
	 	//first: set up ConfirmationToke Object
	 
	 	//create UUID token like a random token ?
	 
	 String token = UUID.randomUUID().toString();
	 ConfirmationToken confirmationToken = new ConfirmationToken(
			 token,
			 LocalDateTime.now(), //create at
			 LocalDateTime.now().plusMinutes(15), //expire at
			 appUser
			 );
	 //second: save token to the token repository
	 confirmationTokenService.saveConfirmationToken(
			 confirmationToken);
	 
		System.out.println("<p>" + "success " + appUserRepository.findByEmail(appUser.getEmail()).toString() + " : " + "Token: " + token + "</p");
		return token;
}
 //may be enable for login officially
 public int enableAppUser(String email) {
	 return appUserRepository.enableAppUser(email);
 }
 
 
}
