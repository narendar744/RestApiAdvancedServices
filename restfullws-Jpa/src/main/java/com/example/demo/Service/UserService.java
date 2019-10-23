package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {
	public List<User> userList();
	public User findbyId(int id);
	public User save(User user);
	public void deleteById(int id);

}
