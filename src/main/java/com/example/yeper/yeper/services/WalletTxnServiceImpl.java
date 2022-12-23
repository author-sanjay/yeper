package com.example.yeper.yeper.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.dao.UserDao;
import com.example.yeper.yeper.dao.WalletTxnDao;
import com.example.yeper.yeper.dao.Walletdao;
import com.example.yeper.yeper.entity.Users;
import com.example.yeper.yeper.entity.Wallet;
import com.example.yeper.yeper.entity.Wallet_transactions;

@Service
public class WalletTxnServiceImpl implements WalletTxnServices{

	
	@Autowired
	public WalletTxnDao wallettxndao;

	@Autowired
	public Walletdao walletdao;
	
	@Autowired
	public UserDao userdao;
	
	@Override
	public List<Wallet_transactions> getall() {
		// TODO Auto-generated method stub
		
		return wallettxndao.findAll();
	}

	@Override
	public Wallet_transactions add(Wallet_transactions txn, String id) {
		// TODO Auto-generated method stub
		Optional<Users> user=userdao.findById(id);
		if(user.isPresent()) {
			Users user2Users=user.get();
			Wallet wallet=user2Users.getWallet();
			txn.setWallet(wallet);
			wallettxndao.save(txn);
			return txn;
		}
		else {
			return null;
		}
//		Optional<Wallet> wal=walletdao.findById(id);
//		if(wal.isPresent()) {
//			Wallet wal1=wal.get();
//			txn.setWallet(wal1);
//			wallettxndao.save(txn);
//			return txn;
//		}else {
//		return null;}
	}

	@Override
	public Wallet_transactions getsingledetail(long id) {
		// TODO Auto-generated method stub
		Optional<Wallet_transactions> txn= wallettxndao.findById(id);
		if(txn.isPresent()) {
			return txn.get();
		}else {
			return null;
		}
	}

	@Override
	public List<Wallet_transactions> getsingle(String id) {
		// TODO Auto-generated method stub
		Optional<Users> user=userdao.findById(id);
		if(user.isPresent()) {
			Users user1=user.get();
			Wallet wallet=user1.getWallet();
			return wallet.getTxn();
			
		}
		return null;
	}

}
