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
public class Wallet_transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	public String date;
	
	public boolean incoming;
	
	public float amount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "wallet")
	public Wallet wallet;

	public Wallet_transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wallet_transactions(long id, String date, boolean incoming, float amount, Wallet wallet) {
		super();
		this.id = id;
		this.date = date;
		this.incoming = incoming;
		this.amount = amount;
		this.wallet = wallet;
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

	public boolean isIncoming() {
		return incoming;
	}

	public void setIncoming(boolean incoming) {
		this.incoming = incoming;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
		

}
