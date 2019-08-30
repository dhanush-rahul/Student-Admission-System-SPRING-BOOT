package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String>
{
	
}
