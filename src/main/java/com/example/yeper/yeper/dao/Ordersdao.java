package com.example.yeper.yeper.dao;

import java.util.List;

import org.hibernate.boot.model.relational.QualifiedName;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yeper.yeper.entity.Orders;
import com.example.yeper.yeper.entity.Users;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

import jakarta.persistence.Query;

public interface Ordersdao extends JpaRepository<Orders, Long> {
    
    // public List<Orders> findByOrderstatus(String s);
}

// SELECT * FROM orders WHERE order_status="Completed"
// ;