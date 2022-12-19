package com.example.yeper.yeper.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.yeper.yeper.entity.Wallet_transactions;

@Service
public interface WalletTxnServices {
	public List<Wallet_transactions> getall();
	public Wallet_transactions add(Wallet_transactions txn,long id);
	public Wallet_transactions getsingledetail(long id);
	public List<Wallet_transactions> getsingle(long id);
	

}
