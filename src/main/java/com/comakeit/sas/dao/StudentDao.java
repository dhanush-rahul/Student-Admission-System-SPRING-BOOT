package com.comakeit.sas.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comakeit.sas.bean.Applications;
import com.comakeit.sas.bean.StudentLogin;
import com.comakeit.sas.repository.ApplicationRepository;
import com.comakeit.sas.repository.StudentRepository;

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
