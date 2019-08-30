package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Login {

	@Id
	private String adminusername;
	private String adminpassword;
	@OneToOne
	@JoinColumn(name="collegeCode")
	private Colleges collegeCode;
	
	public String getAdminusername() {
		return adminusername;
	}
	public void setAdminusername(String adminusername) {
		this.adminusername = adminusername;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	
	public Colleges getCollegeCode() {
		return collegeCode;
	}
	public void setCollegeCode(Colleges collegeCode) {
		this.collegeCode = collegeCode;
	}
	@Override
	public String toString() {
		return "Login [adminusername=" + adminusername + ", adminpassword=" + adminpassword + ", collegeCode="
				+ collegeCode + "]";
	}
	
}
