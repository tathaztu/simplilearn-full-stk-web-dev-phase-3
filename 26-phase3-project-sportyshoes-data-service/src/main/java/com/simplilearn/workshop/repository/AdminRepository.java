package com.simplilearn.workshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.workshop.domain.AdminDVO;

public interface AdminRepository extends JpaRepository<AdminDVO, String>{

	List<AdminDVO> findByStrAdminIdAndStrPassword(String strAdminId, String strPwd);

}
