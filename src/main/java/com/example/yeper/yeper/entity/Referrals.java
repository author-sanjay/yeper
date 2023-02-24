package com.example.yeper.yeper.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Referrals {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	public String date;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "user")
	public Users user;

	public String name;

	public float contri;

	public Referrals() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Referrals(long id, String date, Users user, String name, float contri) {
		this.id = id;
		this.date = date;
		this.user = user;
		this.name = name;
		this.contri = contri;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getContri() {
		return contri;
	}

	public void setContri(float contri) {
		this.contri = contri;
	}
}
