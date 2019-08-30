package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Applications;
import com.example.demo.bean.Colleges;
import com.example.demo.bean.SelectedStudents;
import com.example.demo.bean.StudentLogin;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.repository.CollegeRepository;
import com.example.demo.repository.SelectedRepository;
import com.example.demo.repository.StudentRepository;


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
		Applications application = applicationrepo.findById(applicationbean.getStudentUsername()).orElse(new Applications());
		application.setStatus("Selected");
		applicationrepo.save(application);
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
