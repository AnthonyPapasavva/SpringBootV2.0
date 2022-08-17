package com.qa.springbootproject.service;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

//	private PersonRepo repo;
//
//	public PersonService() {
//	}
//
//	public PersonService(PersonRepo repo) {
//		this.repo = repo;
//	}
//
//	public Person addPerson(Person person) {
//		return this.repo.save(person);
//	}
//
//	public List<Person> addManyPersons(List<Person> persons) {
//		return this.repo.saveAll(persons);
//	}
//
//	public Person findById(Long personId) {
//		Optional<Person> existingPerson = this.repo.findById(personId);
//		if (existingPerson.get() instanceof Person)
//			return existingPerson.get();
//		return null;
//	}
//
//	public List<Person> readAllPersons() {
//		return this.repo.findAll();
//	}
//
//	public Person updatePerson(Person updatePerson, Long personId) {
//		Optional<Person> existingPerson = this.repo.findById(personId);
//
//		if (existingPerson.get() instanceof Person) {
//			Person oldPerson = existingPerson.get();
//
//			oldPerson.setUsername(updatePerson.getUsername());
//
//			return this.repo.save(oldPerson);
//		}
//		return null;
//	}
//
//	public boolean deletePerson(Long personId) {
//		this.repo.deleteById(personId);
//		boolean exists = this.repo.existsById(personId);
//		return !exists;
//	}
//
}
