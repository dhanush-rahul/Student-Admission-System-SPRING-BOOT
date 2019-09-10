package com.comakeit.sas.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comakeit.sas.bean.Applications;
import com.comakeit.sas.bean.Colleges;
import com.comakeit.sas.bean.Login;
import com.comakeit.sas.repository.ApplicationRepository;
import com.comakeit.sas.repository.CollegeRepository;
import com.comakeit.sas.repository.LoginRepository;

@Service
public class Admindao {

	@Autowired
	LoginRepository loginrepo;
	
	@Autowired
	CollegeRepository collegerepo;
	
	@Autowired
	ApplicationRepository applicationrepo;
	
	public Colleges getCollegecode(Login login) {
		// TODO Auto-generated method stub
		Login loginbean = loginrepo.findById(login.getAdminusername()).orElse(new Login());
		
        if(loginbean.getAdminpassword().equals(login.getAdminpassword()))
		return loginbean.getCollegeCode();
        return null;
	}

	public String savecollegedetails(Colleges college) {
		// TODO Auto-generated method stub
		collegerepo.save(college);
		return "yes";
	}

	public String saveAdmindetails(Login login) {
		// TODO Auto-generated method stub
		loginrepo.save(login);
		return "yes";
	}

	public ArrayList<Login> getAdmins() {
		// TODO Auto-generated method stub
		return (ArrayList<Login>) loginrepo.findAll();
	}

	public ArrayList<Applications> getApplications() {
		// TODO Auto-generated method stub
		return (ArrayList<Applications>) applicationrepo.findAll();
	}

}
