package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojo.Ticket;

@Repository
@Transactional
public class TicketImpl implements ITicketDao {

	@Autowired
	private SessionFactory sf;
	
	public void Ticket() {
		// TODO Auto-generated method stub
		System.out.println("Inside Ticket impl constructor");
	}
	
	@Override
	public Ticket bookTicket(Ticket t) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().persist(t);
		System.out.println("registration successfull");
		return t;		
		
	}

	@Override
    	 public Ticket getTicketBYUserId(int userId) {
		String jpql = "select t from Ticket t where t.user_id=:id";
		return sf.getCurrentSession().createQuery(jpql,Ticket.class).setParameter("id", userId).getSingleResult();
	}

	@Override
	public Ticket getTicketBYTicketId(int Id) {
		String jpql = "select t from Ticket t where t.ticketId=:id";
		return sf.getCurrentSession().createQuery(jpql,Ticket.class).setParameter("id", Id).getSingleResult();
	}

}
