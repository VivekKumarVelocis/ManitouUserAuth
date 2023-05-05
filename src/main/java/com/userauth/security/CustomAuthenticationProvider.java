package com.userauth.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.userauth.constant.AuthConstant;
import com.userauth.entity.Role;
import com.userauth.entity.User;
import com.userauth.exception.UserInactiveException;
import com.userauth.exception.UserLockedException;
import com.userauth.service.UserService;
 



/**
 * added by kishan pandey. this class is used for custom authentication of username and password
 */

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static final Logger szLogger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

	@Autowired(required = true)
	private CustomUserDetailsService szCustomeUserDetailsService;

	@Autowired
	private UserService userService;
	private List<SimpleGrantedAuthority> szAuthority;

	
	
	
	
	/*
	 * this function is called when you have to authenticate any user in your
	 * application form database
	 */
	@Override
	public Authentication authenticate(Authentication l_authentication) throws AuthenticationException {
		
		szLogger.info("user authentication  :::::::::Activity started");
		String _userId = l_authentication.getName();
		String _password = l_authentication.getCredentials().toString();

		User _user =  (User) szCustomeUserDetailsService.loadUserByUsername(_userId);
//        UserForSave userforsave = new UserForSave();
		
		if(_user.getLocked_status().equals(AuthConstant.USER_STATUS_LOCKED)){
			 szLogger.error("User staus is locked");
			 System.out.println("Exception is :::::::::::::: "+AuthConstant.USER_STATUS_LOCKED);
        	throw new UserLockedException(AuthConstant.USER_LOCKED);
        }
		
		 if(_user.getStatus().equals(AuthConstant.USER_STATUS_ACTIVE)){
			 boolean get = PasswordEncoderUtility.checkPassword(_password, _user.getPassword());
			 System.out.println("asdf");
		if (PasswordEncoderUtility.checkPassword(_password, _user.getPassword())) {
			 szLogger.info("username and password is correct.");
			szAuthority = new ArrayList<SimpleGrantedAuthority>();
			
			for(Role role:_user.getRoles()) {
				szAuthority.add(new SimpleGrantedAuthority(role.getRoleId()));
			}
//            szAuthority.add(new SimpleGrantedAuthority(_user.getRoles().));

			l_authentication = new UsernamePasswordAuthenticationToken(_user, _password, szAuthority);
			if (l_authentication.getPrincipal() instanceof User) {
				 szLogger.info("user Authentication");			
			}

			SecurityContextHolder.getContext().setAuthentication(l_authentication);
			szLogger.info("user authentication  :::::::::Activity end");
			_user.setIncorrect_attempt(0);
			//userforsave.setUserId(_user.getUserId());
			//userforsave.setIncorrect_attempt(0);
			try {
				userService.updateUserWhileAuthentication(_user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return l_authentication;
		}else {
			

			int incorrectAttempt = _user.getIncorrect_attempt(); 
			if(incorrectAttempt<_user.getIncorrect_max_attempt_limit()) {
				incorrectAttempt++;
				_user.setIncorrect_attempt(incorrectAttempt);
			//	userforsave.setUserId(_user.getUserId());
			//	userforsave.setIncorrect_attempt(incorrectAttempt);
				try {
					userService.updateUserWhileAuthentication(_user);
				} catch (Exception e) {
					e.printStackTrace();
				}
				}else {
				//	userforsave.setUserId(_user.getUserId());
				//	userforsave.setLocked_status("Y");
					_user.setLocked_status("Y");
					try {
						userService.updateUserWhileAuthentication(_user);
					} catch (Exception e) {
						e.printStackTrace();
					
					
				}
			}
			
		}
		}
		if(_user.getStatus().equals(AuthConstant.USER_STATUS_INACTIVE)){
			szLogger.error("User staus is Inactive");
			System.out.println("Exception is :::::::::::::: "+AuthConstant.USER_STATUS_INACTIVE);
            throw new UserInactiveException(AuthConstant.INVLAID_CREDENTIALS);
        }
		System.out.println("Exception is :::::::::::::: "+AuthConstant.INVLAID_CREDENTIALS);
		throw new BadCredentialsException(AuthConstant.INVLAID_CREDENTIALS);
		
		
		
	}
	
	
	
	

	@Override
	public boolean supports(Class<?> l_authentication) {

		return l_authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
