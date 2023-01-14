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

import com.example.yeper.yeper.entity.Cards;
import com.example.yeper.yeper.entity.Users;
import com.example.yeper.yeper.services.UserServices;

@RequestMapping("/user")
@RestController
public class UserController {
	@Autowired
	public UserServices user;

	@GetMapping(path = "/getall")
	public List<Users> getall() {
		return this.user.getall();

	}

	@GetMapping(path = "/getref/{id}")
	public List<Users> getref(@PathVariable String id) {
		return this.user.getreferals(id);

	}

	@PostMapping(path = "/add")
	public Users add(@RequestBody Users user) {
		return this.user.adduser(user);
	}

	@PutMapping(path = "/update/{id}")
	public Users update(@PathVariable String id, @RequestBody Users user) {
		return this.user.update(id, user);
	}

	@DeleteMapping(path = "/delete/{id}")
	public boolean delete(@PathVariable String id) {
		return this.user.delete(id);
	}

	@GetMapping(path = "/isuser/{id}")
	public boolean checkuser(@PathVariable String id) {
		return this.user.delete(id);
	}

	@GetMapping(path = "/getsingle/{id}")
	public Users getsingle(@PathVariable String id) {
		return this.user.getsingle(id);
	}

	@GetMapping(path = "/getwalletbalance/{id}")
	public long getwallet(@PathVariable String id) {
		return this.user.getwalletid(id);
	}

	@GetMapping(path = "/getcards/{id}")
	public List<Cards> getcards(@PathVariable String id) {
		return this.user.usercards(id);
	}

	@PostMapping(path = "/addcards/{id}/{id2}")
	public Users addcards(@PathVariable String id, @PathVariable String id2) {
		return this.user.addcard(id, id2);
	}
}
