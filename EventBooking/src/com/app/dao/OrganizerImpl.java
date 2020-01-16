package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojo.Organization;
@Repository
@Transactional
public class OrganizerImpl implements IOrganizerDao {
	@Autowired
	private SessionFactory sf;
	
	
	
	
	public OrganizerImpl() {
		System.out.println("in org Implementation Constructor");
	}

	@Override
	public Organization getOrgDetails(int id) {
		// TODO Auto-generated method stub
		return sf.getCurrentSession().get(Organization.class,id);
	}

	@Override
	public Organization registerOrg(Organization o) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().persist(o);
		System.out.println("registration successfull");
		return o;
	}

	@Override
	public Organization authenticateOrg(String email, String password) {
		// TODO Auto-generated method stub
		String jpql="select o from Organization o where o.orgEmail=:em and o.orgPassword=:pwd";
		return sf.getCurrentSession().createQuery(jpql, Organization.class).setParameter("em", email).setParameter("pwd",password).getSingleResult();
	}

}
