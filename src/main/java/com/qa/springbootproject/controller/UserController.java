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

import com.qa.springbootproject.User;
import com.qa.springbootproject.service.UserService;

@RestController
@RequestMapping("localhost:8085")
public class UserController {

	@Autowired
	UserService service;

	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createUser = service.addUser(user);
		return new ResponseEntity<User>(createUser, HttpStatus.CREATED);
	}

	@GetMapping("/read")
	public ResponseEntity<List<User>> getUsers() {
		List<User> userData = service.readAllUsers();
		return new ResponseEntity<List<User>>(userData, HttpStatus.OK);
	}

	// May need to change the {id} to respective userId in controllers **
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long userId) {
		User updateUser = service.updateUser(user, userId);
		return new ResponseEntity<User>(updateUser, HttpStatus.I_AM_A_TEAPOT);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable Long userId) {
		Boolean deletedUser = service.deleteUser(userId);
		return (deletedUser) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

}
