package com.example.yeper.yeper.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.yeper.yeper.entity.Orders;

@Service
public interface OrdersSevices {
	public Orders add(Orders order,long id,long id2);
	public List<Orders> getall();
	public Orders getsingle(long id);
	public Orders update(long id,Orders order);
}
