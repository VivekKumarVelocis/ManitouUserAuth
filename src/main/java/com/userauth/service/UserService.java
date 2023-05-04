package com.userauth.service;
 

import org.springframework.stereotype.Service;

import com.userauth.entity.Response;
import com.userauth.entity.User; 
 
/*
*Added by Vivek Kumar. service interface used to declared the operation performed on user entity 
 */
@Service
public interface UserService { 
	
	public User findByUserName(String l_username) throws Exception;
	
	public User findByUserId(String userid) throws Exception;	 

	public Response saveUser(User user) throws Exception;;
	
	public Response updateUser(User user) throws Exception;
	
	public Response findAllUser() throws Exception;

	public Response findById(Long id) throws Exception;

	public Response deleteUserById(String userid) throws Exception;
}
