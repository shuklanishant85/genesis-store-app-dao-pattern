package com.dailyapp.dao;

import com.dailyapp.model.User;

public interface UserDao {
	public void addUser(User user);
	public void removeUser(User user);
	public User getUser(String email);
	public void updateUser(User user);
}
