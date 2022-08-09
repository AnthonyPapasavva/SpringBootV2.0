package com.qa.springbootproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.springbootproject.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {

	@Query(value = "SELECT * FROM patient", nativeQuery = true)
	public List<Patient> allFromPatient();

	@Query(value = "SELECT * FROM patient WHERE first_name = ?1", nativeQuery = true)
	public List<Patient> sameNameSelect(String name);

}