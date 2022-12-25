package com.example.yeper.yeper.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.dao.UserDao;
import com.example.yeper.yeper.entity.Cards;
import com.example.yeper.yeper.entity.Referrals;
import com.example.yeper.yeper.entity.Users;
import com.example.yeper.yeper.entity.Wallet;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	public UserDao userdao;

	@Autowired
	public ReferralServices refservice;
	
	@Autowired
	public WalletServices walletservice;
	
	@Override
	public Users adduser(Users user) {
	Users user1 = userdao.findByReferalCode(user.getReferralof());
		if(user1!=null) {
		Referrals ref =new  Referrals();
		ref.setUser(user1);
		ref.setName(user.name);
		refservice.add(ref, user1.getUid());
		}
		Wallet wal=new Wallet();
		wal.setUser(user);
		user.setWallet(walletservice.add(wal));
		userdao.save(user);
		return user;
	}

	@Override
	public Users update(String id, Users user) {
		// TODO Auto-generated method stub
		Optional<Users> user1 = userdao.findById(id);
		if (user1.isPresent()) {
			Users user2 = user1.get();
//			user2.setAddress(user.getAddress());
			user2.setEmail(user.getEmail());
//			user2.setName(user.getName());
//			user2.setReferralof(user.getReferralof());

			user2.setPhonenumber(user.getPhonenumber());
			user2.setPhoto(user.getPhoto());
			user2.setAcnumber(user.getAcnumber());
			user2.setBankname(user.getBankname());
			user2.setIdfc(user.getIdfc());
			userdao.save(user2);
			return user2;
		}
		return null;
	}

	@Override
	public Boolean delete(String id) {
		// TODO Auto-generated method stub
		userdao.deleteById(id);
		return true;
	}

	@Override
	public Boolean isadmin(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Users> getall() {
		// TODO Auto-generated method stub
		return userdao.findAll();

	}

	@Override
	public List<Users> getreferals(String id) {
		// TODO Auto-generated method stub
		Optional<Users> user=userdao.findById(id);
		if(user.isPresent()) {
			Users user2=user.get();
			List<Users> refe =new ArrayList<Users>();
			List<Referrals> ref=user2.getReferrals();
			for(int i=0;i<ref.size();i++) {
				refe.add(ref.get(i).getUser());
				
			}
			return refe;
		}
		
		return null;
	}

	@Override
	public Users getsingle(String id) {
		// TODO Auto-generated method stub
		Optional<Users> user=userdao.findById(id);
		
		return user.get();
	}

	@Override
	public long getwalletid(String id) {
		// TODO Auto-generated method stub
		Optional<Users> user=userdao.findById(id);
		if(user.isPresent()) {
			Users user1=user.get();
			long walid=user1.getWallet().getBalance();
			
			return walid;
		}
		return 0;
	}

	@Override
	public List<Cards> usercards(String id) {
		// TODO Auto-generated method stub
		Optional<Users> user=userdao.findById(id);
		if(user.isPresent()) {
			return user.get().cards;
		}
		return null;
	}

	@Override
	public Users addcard(String id, Cards card) {
		// TODO Auto-generated method stub
		Optional<Users> user= userdao.findById(id);
		if(user.isPresent()) {
			Users user2=user.get();
			List<Cards> cards= user2.getCards();
			cards.add(card);
			user2.setCards(cards);
			userdao.save(user2);
		}
		
		return null;
	}
	
	

}
