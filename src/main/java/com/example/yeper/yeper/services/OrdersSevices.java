package com.example.yeper.yeper.services;

import java.util.List;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.entity.Deals;
import com.example.yeper.yeper.entity.Orders;

@Service
public interface OrdersSevices {
	public Orders add(Orders order, long id, long id2);

	public List<Orders> getall();

	public List<Orders> getsingle(long id);

	public Orders complete(long id);

	public Deals getdeal(long id);

	public Orders updatesingle(long id, Orders order);

	public Orders getsingleorder(long id);
}
