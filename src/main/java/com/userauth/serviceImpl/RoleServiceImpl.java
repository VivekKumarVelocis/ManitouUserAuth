package com.userauth.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userauth.constant.AuthConstant;
import com.userauth.entity.Response;
import com.userauth.entity.Role;
import com.userauth.repository.RoleRepository;
import com.userauth.repository.UserRepository;
import com.userauth.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	private final static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Autowired
	private RoleRepository roleRepo;

	@Override
	public Response getRoleById(String roleId) throws Exception {
		try {
			logger.info("get role by id service impl called ::::::::::::::: Activity started  " + roleId);
			Role roles = roleRepo.findByRoleId(roleId);
			Optional<Role> ofNullableRole = Optional.ofNullable(roles);

			if (ofNullableRole.isPresent()) {
				return new Response(AuthConstant.SUCCESS, AuthConstant.SUCCESS_CODE, roles);
			} else {
				logger.error("Role not present for the roleid " + roleId);
				return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.NO_RECORD_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, e.getMessage());

		}
	}

	@Override
	public Role findByRoleName(String roleName) throws Exception {
		Role findByRoleName = roleRepo.findByRoleDesc(roleName);
		return findByRoleName;
	}

	@Override
	public Response findAllRole() throws Exception {
		try {
			logger.info("findAllRole() method  " );
			List<Role> roles = roleRepo.findAll();
			
			if (roles.size() == 0) {
				logger.error("Error::::: No record found");
				return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, AuthConstant.NO_RECORD_FOUND);
			}
			logger.info("Roles fetched successfully !!!!!!!!");
			return new Response(AuthConstant.SUCCESS, AuthConstant.SUCCESS_CODE, roles);

		} catch (Exception e) {
			logger.error("Error in findAllRole() method ");
			e.printStackTrace();
			return new Response(AuthConstant.FAILURE, AuthConstant.ERROR_CODE, e.getMessage());
		}
	}

}
