package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IUserDao;

@RestController
public class UserController {

	@Autowired
	private IUserDao dao;
	
	public UserController() {
	System.out.println("Inside UserController Contructor");
	}
	
}
