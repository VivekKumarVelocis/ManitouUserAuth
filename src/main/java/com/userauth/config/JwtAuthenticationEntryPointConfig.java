package com.userauth.config;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


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
	}
}
