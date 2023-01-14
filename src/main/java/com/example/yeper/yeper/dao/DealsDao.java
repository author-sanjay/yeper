package com.example.yeper.yeper.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yeper.yeper.entity.Deals;

public interface DealsDao extends JpaRepository<Deals, Long> {
    public List<Deals> findByActive(boolean b);
}
