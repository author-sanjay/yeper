package com.example.yeper.yeper.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.dao.Walletdao;
import com.example.yeper.yeper.entity.Wallet;
import com.example.yeper.yeper.entity.Wallet_transactions;


@Service
public class WalletServiceImpl implements WalletServices{

	List<Wallet_transactions> txn;
	@Autowired
	public Walletdao walletdao;
	@Override
	public Wallet add(Wallet wal) {
		// TODO Auto-generated method stub
		
		return walletdao.save(wal);
	}

	@Override
	public Wallet update(long id) {
		// TODO Auto-generated method stub
		Optional<Wallet> wal=walletdao.findById(id);
		if(wal.isPresent()) {
			Wallet wal2=wal.get();
			txn=wal2.getTxn();
			long bal=0;
			for(int i=0;i<txn.size();i++) {
				bal=(long) txn.get(i).amount;
			
			}
			wal2.setBalance(bal);
			walletdao.save(wal2);
			return wal2;
		}else {
		return null;}
	}



}
