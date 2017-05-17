package com.nexus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexus.domain.User;


@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	User findByName(String userName);

	User findById(int userId);

	List<User> findAll();
}
