package com.app.dao;

import java.util.List;

import com.app.pojo.User;

public interface IUserDao {

	User getUserDetails(int id);
	User registerUser(User u);
	User authenticateUser(String email,String password);
	List<User> getAllUser();
	String deleteUser(int userId);
	
	
}
