package com.userauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userauth.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	public Role findByRoleName(String roleName);

	public Role findByRoleId(Long roleId);
}
