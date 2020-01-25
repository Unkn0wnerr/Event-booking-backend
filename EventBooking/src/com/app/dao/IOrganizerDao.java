package com.app.dao;

import java.util.List;

import com.app.pojo.Organization;

public interface IOrganizerDao {
	
	Organization getOrgDetails(int id);
	Organization registerOrg(Organization o);
	Organization authenticateOrg(String email,String password);
	List<Organization> getAllOrg();

}
