package com.example.yeper.yeper.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.yeper.yeper.entity.Cards;

@Service
public interface CardServices {
	
	public Cards add(Cards card);
	public Cards update(Cards card);
	public List<Cards> getall();
	public List<Cards> getbyname(String name);

	public  Cards delete(int id);
}
