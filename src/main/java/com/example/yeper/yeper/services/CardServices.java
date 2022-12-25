package com.example.yeper.yeper.services;

import org.springframework.stereotype.Service;

import com.example.yeper.yeper.entity.Cards;

@Service
public interface CardServices {
	
	public Cards add(Cards card);
	public Cards update(Cards card);

}
