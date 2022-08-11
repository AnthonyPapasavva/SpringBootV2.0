package com.qa.springbootproject.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.springbootproject.domain.ToDo;

@Repository
public interface ToDoRepo extends JpaRepository<ToDo, Long> {

	@Query(value = "SELECT * FROM to_do", nativeQuery = true)
	public List<ToDo> allFromToDo();

	@Query(value = "SELECT * FROM to_do WHERE title = ?1", nativeQuery = true)
	public List<ToDo> sameNameSelect(String title);

}
