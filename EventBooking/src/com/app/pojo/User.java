package com.app.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User {
	private Integer userId;//PK
	private String name;
	private String nickName;
	private String userEmail;
	private String password;
	private int age;
	private Date birthDate;
	private String gender;
	private String role;//Audience or TeamMember
	private String country;
	//FK
	private Team userTeam;
	//FK
	private List<Ticket> tickets=new ArrayList<Ticket>();
	
	public User() {
		System.out.println("Inside User Default Contructor");
	}

	public User(String name, String nickName, String userEmail, String password, int age, Date birthDate, String gender,
			String role, String country) {
		super();
		this.name = name;
		this.nickName = nickName;
		this.userEmail = userEmail;
		this.password = password;
		this.age = age;
		this.birthDate = birthDate;
		this.gender = gender;
		this.role = role;
		this.country = country;
		System.out.println("Inside User Para Contructor");
		
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(length=30,nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length=20,nullable=false)
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
 
	@Column(length=50,unique=true,nullable=false)
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
    
	@Column(length=30,nullable=false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(nullable=false)
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Temporal(TemporalType.DATE)
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Column(length=15,nullable=false)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(length=10,nullable=false)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(length=25,nullable=false)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@ManyToOne
	@JoinColumn(name="team_id")
	public Team getUserTeam() {
		return userTeam;
	}

	public void setUserTeam(Team userTeam) {
		this.userTeam = userTeam;
	}

		
	@OneToMany(mappedBy = "userTicket", cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", nickName=" + nickName + ", userEmail=" + userEmail
				+ ", password=" + password + ", age=" + age + ", birthDate=" + birthDate + ", gender=" + gender
				+ ", role=" + role + ", country=" + country + "]";
	}
	
	
	
	// add ticket : helper method
	public void addTicket(Ticket t)
	{
		tickets.add(t);  // user --> ticket
		t.setUserTicket(this);  //ticket-->user
	}

	// remove ticket : helper method
	public void removeTicket(Ticket t)
	{
		tickets.remove(t);
		t.setUserTicket(null);
	}
	

}
