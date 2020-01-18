package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ITeamDao;
import com.app.pojo.Team;

@RestController
@RequestMapping("/team")
public class TeamController {
	
	
	@Autowired
	private ITeamDao dao;
	
	@PostMapping("/register")
	public Team createTeam(@RequestBody Team t)
	{
	System.out.println("team successfully created");	
		return dao.registerTeam(t);
	}
	
	@GetMapping("/{team_id}")
	public Team getTeamById(@PathVariable Integer team_id)
	{
		System.out.println("In get team details "+team_id);
		return dao.getDetailsTeam(team_id);
	}

	@GetMapping("/list")
	public List<Team> getList()
	{
		return dao.getList();
	}
	 
}
