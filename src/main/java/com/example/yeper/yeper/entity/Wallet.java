package com.example.yeper.yeper.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Wallet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "uid")
	public Users user;
	
	@OneToMany(mappedBy = "wallet",cascade = CascadeType.ALL)
	public List<Wallet_transactions> txn;

	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wallet(int id, Users user, List<Wallet_transactions> txn) {
		super();
		this.id = id;
		this.user = user;
		this.txn = txn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Wallet_transactions> getTxn() {
		return txn;
	}

	public void setTxn(List<Wallet_transactions> txn) {
		this.txn = txn;
	}
	
	
}
