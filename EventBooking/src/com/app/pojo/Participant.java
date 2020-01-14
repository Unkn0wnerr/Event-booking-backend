package com.app.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Participant 
{
	private int pId; 
	
	private Matches mtP;
	
	//one-to-one
	private Team partT;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	@ManyToOne
	@JoinColumn (name="match_id")
	public Matches getMtP() {
		return mtP;
	}

	public void setMtP(Matches mtP) {
		this.mtP = mtP;
	}

	@OneToOne
	@JoinColumn(name = "team_id")
	public Team getPartT() {
		return partT;
	}

	public void setPartT(Team partT) {
		this.partT = partT;
	}

}
