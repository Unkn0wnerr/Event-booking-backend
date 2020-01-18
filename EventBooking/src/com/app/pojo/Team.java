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
import javax.persistence.OneToOne;

@Entity
public class Team {
private Integer teamId;//PK
private String teamName;
private String country;
private boolean trustedStatus;
//FK
//Team HAS-A multiple users
private List<User> user = new ArrayList<User>();
	
//One-to-One

private Participant partTeam;

public Team() {
	System.out.println("Inside Team Default Contructor");
}

public Team(String teamName, String country, boolean trustedStatus) {
	super();
	
	this.teamName = teamName;
	this.country = country;
    this.trustedStatus = trustedStatus;
    System.out.println("Inside Team para Contructor");
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Integer getTeamId() {
	return teamId;
}

public void setTeamId(Integer teamId) {
	this.teamId = teamId;
}

@Column(length=30,unique=true)
public String getTeamName() {
	return teamName;
}

public void setTeamName(String teamName) {
	this.teamName = teamName;
}

@Column(length=20)
public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

@Column(length=10)
public boolean isTrustedStatus() {
	return trustedStatus;
}

public void setTrustedStatus(boolean trustedStatus) {
	this.trustedStatus = trustedStatus;
}

@OneToMany(mappedBy="userTeam", cascade = CascadeType.ALL,orphanRemoval =true,fetch = FetchType.EAGER)
public List<User> getUser() {
	return user;
}

public void setUser(List<User> user) {
	this.user = user;
}

@OneToOne (mappedBy = "partT" , cascade = CascadeType.ALL)
public Participant getPartTeam() {
	return partTeam;
}

public void setPartTeam(Participant partTeam) {
	this.partTeam = partTeam;
}

@Override
public String toString() {
	return "Team [teamId=" + teamId + ", teamName=" + teamName + ", country=" + country + ", trustedStatus="
			+ trustedStatus + "]";
}





// add user : helper method
public void addUser(User u)
{
	user.add(u);  // team --> user
	u.setUserTeam(this);  //user-->team
}

// remove user : helper method
public void removeUser(User u)
{
	user.remove(u);
	u.setUserTeam(null);
}


}


