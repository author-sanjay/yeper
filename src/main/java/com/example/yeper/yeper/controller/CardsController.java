package com.example.yeper.yeper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yeper.yeper.entity.Cards;
import com.example.yeper.yeper.entity.Users;
import com.example.yeper.yeper.services.CardServices;

@RestController
@RequestMapping(path = "/cards")
public class CardsController {

	@Autowired
	public CardServices card;

	@PostMapping(path = "/add")
	public Cards add(@RequestBody Cards cards) {
		return this.card.add(cards);
	}

	// @PostMapping(path = "/adduser/{id}")
	// public Cards add(@PathVariable String id, @RequestBody Cards cards) {
	// return this.card.add(id, cards);
	// }

	@GetMapping(path = "/getall")
	public List<Cards> getall() {
		return this.card.getall();
	}

	@GetMapping(path = "/getbyname/{id}")
	public List<Cards> getbyname(@PathVariable String id) {
		return this.card.getbyname(id);
	}
}
