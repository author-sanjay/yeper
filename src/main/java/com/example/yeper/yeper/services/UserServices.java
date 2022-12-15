package com.example.yeper.yeper.services;

import com.example.yeper.yeper.entity.Users;

public interface UserServices {

	public Users adduser(Users user);
	public Users update(long id);
	public Boolean delete(long id);
	public Boolean isadmin(Users user);
}
