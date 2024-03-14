package com.example.demo.config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;



//New
@Service
public class JwtService {

	@Value("${application.security.jwt.secret-key}")
	private static String SECRET_KEY = "9f6181a491989b18f03b9ada8376e2e23b61c5008f7b5ca331e001d190883297";
	private long jwtExpiration = 1000 * 60 * 60 * 24;
	private long refreshExpiration = 1000 * 60 * 60 * 24 * 7;
	
	//TODO: CREATE JWT
	/*1. Use the Jwts.builder() method to create JwtBuilder instance
	 *2. Optionally set any "header" parameters as desired
	 *3. Call builder methods to set the payload content or claims
	//TODO: CREATE JWS
	 *4. Optionally call signWith || ecryptWith methods If you want
	 *   to digitally sign or encrypt the JWT
	 *5. Call the compact() to produce the resulting compact JWT String
	 * */
	//TODO: CREATE JWE 
	
	//Creating a singed JWT: Set up Header and Payload
	 public String generateToken(Map<String,Object> extraClaims, UserDetails userDetails, long expiration) {
		 //We totally can use User(com.example.demo.User) instance instead UserDetails instance
		String token = Jwts.builder()
				.setClaims(extraClaims)
				.setSubject(userDetails.getUsername())
				.setIssuer("Me")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(getSigningKey(), SignatureAlgorithm.HS384)
				.compact();
				
		return token;
	 }
	 
	 public String generateTokenForUser(UserDetails userDetails) {
		 return this.generateToken(new HashMap<>(), userDetails, jwtExpiration);
	 }
	 
	 public String generateRefreshTokenForUser(UserDetails userDetails) {
		 return this.generateToken(new HashMap<>(), userDetails, refreshExpiration);
	 }
	 
	 //==Custom Key for signing key to convert JWT to Signed JWTs = JWS==//
	 /*Because you are using your own SecretKey String
	  * But if you want to sign a JWS using HMAC-SHA Algorithms
	  * --> you need to convert it into a SecretKey instance
	  * --> so that you can use as the signWith(key) method argument
	 */
	 private Key getSigningKey() {
		 //A Base64-encoded String
		 System.out.println("SECRET KEY: " + this.SECRET_KEY);
		SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_KEY));
		//The code above is shorthand of this
			/*byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
			SecretKey key = Keys.hmacShaKeyFor(keyBytes); */
		 return key;
	 }
	 
	 //==READ TOKEN==//
	 //Reading AllClaims
	 /*
	    You read (parse) a JWS as follows:
		1. Use the Jwts.parser() -- create a JwtParserBuilder instance.
		2. Call either keyLocator or verifyWith methods -- determine the key used to verify the JWS signature.
		3. Call the build() method on the JwtParserBuilder -- return a thread-safe JwtParser.
		4. Call the parseClaimsJws(String) with your jws String -- producing the original JWS.
		5. The entire call is wrapped in a try/catch block in case parsing or signature
		 	validation fails. We'll cover exceptions and causes for failure later.
		*/
	 
	 private Claims extractAllClaims(String token) {
		
		 Claims allClaims = Jwts
				 .parserBuilder()
				 .setSigningKey(getSigningKey())
				 .build()
				 .parseClaimsJws(token)
				 .getBody();
	return allClaims;
		 
	 }
	 
	 public <T> T extractSpecificClaim(String token, Function<Claims, T> claimsResolver) {
		 final Claims claimsFunc= this.extractAllClaims(token);
		 return claimsResolver.apply(claimsFunc);
		 
	 }
	 
	 public String extractUsername(String token) {
		 return this.extractSpecificClaim(token, Claims::getSubject);
	 }
	 
	 private Date extractTokenExpireation(String token) {
		 return  this.extractAllClaims(token).getExpiration();
		 //can use
//		 return  extractSpecificClaim(token, Claims::getExpiration);
	 }
	 
	 public boolean isTokenExpired(String token) {
		 System.out.println("ISTOKEN EXPIRED ---> " + this.extractTokenExpireation(token).before(new Date()));
		 return this.extractTokenExpireation(token).before(new Date());
	 }
	 
	 public boolean isTokenValid(String token, UserDetails userDetails) {
		 final String tokenUsername = extractUsername(token);
		 System.out.println("ISTOKEN VALID ---> " + (tokenUsername.equals(userDetails.getUsername()) && !isTokenExpired(token)));
		 return (tokenUsername.equals(userDetails.getUsername()) && !isTokenExpired(token));
	 }
	 
	 
	 
	 
	 
	 
	 
	
	 
	 
	
	 
	 
	 
	 
	 
	 
			
	
}
