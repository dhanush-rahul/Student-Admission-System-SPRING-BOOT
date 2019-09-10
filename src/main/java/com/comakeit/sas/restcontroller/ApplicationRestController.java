package com.comakeit.sas.restcontroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comakeit.sas.bean.Applications;
import com.comakeit.sas.bean.Colleges;
import com.comakeit.sas.bean.StudentLogin;
import com.comakeit.sas.dao.Applicationdao;
import com.comakeit.sas.repository.ApplicationRepository;
import com.comakeit.sas.repository.CollegeRepository;
import com.comakeit.sas.repository.StudentRepository;

@RestController
@RequestMapping("/applicationresource")
public class ApplicationRestController {
	@Autowired
	CollegeRepository collegerepo;
	@Autowired
	ApplicationRepository applicationrepo;
	@Autowired
	StudentRepository studentrepo;
	@Autowired
	Applicationdao applicationdao;
	
	@RequestMapping(value="/getcolleges",method=RequestMethod.GET)
	public ArrayList<Colleges> getColleges()
	{
		return (ArrayList<Colleges>) applicationdao.getColleges();
	}
	
	@RequestMapping(value="/addapplication",method=RequestMethod.POST)
	public String addApplication(@RequestBody Applications applications)
	{
		return applicationdao.addApplication(applications);
	}
	
	@RequestMapping(value="/addstudentlogin",method=RequestMethod.POST)
	public String addStudent(@RequestBody StudentLogin studentbean)
	{
		return applicationdao.addStudent(studentbean);
	}
}
