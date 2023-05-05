package com.userauth.config;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;


/*
 * added by Vivek Kumar. this class check the entry point Request 
*/
@Component
public class JwtAuthenticationEntryPointConfig implements AuthenticationEntryPoint, Serializable {

	private static final long serialVersionUID = -7858869558953243875L;

	
	/*
	 * this function is called when wrong url called with the same port number
	 * like example localhost:8080 . but the correct url is localhost:8080/neft
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse l_szresponse,
			AuthenticationException l_authException) throws IOException {

			l_szresponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
			
//		l_szresponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
//		l_szresponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//
//	        final Map<String, Object> body = new HashMap<>();
//	        body.put("code", HttpServletResponse.SC_UNAUTHORIZED);
//	        body.put("payload", "You need to login first in order to perform this action.");
//
//	        final ObjectMapper mapper = new ObjectMapper();
//	        mapper.writeValue(l_szresponse.getOutputStream(), body);
	}
}
