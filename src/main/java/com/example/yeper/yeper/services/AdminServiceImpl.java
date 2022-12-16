package com.example.yeper.yeper.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.dao.Admindao;
import com.example.yeper.yeper.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	public Admindao admindao;
	
	@Override
	public Admin add(Admin admin) {
		// TODO Auto-generated method stub
		admindao.save(admin);
		return admin;
	}

	@Override
	public List<Admin> getall() {
		// TODO Auto-generated method stub
		return admindao.findAll();
	}

	@Override
	public Admin verify(String id, String password) {
		// TODO Auto-generated method stub
		return admindao.findByEmailAndPassword(id, password);
	}
	

}
