package com.example.yeper.yeper.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yeper.yeper.entity.Wallet_transactions;

public interface WalletTxnDao extends JpaRepository<Wallet_transactions, Long>{

}
