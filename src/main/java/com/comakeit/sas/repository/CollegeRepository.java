package com.comakeit.sas.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.comakeit.sas.bean.Colleges;
@Repository
public interface CollegeRepository extends JpaRepository<Colleges, String> {

//	@Query("select c.collegeName from Colleges c")
//	ArrayList<Colleges> getColleges();

	@Query(value = "select * from colleges c where c.college_code=?1",nativeQuery = true)
	public Colleges getCollegeName(String collegeCode);

}
