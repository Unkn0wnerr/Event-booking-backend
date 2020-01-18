package com.app.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Matches 
{
	private int matchId;//PK
	
	
	private Event evntS;
	
	
    private List<Participant> matchPart = new ArrayList<Participant>();
	
	public Matches() {
		System.out.println("In Matcehs Constructor");
	}

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getMatchId() {
		return matchId;
	}


	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

    
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn ( name="event_id" )
	public Event getEvntS() {
		return evntS;
	}

	public void setEvntS(Event evntS) {
		this.evntS = evntS;
	}

	
	
    @OneToMany(mappedBy = "mtP" , cascade = CascadeType.ALL , orphanRemoval = true )
	public List<Participant> getMatchPart() {
		return matchPart;
	}

	public void setMatchPart(List<Participant> matchPart) {
		this.matchPart = matchPart;
	}

	@Override
	public String toString() {
		return "Matches [matchId=" + matchId + "]";
	}


	
}
