package com.simplilearn.workshop.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.workshop.domain.AdminDVO;
import com.simplilearn.workshop.repository.AdminRepository;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminServiceIF {

	@Autowired
	private AdminRepository adminRepositoryImpl;

	public AdminServiceImpl() {}

	public AdminServiceImpl(AdminRepository adminRepositoryImpl) {
		System.out.println("Spring DI using Constructor");
		this.adminRepositoryImpl = adminRepositoryImpl;
	}

	@Override
	public AdminDVO authenticate(String strAdminId, String strPwd) {
		List<AdminDVO> listAdminDVOs = adminRepositoryImpl.findByStrAdminIdAndStrPassword(strAdminId, strPwd);

		AdminDVO adminDVO = null;
		if(null != listAdminDVOs && !listAdminDVOs.isEmpty()) {
			adminDVO = listAdminDVOs.get(0);
		}

		return adminDVO;
	}

	@Override
	public AdminDVO getAdminById(String strUserId) {
		return adminRepositoryImpl.findById(strUserId).get();
	}

	@Override
	public void updateRecord(AdminDVO adminDVO) {
		adminRepositoryImpl.save(adminDVO);
	}

}
