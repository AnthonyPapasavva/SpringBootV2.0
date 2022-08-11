package com.qa.springbootproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.springbootproject.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	@Query(value = "SELECT * FROM user", nativeQuery = true)
	public List<User> allFromUser();

	@Query(value = "SELECT * FROM doctor WHERE username = ?1", nativeQuery = true)
	public List<User> sameNameSelect(String name);

}
