package com.example.demo.registration.token;

import java.time.LocalDateTime;

import com.example.demo.appuser.AppUser;
import com.example.demo.appuser.AppUserRole;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {

	// Describe: this is an entity for storing token to later send for confirm email
	
	@Id
	@SequenceGenerator(
			name = "token_sequence_generator",
			sequenceName = "token_sequence",
			allocationSize = 1
			
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "token_sequence_generator"
			)
	
	private Long id;
	@Column(nullable = false)
	private String token;
	@Column(nullable = false)
	private LocalDateTime createAt;
	@Column(nullable = false)
	private LocalDateTime expireAt;
	private LocalDateTime confirmedAt;
	@ManyToOne
	@JoinColumn(
			nullable = false,
			name="app_user_id" //the column name for this foreign key
			)
	private AppUser appUser;
	public ConfirmationToken(
			String token,
			LocalDateTime createAt,
			LocalDateTime expiredAt,
			AppUser appUser) {
		
		this.token = token;
		this.createAt = createAt;
		this.expireAt = expiredAt;
		this.appUser = appUser;
	}
	
	
}
