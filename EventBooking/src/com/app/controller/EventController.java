package com.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IEventDao;
import com.app.pojo.Event;

@RestController
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	IEventDao dao;
	
	public EventController() {
		System.out.println("Inside EventController Contructor");
		}
	
	@GetMapping("/all")
	public List<Event> getAllEvent()
	{
		System.out.println("In get org details ");
		
		return dao.getAllEvents();
	}
		
	@GetMapping("/upcoming/{date}")
	public List<Event> getUpcomingEvent(@PathVariable Date date)
	{
		System.out.println("In get org details ");
		
		return dao.upcomingEvent(date);
	}
	
	@GetMapping("/past/{date}")
	public List<Event> getPastEvent(@PathVariable Date date)
	{
		System.out.println("In get org details ");
		
		return dao.pastEvent(date);
	}
	
	@GetMapping("/ongoing/{date}")
	public List<Event> getCurrentEvent(@PathVariable Date date)
	{
		System.out.println("In get org details ");
		
		return dao.currentEvent(date);
	}
	
	@GetMapping("/{game}")
	public List<Event> eventbyGameName(@PathVariable String game)
	{
		System.out.println("In get org details ");
		
		return dao.getEventDtlsbyGame(game);
	}

}
