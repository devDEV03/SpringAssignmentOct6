package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user2")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;
	private String username;
	private String password;
	private String emailid;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(Long userid, String username) {
		super();
		this.userid = userid;
		this.username = username;
	}
	
	public User(Long userid, String username, String password, String emailid) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.emailid = emailid;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	
}
