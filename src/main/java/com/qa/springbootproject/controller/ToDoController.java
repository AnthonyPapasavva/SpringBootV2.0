package com.qa.springbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springbootproject.domain.ToDo;
import com.qa.springbootproject.service.ToDoService;

@RestController
@RequestMapping("/todo")
public class ToDoController {

	@Autowired
	ToDoService service;

	public ToDoController(ToDoService toDoService) {
		this.service = toDoService;
	}

	@PostMapping("/createToDo")
	public ResponseEntity<ToDo> createToDo(@RequestBody ToDo toDo) {
		ToDo createToDo = service.addToDo(toDo);
		return new ResponseEntity<ToDo>(createToDo, HttpStatus.CREATED);
	}

	@GetMapping("/read")
	public ResponseEntity<List<ToDo>> getToDos() {
		List<ToDo> toDoData = service.readAllToDos();
		return new ResponseEntity<List<ToDo>>(toDoData, HttpStatus.OK);
	}

	@PutMapping("/updateToDo/{toDoId}")
	public ResponseEntity<ToDo> updateToDo(@RequestBody ToDo toDo, @PathVariable Long toDoId) {
		ToDo updateToDo = service.updateToDo(toDo, toDoId);
		return new ResponseEntity<ToDo>(updateToDo, HttpStatus.I_AM_A_TEAPOT);
	}

	@DeleteMapping("/deleteToDo/{toDoId}")
	public ResponseEntity<Boolean> deleteToDo(@PathVariable Long toDoId) {
		Boolean deletedToDo = service.deleteToDo(toDoId);
		return (deletedToDo) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

}