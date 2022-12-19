package com.example.yeper.yeper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.yeper.yeper.entity.Deals;
import com.example.yeper.yeper.services.DealsServices;

@RequestMapping("/deals")
@RestController
public class DealsController {
	
	@Autowired
	public DealsServices deals;
	
	@GetMapping(path = "/getall")
	public List<Deals> getall(){
		return this.deals.getall();
	}
	
	@PostMapping(path = "/add")
	public Deals add(@RequestBody Deals deal){
		return this.deals.add(deal);
	}
	
	@PutMapping(path="/update/{id}")
	public Deals update(@PathVariable long id, @RequestBody Deals deal ) {
		return this.deals.update(id,deal);
	}
	
	@DeleteMapping(path="/delete/{id}")
	public boolean delete(@PathVariable long id) {
		return this.deals.delete(id);
	}
	
	@PutMapping(path="/complete/{id}")
	public Deals complete(@PathVariable long id) {
		return this.deals.markcomplete(id);
	}
	
	
}