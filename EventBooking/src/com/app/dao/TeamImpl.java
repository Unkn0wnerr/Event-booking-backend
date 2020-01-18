package com.app.dao;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojo.Team;
import com.app.pojo.User;

@Repository
public class TeamImpl implements ITeamDao {

	@Autowired
	private SessionFactory sf;
	
	public TeamImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("Inside TeamImpl cnstr");
	}

	@Override
	public Team registerTeam(Team t) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().persist(t);
		return null;
	}
	
	
}
