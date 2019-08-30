package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bean.Applications;
import com.example.demo.bean.Colleges;
import com.example.demo.bean.SelectedStudents;
import com.example.demo.bean.StudentLogin;

@Controller
public class CollegeAdminController {
	@Autowired
	Environment environment;



	@RequestMapping("/collegeAdminFunc")
	public ModelAndView CollegeAdminFunction(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String port = environment.getProperty("local.server.port");
		HttpSession session = request.getSession(true);
		Colleges colleges = (Colleges) session.getAttribute("college");	
		Applications applicationbean = new Applications();
		applicationbean.setCollegeName(colleges.getCollegeName());
		
		switch(Integer.parseInt(request.getParameter("adminfunc")))
		{
		case 1:
			HttpHeaders requestHeaders = new HttpHeaders();
			HttpEntity<Applications> requestEntity = new HttpEntity<>(applicationbean, requestHeaders);
			RestTemplate rest = new RestTemplate();
			ModelAndView modelAndView = new ModelAndView();
			ResponseEntity<ArrayList<Applications>> responseEntity = rest.exchange("http://localhost:"+port+"/collegeadminresource/collegeapplications",
					HttpMethod.POST,
					requestEntity, new ParameterizedTypeReference<ArrayList<Applications>>() {
					});
			modelAndView.addObject("collegeApplications", responseEntity.getBody());
			modelAndView.setViewName("viewcollegeapplications.jsp");	
			return modelAndView;
		case 2:
			HttpHeaders requestHeaders1 = new HttpHeaders();
			HttpEntity<Applications> requestEntity1 = new HttpEntity<>(applicationbean, requestHeaders1);
			RestTemplate rest1 = new RestTemplate();
			ModelAndView modelAndView1 = new ModelAndView();
			ResponseEntity<ArrayList<SelectedStudents>> responseEntity1 = rest1.exchange("http://localhost:"+port+"/collegeadminresource/collegeselected",
					HttpMethod.POST,
					requestEntity1, new ParameterizedTypeReference<ArrayList<SelectedStudents>>() {
					});
			modelAndView1.addObject("collegeselected", responseEntity1.getBody());
			modelAndView1.setViewName("viewCollegeSelected.jsp");	
			return modelAndView1;
		case 3:
			session.setAttribute("applicationbean", applicationbean);
			RequestDispatcher dispatch = request.getRequestDispatcher("selectdeparment.jsp");
			dispatch.forward(request, response);
			break;
		default :
			{
				RequestDispatcher dispatch1 = request.getRequestDispatcher("collegeadmin.jsp");
				dispatch1.forward(request, response);
			}
		}
		return null;
	}
	@RequestMapping("/ViewParticular")
	@PostMapping
	public void ViewParticular(HttpServletRequest request,@RequestParam("varname") String name,HttpServletResponse response) throws ServletException, IOException
	{
		String port = environment.getProperty("local.server.port");
		Applications applicationbean = new Applications();
		applicationbean.setStudentUsername(name);
		String url1="http://localhost:"+port+"/collegeadminresource/getParticularApplication";
		RestTemplate rt1=new RestTemplate();
        Applications application=rt1.postForObject(url1, applicationbean, Applications.class);
		request.setAttribute("application", application);
		RequestDispatcher dispatch = request.getRequestDispatcher("viewparticular.jsp");
		dispatch.forward(request, response);
	}
	@RequestMapping("/StudentStatus")
	@PostMapping
	public String StudentStatus(HttpServletRequest request,@RequestParam("varname") String status)
	{
		String port = environment.getProperty("local.server.port");
		HttpSession session = request.getSession(true);
		if(status.equals("Accept"))
		{
			Applications application = (Applications) session.getAttribute("applicationbean");
			
			String url1="http://localhost:"+port+"/collegeadminresource/updateApplication";
			RestTemplate rt1=new RestTemplate();
			String status1=rt1.postForObject(url1, application, String.class);
			
			SelectedStudents selectedbean = new SelectedStudents();
			selectedbean.setStudentUsername(application.getStudentUsername());
			selectedbean.setCollegeName(application.getCollegeName());
			selectedbean.setBranch(application.getBranch());
			selectedbean.setSchoolName(application.getSchoolName());
			selectedbean.setDepartment(application.getDepartment());
			String url2="http://localhost:"+port+"/collegeadminresource/insertintoselected";
			RestTemplate rt2=new RestTemplate();
			String status2=rt2.postForObject(url2, selectedbean, String.class);
			
			if(status1.equals("yes") && status2.equals("yes"))
				return "Successfullpage.jsp";
			return "Failed.jsp";
		}
		else
		{
			Applications application = (Applications) session.getAttribute("applicationbean");
			String url2="http://localhost:"+port+"/collegeadminresource/getCounter";
			RestTemplate rt2=new RestTemplate();
			int counter=rt2.postForObject(url2, application, Integer.class);
			System.out.println(counter);
			if(counter<2)
			{
				StudentLogin studentbean = new StudentLogin();
				studentbean.setStudentUsername(application.getStudentUsername());
				studentbean.setCounter(counter+1);
				studentbean.setStatus("FirstLevel");
				String url3="http://localhost:"+port+"/collegeadminresource/updatestudentlogin";
				RestTemplate rt3=new RestTemplate();
				String status1 = rt3.postForObject(url3, studentbean, String.class);
				
				String url4="http://localhost:"+port+"/collegeadminresource/updateApplicationFirstLevel";
				RestTemplate rt4=new RestTemplate();
				String status2 = rt4.postForObject(url4, application, String.class);
				if(status1.equals("yes") && status2.equals("yes"))
					return "Successfullpage.jsp";
			}
			else
			{
				StudentLogin studentbean = new StudentLogin();
				studentbean.setStudentUsername(application.getStudentUsername());
				String url3="http://localhost:"+port+"/collegeadminresource/updaterejectedstudent";
				RestTemplate rt3=new RestTemplate();
				String status1 = rt3.postForObject(url3, studentbean, String.class);
				
				String url4="http://localhost:"+port+"/collegeadminresource/updaterejectedapplication";
				RestTemplate rt4=new RestTemplate();
				String status2 = rt4.postForObject(url4, application, String.class);
				if(status1.equals("yes") && status2.equals("yes"))
					return "Successfullpage.jsp";
			}
		}
		return "Failed.jsp";
	}
	
	@RequestMapping("/DeptSelected")
	public ModelAndView departmentSelected(HttpServletRequest request,HttpServletResponse response)
	{
		String port = environment.getProperty("local.server.port");
		HttpSession session = request.getSession(true);
		Applications applicationbean = (Applications) session.getAttribute("applicationbean");
		applicationbean.setDepartment(request.getParameter("dept"));
		HttpHeaders requestHeaders1 = new HttpHeaders();
		HttpEntity<Applications> requestEntity1 = new HttpEntity<>(applicationbean, requestHeaders1);
		RestTemplate rest1 = new RestTemplate();
		ModelAndView modelAndView1 = new ModelAndView();
		ResponseEntity<ArrayList<SelectedStudents>> responseEntity1 = rest1.exchange("http://localhost:"+port+"/collegeadminresource/collegeselectedDeparment",
				HttpMethod.POST,
				requestEntity1, new ParameterizedTypeReference<ArrayList<SelectedStudents>>() {
				});
		modelAndView1.addObject("collegeselectedDepartment", responseEntity1.getBody());
		modelAndView1.setViewName("viewCollegeSelectedDepartment.jsp");	
		return modelAndView1;
	}
}
