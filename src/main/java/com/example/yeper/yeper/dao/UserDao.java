package com.example.yeper.yeper.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yeper.yeper.entity.Users;

public interface UserDao extends JpaRepository<Users, String> {
	public Users findByReferalCode(String id);
}
