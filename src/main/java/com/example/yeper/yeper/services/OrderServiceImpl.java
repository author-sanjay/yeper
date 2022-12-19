package com.example.yeper.yeper.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.dao.DealsDao;
import com.example.yeper.yeper.dao.Ordersdao;
import com.example.yeper.yeper.dao.UserDao;
import com.example.yeper.yeper.entity.Deals;
import com.example.yeper.yeper.entity.Orders;
import com.example.yeper.yeper.entity.Users;

@Service
public class OrderServiceImpl implements OrdersSevices{

	@Autowired
	public Ordersdao orderdao;
	
	@Autowired
	public UserDao userdao;
	
	@Autowired
	public DealsDao dealsdao;
	
	@Override
	public Orders add(Orders order,long id,long id2) {
		Optional<Users> user=userdao.findById(id);
		Optional<Deals> deals=dealsdao.findById(id2);
		if(user.isPresent()&& deals.isPresent()) {
			Users user1=user.get();
			Deals deal2=deals.get();
			order.setUser(user1);
			order.setDeals(deal2);
			orderdao.save(order);
			return order;
		}
		else {
			return null;
		}
	}

	@Override
	public List<Orders> getall() {
		// TODO Auto-generated method stub
		return orderdao.findAll();
	}

	@Override
	public Orders getsingle(long id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Orders complete(long id) {
		// TODO Auto-generated method stub
		Optional<Orders> order1=orderdao.findById(id);
		if(order1.isPresent()) {
			Orders order2=order1.get();
			order2.setOrder_status("Completed");
			orderdao.save(order2);
			return order2;
		}else {
		return null;}
	}

	

}
