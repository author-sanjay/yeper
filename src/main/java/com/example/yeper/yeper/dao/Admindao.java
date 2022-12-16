package com.example.yeper.yeper.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yeper.yeper.entity.Admin;

public interface Admindao extends JpaRepository<Admin, Long>{
	Admin findByEmailAndPassword(String email,String Password);
}
