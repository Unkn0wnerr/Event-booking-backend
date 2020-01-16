package com.app.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Event {
private Integer eventId;//PK
private String eventName;
private Date startDate;
private Date endDate;
private String arena;
private String gameName;
private int prizePool;	
//FK
private Organization org;	

private List<Ticket> ticketsE= new ArrayList<Ticket>();

private List<Matches> matchesE = new ArrayList<Matches>();

public Event() {
	System.out.println("Inside Event Default Constructor");
}

public Event(String eventName, Date startDate, Date endDate, String arena, String gameName, int prizePool) {
	super();
	this.eventName = eventName;
	this.startDate = startDate;
	this.endDate = endDate;
	this.arena = arena;
	this.gameName = gameName;
	this.prizePool = prizePool;
	System.out.println("Inside Event Para Constructor");
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getEventId() {
	return eventId;
}

public void setEventId(Integer eventId) {
	this.eventId = eventId;
}

@Column(length=30,nullable=false,unique=true)
public String getEventName() {
	return eventName;
}

public void setEventName(String eventName) {
	this.eventName = eventName;
}

@Temporal(TemporalType.DATE)
public Date getStartDate() {
	return startDate;
}

public void setStartDate(Date startDate) {
	this.startDate = startDate;
}

@Temporal(TemporalType.DATE)
public Date getEndDate() {
	return endDate;
}

public void setEndDate(Date endDate) {
	this.endDate = endDate;
}

@Column(length=30,nullable=false)
public String getArena() {
	return arena;
}

public void setArena(String arena) {
	this.arena = arena;
}

@Column(length=30,nullable=false)
public String getGameName() {
	return gameName;
}


public void setGameName(String gameName) {
	this.gameName = gameName;
}

@Column(length=10,nullable=false)
public int getPrizePool() {
	return prizePool;
}

public void setPrizePool(int prizePool) {
	this.prizePool = prizePool;
}

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="org_id")
public Organization getOrg() {
	return org;
}

public void setOrg(Organization org) {
	this.org = org;
}

@OneToMany(mappedBy = "eventTicket",  cascade = CascadeType.ALL,orphanRemoval = true)
public List<Ticket> getTicketsE() {
	return ticketsE;
}

@OneToMany(mappedBy = "evntS" , cascade = CascadeType.ALL , orphanRemoval = true)
public List<Matches> getMatchesE() {
	return matchesE;
}

public void setMatchesE(List<Matches> matchesE) {
	this.matchesE = matchesE;
}

public void setTicketsE(List<Ticket> ticketsE) {
	this.ticketsE = ticketsE;
}

@Override
public String toString() {
	return "Event [eventId=" + eventId + ", eventName=" + eventName + ", startDate=" + startDate + ", endDate="
			+ endDate + ", arena=" + arena + ", gameName=" + gameName + ", prizePool=" + prizePool + "]";
}


//add ticket : helper method
	public void addTicket(Ticket t)
	{
		ticketsE.add(t);  // event --> ticket
		t.setEventTicket(this);  //ticket-->event
	}

	// remove ticket : helper method
	public void removeTicket(Ticket t)
	{
		ticketsE.remove(t);
		t.setEventTicket(null);
	}
	



}
