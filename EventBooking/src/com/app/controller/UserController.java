package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IUserDao;
import com.app.pojo.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserDao dao;
	
	public UserController() {
	System.out.println("Inside UserController Contructor");
	}
	
	@GetMapping("/{user_id}")
	public User getUserDetail(@PathVariable int user_id)
	{
		System.out.println("In get user details "+user_id);
		
		return dao.getUserDetails(user_id);
	}
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User u)
	{
		System.out.println("In register User ");
		return dao.registerUser(u);
	}
	@PostMapping("/validate")
	public User validateUser(@RequestParam String email,@RequestParam String password)
	{
		System.out.println("In register User ");
		return dao.authenticateUser(email, password);
	}
	
}
