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

	public String phonenumber;

	public String address;

	public String referalCode;

	public boolean isuser;

	public String referedby;

	public int acnumber;
	public String bankname;
	public String idfc;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	public List<Orders> orders;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	public Wallet wallet;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	public List<Referrals> referrals;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(long id, String name, String email, String phonenumber, String address, String referalCode,
			boolean isuser, String referedby, int acnumber, String bankname, String idfc, List<Orders> orders,
			Wallet wallet, List<Referrals> referrals) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
		this.address = address;
		this.referalCode = referalCode;
		this.isuser = isuser;
		this.referedby = referedby;
		this.acnumber = acnumber;
		this.bankname = bankname;
		this.idfc = idfc;
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

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getReferalCode() {
		return referalCode;
	}

	public void setReferalCode(String referalCode) {
		this.referalCode = referalCode;
	}

	public boolean isIsuser() {
		return isuser;
	}

	public void setIsuser(boolean isuser) {
		this.isuser = isuser;
	}

	public String getReferedby() {
		return referedby;
	}

	public void setReferedby(String referedby) {
		this.referedby = referedby;
	}

	public int getAcnumber() {
		return acnumber;
	}

	public void setAcnumber(int acnumber) {
		this.acnumber = acnumber;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getIdfc() {
		return idfc;
	}

	public void setIdfc(String idfc) {
		this.idfc = idfc;
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
