package com.example.yeper.yeper.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.yeper.yeper.entity.Referrals;

@Service
public interface ReferralServices {
	public List<Referrals> getall();
	public Referrals add(Referrals referral,long id);
	public Referrals findbyid(long id);

	
}
