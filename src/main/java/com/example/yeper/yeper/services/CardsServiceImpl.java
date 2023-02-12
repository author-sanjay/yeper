package com.example.yeper.yeper.services;

import java.util.List;
import java.util.Optional;

import com.example.yeper.yeper.dao.UserDao;
import com.example.yeper.yeper.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.dao.Cardsdao;
import com.example.yeper.yeper.entity.Cards;

@Service
public class CardsServiceImpl implements CardServices{

	@Autowired
	public Cardsdao carddao;


	@Autowired
	public UserDao userDao;

	@Override
	public Cards add(Cards card) {
		// TODO Auto-generated method stub
		card.setActive(true);
		return carddao.save(card);
	}

	@Override
	public Cards update(Cards card) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cards> getall() {
		// TODO Auto-generated method stub

		return carddao.findByActive(true);
	}

	@Override
	public List<Cards> getbyname(String name) {
		// TODO Auto-generated method stub
		return carddao.findByName(name);
	}

	@Override
	public Cards delete(int id) {
		Optional<Cards> card=carddao.findById(id);
		if(card.isPresent()){
			Cards cards=card.get();
			cards.setActive(false);


			carddao.deleteById(id);



			return card.get()		;
		}

		return null;
	}

}
