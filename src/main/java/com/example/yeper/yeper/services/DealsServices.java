package com.example.yeper.yeper.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.yeper.yeper.entity.Deals;

@Service
public interface DealsServices {
	public Deals add(Deals deal);
	public boolean delete(long id);
	public Deals update(long id, Deals deal);
	
	public List<Deals> getall();
	public Deals markcomplete(long id);
}
