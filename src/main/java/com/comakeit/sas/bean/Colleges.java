package com.comakeit.sas.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Colleges {

	@Id
	private String collegeCode;
	@NotNull
	private String collegeName;
	
	public String getCollegeCode() {
		return collegeCode;
	}
	public void setCollegeCode(String collegeCode) {
		this.collegeCode = collegeCode;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
	@Override
	public String toString() {
		return "Colleges [collegeCode=" + collegeCode + ", collegeName=" + collegeName + "]";
	}
	
}
