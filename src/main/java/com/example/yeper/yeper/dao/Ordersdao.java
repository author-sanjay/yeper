package com.example.yeper.yeper.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yeper.yeper.entity.Orders;

public interface Ordersdao extends JpaRepository<Orders, Long> {

    // public List<Orders> findByOrderstatus(String s);

}

// SELECT * FROM orders WHERE order_status="Completed"
// ;