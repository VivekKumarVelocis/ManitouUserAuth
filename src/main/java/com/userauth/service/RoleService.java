package com.userauth.service;

import org.springframework.stereotype.Service;

import com.userauth.entity.Response;
import com.userauth.entity.Role;
 

@Service
public interface RoleService {

	public Response getRoleById(Long roleId) throws Exception;
	public Role findByRoleName(String roleName) throws Exception;
}
