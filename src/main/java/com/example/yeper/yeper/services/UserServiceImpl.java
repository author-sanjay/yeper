package com.example.yeper.yeper.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.yeper.yeper.dao.ReferralDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.dao.UserDao;
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
	private ReferralDao referralDao;

	@Override
	public Users adduser( Users user) {
		Wallet wal = new Wallet();
		wal.setUser(user);
		user.setWallet(walletservice.add(wal));
//		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setRole("ROLE_USER");
		user.setReferralcontribution(0);
		user.setReferalcode(user.getReferalcode());
		Users users1=userdao.save(user);
		Optional<Users> user3=userdao.findByReferalcode(user.getReferralof());
		System.out.println(user3.get().getName());
		try{
			if(user3.isPresent()){
				Users users=user3.get();
				List<Referrals> user2=users.getReferrals();
				Referrals ref=new Referrals();
				ref.setUser(users1);
				ref.setDate(LocalDate.now().toString());
				ref.setName(user.getName());
				ref.setUserof(users);
				Referrals ref2=referralDao.save(ref);
				user2.add(ref2);
				users.setReferrals(user2);
				userdao.save(users);
			}
		} catch (Exception e){
			System.out.println(e);
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
	public List<Referrals> getreferrals(String id) {
		Optional<Users> user = userdao.findById(id);
		if (user.isPresent()) {
			List<Referrals> ref=referralDao.findAll();
			ArrayList<Referrals> reff=new ArrayList<>();
			for(int i=0;i<ref.size();i++){
				if(ref.get(i).getUserof().getUid().equals(id)){
					reff.add(ref.get(i));
				}
			}
			return reff;
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






}
