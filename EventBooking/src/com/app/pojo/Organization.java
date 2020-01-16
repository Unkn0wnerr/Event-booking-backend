package com.app.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Organization {
	private Integer orgId;//PK
	private String orgEmail;
	private String orgName;
	private String orgPassword;
	private boolean trustedStatus; 
	
	private List<Event> events = new ArrayList<Event>();
	
	public Organization() {
		System.out.println("Inside Organization Default Constructor");
	}

	public Organization(String orgEmail, String orgName, String orgPassword, boolean trustedStatus) {
		super();
		this.orgEmail = orgEmail;
		this.orgName = orgName;
		this.orgPassword = orgPassword;
		this.trustedStatus = trustedStatus;
		System.out.println("Inside Organization Para Constructor");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getOrgId() {
		return orgId;
	}

	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	@Column(length=50,unique=true,nullable=false)
	public String getOrgEmail() {
		return orgEmail;
	}

	public void setOrgEmail(String orgEmail) {
		this.orgEmail = orgEmail;
	}

	@Column(length=30,unique=true,nullable=false)
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	@Column(length=30,nullable=false)
	public String getOrgPassword() {
		return orgPassword;
	}

	public void setOrgPassword(String orgPassword) {
		this.orgPassword = orgPassword;
	}

	//@Column(nullable=true)
	public boolean isTrustedStatus() {
		return trustedStatus;
	}

	public void setTrustedStatus(boolean trustedStatus) {
		this.trustedStatus = trustedStatus;
	}

	@OneToMany(mappedBy = "org",cascade =CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER )
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Organization [orgId=" + orgId + ", orgEmail=" + orgEmail + ", orgName=" + orgName + ", orgPassword="
				+ orgPassword + ", trustedStatus=" + trustedStatus + "]";
	}

	

	// add event : helper method
	public void addEvent(Event e)
	{
		events.add(e);  // organization --> event
		e.setOrg(this);  //event-->organization
	}

	// remove event : helper method
	public void removeEvent(Event e)
	{
		events.remove(e);
		e.setOrg(null);
	}
	
	
	
}
