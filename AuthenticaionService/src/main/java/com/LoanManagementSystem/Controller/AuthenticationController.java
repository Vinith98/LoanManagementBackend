package com.LoanManagementSystem.Controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LoanManagementSystem.Exception.UserCredentialsMismatchException;
import com.LoanManagementSystem.Exception.UserNotFoundException;
import com.LoanManagementSystem.Model.User;
import com.LoanManagementSystem.Repository.UserRepository;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class AuthenticationController {
	
	@Autowired
	private UserRepository userRepository;
	


@GetMapping("/authenticate")
 public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) throws UserNotFoundException, UserCredentialsMismatchException {
	Map<String, String> jwt = new HashMap<String, String>();
	String userId = getUser(authHeader);
	String password = getPassword(authHeader);
	System.out.println(userId);
	User user =  userRepository.findByMobileNumber(Integer.parseInt(userId));
	if(user == null){
		throw new UserNotFoundException();
	}
	else
	if(user.getPassword().equals(password)){
		String token = generateJwt(userId);
		String role = user.getRole();
		jwt.put("userId", userId);
		jwt.put("role", role);
		jwt.put("token", token);
		return jwt;
	}
	else throw new UserCredentialsMismatchException();

}
private String getUser(String authHeader) {
	String encodedCredentials = authHeader.split(" ")[1];
	byte[] credentials = Base64.getDecoder().decode(encodedCredentials);
	String userId = new String(credentials).split(":")[0];
	return userId;
}
private String getPassword(String authHeader) {
	String encodedCredentials = authHeader.split(" ")[1];
	byte[] credentials = Base64.getDecoder().decode(encodedCredentials);
	String password = new String(credentials).split(":")[1];
	return password;
}
private String generateJwt(String user) {

	JwtBuilder builder = Jwts.builder();
	builder.setSubject(user);

	// Set the token issue time as current time
	builder.setIssuedAt(new Date());

	// Set the token expiry as 20 minutes from now
	builder.setExpiration(new Date((new Date()).getTime() + 1200000));
	builder.signWith(SignatureAlgorithm.HS256, "secretkey");

	String token = builder.compact();
    System.out.println(token);
	return token;
}
}


