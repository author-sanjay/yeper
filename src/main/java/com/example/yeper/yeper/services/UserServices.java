package com.example.yeper.yeper.services;

import java.util.List;

import com.example.yeper.yeper.entity.Referrals;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.entity.Users;

@Service
public interface UserServices {
	public List<Users> getall();

	public Users adduser(Users user);

	public Users update(String id, Users user);

	public Boolean delete(String id);

	public Boolean isadmin(int id);

	public  Users kyc(Users users);

	public List<Users> getreferals(String id);

	public  List<Referrals> getreferrals(String id);

	public Users getsingle(String id);

	public long getwalletid(String id);




}
