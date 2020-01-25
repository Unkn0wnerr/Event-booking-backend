package com.app.dao;

import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.app.pojo.Matches;


@Repository
@Transactional
public class MatchImpl implements IMatchesDao {
	
	@Autowired
	private SessionFactory sf;
	

	@Override
	public List<Matches> upcomingMatches(Date dt) {
		String jpql = "select m from Matches m where m.startDate > date";
		return sf.getCurrentSession().createQuery(jpql, Matches.class).setParameter("date", dt).getResultList();
	}

	@Override
	public List<Matches> todaysMatches(Date dt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Matches> pastMatches(Date dt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Matches> getMatchDtlsbyGame(String game) {
		// TODO Auto-generated method stub
		return null;
	}

}
