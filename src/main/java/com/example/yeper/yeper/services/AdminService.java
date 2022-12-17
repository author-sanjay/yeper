package com.example.yeper.yeper.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.yeper.yeper.entity.Admin;

@Service
public interface AdminService {
	public Admin add(Admin admin);

	public List<Admin> getall();

	public Admin verify(Admin admin);

}
