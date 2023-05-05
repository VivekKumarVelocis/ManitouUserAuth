package com.userauth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userauth.entity.Response;
import com.userauth.service.RoleService;
import com.userauth.service.UserService;

@RestController
public class RoleController {

	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private RoleService roleService;
	
	@GetMapping("/getAllRole")
	public ResponseEntity<Response> findAllRole() {

		try {
			logger.info("findAllRole() ::::::::::::::: method called to get all the role");

			Response response = roleService.findAllRole();

			logger.info("findAllRole()::::::method ended.......");
			return ResponseEntity.ok(response);

		} catch (Exception e) {
			System.out.println("Exception is :::::::::::::" + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.ok(Response.error(e.getMessage()));

		}

	}
}
