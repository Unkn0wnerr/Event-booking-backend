package com.app.dao;

import java.util.List;

import com.app.pojo.Event;

public interface IEventDao {
	
	List<Event> upcomingEvent(String game);
	List<Event> currentEvent(String game);
	List<Event> pastEvent(String game);
	List<Event> getEventDtlsbyGame(String game);
	Event eventRegister(Event e);
	Event getEventbyId(int id);
}
