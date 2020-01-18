package com.app.dao;

import java.util.List;

import com.app.pojo.Team;

public interface ITeamDao {

	Team registerTeam(Team t);
	Team getDetailsTeam(int id);
	List<Team> getList();
}
