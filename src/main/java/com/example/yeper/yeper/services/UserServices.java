package com.example.yeper.yeper.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.yeper.yeper.entity.Cards;
import com.example.yeper.yeper.entity.Users;

@Service
public interface UserServices {
	public List<Users> getall();
	public Users adduser(Users user);
	public Users update(String id, Users user);
	public Boolean delete(String id);
	public Boolean isadmin(int id);
	public List<Users> getreferals(String id);
	public Users getsingle(String id);
	public long getwalletid(String id);
	public List<Cards> usercards(String id);
	public Users addcard(String id, Cards card);
}
