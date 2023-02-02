package com.example.yeper.yeper.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.yeper.yeper.entity.Deals;
import com.example.yeper.yeper.entity.Orders;
import com.example.yeper.yeper.services.OrdersSevices;

@RequestMapping("/orders")
@RestController
public class OrderController {
	@Autowired
	public OrdersSevices order;

	@GetMapping(path = "/getall")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public List<Orders> getforuser() {
		return this.order.getall();
	}

	@GetMapping(path = "/getsingle/{id}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public List<Orders> getsingleuser(@PathVariable String id) {
		return this.order.getsingle(id);
	}

	@GetMapping(path = "/getsingleorder/{id}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public Orders getsingleorder(@PathVariable long id) {
		return this.order.getsingleorder(id);
	}

	@PostMapping(path = "/add/{id}/{id2}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public Orders add(@RequestBody Orders order, @PathVariable String id, @PathVariable long id2) {
		return this.order.add(order, id, id2);
	}

	@PutMapping(path = "/update/{id}")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public Orders add(@PathVariable long id) {
		return this.order.complete(id);
	}

	@GetMapping(path = "/getdeal/{id}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public Deals getdeal(@PathVariable long id) {
		return this.order.getdeal(id);
	}

	@PostMapping(path = "/updatesingle/{id}")
	@PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
	public Orders update(@PathVariable long id, @RequestBody Orders order) {
		return this.order.updatesingle(id, order);
	}

}
