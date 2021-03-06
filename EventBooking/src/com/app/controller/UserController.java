package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ITeamDao;
import com.app.dao.IUserDao;

import com.app.pojo.Team;
import com.app.pojo.User;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private IUserDao dao;
	@Autowired
	private ITeamDao tdao;
	
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
	public ResponseEntity<?> validateUser(@RequestBody User u)
	{
		System.out.println("In register User ");
		System.out.println(u);
		User y= dao.authenticateUser(u.getUserEmail(), u.getPassword());
		System.out.println(y);
	    return new ResponseEntity<User>(y, HttpStatus.OK);
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUserById(@PathVariable int id)
	{
		System.out.println("In delete user By id");
		String ds= dao.deleteUser(id);
		 return ds;
	}
	
	@GetMapping("/updateTeam/{userId}/{teamId}")
	public String updateUser(@PathVariable Integer userId,@PathVariable Integer teamId)
	{
		User u = dao.getUserDetails(userId);
		Team t = tdao.getDetailsTeam(teamId);
		System.out.println(userId +"-----"+teamId);
		u.setUserTeam(t);
		dao.updateTeamId(u);
		return "update";
		
	}
	
	
	@GetMapping("/list")
	public List<User> getAllList()
	{
		return dao.getAllUser();
	}
}
