package com.example.yeper.yeper.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yeper.yeper.entity.Admin;

public interface Admindao extends JpaRepository<Admin, Long> {
	Optional<Admin> findByEmailAndPassword(String email, String Password);
}
