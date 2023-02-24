package com.example.yeper.yeper.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.yeper.yeper.dao.ReferralDao;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.dao.Cardsdao;
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

	@Autowired
	public Cardsdao carddao;
	@Autowired
	private ReferralDao referralDao;

	@Override
	public Users adduser( Users user) {
		Optional<Users> users=userdao.findByReferalCode(user.getReferralof());
		Wallet wal = new Wallet();
		wal.setUser(user);
		user.setWallet(walletservice.add(wal));
//		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setRole("ROLE_USER");
		user.setReferralcontribution(0);
		Users users1=userdao.save(user);
		if(users.isPresent()){
			List<Referrals> user2=users.get().getReferrals();
			Referrals ref=new Referrals();
			ref.setUser(users1);
			ref.setDate(LocalDate.now().toString());
			ref.setName(user.getName());
			Referrals ref2=referralDao.save(ref);
			user2.add(ref2);
			users.get().setReferrals(user2);
			userdao.save(users.get());
		}
		return user;
	}

	@Override
	public Users update(String id, Users user) {
		// TODO Auto-generated method stub
		Optional<Users> user1 = userdao.findById(id);
		if (user1.isPresent()) {
			Users user2 = user1.get();
			// user2.setAddress(user.getAddress());
			user2.setEmail(user.getEmail());
			// user2.setName(user.getName());
			// user2.setReferralof(user.getReferralof());

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
	public Users kyc(Users users) {
		Optional<Users> user= userdao.findById(users.getUid());
		if(user.isPresent()){
			Users users1=user.get();
			users1.setAcnumber(users.getAcnumber());
			users1.setBankname(users.getBankname());
			users1.setIdfc(users.getIdfc());
			users1.setGst(users.getGst());
			users1.setPan(users.getPan());
			userdao.save(users1);
			return  users1;
		}
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
		Optional<Users> user = userdao.findById(id);
		if (user.isPresent()) {
			Users user2 = user.get();
			List<Users> refe = new ArrayList<Users>();
			List<Referrals> ref = user2.getReferrals();
			for (int i = 0; i < ref.size(); i++) {
				refe.add(ref.get(i).getUser());

			}
			return refe;
		}

		return null;
	}

	@Override
	public Users getsingle(String id) {
		// TODO Auto-generated method stub
		Optional<Users> user = userdao.findById(id);

		return user.get();
	}

	@Override
	public long getwalletid(String id) {
		// TODO Auto-generated method stub
		Optional<Users> user = userdao.findById(id);
		if (user.isPresent()) {
			Users user1 = user.get();
			long walid = user1.getWallet().getBalance();

			return walid;
		}
		return 0;
	}

	@Override
	public List<Cards> usercards(String id) {
		// TODO Auto-generated method stub
		Optional<Users> user = userdao.findById(id);
		if (user.isPresent()) {
			return user.get().cards;
		}
		return null;
	}

	@Override
	public Users addcard(String id, String card) {
		// TODO Auto-generated method stub
		Optional<Users> user = userdao.findById(id);
		if (user.isPresent()) {
			Users user2 = user.get();
			List<Cards> cards = user2.getCards();
			Boolean flag = false;

			Optional<Cards> card1 = carddao.findById(Integer.parseInt(card));

			for(int i=0;i<cards.size();i++){
				if(cards.get(i).getId()==Integer.parseInt(card)){
					flag=true;
				}
			}
			if(flag){
				return user2;
			}else{
			cards.add(card1.get());
			// cards.add(card);
			user2.setCards(cards);
			userdao.save(user2);
			return  user2;}
		}

		return null;
	}


}
