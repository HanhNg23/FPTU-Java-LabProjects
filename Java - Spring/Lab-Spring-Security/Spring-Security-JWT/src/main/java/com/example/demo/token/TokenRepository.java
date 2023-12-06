package com.example.demo.token;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TokenRepository extends JpaRepository<Token, Integer>{
	
	Optional<Token> findByToken(String token);

	@Query(
			value = "SELECT t FROM Token t "
					+ "INNER JOIN User u "
					+ "ON t.user.id = u.id "
					+ "WHERE u.id = :id "
					+ "AND (t.expired = false "
					+ "OR t.revoked = false) "
			)
	
	
//	@Query(value = """
//		      select t from token t inner join user u\s
//		      on t.user.id = u.id\s
//		      where u.id = :id and (t.expired = false or t.revoked = false)\s
//		      """)
	List<Token> findAllValidTokenByUser(@Param(value = "id") Integer userId);
	
}
