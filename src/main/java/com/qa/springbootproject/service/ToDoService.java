package com.qa.springbootproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springbootproject.domain.ToDo;
import com.qa.springbootproject.repo.ToDoRepo;

@Service
public class ToDoService {

	@Autowired
	private ToDoRepo repo;

	public ToDoService() {

	}

	@Autowired
	public ToDoService(ToDoRepo repo) {
		this.repo = repo;
	}

	public ToDo addToDo(ToDo toDo) {
		return this.repo.save(toDo);
	}

	public List<ToDo> addManyToDos(List<ToDo> toDos) {
		return this.repo.saveAll(toDos);
	}

	public ToDo findById(Long toDoId) {
		Optional<ToDo> existingToDo = this.repo.findById(toDoId);
		if (existingToDo.get() instanceof ToDo)
			return existingToDo.get();
		return null;
	}

	public List<ToDo> readAllToDos() {
		return this.repo.findAll();
	}

	public ToDo updateToDo(ToDo updateToDo, Long toDoId) {
		Optional<ToDo> existingToDo = this.repo.findById(toDoId);

		if (existingToDo.get() instanceof ToDo) {
			ToDo oldToDo = existingToDo.get();

			oldToDo.setToDoTitle(updateToDo.getToDoTitle());
			oldToDo.setToDoItem(updateToDo.getToDoItem());
			oldToDo.setToDoComplete(updateToDo.getToDoComplete());

			return this.repo.save(oldToDo);
		}
		return null;
	}

	public boolean deleteToDo(Long toDoId) {
		this.repo.deleteById(toDoId);
		boolean exists = this.repo.existsById(toDoId);
		return !exists;
	}
}
