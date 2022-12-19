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
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;

	public String order_id;

	public String order_status;

	public String product;

	public int deal;
	
	public String date;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "uid")
	public Users user;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "dealid")
	public Deals deals;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(long id, String order_id, String order_status, String product, int deal, String date, Users user,
			Deals deals) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.order_status = order_status;
		this.product = product;
		this.deal = deal;
		this.date = date;
		this.user = user;
		this.deals = deals;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getDeal() {
		return deal;
	}

	public void setDeal(int deal) {
		this.deal = deal;
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

	public Deals getDeals() {
		return deals;
	}

	public void setDeals(Deals deals) {
		this.deals = deals;
	}

	

	
}
