package com.example.demo.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.bean.SelectedStudents;

public interface SelectedRepository extends JpaRepository<SelectedStudents, String> {

	@Query("select selects from SelectedStudents selects where selects.collegeName=:collegeName")
	ArrayList<SelectedStudents> getCollegeSelects(@Param("collegeName")String collegeName);

	@Query("select selects from SelectedStudents selects where selects.collegeName=:collegeName and selects.department=:department")
	ArrayList<SelectedStudents> getCollegeSelectedDepartment(@Param("collegeName")String collegeName,@Param("department") String department);

}
