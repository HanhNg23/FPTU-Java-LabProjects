package com.example.demo.appuser;

import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.demo.appuser.AppUserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter //from lombok spring tool
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AppUser implements UserDetails{

	@Id
	@SequenceGenerator(
			name = "student_sequence_generator",
			sequenceName = "student_sequence",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "student_sequence_generator"
			)
	//the annotation above is going to set unique value for id field
	private Long id;
	private String fistName;
	private String lastName;
	private String email;
	private String password;
	@Enumerated(EnumType.STRING)
	private AppUserRole appUserRole;
	private Boolean locked = false;
	private Boolean enabled = false;
	

	public AppUser(
			String fistName,
			String lastName,
			String email,
			String password,
			AppUserRole appUserRole) {
		this.fistName = fistName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.appUserRole = appUserRole;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//this method for setting up the collection of user roles for this app
	GrantedAuthority grantedAuthority = 
			new SimpleGrantedAuthority(this.appUserRole.name());
		
	return Collections.singletonList(grantedAuthority);
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.email;
	}
	
	public String getFirstName() {
		return this.fistName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {	
		//default : false
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		//default: false
		return enabled;
	}
	
	@Override
	public String toString() {
		return String.format("email: %s fname: %s lname: %s",this.getUsername(), this.getFirstName(), this.getLastName());
	}


}
