package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Applications;
import com.example.demo.bean.Colleges;
import com.example.demo.bean.StudentLogin;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.repository.CollegeRepository;
import com.example.demo.repository.StudentRepository;

@EnableAutoConfiguration
@Service
@Component
public class Applicationdao {

	@Autowired
	ApplicationRepository applicationrepo;
	@Autowired
	StudentRepository studentrepo;
	@Autowired
	CollegeRepository collegerepo;
	
	public String addApplication(Applications applications) {
		// TODO Auto-generated method stub
		applicationrepo.save(applications);
		return "yes";
	}


	public String addStudent(StudentLogin studentbean) {
		// TODO Auto-generated method stub
		studentrepo.save(studentbean);
		return "yes";
	}


	public ArrayList<Colleges> getColleges() {
		// TODO Auto-generated method stub
		return (ArrayList<Colleges>) collegerepo.findAll();
	}


}
