package com.example.yeper.yeper.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;

	public String email;
	public String password;
	public long earning;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(long id, String email, String password, long earning) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.earning = earning;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getEarning() {
		return earning;
	}
	public void setEarning(long earning) {
		this.earning = earning;
	}



}
