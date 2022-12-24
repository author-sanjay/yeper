package com.example.yeper.yeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yeper.yeper.entity.Wallet;
import com.example.yeper.yeper.services.WalletServices;

@RestController
@RequestMapping("/wallet")
public class WalletController {
	
	@Autowired
	public WalletServices wallet;
	
	@PostMapping(path = "/add/{$}")
	public Wallet add(@RequestBody Wallet wal) {
		return this.wallet.add(wal);
	}
	
	@PutMapping(path="/update/{id}")
	public Wallet update(@PathVariable long id) {
		return this.wallet.update(id);
	}
	
	
}
