package com.comakeit.sas.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.comakeit.sas.bean.Applications;
import com.comakeit.sas.bean.Colleges;
import com.comakeit.sas.bean.SelectedStudents;
import com.comakeit.sas.bean.StudentLogin;
import com.comakeit.sas.repository.ApplicationRepository;
import com.comakeit.sas.repository.CollegeRepository;
import com.comakeit.sas.repository.SelectedRepository;
import com.comakeit.sas.repository.StudentRepository;


@Service
public class CollegeAdminDao {

	@Autowired
	private ApplicationRepository applicationrepo;
	
	@Autowired
	CollegeRepository collegerepo;
	
	@Autowired
	SelectedRepository selectedrepo;
	
	@Autowired
	StudentRepository studentrepo;
	
	public ArrayList<Applications> getCollegeApplications(String collegeName) {
		return 	new ArrayList<Applications>(applicationrepo.getCollegeApplications(collegeName));

	}

	public Applications getParticularApplication(String studentUsername) {
		return applicationrepo.getParticularApplication(studentUsername);
	}

	public String updateApplication(Applications applicationbean) {
		Applications application = applicationrepo.findById(applicationbean.getStudentUsername()).get();
		application.setStatus("Selected");
		applicationrepo.save(application);
		StudentLogin studentbean = studentrepo.findById(applicationbean.getStudentUsername()).get();
		studentbean.setStatus("Selected");
		studentrepo.save(studentbean);
		return "yes";
	}

	public String insertintoselected(SelectedStudents selectedbean) {
		selectedrepo.save(selectedbean);
		return "yes";
	}

	public int getcounter(Applications applicationbean) {
		
		return studentrepo.getCount(applicationbean.getStudentUsername());
	}

	public String updateStudentLogin(StudentLogin studentbean) {
		StudentLogin studentbean1 = studentrepo.findById(studentbean.getStudentUsername()).orElse(new StudentLogin());
		studentbean1.setStatus("FirstLevel");
		studentbean1.setCounter(studentbean.getCounter());
		studentrepo.save(studentbean1);
		return "yes";
	}

	public String updateApplicationFirstLevel(Applications applicationbean) {
		Applications application = applicationrepo.findById(applicationbean.getStudentUsername()).orElse(new Applications());
		application.setStatus("FirstLevel");
		applicationrepo.save(application);
		return "yes";
	}

	public String updateRejectedApplication(StudentLogin studentbean) {
		
		StudentLogin studentbean1 = studentrepo.findById(studentbean.getStudentUsername()).orElse(new StudentLogin());
		studentbean1.setStatus("Rejected");
		studentrepo.save(studentbean1);
		return "yes";
	}

	public String updaterejectedApplication(Applications applicationbean) {
		// TODO Auto-generated method stub
		Applications application = applicationrepo.findById(applicationbean.getStudentUsername()).orElse(new Applications());
		application.setStatus("Rejected");
		applicationrepo.save(application);
		return "yes";
	}

	public ArrayList<SelectedStudents> getCollegeSelected(String collegeName) {
		// TODO Auto-generated method stub
		return 	selectedrepo.getCollegeSelects(collegeName);
	}

	public ArrayList<SelectedStudents> getCollegeSelectedDepartment(String collegeName, String department) {
		// TODO Auto-generated method stub
		return selectedrepo.getCollegeSelectedDepartment(collegeName,department);
	}

	
}
