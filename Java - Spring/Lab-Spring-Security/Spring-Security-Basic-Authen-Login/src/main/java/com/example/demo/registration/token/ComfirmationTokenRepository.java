package com.example.demo.registration.token;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional(readOnly = true)
public interface ComfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {

	Optional<ConfirmationToken> findByToken(String token);
	
	//create new function for repository
	@Transactional
	@Modifying
	@Query("UPDATE ConfirmationToken c " + 
			"SET c.confirmedAt = ?2 " +
			"WHERE c.token = ?1"
			)
	int updateConfirmedAt(String token, LocalDateTime confirmedAt);
	
}
