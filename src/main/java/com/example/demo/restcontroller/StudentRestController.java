package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Applications;
import com.example.demo.bean.StudentLogin;
import com.example.demo.dao.StudentDao;

@RestController
@RequestMapping("/studentresource")
public class StudentRestController {

	@Autowired
	StudentDao studentdao;
	
	@RequestMapping("/validate")
	public String validate(@RequestBody StudentLogin studentbean)
	{
		return studentdao.getStatus(studentbean);
	}
	
	@RequestMapping("/getApplication")
	public Applications getApplication(@RequestBody StudentLogin studentbean)
	{
		return studentdao.getApplication(studentbean);
	}
	@RequestMapping("/registeragain")
	public String registerAgain(@RequestBody Applications applications)
	{
		return studentdao.registerAgain(applications);
	}
	
	@RequestMapping("/updatestudentlogin")
	public String updateStudentLogin(@RequestBody Applications applications)
	{
		return studentdao.updateStudentLogin(applications);
	}
}
