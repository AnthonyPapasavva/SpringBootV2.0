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
@RequestMapping("/home")
public class PersonController {

	@Autowired
	PersonService service;

	@PostMapping("/createPerson")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		Person createPerson = service.addPerson(person);
		return new ResponseEntity<Person>(createPerson, HttpStatus.CREATED);
	}

	@GetMapping("/readPerson")
	public ResponseEntity<List<Person>> getPersons() {
		List<Person> personData = service.readAllPersons();
		return new ResponseEntity<List<Person>>(personData, HttpStatus.OK);
	}

	// May need to change the {id} to respective personId in controllers **
	@PutMapping("/updatePerson/{id}")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable Long personId) {
		Person updatePerson = service.updatePerson(person, personId);
		return new ResponseEntity<Person>(updatePerson, HttpStatus.I_AM_A_TEAPOT);
	}

	@DeleteMapping("/deletePerson/{id}")
	public ResponseEntity<Boolean> deletePerson(@PathVariable Long personId) {
		Boolean deletedPerson = service.deletePerson(personId);
		return (deletedPerson) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

}
