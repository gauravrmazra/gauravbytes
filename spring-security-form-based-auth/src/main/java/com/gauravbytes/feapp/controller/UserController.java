package com.gauravbytes.feapp.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gauravbytes.feapp.model.User;
import com.gauravbytes.feapp.service.UserService;

/**
 * Controller to perform crud operation on Users
 * 
 * @author Mazra, Gaurav Rai
 *
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getAllUsers() {
		logger.info("Getting all userss");
		List<User> users = userService.findAllUsers();
		if (users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(users);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUser(@PathVariable("id") long id) {
		logger.info("Fetching User with id : {} ", id);
		return userService.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		logger.info("Registering user: {} ", user);
		if (userService.userExists(user)) {
			logger.warn("User with username: {} already exists...", user.getUsername());
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		userService.saveUser(user);

		URI uri = ucBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
		logger.info("Updating User: {} ", user);

		Optional<User> optionalUser = userService.findById(id);
		if (optionalUser.isPresent()) {
			User currentUser = optionalUser.get();
			currentUser.setUsername(user.getUsername());
			currentUser.setAddress(user.getAddress());
			currentUser.setEmail(user.getEmail());
			userService.updateUser(currentUser);
			return ResponseEntity.ok(currentUser);
			
		}
		else {
			logger.warn("User with id :{} doesn't exists", id);
			return ResponseEntity.notFound().build();
		}

		
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
		logger.info("Deleting User with id : {}", id);

		Optional<User> optionalUser = userService.findById(id);
		if (optionalUser.isPresent()) {
			userService.deleteUserById(id);
			return ResponseEntity.noContent().build();
		}
		else {
			logger.info("User with id: {} not found", id);
			return ResponseEntity.notFound().build();
		}

	}
}