package com.userauth.security;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 
import com.userauth.constant.AuthConstant;
import com.userauth.entity.User;
import com.userauth.service.UserService;
import com.userauth.serviceImpl.UserServiceImpl;

/**
 * added by kishan pandey. custom class to get the user details
 */

@Service
//public class CustomUserDetailsService implements UserDetailsService {
public class CustomUserDetailsService{

	@Autowired
	private UserService szUserService;

	public User loadUserByUsername(String l_username) throws BadCredentialsException {
try {
		User _user = szUserService.findByUserName(l_username);
		System.out.println("Code in CustomUserDetailsService");

		if (_user == null) {
			System.out.println("Exception is :::::::::::::: "+AuthConstant.USER_NOT_FOUND);
			throw new UsernameNotFoundException(AuthConstant.INVLAID_CREDENTIALS);
		}


		return _user;
		
	}catch (Exception e) {
		e.printStackTrace();
		throw new UsernameNotFoundException(AuthConstant.INVLAID_CREDENTIALS);
	}
	}
	
//	public User loadUserByUsername(String l_username) throws BadCredentialsException {
//		try {
//			User _user = szUserService.findByUserName(l_username);
//			System.out.println("Code in CustomUserDetailsService");
//
//			if (_user == null) {
//				System.out.println("Exception is :::::::::::::: " + AuthConstant.USER_NOT_FOUND);
//				throw new UsernameNotFoundException(AuthConstant.INVLAID_CREDENTIALS);
//			}
//
//			return _user;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new UsernameNotFoundException(AuthConstant.INVLAID_CREDENTIALS);
//		}
//	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, BadCredentialsException {
//		try {
//			Optional<User> userOptional = Optional.ofNullable(szUserService.findByUserName(username));
//
//			if (userOptional.isPresent()) {
////				return new org.springframework.security.core.userdetails.User(userOptional.get().getUserName(),
////						userOptional.get().getPassword(),
////						new ArrayList<>());
//				return new CustomerUserDetails(userOptional.get());
//			} else {
//				System.out.println("Exception is :::::::::::::: " + AuthConstant.USER_NOT_FOUND);
//				throw new UsernameNotFoundException(AuthConstant.INVLAID_CREDENTIALS);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new UsernameNotFoundException(AuthConstant.INVLAID_CREDENTIALS);
//		}
//
//	}

}
