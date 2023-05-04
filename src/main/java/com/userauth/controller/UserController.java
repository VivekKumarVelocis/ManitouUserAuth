package com.userauth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.userauth.entity.Response;
import com.userauth.entity.User;
import com.userauth.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	/*
	 * This method is used to get the list of all users
	 * 
	 */
	@GetMapping("/getAllUser")
	public ResponseEntity<Response> findAllUser() {

		try {
			logger.info("findAllUser() ::::::::::::::: method called to get all the users");

			Response response = userService.findAllUser();

			logger.info("findAllUser()::::::method ended.......");
			return ResponseEntity.ok(response);

		} catch (Exception e) {
			System.out.println("Exception is :::::::::::::" + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.ok(Response.error(e.getMessage()));

		}

	}

	/*
	 * This method is used to get the user on the basis of its ID
	 * 
	 */
	@GetMapping("/getUserById")
	public ResponseEntity<Response> getUserById(@RequestParam("id") Long id) {
		try {
			logger.info("getUserById():::::::::::: method called to get the user data by its ID " + id);

			Response findByUserId = userService.findById(id);
		
			logger.info("getUserById()::::::method ended.......");
			return ResponseEntity.ok(Response.ok(findByUserId));

		} catch (Exception e) {
			System.out.println("Exception is :::::::::::::" + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.ok(Response.error(e.getMessage()));
		}finally {
			
		}
	}

	/*
	 * This method is used to save the new user
	 * 
	 */
	@PostMapping("/saveUser")
	public ResponseEntity<Response> saveUser(@RequestBody User user) {
		try {
			logger.info("saveUser()::::method called to save the user " + user);
			Response response = userService.saveUser(user);

			logger.info("saveUser()::::method ended.......");
			return ResponseEntity.ok(response);

		} catch (Exception e) {
			System.out.println("Exception is :::::::::::::" + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.ok(Response.error(e.getMessage()));
		}
	}

	/*
	 * This method is used to update the existing user
	 * 
	 */
	@PostMapping("/updateUser")
	public ResponseEntity<Response> updateUser(@RequestBody User user) {
		try {
			logger.info("updateUser()::::method called to update the user " + user);

			Response response = userService.updateUser(user);

			logger.info("updateUser()::::method ended.......");
			return ResponseEntity.ok(response);

		} catch (Exception e) {
			System.out.println("Exception is :::::::::::::" + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.ok(Response.error(e.getMessage()));
		}
	}
	
	/*
	 * This method is used to delete the user on the basis of its userid
	 * 
	 */
	@PostMapping("/deleteUserById")
	public ResponseEntity<Response> deleteUserById(@RequestParam("userid") String userid) {
		try {
			logger.info("deleteUserById():::::::::::: method called to delete the user  " + userid);
			Response response = userService.deleteUserById(userid);
			
			logger.info("deleteUserById()::::method ended.......");
			return ResponseEntity.ok(response);
			
		} catch (Exception e) {
			System.out.println("Exception is :::::::::::::"+e.getMessage());
			e.printStackTrace();
			return ResponseEntity.ok(Response.error(e.getMessage()));
		}

	}
}
