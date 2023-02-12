package com.example.yeper.yeper.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yeper.yeper.entity.Cards;

public interface Cardsdao extends JpaRepository<Cards, Integer>{
public List<Cards> findByName(String name);

public List<Cards> findByActive(boolean active);
public Cards getById(Cards card);
}
