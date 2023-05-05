package com.userauth.service;

import org.springframework.stereotype.Service;

import com.userauth.entity.Branch;
import com.userauth.entity.Response;

@Service
public interface BranchService {
	
	public Response findAllBranch() throws Exception;
	public Response getBranchById(String branchId) throws Exception;
}
