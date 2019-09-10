package com.comakeit.sas;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.comakeit.sas.bean.Applications;
import com.comakeit.sas.bean.Colleges;
import com.comakeit.sas.bean.StudentLogin;

@Controller
public class ApplicationController {
	
	@Autowired
	Environment environment;


	
	@RequestMapping("/admissionForm")
	public ModelAndView admissionForm()
	{	String port = environment.getProperty("local.server.port");

		RestTemplate rest = new RestTemplate();
		ModelAndView mv = new ModelAndView();
		ResponseEntity<List<Colleges>> responseEntity = rest.exchange("http://localhost:"+port+"/applicationresource/getcolleges",
				HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Colleges>>() {
				});
		mv.addObject("colleges", responseEntity.getBody());
		mv.setViewName("studentregistration.jsp");
		return mv;
	}
	
	@RequestMapping("/register")
	public String register(Applications applications,HttpServletRequest request)
	{
		String port = environment.getProperty("local.server.port");

		applications.setStatus("Pending");
		
		StudentLogin studentbean = new StudentLogin();
        studentbean.setStudentUsername(applications.getStudentUsername());
        studentbean.setPassword(applications.getPassword());
        studentbean.setStatus(applications.getStatus());
        studentbean.setCounter(1);
        
        String url1="http://localhost:"+port+"/applicationresource/addstudentlogin";
		RestTemplate rt1=new RestTemplate();
        String status1=rt1.postForObject(url1, studentbean, String.class);
		
		
		String url="http://localhost:"+port+"/applicationresource/addapplication";
		RestTemplate rt=new RestTemplate();
        String status=rt.postForObject(url, applications, String.class);
        
        
        if(status.equals("yes") && status1.equals("yes"))
		return "Successfullpage.jsp";
        else
        	return "Failed.jsp";
	}

}
