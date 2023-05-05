package com.userauth.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.userauth.config.JwtTokenUtil;
import com.userauth.constant.AuthConstant;
import com.userauth.entity.Response;
import com.userauth.entity.Role;
import com.userauth.entity.User;
import com.userauth.security.CustomUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * added by Vivek Kumar. All request first come to the filter class and validate
 * token this application restrict the access of all URL without token accept
 * /authenticate .
 */
@Component
public class JwtFilterConfig extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private CustomUserDetailsService szCustomUserDetailsService;
  
	@Autowired
	private UserDetailsService userDetailsService;

	private List<SimpleGrantedAuthority> authority;
	
	Response jwtResponseBack = null;
	private final static Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

	/*
	 * Added by Vivek Kumar.All request come first into this function if having token or not
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

	 

		logger.info(" Entry point of application do filter function called");
		jwtResponseBack = new Response();
		final String jwtTokenGetFromHeader = request.getHeader("Authorization");

		boolean exceptionOccurredInToken = false;
		String token = null;
		String userName = null;
		try {

			if (jwtTokenGetFromHeader != null && jwtTokenGetFromHeader.startsWith("Bearer ")) {
				token = jwtTokenGetFromHeader.replace("Bearer ", "").trim();

				userName = jwtTokenUtil.extractUsername(token);
			}

			if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				User userDetails =   szCustomUserDetailsService.loadUserByUsername(userName);
//				UserDetails userDetails = (UserDetails) userDetailsService.loadUserByUsername(userName);
				
				
				if (jwtTokenUtil.validateToken(token, userDetails)) {


					authority = new ArrayList<SimpleGrantedAuthority>();
					
					for(Role role:userDetails.getRoles()) {
						authority.add(new SimpleGrantedAuthority(role.getRoleId()));
					}
					
					
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, authority);

					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}

			}
			if(token==null &&   !request.getRequestURI().contains("/authenticate/createToken") &&  !request.getRequestURI().contains("/user/saveUser")) {
//			if(token==null &&   !request.getRequestURI().contains("/authenticate/createToken")){
			logger.info("Token not present ::::::::");
				System.out.println("Exception is :::::"+AuthConstant.TOKEN_BLANK);
				throw new Exception();
			}

		} catch (IllegalArgumentException e) {
			exceptionOccurredInToken = true;
			logger.info("Unable to get Token ");
			System.out.println("Exception is :::::" + AuthConstant.INVALID_TOKEN);
			createJwtResponseBody(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.INVLAID_CREDENTIALS);
			e.printStackTrace();
		}
		catch (ExpiredJwtException e) {
			exceptionOccurredInToken = true;
			logger.info("Token has expired");
			System.out.println("Exception is :::::"+AuthConstant.TOKEN_EXPIRE);
			createJwtResponseBody(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.TOKEN_EXPIRE);
			e.printStackTrace();
		} 
		catch (Exception e) {
			logger.info("JWT Token Extracted username is not matched");
			System.out.println("Exception is :::::"+AuthConstant.INVALID_TOKEN);
			exceptionOccurredInToken = true;
			createJwtResponseBody(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.INVALID_TOKEN);
			e.printStackTrace();
			logger.info("Exception called in filter class::::::::::::::::::::");

		}
		if (exceptionOccurredInToken)
			revertResponseToClient(response);
		chain.doFilter(request, response);
	}
  
	/*
	 * Added by Vivek Kumar . create the custom object for response
	 */
	public Response createJwtResponseBody(String status, String statusCode, String errorMsg) {

		jwtResponseBack.setStatus(status);
		jwtResponseBack.setStatusCode(statusCode);
		jwtResponseBack.setErrorMsg(errorMsg);

		logger.info("jwtResponse added :::::::::: " + jwtResponseBack);
		return jwtResponseBack;
	}

	/*
	 * Added by Vivek Kumar. revertResponseToClient funtion revert back response
	 * to the client
	 */
	public void revertResponseToClient(HttpServletResponse httpServletResponse)
			throws JsonGenerationException, JsonMappingException, IOException {
		logger.info("Token validation and authraization failed::::::: ");
		final ObjectMapper _mapper = new ObjectMapper();
		// httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
		httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
		_mapper.writeValue(httpServletResponse.getWriter(), jwtResponseBack);
	}

}
