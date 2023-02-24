package com.example.yeper.yeper.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.dao.ReferralDao;
import com.example.yeper.yeper.dao.UserDao;
import com.example.yeper.yeper.entity.Referrals;
import com.example.yeper.yeper.entity.Users;


@Service
public class ReferralServiceImpl implements ReferralServices{
	
	@Autowired
	public ReferralDao referraldao;

	@Autowired
	public UserDao userdao;
	
	@Override
	public List<Referrals> getall() {
		// TODO Auto-generated method stub
		
		return referraldao.findAll();
	}

	@Override
	public Referrals add(Referrals referral,String id) {
		// TODO Auto-generated method stub
		Optional<Users> user=userdao.findById(id);
		if(user.isPresent()) {
			Users user2=user.get();
			referral.setUser(user2);
			referraldao.save(referral);
			return referral;
		}
		else {
		return null;}
	}

	@Override
	public Referrals findbyid(long id) {
		// TODO Auto-generated method stub
		Optional<Referrals> ref=referraldao.findById(id);
		if(ref.isPresent()) {
			return ref.get();
		}else {
		return null;
		}
	}

	@Override
	public Users finduser(long id) {
		Optional<Referrals> ref=referraldao.findById(id);
		if(ref.isPresent()) {
			Referrals ref2=ref.get();
			return ref2.getUser();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Referrals> ofuser(String id) {
		// TODO Auto-generated method stub
		Optional<Users> user=userdao.findById(id);
		if(user.isPresent()) {
			List<Referrals> ref=referraldao.findAll();
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

	// public

}
