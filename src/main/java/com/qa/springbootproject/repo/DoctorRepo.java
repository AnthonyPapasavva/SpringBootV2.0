package com.qa.springbootproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.springbootproject.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

	@Query(value = "SELECT * FROM doctor", nativeQuery = true)
	public List<Doctor> allFromDoctor();

	@Query(value = "SELECT * FROM doctor WHERE first_name = ?1", nativeQuery = true)
	public List<Doctor> sameNameSelect(String name);

}
