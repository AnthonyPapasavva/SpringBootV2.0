package com.qa.springbootproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springbootproject.domain.Person;
import com.qa.springbootproject.repo.PersonRepo;

@Service
public class PersonService {

	@Autowired
	private PersonRepo repo;

	public PersonService() {

	}

	@Autowired
	public PersonService(PersonRepo repo) {
		this.repo = repo;
	}

	public Person addUser(Person user) {
		return this.repo.save(user);
	}

	public List<Person> addManyUsers(List<Person> users) {
		return this.repo.saveAll(users);
	}

	public Person findById(Long userId) {
		Optional<Person> existingUser = this.repo.findById(userId);
		if (existingUser.get() instanceof Person)
			return existingUser.get();
		return null;
	}

	public List<Person> readAllUsers() {
		return this.repo.findAll();
	}

	public Person updateUser(Person updateUser, Long userId) {
		Optional<Person> existingUser = this.repo.findById(userId);

		if (existingUser.get() instanceof Person) {
			Person oldUser = existingUser.get();

			oldUser.setUsername(updateUser.getUsername());

			return this.repo.save(oldUser);
		}
		return null;
	}

	public boolean deleteUser(Long userId) {
		this.repo.deleteById(userId);
		boolean exists = this.repo.existsById(userId);
		return !exists;
	}

}
