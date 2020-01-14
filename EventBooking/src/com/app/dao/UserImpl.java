package com.app.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserImpl implements IUserDao {
	
	@Autowired
	private SessionFactory sf;
	
	public UserImpl() {
		System.out.println("Inside UserImpl cnstr");
	}
	
	
	
	

}
