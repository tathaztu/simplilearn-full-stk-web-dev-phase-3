package com.simplilearn.workshop.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.workshop.domain.AdminDVO;
import com.simplilearn.workshop.service.admin.AdminServiceIF;

@RestController
public class AdminResource {


	@Autowired
	private AdminServiceIF m_adminService;

	@GetMapping(path = "/admin/{strAdminId}")
	public AdminDVO getAdminDVOById(@PathVariable String strAdminId) {
		System.out.println("Debug : " + strAdminId);
		return m_adminService.getAdminById(strAdminId);
	}

	@PostMapping(path = "/admin/authenticate")
	public AdminDVO authenticate(@RequestParam("userId") String strUserId, @RequestParam("password") String strPassword) {
		return m_adminService.authenticate(strUserId, strPassword);
	}

	@PostMapping(path = "/admin/updateid")
	public void updateId(@Valid @RequestBody AdminDVO adminDVO) {
		m_adminService.updateRecord(adminDVO);
	}

}
