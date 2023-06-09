package com.userauth.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.userauth.config.JwtTokenUtil;
import com.userauth.constant.AuthConstant;
import com.userauth.entity.AuthRequest;
import com.userauth.entity.JwtResponseForToken;
import com.userauth.entity.Response;
import com.userauth.proxy.DispatchProxy;
import com.userauth.security.CustomUserDetailsService;

@RestController
public class JwtAuthenticationController {
	private final static Logger logger = LoggerFactory.getLogger(JwtAuthenticationController.class);

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	CustomUserDetailsService customerUserDetailsService;
	 
	 
	/*
	 * This method is use to create Token
	 */

	@PostMapping("/authenticate/createToken")
	public ResponseEntity<?> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			logger.info("generateToken():::::: method called to generate token ");

//			authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
			jwtTokenUtil.authenticate(authRequest.getUserName(), authRequest.getPassword());
			String token = "Bearer " + jwtTokenUtil.generateToken(authRequest.getUserName());

			System.out.println("Generated token is::::::: " + token);

			return ResponseEntity
					.ok(new JwtResponseForToken(token, AuthConstant.SUCCESS, AuthConstant.SUCCESS_CODE, null));
		} catch (Exception ex) {
			logger.error("Error::::::::::While generating token");
			ex.printStackTrace();
			return ResponseEntity
					.ok(new JwtResponseForToken(null, AuthConstant.FAILURE, AuthConstant.ERROR_CODE, ex.getMessage()));
		}

	}

 
}
