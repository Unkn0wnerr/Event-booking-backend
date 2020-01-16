package com.app.dao;

import com.app.pojo.User;

public interface IUserDao {

	User getUserDetails(int id);
	User registerUser(User u);
	User authenticateUser(String email,String password);
	
	
}
