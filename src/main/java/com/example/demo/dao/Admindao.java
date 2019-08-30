package com.example.demo.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Applications;
import com.example.demo.bean.Colleges;
import com.example.demo.bean.Login;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.repository.CollegeRepository;
import com.example.demo.repository.LoginRepository;

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
		Login login1 = loginrepo.findById(login.getAdminusername()).orElse(new Login());
		
		
        if(login1.getAdminpassword().equals(login.getAdminpassword()))
		return login1.getCollegeCode();
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
