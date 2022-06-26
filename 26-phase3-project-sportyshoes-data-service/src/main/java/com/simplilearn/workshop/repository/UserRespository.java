package com.simplilearn.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.domain.User;

public interface UserRespository extends JpaRepository<User, String>{

	// Used to Authenticate
	User findByStrUserIdAndStrPassword(String strUserId, String strPwd);

	// Find by Id

	// Find by EMail
	User findByStrEMail(String strEmail);

	// Save (Insert/Update)

	// All Users
}
