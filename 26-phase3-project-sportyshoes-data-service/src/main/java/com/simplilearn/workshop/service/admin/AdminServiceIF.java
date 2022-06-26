package com.simplilearn.workshop.service.admin;

import com.simplilearn.workshop.domain.AdminDVO;

public interface AdminServiceIF {

	public AdminDVO authenticate(String strAdminId, String strPwd);

	public AdminDVO getAdminById(String strUserId);

	public void updateRecord(AdminDVO adminDVO);
}
