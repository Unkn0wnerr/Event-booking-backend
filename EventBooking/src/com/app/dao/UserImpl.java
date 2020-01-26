package com.app.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojo.User;

@Repository
@Transactional
public class UserImpl implements IUserDao {
	
	@Autowired
	private SessionFactory sf;
	
	public UserImpl() {
		System.out.println("Inside UserImpl cnstr");
	}

	@Override
	public User getUserDetails(int id) {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(User.class,id);
	}

	@Override
	public User registerUser(User u) {
		sf.getCurrentSession().persist(u);
		System.out.println("registration successfull");
		return u;
	}

	@Override
	public User authenticateUser(String email, String password) {
		// TODO Auto-generated method stub
		String jpql="select u from User u where u.userEmail=:em and u.password=:pwd";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email).setParameter("pwd",password).getSingleResult();
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		String jpql="select u from User u";
		return sf.getCurrentSession().createQuery(jpql, User.class).getResultList();
	}

	@Override
	public String deleteUser(int userId) {
		Session hs=sf.getCurrentSession();
		User u =hs.get(User.class, userId);
		if(u!=null)
		{
			hs.delete(u);
		}
		
		return "Delete User";
	}
	
	
	
	
	
	

}
