package com.comakeit.sas;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.comakeit.sas.bean.Applications;
import com.comakeit.sas.bean.Colleges;
import com.comakeit.sas.bean.StudentLogin;

@Controller
public class StudentLoginController {
	@Autowired
	Environment environment;

	@RequestMapping("/StudentLogin")
	public String studentLogin(HttpServletRequest request,HttpServletResponse response)
	{
		String port = environment.getProperty("local.server.port");

		HttpSession session = request.getSession(true);
		StudentLogin studentbean = new StudentLogin();
		studentbean.setStudentUsername(request.getParameter("username"));
		studentbean.setPassword(request.getParameter("password"));
		
		String url="http://localhost:"+port+"/studentresource/validate";
		RestTemplate rt=new RestTemplate();
        String status=rt.postForObject(url, studentbean, String.class);
        session.setAttribute("status", status);

        String url1="http://localhost:"+port+"/studentresource/getApplication";
		RestTemplate rt1=new RestTemplate();
        Applications application1=rt1.postForObject(url1, studentbean, Applications.class);
        session.setAttribute("application",application1);
        if(status==null)
        	return "studentlogin.jsp";
		if(status.equals("Pending"))
		{
			return "viewStudentApplication.jsp";
		}
		else if(status.equals("FirstLevel"))
		{
			RestTemplate rest = new RestTemplate();
			ResponseEntity<List<Colleges>> responseEntity = rest.exchange("http://localhost:"+port+"/applicationresource/getcolleges",
					HttpMethod.GET,
					null, new ParameterizedTypeReference<List<Colleges>>() {
					});
			session.setAttribute("colleges", responseEntity.getBody());
			return "registerAgain.jsp";
		}
		else if(status.equals("Rejected"))
			return "Rejected.jsp";
		else if(status.equals("Selected"))
			return "viewStudentApplication.jsp";
		return "studentlogin.jsp";
	}
	
	@RequestMapping("/RegisterAgain")
	public String registerAgain(HttpServletRequest request,HttpServletResponse response)
	{
		String port = environment.getProperty("local.server.port");

		HttpSession session = request.getSession();
		Applications applications = (Applications) session.getAttribute("applicationbean");
		applications.setDepartment(request.getParameter("dept_choice"));
		applications.setCollegeName(request.getParameter("college"));
		
		String url1="http://localhost:"+port+"/studentresource/registeragain";
		RestTemplate rt1=new RestTemplate();
        String status1=rt1.postForObject(url1, applications, String.class);
        
        String url2="http://localhost:"+port+"/studentresource/updatestudentlogin";
		RestTemplate rt2=new RestTemplate();
        String status2=rt2.postForObject(url2, applications, String.class);
        
        if(status1.equals("yes") && status2.equals("yes"))
        	return "Successfullpage.jsp";
        return "Failed.jsp";
	}
}
