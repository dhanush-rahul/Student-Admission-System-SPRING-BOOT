package com.comakeit.sas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comakeit.sas.bean.StudentLogin;

@Repository
public interface StudentRepository extends JpaRepository<StudentLogin, String> {

	@Query("select c.counter from StudentLogin c where c.studentUsername=:studentUsername")
	int getCount(@Param("studentUsername") String studentUsername);

	@Query("select c.status from StudentLogin c where c.studentUsername= :studentUsername and c.password= :password")
	String getStatus(@Param("studentUsername") String studentUsername,@Param("password") String password);

}
