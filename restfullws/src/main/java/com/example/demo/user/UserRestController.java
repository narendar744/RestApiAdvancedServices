package com.example.demo.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserRestController {
	
	private UserDao service;
	@Autowired
	public UserRestController(UserDao service) {
		this.service = service;
	}

	@GetMapping("/users")
	public List<User> findallusers(){
		return service.findAll();
		
	}
	@GetMapping("/users/{id}")
	public User findById(@PathVariable int id) {
		User user = service.findById(id);
		if(user==null) {
			throw new UserNotFoundException("user not foutd with id "+id);
		}
		
		return user;
	}
	@PostMapping("/user")
	public ResponseEntity<User> createuser(@RequestBody User user) {
		User theUser = service.save(user);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("{/id}").buildAndExpand(theUser.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		User theUser = service.deleteById(id);
		if(theUser==null) {
			throw new UserNotFoundException("user not foutd with id "+id);
		}
		return "user deleted with id of "+id;
		
	}
	
	
}
