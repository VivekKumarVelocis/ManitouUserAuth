package com.userauth.service;

import org.springframework.stereotype.Service;

import com.userauth.entity.Response;
import com.userauth.entity.Role;
 

@Service
public interface RoleService {

	public Response findAllRole() throws Exception;
	public Response getRoleById(String roleId) throws Exception;
	public Role findByRoleName(String roleName) throws Exception;
}
