package com.example.yeper.yeper.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.dao.Admindao;
import com.example.yeper.yeper.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {

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
	public Admin verify(Admin admin) {
		// TODO Auto-generated method stub
		Optional<Admin> admin1 = admindao.findByEmailAndPassword(admin.email, admin.password);
		if (admin1.isPresent()) {
			return admin1.get();
		}
		return null;
	}

}
