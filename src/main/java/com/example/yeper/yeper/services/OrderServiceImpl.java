package com.example.yeper.yeper.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.net.TLSClientHelloExtractor.ExtractorResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.dao.DealsDao;
import com.example.yeper.yeper.dao.Ordersdao;
import com.example.yeper.yeper.dao.UserDao;
import com.example.yeper.yeper.entity.Deals;
import com.example.yeper.yeper.entity.Orders;
import com.example.yeper.yeper.entity.Users;
import com.example.yeper.yeper.entity.Wallet_transactions;

@Service
public class OrderServiceImpl implements OrdersSevices {

	@Autowired
	public Ordersdao orderdao;

	@Autowired
	public UserDao userdao;

	@Autowired
	public DealsDao dealsdao;

	@Autowired
	public AdminService adminService;

	@Autowired
	public WalletTxnServices walletTxnServices;

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
			deal2.setCountleft(deal2.getCountleft() - 1);
			if (deal2.getCountleft() == 0) {
				deal2.setActive(false);
			}
			dealsdao.save(deal2);
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
	public Orders updatestatus(long id, String status) {
		Optional<Orders> order = orderdao.findById(id);
		if(order.isPresent()){
			Orders order2=order.get();
			order2.setOrder_status(status);
			orderdao.save(order2);
			return  order2;
		}
		return  null;
	}


	@Override
	public Orders complete(long id) {
		// TODO Auto-generated method stub
		Optional<Orders> order1 = orderdao.findById(id);
		if (order1.isPresent()) {
			Orders order2 = order1.get();
			order2.setOrder_status("Completed");
			Users user = order2.getUser();
			Deals deal = order2.getDeals();
			Wallet_transactions wal = new Wallet_transactions();
			wal.setAmount(deal.getOffer_price());
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDateTime now = LocalDateTime.now();
			wal.setDate(now.toString());
			wal.setIncoming(true);
			walletTxnServices.add(wal, user.getUid());
			Wallet_transactions wal2 = new Wallet_transactions();
			long walamaount = (long) ((long) deal.getOffer_price() * 0.1);
			wal2.setAmount(walamaount);
			wal2.setDate(now.toString());
			wal.setIncoming(true);
			try {
				Users user2 = userdao.findByReferalCode(user.getReferralof());
				walletTxnServices.add(wal2, user2.getUid());
				adminService.updateearning((long) ((long) deal.offer_price * 0.4));
			} catch (Exception e) {
				System.err.println("Error");
			}
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
			// order2=order;
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
