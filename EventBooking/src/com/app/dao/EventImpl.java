package com.app.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojo.Event;
@Repository
@Transactional
public class EventImpl implements IEventDao {

	
	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public List<Event> getAllEvents() {

		
			String jpql = "select e from Event e";
			return sf.getCurrentSession().createQuery(jpql, Event.class).getResultList();
	
	}


	@Override
	public List<Event> upcomingEvent(Date dt) {
		String jpql = "select e from Event e where e.startDate > date";
		return sf.getCurrentSession().createQuery(jpql, Event.class).setParameter("date", dt).getResultList();
	}


	@Override
	public List<Event> currentEvent(Date dt) {
		String jpql = "select e from Event e where e.endDate < date";
		return sf.getCurrentSession().createQuery(jpql, Event.class).setParameter("date",dt).getResultList();
	}


	@Override
	public List<Event> pastEvent(Date dt) {
		String jpql = "select e from Event e where e.startDate<=dt and e.endDate>=dt";
		return sf.getCurrentSession().createQuery(jpql, Event.class).setParameter("date",dt).getResultList();
	}


	@Override
	public List<Event> getEventDtlsbyGame(String game) {
		String jpql = "select e from Event e where e.gameName=:gameNm";
		return sf.getCurrentSession().createQuery(jpql, Event.class).setParameter("gameNm",game).getResultList();
	}

	
}
