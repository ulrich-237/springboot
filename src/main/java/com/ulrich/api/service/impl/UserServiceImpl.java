package com.ulrich.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ulrich.api.exception.RessourceNotFoundException;
import com.ulrich.api.model.User;
import com.ulrich.api.repository.UserRepository;
import com.ulrich.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}


	@Override
	public User getUserById(long id) {
//		Optional<User> user = userRepository.findById(id);
//		if (user.isPresent()) {
//			return user.get();
//		}else {
//			throw new RessourceNotFoundException("User", "id", id);
//		}
		return userRepository.findById(id).orElseThrow(() ->
		            new RessourceNotFoundException("user", "id", id));
	}



	@Override
	public User updateUser(User user, long id) {
		User existingUser = userRepository.findById(id).orElseThrow(
				() -> new RessourceNotFoundException("user", "Id", id) );
		existingUser.setFirstname(user.getFirstname());
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		existingUser.setPersonality(user.getPersonality());
		existingUser.setPhoneNumber(user.getPhoneNumber());
		existingUser.setStatus(user.getStatus());
		// save existing user to db
		userRepository.save(existingUser);
		return existingUser;
	}



	@Override
	public void deleteUser(long id) {
		// check whetter a user exist in a db or not
		userRepository.findById(id).orElseThrow(
				() -> new RessourceNotFoundException("user", "Id", id));
		userRepository.deleteById(id);
	}

}
