package com.manish.user.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.manish.user.dao.UserDao;
import com.manish.user.pojo.User;

public class UserDaoImpl implements UserDao {

	HashMap<String, User> users = new HashMap<String, User>();

	@Override
	public User createUser(User user) {
		UUID uuid = UUID.randomUUID();
		String uuidAsString = uuid.toString();
		user.setUidLink(uuidAsString);
		users.put(uuidAsString, user);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<>();
		for (String key : users.keySet())
			userList.add(users.get(key));
		return userList;
	}

}
