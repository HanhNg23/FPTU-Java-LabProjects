package com.example.demo.token;

import com.example.demo.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "token")
public class Token {

	@Id
	@GeneratedValue
	public Integer id;
	
	@Column(unique = true)
	public String token;
	
	@Enumerated(EnumType.STRING)
	public TokenType tokenType = TokenType.BEARER;
	
	public boolean revoked; //eliminate
	
	public boolean expired;
	
	@ManyToOne(fetch = FetchType.LAZY)//to load this field later
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	public User user;
	
	
	
}
