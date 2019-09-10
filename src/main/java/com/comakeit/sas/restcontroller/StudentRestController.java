package com.comakeit.sas.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comakeit.sas.bean.Applications;
import com.comakeit.sas.bean.StudentLogin;
import com.comakeit.sas.dao.StudentDao;

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
