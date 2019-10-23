package com.example.demo.filter;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeBeanFilter")
public class UserFilter {
	private String username;
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
