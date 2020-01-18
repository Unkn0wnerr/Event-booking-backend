package com.app.dao;

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
	public List<Event> upcomingEvent(String game) {
		String jpql = "select e from Event e where e.startDate > CURRENT_TIMESTAMP and e.gameName=:gameNm";
		return sf.getCurrentSession().createQuery(jpql, Event.class).setParameter("gameNm",game).getResultList();
	}


	@Override
	public List<Event> currentEvent(String game) {
		
		String jpql = "select e from Event e where e.startDate<=CURRENT_TIMESTAMP  and e.endDate>=CURRENT_TIMESTAMP  and e.gameName=:gameNm";
		return sf.getCurrentSession().createQuery(jpql, Event.class).setParameter("gameNm",game).getResultList();
	}


	@Override
	public List<Event> pastEvent(String game) {
		String jpql = "select e from Event e where e.endDate < CURRENT_TIMESTAMP  and e.gameName=:gameNm";
		return sf.getCurrentSession().createQuery(jpql, Event.class).setParameter("gameNm",game).getResultList();
	}


	@Override
	public List<Event> getEventDtlsbyGame(String game) {
		String jpql = "select e from Event e where e.gameName=:gameNm";
		return sf.getCurrentSession().createQuery(jpql, Event.class).setParameter("gameNm",game).getResultList();
	}




	@Override
	public Event eventRegister(Event e) {
		sf.getCurrentSession().persist(e);
		System.out.println("Event registration successfull");
		return e;
	}

	
}
