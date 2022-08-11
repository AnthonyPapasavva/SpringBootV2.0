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

import com.qa.springbootproject.domain.Person;
import com.qa.springbootproject.service.PersonService;

@RestController
@RequestMapping("localhost:8085")
public class PersonController {

	@Autowired
	PersonService service;

	@PostMapping("/createUser")
	public ResponseEntity<Person> createUser(@RequestBody Person user) {
		Person createUser = service.addUser(user);
		return new ResponseEntity<Person>(createUser, HttpStatus.CREATED);
	}

	@GetMapping("/readUser")
	public ResponseEntity<List<Person>> getUsers() {
		List<Person> userData = service.readAllUsers();
		return new ResponseEntity<List<Person>>(userData, HttpStatus.OK);
	}

	// May need to change the {id} to respective userId in controllers **
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<Person> updateUser(@RequestBody Person user, @PathVariable Long userId) {
		Person updateUser = service.updateUser(user, userId);
		return new ResponseEntity<Person>(updateUser, HttpStatus.I_AM_A_TEAPOT);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable Long userId) {
		Boolean deletedUser = service.deleteUser(userId);
		return (deletedUser) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

}
