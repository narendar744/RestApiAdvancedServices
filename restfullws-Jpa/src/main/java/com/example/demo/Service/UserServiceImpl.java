package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDao repository;

	@Autowired
	public UserServiceImpl(UserDao repository) {
		this.repository = repository;
	}

	@Override
	public List<User> userList() {
	
		return repository.findAll();
	}

	@Override
	public User findbyId(int id) {
		return repository.findById(id).get();
	}

	@Override
	public User save(User user) {
		User newUser = repository.save(user);
		return newUser;

	}

	@Override
	public void deleteById(int id) {

		repository.deleteById(id);
	}

}
