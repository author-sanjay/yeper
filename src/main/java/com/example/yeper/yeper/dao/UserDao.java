package com.example.yeper.yeper.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.yeper.yeper.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<Users, String> {
	public Optional<Users> findByReferalcode(String id);

    public List<Users> findByRole(String roleAdmin);
}
