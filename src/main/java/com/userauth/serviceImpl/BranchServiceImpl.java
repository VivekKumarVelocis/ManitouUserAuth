package com.userauth.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userauth.constant.AuthConstant;
import com.userauth.controller.UserController;
import com.userauth.entity.Branch;
import com.userauth.entity.Response;
import com.userauth.entity.Role;
import com.userauth.repository.BranchRepository;
import com.userauth.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	private final static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private BranchRepository branchRepo;

	@Override
	public Response findAllBranch() throws Exception {
		try {
			logger.info("findAllBranch()::::::::: method in BranchServiceImpl");

			List<Branch> branches = branchRepo.findAll();

			if (branches.size() == 0) {
				logger.error("Error::::: No record found");
				return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.NO_RECORD_FOUND);
			}
			logger.info("Branch fetched successfully !!!!!!!!");
			return new Response(AuthConstant.SUCCESS, AuthConstant.SUCCESS_CODE, branches);

		} catch (Exception e) {
			logger.error("Error in findAllBranch() method ");
			e.printStackTrace();
			return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, e.getMessage());
		}
	}

	@Override
	public Response getBranchById(String branchId) throws Exception {
		try {
			logger.info("getBranchById() method to find branch by its id");
			
			Branch branch = branchRepo.findByBranchId(branchId);
			
			Optional<Branch> ofNullableBranch = Optional.ofNullable(branch);

			if (ofNullableBranch.isPresent()) {
				return new Response(AuthConstant.SUCCESS, AuthConstant.SUCCESS_CODE, branch);
			} else {
				logger.error("branch not present for the branchid " + branch);
				return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.NO_RECORD_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, e.getMessage());
		}
	}

}
