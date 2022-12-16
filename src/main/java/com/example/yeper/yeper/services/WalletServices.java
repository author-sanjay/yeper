package com.example.yeper.yeper.services;

import org.springframework.stereotype.Service;

import com.example.yeper.yeper.entity.Wallet;

@Service
public interface WalletServices {

	public Wallet add(Wallet wal);
	public Wallet update(long id);
	
	
}
