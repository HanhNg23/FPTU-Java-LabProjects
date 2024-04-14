package com.example.demo.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//New
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

	private String accessToken;
	private String refreshToken;
	private String extraStatement;
}
