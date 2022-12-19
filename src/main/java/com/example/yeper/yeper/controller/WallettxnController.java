package com.example.yeper.yeper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yeper.yeper.entity.Wallet_transactions;
import com.example.yeper.yeper.services.WalletServices;
import com.example.yeper.yeper.services.WalletTxnServices;

@RequestMapping("/txn")
@RestController
public class WallettxnController {
	@Autowired
	public WalletTxnServices wallettxnservice;

	@GetMapping(path = "/get")
	public List<Wallet_transactions> get() {
		return this.wallettxnservice.getall();
	}

	@PostMapping(path = "/add/{id}")
	public Wallet_transactions add(@RequestBody Wallet_transactions txn, @PathVariable long id) {
		return this.wallettxnservice.add(txn, id);
	}

	@GetMapping(path = "getsingle/{id}")
	public List<Wallet_transactions> getall(@PathVariable long id) {
		return this.wallettxnservice.getsingle(id);
	}
}
