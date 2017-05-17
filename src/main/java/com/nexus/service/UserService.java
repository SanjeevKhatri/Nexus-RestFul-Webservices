package com.nexus.service;

import java.util.List;

import com.nexus.domain.User;

public interface UserService {
	User save(User user);

	void delete(int userId);

	User findByUserName(String userName);

	List<User> findAll();

	User findByUserId(int userId);
}
