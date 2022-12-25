package com.example.yeper.yeper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yeper.yeper.entity.Referrals;
import com.example.yeper.yeper.services.ReferralServices;

@RequestMapping("/refer")
@RestController
public class ReferralsController {
	
	@Autowired
	public ReferralServices referservice;
	
	@GetMapping(path = "/get")
	public List<Referrals> getall(){
		return this.referservice.getall();
	}
	
	@PostMapping(path = "/add/{id}")
	public Referrals add(@RequestBody Referrals referrals,@PathVariable String id) {
		return this.referservice.add(referrals, id);
	}
	
	@GetMapping(path="/ofuser/{id}")
	public List<Referrals> get(@PathVariable String id){
		return this.referservice.ofuser(id);
	}
	
	
}
