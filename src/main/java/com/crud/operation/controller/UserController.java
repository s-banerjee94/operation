package com.crud.operation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.operation.modal.User;
import com.crud.operation.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User newUser = this.userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
	}

	@GetMapping("/get")
	public ResponseEntity<User> getUserById(@RequestParam long id) {
		User user = this.userService.getUserById(id);
		return ResponseEntity.status(HttpStatus.FOUND).body(user);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> users = this.userService.getAllUser();
		return ResponseEntity.status(HttpStatus.FOUND).body(users);
	}

	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User updatedUser = this.userService.updateUser(user);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedUser);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteUser(@RequestParam long id) {
		this.userService.deleteUser(id);
		return ResponseEntity.ok().body("Deleted!");
	}
}
