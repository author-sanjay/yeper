package com.example.yeper.yeper.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {

	@Id
	public String id;

	public String name;
	public String email;
	public String password;
	public long earning;
	public  String role;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String id, String name, String email, String password, long earning, String role) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.earning = earning;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
