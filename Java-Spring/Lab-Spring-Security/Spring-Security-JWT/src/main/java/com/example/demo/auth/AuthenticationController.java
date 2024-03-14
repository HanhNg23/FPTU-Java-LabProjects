package com.example.demo.auth;
//New

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	
	private final AuthenticationService authService;
	
	@PostMapping("/register")
	public ResponseEntity<String> register( @RequestBody RegisterRequest request ){
		return ResponseEntity.ok(authService.register(request).toString());
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<String> authenticate( @RequestBody AuthenticationRequest request ){
		return ResponseEntity.ok(authService.authenticate(request).toString());
	}
	
	@GetMapping("/myhome")
	public ResponseEntity<String> welcomeHome(){
		return ResponseEntity.ok("WELCOME HOME OK");
	}
	
	@PostMapping("/refresh-token")
	public void refreshToken(
		      HttpServletRequest request,
		      HttpServletResponse response
		  ) throws IOException {
		authService.refreshToken(request, response);
		  }
}
