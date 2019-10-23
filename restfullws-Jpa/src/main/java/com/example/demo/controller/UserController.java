package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.entity.Posts;
import com.example.demo.entity.User;

@RestController
public class UserController {
	private UserService service;

	@Autowired
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<User> findAll(){
		return service.userList();
		
	}

	@GetMapping("/users/{userId}")
	public User findbyId(@PathVariable("userId")int id) {
		return service.findbyId(id);
	}
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		User theUser=service.save(user);
		return theUser;
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		User theUser=service.save(user);
		return theUser;
	}
	@DeleteMapping("/users/{userId}")
	public String deleteById(@PathVariable("userId")int id) {
		
		service.deleteById(id);
		return "user deleted with id of "+id;
	}
	@GetMapping("/users/{id}/posts")
	public List<Posts> findUsersByPostId(@PathVariable("id")int id){
	
			 User user = service.findbyId(id);
				 if(user==null) {
					 throw new RuntimeException("user not found..");
				 }
				return user.getPosts();
	}
}
