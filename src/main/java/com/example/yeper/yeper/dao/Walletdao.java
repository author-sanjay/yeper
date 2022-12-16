package com.example.yeper.yeper.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yeper.yeper.entity.Wallet;

public interface Walletdao extends JpaRepository<Wallet, Long> {

}
