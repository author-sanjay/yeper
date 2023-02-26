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
	
	public String status;

	public String product;

	public String date;

	public String courier;
	public long deal;
	public long otp;

	public long phonenumberr;

	public String platformtxnid;
	
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

	public Orders(long id, String status, String product, String date, String courier, long deal, long otp, long phonenumberr, String platformtxnid, Users user, Deals deals) {
		this.id = id;
		this.status = status;
		this.product = product;
		this.date = date;
		this.courier = courier;
		this.deal = deal;
		this.otp = otp;
		this.phonenumberr = phonenumberr;
		this.platformtxnid = platformtxnid;
		this.user = user;
		this.deals = deals;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCourier() {
		return courier;
	}

	public void setCourier(String courier) {
		this.courier = courier;
	}

	public long getDeal() {
		return deal;
	}

	public void setDeal(long deal) {
		this.deal = deal;
	}

	public long getOtp() {
		return otp;
	}

	public void setOtp(long otp) {
		this.otp = otp;
	}

	public long getPhonenumberr() {
		return phonenumberr;
	}

	public void setPhonenumberr(long phonenumberr) {
		this.phonenumberr = phonenumberr;
	}

	public String getPlatformtxnid() {
		return platformtxnid;
	}

	public void setPlatformtxnid(String platformtxnid) {
		this.platformtxnid = platformtxnid;
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

