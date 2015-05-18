package com.oil.ir.db.service.impl;

import java.sql.Timestamp;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.oil.ir.db.dao.RoleDao;
import com.oil.ir.db.dao.UserDao;
import com.oil.ir.db.model.Role;
import com.oil.ir.db.model.User;
import com.oil.ir.db.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private TransactionTemplate transactionTemplate;

	@Resource
	private PlatformTransactionManager transactionManager;

	@Resource
	UserDao userDao;

	@Resource
	RoleDao roleDao;
	
	@Resource
	PasswordEncoder encoder;

	@PostConstruct
	public void init() {

		this.transactionTemplate = new TransactionTemplate(transactionManager);
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				Role role = roleDao.findByRoldId("ROLE_USER");
				if (role == null) {
					role = new Role();

					role.setRoleId("ROLE_USER");
					role.setRoleName("USER");
					role.setRoleLevel(1);
					roleDao.save(role);
				}
				User user = userDao.findByUserId("rick");
				if (user == null) {
					//PasswordEncoder encoder = new BCryptPasswordEncoder();
					user = new User("rick", "中文", encoder.encode("abcd"), role,
							"rick", new Timestamp(System.currentTimeMillis()));
					userDao.save(user);
				}
			}
		});

	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public void update(User user) {
		userDao.update(user);
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	public User findByUserId(String userId) {
		return userDao.findByUserId(userId);
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		User user = userDao.findByUserId(username);
		if (user != null) {
			return user;
		}
		throw new UsernameNotFoundException("User " + username
				+ " has no GrantedAuthority");
	}

}
