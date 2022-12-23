package com.example.yeper.yeper.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.dao.DealsDao;
import com.example.yeper.yeper.dao.Ordersdao;
import com.example.yeper.yeper.dao.UserDao;
import com.example.yeper.yeper.entity.Deals;
import com.example.yeper.yeper.entity.Orders;
import com.example.yeper.yeper.entity.Users;

@Service
public class OrderServiceImpl implements OrdersSevices {

	@Autowired
	public Ordersdao orderdao;

	@Autowired
	public UserDao userdao;

	@Autowired
	public DealsDao dealsdao;

	@Override
	public Orders add(Orders order, String id, long id2) {
		Optional<Users> user = userdao.findById(id);
		Optional<Deals> deals = dealsdao.findById(id2);
		if (user.isPresent() && deals.isPresent()) {
			Users user1 = user.get();
			Deals deal2 = deals.get();
			order.setUser(user1);
			order.setDeals(deal2);
			orderdao.save(order);
			return order;
		} else {
			return null;
		}
	}

	@Override
	public List<Orders> getall() {
		// TODO Auto-generated method stub
		return orderdao.findAll();
	}

	@Override
	public List<Orders> getsingle(String id) {
		// TODO Auto-generated method stub
		Optional<Users> user = userdao.findById(id);
		if (user.isPresent()) {
			Users user1 = user.get();
			List<Orders> order = user1.getOrders();
			return order;
		}
		return null;
	}

	@Override
	public Orders complete(long id) {
		// TODO Auto-generated method stub
		Optional<Orders> order1 = orderdao.findById(id);
		if (order1.isPresent()) {
			Orders order2 = order1.get();
			order2.setOrder_status("Completed");
			orderdao.save(order2);
			return order2;
		} else {
			return null;
		}
	}

	@Override
	public Deals getdeal(long id) {
		// TODO Auto-generated method stub
		Optional<Orders> order = orderdao.findById(id);
		if (order.isPresent()) {
			Orders order2 = order.get();
			Deals deal = order2.getDeals();
			return deal;
		}

		return null;
	}

	@Override
	public Orders updatesingle(long id, Orders order) {
		// TODO Auto-generated method stub
		Optional<Orders> order1 = orderdao.findById(id);
		if (order1.isPresent()) {
			Orders order2 = order1.get();
			order2.setOrder_status(order.getOrder_status());
			order2.setPlatformtxnid(order.getPlatformtxnid());
			orderdao.save(order2);
			return order2;
		}

		return null;
	}

	@Override
	public Orders getsingleorder(long id) {
		// TODO Auto-generated method stub
		Optional<Orders> order = orderdao.findById(id);
		if (order.isPresent()) {
			return order.get();
		}
		return null;
	}

}
