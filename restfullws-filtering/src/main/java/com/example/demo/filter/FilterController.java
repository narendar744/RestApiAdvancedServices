package com.example.demo.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {
	
	@GetMapping("/list")
	public List<UserFilter> userList() {
		return  Arrays.asList (new UserFilter("nnr", "test123"),new UserFilter("mx","test456"));
	}

}
