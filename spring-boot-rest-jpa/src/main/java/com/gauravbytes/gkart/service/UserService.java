package com.gauravbytes.gkart.service;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.gauravbytes.gkart.entity.User;
import com.gauravbytes.gkart.jpa.UserRepository;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="http://www.gauravbytes.com">Catch me</a>
 */
@Service
public class UserService implements GenericService<User, String> {
	private final UserRepository userRepository;
	
	public UserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public CrudRepository<User, String> getRepository() {
		return this.userRepository;
	}

	@Override
	public String getId(User entity) {
		return entity.getUserId();
	}
	
	@Override
	public User save(User entity) {
		entity.setUserId(UUID.randomUUID().toString());
		return GenericService.super.save(entity);
	}

}
