package com.example.yeper.yeper.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.example.yeper.yeper.entity.*;
import org.apache.tomcat.util.net.TLSClientHelloExtractor.ExtractorResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.dao.DealsDao;
import com.example.yeper.yeper.dao.Ordersdao;
import com.example.yeper.yeper.dao.UserDao;

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
			order2.setStatus(status);
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
			order2.setStatus("Completed");
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
				try{
				Optional<Users> user2 = userdao.findByReferalcode(user.getReferralof());
				if(user2.isPresent()) {
					walletTxnServices.add(wal2, user2.get().getUid());
					List<Referrals> ref= user2.get().getReferrals();
					for(int i=0;i<ref.size();i++){
						if(ref.get(i).getUser().getUid().equals(user.getUid())){
							ref.get(i).setContri((float) (deal.getOffer_price()*0.1));
							user2.get().setReferralcontribution((float) (user2.get().getReferralcontribution()+deal.getOffer_price()*0.1));
						}
					}
				}
				}
				catch (Exception e){
					System.out.println(e);
				}
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
			order2.setStatus(order.getStatus());
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


	public Orders addotp(Orders order){
		Optional<Orders> orders=orderdao.findById(order.getId());
		if(orders.isPresent()){
			Orders orders1=orders.get();
			orders1.setStatus(order.getStatus());
orders1.setCourier(order.getCourier());
orders1.setOtp(order.getOtp());
orderdao.save(orders1);
return orders1;
		}
		return null;
	}

}
