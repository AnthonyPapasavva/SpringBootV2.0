package com.qa.springbootproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.springbootproject.domain.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

	@Query(value = "SELECT * FROM person", nativeQuery = true)
	public List<Person> allFromUser();

	@Query(value = "SELECT * FROM person WHERE username = ?1", nativeQuery = true)
	public List<Person> sameNameSelect(String name);

}
