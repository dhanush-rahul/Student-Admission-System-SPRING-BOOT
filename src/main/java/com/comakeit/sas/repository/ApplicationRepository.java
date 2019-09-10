package com.comakeit.sas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comakeit.sas.bean.Applications;
@Repository
public interface ApplicationRepository extends JpaRepository<Applications, String> {
	
	@Query("SELECT application FROM Applications application WHERE application.collegeName= :collegeName and application.status='Pending'")
	public List<Applications> getCollegeApplications(@Param("collegeName") String collegeName);

	@Query("SELECT application from Applications application where application.studentUsername=:studentUsername")
	public Applications getParticularApplication(@Param("studentUsername") String studentUsername);
	
}
