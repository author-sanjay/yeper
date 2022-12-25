package com.example.yeper.yeper.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.dao.Cardsdao;
import com.example.yeper.yeper.entity.Cards;

@Service
public class CardsServiceImpl implements CardServices{

	@Autowired
	public Cardsdao carddao;
	
	@Override
	public Cards add(Cards card) {
		// TODO Auto-generated method stub
		
		return carddao.save(card);
	}

	@Override
	public Cards update(Cards card) {
		// TODO Auto-generated method stub
		return null;
	}

}
