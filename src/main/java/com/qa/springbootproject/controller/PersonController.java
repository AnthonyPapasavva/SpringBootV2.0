package com.qa.springbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springbootproject.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService service;

//	@PostMapping("/createPerson")
//	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
//		Person createPerson = service.addPerson(person);
//		return new ResponseEntity<Person>(createPerson, HttpStatus.CREATED);
//	}
//
//	@GetMapping("/readPerson")
//	public ResponseEntity<List<Person>> getPersons() {
//		List<Person> personData = service.readAllPersons();
//		return new ResponseEntity<List<Person>>(personData, HttpStatus.OK);
//	}
//
//	@PutMapping("/updatePerson/{personId}")
//	public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable Long personId) {
//		Person updatePerson = service.updatePerson(person, personId);
//		return new ResponseEntity<Person>(updatePerson, HttpStatus.I_AM_A_TEAPOT);
//	}
//
//	@DeleteMapping("/deletePerson/{personId}")
//	public ResponseEntity<Boolean> deletePerson(@PathVariable Long personId) {
//		Boolean deletedPerson = service.deletePerson(personId);
//		return (deletedPerson) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
//				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
//	}

}