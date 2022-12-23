package com.example.yeper.yeper.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.dao.DealsDao;
import com.example.yeper.yeper.dao.Ordersdao;
import com.example.yeper.yeper.entity.Deals;
import com.example.yeper.yeper.entity.Orders;

@Service
public class DealsServiceImpl implements DealsServices {

	@Autowired
	public DealsDao dealsdao;

	@Autowired
	public Ordersdao orderdao;

	@Override
	public Deals add(Deals deal) {
		// TODO Auto-generated method stub
		dealsdao.save(deal);
		return deal;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub

		dealsdao.deleteById(id);
		return true;
	}

	@Override
	public Deals update(long id, Deals deal) {
		// TODO Auto-generated method stub
		Optional<Deals> deal1 = dealsdao.findById(id);
		if (deal1.isPresent()) {
			Deals deal2 = deal1.get();
			deal2.setId(deal.getId());
			deal2.setActive(deal.isActive());
			deal2.setActual_price(deal.getActual_price());
			deal2.setCard(deal.getCard());
			deal2.setCountleft(deal.getCountleft());
			deal2.setDescription(deal.getDescription());
			deal2.setOffer_price(deal.getOffer_price());
			deal2.setPhotourl(deal.getPhotourl());
			deal2.setProduct_name(deal.getProduct_name());
			deal2.setUser_earning(deal.getUser_earning());
			dealsdao.save(deal2);
			return deal2;
		} else {
			return null;
		}

	}

	@Override
	public List<Deals> getall() {
		// TODO Auto-generated method stub
		return dealsdao.findAll();
	}

	@Override
	public Deals markcomplete(long id) {
		// TODO Auto-generated method stub
		Optional<Deals> deal = dealsdao.findById(id);
		if (deal.isPresent()) {
			Deals deal1 = deal.get();
			List<Orders> orderslist = deal1.getOrders();
			for (int i = 0; i < orderslist.size(); i++) {
				Optional<Orders> order = orderdao.findById(orderslist.get(i).getId());
				if (order.isPresent()) {
					Orders order2 = order.get();
					order2.setOrder_status("Completed");
				}
			}

			dealsdao.save(deal1);
			return deal1;
		}
		return null;
	}

	@Override
	public Deals getsingle(long id) {
		// TODO Auto-generated method stub
		Optional<Deals> deal = dealsdao.findById(id);
		if (deal.isPresent()) {
			return deal.get();
		}
		return null;
	}

}
