package com.oil.ir.db.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.oil.ir.db.model.User;

public interface UserService extends UserDetailsService {
	void save(User user);

	void update(User user);

	void delete(User user);

	User findByUserId(String userId);
}
