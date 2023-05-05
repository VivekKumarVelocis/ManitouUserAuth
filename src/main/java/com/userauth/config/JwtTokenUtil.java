package com.userauth.config;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
 
import com.userauth.constant.AuthConstant;
import com.userauth.entity.User;
import com.userauth.security.CustomAuthenticationProvider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/*
 * added by Vivek Kumar. Authention bussness logic is written in that class
*/
@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -2550185165626007488L;
	private final static Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);
	@Autowired
	private CustomAuthenticationProvider authenticationManager;
	public static String sessionId = null;

//	@Autowired
//	private AuthenticationManager authenticationManager;

	@Value("${jwt.secret}")
	private String secret;

	@Value("${TOKEN_EXPIRE_TIME_IN_MIN}")
	public long JWT_TOKEN_VALIDITY;

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public String generateToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, username);
	}

	private String createToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
//	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public Boolean validateToken(String token, User userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUserName()) && !isTokenExpired(token));
	}

	public String getSessionFormTokens(String jwtToken) {
		try {

			System.out.println("inside Session id get method called :::: secret key " + secret + " token " + jwtToken);
			Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken).getBody();
			String sessionId = (String) claims.get("SESSION_ID");
			return sessionId;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public void authenticate(String l_username, String l_password) throws Exception {
		logger.info("authenticate user funtion called ::::::::::::::Activity started");
		Objects.requireNonNull(l_username);
		Objects.requireNonNull(l_password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(l_username, l_password));
			logger.info("authenticate user funtion called ::::::::::::::Activity end");
		} catch (DisabledException e) {
			System.out.println("Exception is :::::" + AuthConstant.USER_DISABLED);
			throw new Exception(AuthConstant.INVLAID_CREDENTIALS, e);
		} catch (BadCredentialsException e) {
			throw new Exception(AuthConstant.INVLAID_CREDENTIALS, e);
		} 
	}

}
