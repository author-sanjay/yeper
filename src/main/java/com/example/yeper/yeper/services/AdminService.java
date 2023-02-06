package com.example.yeper.yeper.services;

import java.util.List;

import com.example.yeper.yeper.entity.Users;
import org.springframework.stereotype.Service;

import com.example.yeper.yeper.entity.Admin;

@Service
public interface AdminService {
	public Admin add(Admin admin);

	public List<Users> getall();

	public Admin verify(Admin admin);

	public long totaluser();

	public long activeusers();

	public long activedeals();

	public long earning();

	public long completeddeals();

	public long updateearning(long amount);
	
	public Admin delete(long id);

}
