package com.example.demo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	private static int userCount = 2;
	public static List<User> users = new ArrayList<>();
	static {

		users.add(new User(1, "narendar", new Date()));
		users.add(new User(2, "abhi", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null)
			user.setId(++userCount);
		users.add(user);
		return user;
	}

	public User findById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}

		}
		return null;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user=iterator.next();
			if(user.getId()==id) {
				iterator.remove();
				return user;
			}
	

		}
		return null;
	}
	
	
	
	
	
	

}
