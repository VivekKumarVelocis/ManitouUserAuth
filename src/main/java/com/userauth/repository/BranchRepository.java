package com.userauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userauth.entity.Branch;
import com.userauth.entity.Role;

@Repository
public interface BranchRepository extends JpaRepository<Branch, String>{

	public Branch findByBranchId(String branchId);
}
