package com.qa.springbootproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.springbootproject.User;
import com.qa.springbootproject.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;

	public UserService() {

	}

	@Autowired
	public UserService(UserRepo repo) {
		this.repo = repo;
	}

	public User addUser(User user) {
		return this.repo.save(user);
	}

	public List<User> addManyUsers(List<User> users) {
		return this.repo.saveAll(users);
	}

	public User findById(Long userId) {
		Optional<User> existingUser = this.repo.findById(userId);
		if (existingUser.get() instanceof User)
			return existingUser.get();
		return null;
	}

	public List<User> readAllUsers() {
		return this.repo.findAll();
	}

	public User updateUser(User updateUser, Long userId) {
		Optional<User> existingUser = this.repo.findById(userId);

		if (existingUser.get() instanceof User) {
			User oldUser = existingUser.get();

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
