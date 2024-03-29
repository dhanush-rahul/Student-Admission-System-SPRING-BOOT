package com.comakeit.sas.restcontroller;




import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comakeit.sas.bean.Applications;
import com.comakeit.sas.bean.Colleges;
import com.comakeit.sas.bean.Login;
import com.comakeit.sas.dao.Admindao;
import com.comakeit.sas.repository.ApplicationRepository;
import com.comakeit.sas.repository.CollegeRepository;
import com.comakeit.sas.repository.LoginRepository;

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
