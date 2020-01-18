package com.app.dao;

import com.app.pojo.Ticket;

public interface ITicketDao {
	
	Ticket bookTicket(Ticket t);
	Ticket getTicketBYUserId(int Id);
	
	Ticket getTicketBYTicketId(int Id);
	

}
