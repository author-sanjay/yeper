package com.example.yeper.yeper.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.dao.DealsDao;
import com.example.yeper.yeper.dao.Ordersdao;
import com.example.yeper.yeper.dao.UserDao;
import com.example.yeper.yeper.entity.Deals;
import com.example.yeper.yeper.entity.Orders;
import com.example.yeper.yeper.entity.Users;
import com.example.yeper.yeper.entity.Wallet;
import com.example.yeper.yeper.entity.Wallet_transactions;

@Service
public class DealsServiceImpl implements DealsServices {

	@Autowired
	public DealsDao dealsdao;

	@Autowired
	public Ordersdao orderdao;

	@Autowired
	public WalletTxnServices walletTxnServices;

	@Autowired
	public AdminService adminService;

	@Autowired
	public UserDao userDao;

	@Override
	public Deals add(Deals deal) {
		// TODO Auto-generated method stub
		dealsdao.save(deal);
		return deal;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub

		Optional<Deals> deals = dealsdao.findById(id);
		if(deals.isPresent()){
			Deals deals1=deals.get();
			deals1.setActive(false);
			dealsdao.save(deals1);
			return true;
		}
		return false;
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
					order2.setStatus("Completed");
					Users user = order2.getUser();
					Wallet_transactions wal = new Wallet_transactions();
					wal.setAmount(deal1.offer_price);
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					LocalDateTime now = LocalDateTime.now();
					wal.setDate(now.toString());
					wal.setIncoming(true);
					walletTxnServices.add(wal, user.getUid());

					Wallet_transactions wal2 = new Wallet_transactions();
					long walamaount = (long) ((long) deal1.getOffer_price() * 0.1);
					wal2.setAmount(walamaount);
					wal2.setDate(now.toString());
					wal.setIncoming(true);

					try {
						if (user.getReferralof() != null) {
							Optional<Users> user2 = userDao.findByReferalCode(user.getReferralof());
							if (user2.get().getUid() != null) {
								walletTxnServices.add(wal2, user2.get().getUid());
							} else {
								continue;
							}
						}
					} catch (Exception e) {
						System.out.println(e);
					}
					adminService.updateearning((long) ((long) deal1.user_earning * 0.4));
				}
			}

			deal1.setActive(false);
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

	@Override
	public List<Deals> getActive() {
		// TODO Auto-generated method stub

		return dealsdao.findByActive(true);
	}

}
