package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;

@Entity

public class Applications{
	
	@Id
	private String studentUsername;

	
	private String status;

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStudentUsername() {
		return studentUsername;
	}
	public void setStudentUsername(String studentUsername) {
		this.studentUsername = studentUsername;
	}
	@NotNull
	private String password;
	@NotNull
	private String schoolName,branch,department,collegeName;
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	@NotNull
	private float percentage,gpa,totalMarks;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public float getPercentage() {
		return percentage;
	}
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}
	public float getGpa() {
		return gpa;
	}
	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
	public float getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(float totalMarks) {
		this.totalMarks = totalMarks;
	}
	@Override
	public String toString() {
		return "Applications [studentUsername=" + studentUsername + ", status=" + status + ", password=" + password
				+ ", schoolName=" + schoolName + ", branch=" + branch + ", department=" + department + ", collegeName="
				+ collegeName + ", percentage=" + percentage + ", gpa=" + gpa + ", totalMarks=" + totalMarks + "]";
	}
	

}
