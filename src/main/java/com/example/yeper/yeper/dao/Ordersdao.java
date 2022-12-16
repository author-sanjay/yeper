package com.example.yeper.yeper.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yeper.yeper.entity.Orders;
import com.example.yeper.yeper.entity.Users;

public interface Ordersdao extends JpaRepository<Orders, Long>{
	
}
