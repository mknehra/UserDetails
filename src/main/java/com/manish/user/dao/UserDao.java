package com.manish.user.dao;

import java.util.List;

import com.manish.user.pojo.User;

public interface UserDao {

	User createUser(User user);

	List<User> getAllUsers();
}
