package com.userauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.userauth.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
 
	public User findByUserName(String username);

	public User findByUserId(String userId);

	@Transactional
	public int deleteByUserId(String userId);
}
