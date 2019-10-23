package com.example.demo.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value= {"password","username"})
public class UserFilter {
	private String username;
	@JsonIgnore
	private String password;
	public UserFilter() {}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserFilter(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	

}
