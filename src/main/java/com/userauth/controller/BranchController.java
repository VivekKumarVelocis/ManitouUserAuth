package com.userauth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userauth.entity.Response;
import com.userauth.service.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {

	private final static Logger logger = LoggerFactory.getLogger(BranchController.class);

	@Autowired
	private BranchService branchService;

	@GetMapping("/getAllBranch")
	public ResponseEntity<Response> getAllBranch() {
		try {
			logger.info("getAllBranch() ::::::::::::::: method called to get all the branches");
			Response response = branchService.findAllBranch();
			logger.info("getAllBranch()::::::method ended.......");

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			System.out.println("Exception is :::::::::::::" + e.getMessage());
			e.printStackTrace();
			return ResponseEntity.ok(Response.error(e.getMessage()));
		}
	}
}
