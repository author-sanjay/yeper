package com.example.yeper.yeper.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.dao.UserDao;
import com.example.yeper.yeper.entity.Users;


@Service
public class UserServiceImpl implements UserServices{

	@Autowired
	public UserDao userdao;
	
	@Override
	public Users adduser(Users user) {
		userdao.save(user);
		return user;
	}

	@Override
	public Users update(long id, Users user) {
		// TODO Auto-generated method stub
		Optional<Users> user1=userdao.findById(id);
		if(user1.isPresent()) {
			Users user2=user1.get();
			user2.setAddress(user.getAddress());
			user2.setEmail(user.getEmail());
			user2.setName(user.getName());
			
			user2.setPhonenumber(user.getPhonenumber());
			
			
			
			user2.setAcnumber(user.getAcnumber());
			user2.setBankname(user.getBankname());
			user2.setIdfc(user.getIdfc());
			userdao.save(user2);
			return user2;
		}
		return null;
	}

	@Override
	public Boolean delete(long id) {
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

}
