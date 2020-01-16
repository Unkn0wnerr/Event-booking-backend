package com.app.dao;

import com.app.pojo.Organization;

public interface IOrganizerDao {
	
	Organization getOrgDetails(int id);
	Organization registerOrg(Organization o);
	Organization authenticateOrg(String email,String password);

}
