package com.app.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojo.Team;

@Repository
@Transactional
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
		return t;
	}

	@Override
	public Team getDetailsTeam(int id) {
		// TODO Auto-generated method stub
		
		String jpql="select t from Team t where t.teamId=:id";
		return sf.getCurrentSession().createQuery(jpql, Team.class).setParameter("id", id).getSingleResult();
	}

	@Override
	public List<Team> getList() {
		// TODO Auto-generated method stub
		
		String jpql = "select t from Team t"; 
		return sf.getCurrentSession().createQuery(jpql,Team.class).getResultList();
	}
	
	
}
