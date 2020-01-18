package com.app.dao;

import java.util.Date;
import java.util.List;

import com.app.pojo.Event;

public interface IEventDao {
	List<Event> getAllEvents();
	List<Event> upcomingEvent(Date dt);
	List<Event> currentEvent(Date dt);
	List<Event> pastEvent(Date dt);
	List<Event> getEventDtlsbyGame(String game);
}
