package com.example.yeper.yeper.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.yeper.yeper.entity.Users;

@Service
public interface UserServices {
	public List<Users> getall();
	public Users adduser(Users user);
	public Users update(long id, Users user);
	public Boolean delete(long id);
	public Boolean isadmin(int id);
}
