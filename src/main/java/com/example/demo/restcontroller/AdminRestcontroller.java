package com.example.demo.restcontroller;




import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Applications;
import com.example.demo.bean.Colleges;
import com.example.demo.bean.Login;
import com.example.demo.dao.Admindao;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.repository.CollegeRepository;
import com.example.demo.repository.LoginRepository;

@RestController
@RequestMapping("/adminresource")
public class AdminRestcontroller {

	@Autowired
	LoginRepository loginrepo;
	
	@Autowired
	CollegeRepository collegerepo;
	
	@Autowired
	ApplicationRepository applicationrepo;
	
	@Autowired
	Admindao admindao;
	    
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	    public Colleges getCollege(@RequestBody Login login) {
	        return admindao.getCollegecode(login);
	    }
	
	@RequestMapping(value="/addcollege", method=RequestMethod.POST)
		public String addCollege(@RequestBody Colleges college)
		{
			return admindao.savecollegedetails(college);
		}
	
	@RequestMapping(value="/addadmin",method=RequestMethod.POST)
		public String addAdmin(@RequestBody Login login)
		{
			return admindao.saveAdmindetails(login);
		}
	@RequestMapping(value="/getadmins",method=RequestMethod.GET)
		public ArrayList<Login> getAdmins()
		{
			return admindao.getAdmins();
		}
	
	@RequestMapping(value="/getapplications",method=RequestMethod.GET)
		public ArrayList<Applications> getApplications()
		{
			return admindao.getApplications();
		}
	
}
