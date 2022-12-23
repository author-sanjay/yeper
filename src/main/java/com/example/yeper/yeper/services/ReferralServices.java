package com.example.yeper.yeper.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.yeper.yeper.entity.Referrals;
import com.example.yeper.yeper.entity.Users;

@Service
public interface ReferralServices {
	public List<Referrals> getall();
	public Referrals findbyid(long id);
	public Users finduser(long id);
	public Referrals add(Referrals referral, String id); 
	
}
