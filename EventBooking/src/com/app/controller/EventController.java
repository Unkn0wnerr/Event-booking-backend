package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
		
	@GetMapping("/{game}/upcoming")
	public List<Event> getUpcomingEvent(@PathVariable String game)
	{
		System.out.println("In upcoming Event List ");
		
		return dao.upcomingEvent(game);
	}
	
	@GetMapping("/{game}/past")
	public List<Event> getPastEvent(@PathVariable String game)
	{
		System.out.println("In past Event List");
		
		return dao.pastEvent(game);
	}
	
	@GetMapping("/{game}/ongoing")
	public List<Event> getCurrentEvent(@PathVariable String game)
	{
		System.out.println("In ongoing event list");
		
		return dao.currentEvent(game);
	}
	
	@GetMapping("/{game}")
	public List<Event> eventbyGameName(@PathVariable String game)
	{
		System.out.println("In game event list");
		
		return dao.getEventDtlsbyGame(game);
	}
	
	@PostMapping("/register")
	public Event registerEvent(@RequestBody Event e){
		
		System.out.println("In event register");
		return dao.eventRegister(e);
		
	}
	
	

}
