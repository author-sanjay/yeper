package com.example.yeper.yeper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Admin> getall() {
		return this.admin.getall();
	}

	@PostMapping(path = "/add")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Admin add(@RequestBody Admin admins) {
		return this.admin.add(admins);
	}

	@PostMapping(path = "/verify")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Admin verify(@RequestBody Admin admin) {
		return this.admin.verify(admin);
	}

	@GetMapping(path = "/total")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Long totaluser() {
		return this.admin.totaluser();
	}

	@GetMapping(path = "/active")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Long actoveuser() {
		return this.admin.activeusers();
	}

	@GetMapping(path = "/dealsactive")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Long activedeals() {
		return this.admin.activedeals();
	}

	@GetMapping(path = "/dealscomplete")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Long notactivedeals() {
		return this.admin.completeddeals();
	}

	@GetMapping(path = "/balance")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Long balanceLong() {
		return this.admin.earning();
	}

	@DeleteMapping(path = "/delete/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Admin delete(@PathVariable long id) {
		return this.admin.delete(id);
	}
}
