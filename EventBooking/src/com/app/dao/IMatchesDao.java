package com.app.dao;

import java.util.Date;
import java.util.List;

import com.app.pojo.Matches;

public interface IMatchesDao {
	
	List<Matches> upcomingMatches(Date dt);
	List<Matches> todaysMatches(Date dt);
	List<Matches> pastMatches(Date dt);
	List<Matches> getMatchDtlsbyGame(String game);

}
