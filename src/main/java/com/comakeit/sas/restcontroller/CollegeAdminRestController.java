package com.comakeit.sas.restcontroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comakeit.sas.bean.Applications;
import com.comakeit.sas.bean.SelectedStudents;
import com.comakeit.sas.bean.StudentLogin;
import com.comakeit.sas.dao.CollegeAdminDao;
import com.comakeit.sas.repository.ApplicationRepository;

@RestController
@RequestMapping("/collegeadminresource")
public class CollegeAdminRestController {

	@Autowired
	ApplicationRepository applicationrepo;
	@Autowired
	CollegeAdminDao collegeadmindao;
	@RequestMapping("/collegeapplications")
	public ArrayList<Applications> collegeApplications(@RequestBody Applications applicationbean)
	{
		ArrayList<Applications> collegeApplications = collegeadmindao.getCollegeApplications(applicationbean.getCollegeName());
		return collegeApplications;
	}
	
	@RequestMapping("/getParticularApplication")
	public Applications getParticularApplication(@RequestBody Applications applicationbean)
	{
		Applications application = collegeadmindao.getParticularApplication(applicationbean.getStudentUsername());
		return application;
	}
	
	@RequestMapping("/updateApplication")
	public String updateApplication(@RequestBody Applications applicationbean)
	{
		return collegeadmindao.updateApplication(applicationbean);
	}
	
	@RequestMapping("/insertintoselected")
	public String insertIntoSelected(@RequestBody SelectedStudents selectedbean)
	{
		return collegeadmindao.insertintoselected(selectedbean);
	}
	
	@RequestMapping("/getCounter")
	public int getCounter(@RequestBody Applications applicationbean)
	{
		return collegeadmindao.getcounter(applicationbean);
	}
	
	@RequestMapping("/updatestudentlogin")
	public String updateStudentLogin(@RequestBody StudentLogin studentbean)
	{
		return collegeadmindao.updateStudentLogin(studentbean);
	}
	
	@RequestMapping("/updateApplicationFirstLevel")
	public String updateApplicationFirstLevel(@RequestBody Applications applicationbean)
	{
		return collegeadmindao.updateApplicationFirstLevel(applicationbean);
	}
	
	@RequestMapping("/updaterejectedstudent")
	public String updateRejectedStudentLogin(@RequestBody StudentLogin studentbean)
	{
		return collegeadmindao.updateRejectedApplication(studentbean);
	}
	
	@RequestMapping("/updaterejectedapplication")
	public String updateRejectedApplication(@RequestBody Applications applicationbean)
	{
		return collegeadmindao.updaterejectedApplication(applicationbean);
	}
	
	@RequestMapping("/collegeselected")
	public ArrayList<SelectedStudents> selectedStudents(@RequestBody Applications applicationbean)
	{
		ArrayList<SelectedStudents> collegeselectes = collegeadmindao.getCollegeSelected(applicationbean.getCollegeName());
		return collegeselectes;
	}
	
	@RequestMapping("/collegeselectedDeparment")
	public ArrayList<SelectedStudents> selectedStudentsDepartment(@RequestBody Applications applicationbean)
	{
		ArrayList<SelectedStudents> collegeselectesdepartment = collegeadmindao.getCollegeSelectedDepartment(applicationbean.getCollegeName(),applicationbean.getDepartment());
		return collegeselectesdepartment;
	}
}
