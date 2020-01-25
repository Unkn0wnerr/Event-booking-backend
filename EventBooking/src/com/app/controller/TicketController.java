package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ITicketDao;
import com.app.pojo.Ticket;

@RestController
@RequestMapping("/ticket")
@CrossOrigin
public class TicketController {

	@Autowired
	private ITicketDao dao;
	
	public TicketController() {
		// TODO Auto-generated constructor stub
		System.out.println("Inside Ticket controller Cnstr");
	}
	
		
	@PostMapping("/book")
	public Ticket bookTicket(@RequestBody Ticket t)
	{
		
		System.out.println("In Booking Ticket ");
		return dao.bookTicket(t);
	}
	
	@GetMapping("/tid/{userId}")
	public Ticket getTicketByuserId(@PathVariable int userId)
	{
		
		return dao.getTicketBYUserId(userId);
	}
	
	@GetMapping("/{ticketId}")
	public Ticket getTicketByticketId(@PathVariable int ticketId)
	{
		
		
		return dao.getTicketBYTicketId(ticketId);
	}
}
