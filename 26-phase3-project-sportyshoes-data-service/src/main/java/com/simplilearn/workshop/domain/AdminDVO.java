package com.simplilearn.workshop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADMIN_CONFIG")
public class AdminDVO {

	@Id
	@Column(name = "ADMIN_ID")
	private String strAdminId;

	@Column(name = "USER_NAME")
	private String strUserName;

	@Column(name = "PASSWORD")
	private String strPassword;



	public AdminDVO() {}

	public AdminDVO(String strAdminId, String strUserName, String strPassword) {
		this.strAdminId = strAdminId;
		this.strUserName = strUserName;
		this.strPassword = strPassword;
	}

	public String getStrAdminId() {
		return strAdminId;
	}

	public void setStrAdminId(String strAdminId) {
		this.strAdminId = strAdminId;
	}

	public String getStrUserName() {
		return strUserName;
	}

	public void setStrUserName(String strUserName) {
		this.strUserName = strUserName;
	}

	public String getStrPassword() {
		return strPassword;
	}

	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}
}
