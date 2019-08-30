package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Applications;
import com.example.demo.bean.StudentLogin;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentDao {
	@Autowired
	StudentRepository studentrepo;
	@Autowired
	ApplicationRepository applicationrepo;

	public String getStatus(StudentLogin studentbean) {
		// TODO Auto-generated method stub
		String status = studentrepo.getStatus(studentbean.getStudentUsername(),studentbean.getPassword());
		if(status!=null)
		return status;
		return null;
	}

	public Applications getApplication(StudentLogin studentbean) {
		// TODO Auto-generated method stub
		Applications application = applicationrepo.getParticularApplication(studentbean.getStudentUsername());
		return application;
	}

	public String registerAgain(Applications applications) {
		// TODO Auto-generated method stub
		Applications application = applicationrepo.findById(applications.getStudentUsername()).orElse(new Applications());
		application.setStatus("Pending");
		application.setDepartment(applications.getDepartment());
		application.setCollegeName(applications.getCollegeName());
		applicationrepo.save(application);
		return "yes";
	}

	public String updateStudentLogin(Applications applications) {
		// TODO Auto-generated method stub
		StudentLogin studentbean = studentrepo.findById(applications.getStudentUsername()).orElse(new StudentLogin());
		studentbean.setStatus("Pending");
		studentrepo.save(studentbean);
		return "yes";
	}

}
