package com.gauravbytes.feapp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.gauravbytes.feapp.model.User;

/**
 * 
 * @author Mazra, Gaurav Rai
 *
 */
@Service("userService")
public class UserService {
	private static final AtomicLong counter = new AtomicLong(0);
	
	private List<User> users = new ArrayList<>();
	
	public UserService() {
	}

	public List<User> findAllUsers() {
		return users;
	}
	
	public Optional<User> findById(final long id) {
		return users.stream().filter(user -> user.getId() == id).findFirst();
	}
	
	public Optional<User> findByName(final String name) {
		return users.stream().filter(user -> user.getUsername().equalsIgnoreCase(name)).findFirst();
	}
	
	public void saveUser(final User user) {
		user.setId(counter.incrementAndGet());
		users.add(user);
	}

	public void updateUser(final User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public void deleteUserById(final long id) {
		for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
		    User user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean userExists(final User user) {
		return findByName(user.getUsername()).isPresent();
	}
	
}
