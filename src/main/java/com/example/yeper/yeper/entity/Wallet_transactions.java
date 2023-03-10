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
	
	public long amount;

	public String message;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "wallet")
	public Wallet wallet;

	public Wallet_transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wallet_transactions(long id, String date, boolean incoming, long amount, String message, Wallet wallet) {
		this.id = id;
		this.date = date;
		this.incoming = incoming;
		this.amount = amount;
		this.message = message;
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

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
}
