package com.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {
private Integer ticketId;//PK
private int seatNo;
private boolean ticketStatus;
private int ticketPrice;
private String category;
//FK
private User userTicket;
//FK
private Event eventTicket;


public Ticket() {
	System.out.println("Inside Ticket Default Constructor");
}


public Ticket(int seatNo, boolean ticketStatus, int ticketPrice, String category) {
	super();
	this.seatNo = seatNo;
	this.ticketStatus = ticketStatus;
	this.ticketPrice = ticketPrice;
	this.category = category;
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getTicketId() {
	return ticketId;
}

public void setTicketId(Integer ticketId) {
	this.ticketId = ticketId;
}

@Column(length=10,nullable=false,unique=true)
public int getSeatNo() {
	return seatNo;
}

public void setSeatNo(int seatNo) {
	this.seatNo = seatNo;
}

@Column(length=10,nullable=false)
public boolean isTicketStatus() {
	return ticketStatus;
}

public void setTicketStatus(boolean ticketStatus) {
	this.ticketStatus = ticketStatus;
}

@Column(length=10,nullable=false)
public int getTicketPrice() {
	return ticketPrice;
}

public void setTicketPrice(int ticketPrice) {
	this.ticketPrice = ticketPrice;
}

@Column(length=20,nullable=false)
public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "user_id")
public User getUserTicket() {
	return userTicket;
}

public void setUserTicket(User userTicket) {
	this.userTicket = userTicket;
}

@ManyToOne
@JoinColumn(name = "event_id")
public Event getEventTicket() {
	return eventTicket;
}

public void setEventTicket(Event eventTicket) {
	this.eventTicket = eventTicket;
}


@Override
public String toString() {
	return "Ticket [ticketId=" + ticketId + ", seatNo=" + seatNo + ", ticketStatus=" + ticketStatus + ", ticketPrice="
			+ ticketPrice + ", category=" + category + "]";
}




}
