package com.comakeit.sas;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.comakeit.sas.bean.Login;

@Controller
public class AdminController {
	@Autowired
	Environment environment;

	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	
	@RequestMapping("/login")
	public String adminLogin(Login login,HttpServletRequest request)
	{
		String port = environment.getProperty("local.server.port");
		HttpSession session = request.getSession(true);
		String url="http://localhost:"+port+"/adminresource/validate";
		RestTemplate rt=new RestTemplate();
        Colleges status=rt.postForObject(url, login, Colleges.class);
        session.setAttribute("college", status);
        if(status==null)
        	return "home.jsp";
		if(status.getCollegeName().equals("Admin"))
			return "admin.jsp";
		else
			return "collegeadmin.jsp";
	}
	
	@RequestMapping("/addcollege")
	public String addCollege(HttpServletRequest req)
	{
		String port = environment.getProperty("local.server.port");

		Colleges collegebean = new Colleges();
		collegebean.setCollegeCode(req.getParameter("collegeCode"));
		collegebean.setCollegeName(req.getParameter("collegeName"));
		
		Login loginbean = new Login();
		loginbean.setAdminpassword(req.getParameter("adminPassword"));
		loginbean.setAdminusername(req.getParameter("adminName"));
		loginbean.setCollegeCode(collegebean);
		
		String url="http://localhost:"+port+"/adminresource/addcollege";
		RestTemplate rt=new RestTemplate();
        String status=rt.postForObject(url, collegebean, String.class);
        
        String url1="http://localhost:"+port+"/adminresource/addadmin";
		RestTemplate rt1=new RestTemplate();
        String status1=rt1.postForObject(url1, loginbean, String.class);
        if(status.equals("yes") && status1.equals("yes"))
		return "Successfullpage.jsp";
        else
        	return "Failed.jsp";
	}
	
	@RequestMapping("/ViewAdmins")
	public ModelAndView viewAdmins()
	{
		String port = environment.getProperty("local.server.port");

			RestTemplate rest = new RestTemplate();
			ModelAndView mv = new ModelAndView();
			ResponseEntity<List<Login>> responseEntity = rest.exchange("http://localhost:"+port+"/adminresource/getadmins",
					HttpMethod.GET,
					null, new ParameterizedTypeReference<List<Login>>() {
					});
			mv.addObject("admins", responseEntity.getBody());
			mv.setViewName("viewAdmins.jsp");
			return mv;
	}
	
	@RequestMapping("/ViewApplications")
	public ModelAndView viewApplications()
	{
		String port = environment.getProperty("local.server.port");

		RestTemplate rest = new RestTemplate();
		ModelAndView mv = new ModelAndView();
		ResponseEntity<List<Applications>> responseEntity = rest.exchange("http://localhost:"+port+"/adminresource/getapplications",
				HttpMethod.GET,
				null, new ParameterizedTypeReference<List<Applications>>() {
				});
		mv.addObject("applications", responseEntity.getBody());
		mv.setViewName("viewApplications.jsp");
		return mv;
	}
	
	
}
