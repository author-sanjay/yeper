package com.example.yeper.yeper.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	public String name;
	
	public String email;
	
	public int phonenumber;
	
	public String Address;
	
	public String ReferalCode;
	
	public boolean isuser;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	public List<Orders> orders;
	
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	public Wallet wallet;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	public List<Referrals> referrals;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(long id, String name, String email, int phonenumber, String address, String referalCode,
			boolean isuser, List<Orders> orders, Wallet wallet, List<Referrals> referrals) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		Address = address;
		ReferalCode = referalCode;
		this.isuser = isuser;
		this.orders = orders;
		this.wallet = wallet;
		this.referrals = referrals;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getReferalCode() {
		return ReferalCode;
	}

	public void setReferalCode(String referalCode) {
		ReferalCode = referalCode;
	}

	public boolean isIsuser() {
		return isuser;
	}

	public void setIsuser(boolean isuser) {
		this.isuser = isuser;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public List<Referrals> getReferrals() {
		return referrals;
	}

	public void setReferrals(List<Referrals> referrals) {
		this.referrals = referrals;
	}

	
}
