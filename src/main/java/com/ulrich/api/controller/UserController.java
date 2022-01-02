package com.ulrich.api.controller;

import java.util.List;

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

import com.ulrich.api.model.User;
import com.ulrich.api.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	//build create user rest api
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new 	ResponseEntity<User>(userService.saveUser(user),HttpStatus.CREATED);
	}
	
	//build get all users REST api
	
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	//build get user by id
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long userId){
		return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);
	}
	
	//build update user rest api
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long id,@RequestBody User user){
		return new ResponseEntity<User>(userService.updateUser(user, id),HttpStatus.OK);
	}
	
	@DeleteMapping ("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
		userService.deleteUser(id);
		return new ResponseEntity<String>("user delete succefully !", HttpStatus.OK);
	}
}
