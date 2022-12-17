package com.example.yeper.yeper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yeper.yeper.entity.Admin;
import com.example.yeper.yeper.services.AdminService;

@CrossOrigin("*")
@RequestMapping("/admin")
@RestController
public class AdminController {

	@Autowired
	public AdminService admin;

	@GetMapping(path = "/get")
	public List<Admin> getall() {
		return this.admin.getall();
	}

	@PostMapping(path = "/add")
	public Admin add(@RequestBody Admin admins) {
		return this.admin.add(admins);
	}

	@PostMapping(path = "/verify")
	public Admin verify(@RequestBody Admin admin) {
		return this.admin.verify(admin);
	}
}
