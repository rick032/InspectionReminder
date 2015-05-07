package com.oil.ir.secuity;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SecurityManager implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User("0001", "Lawrence", "1234"));
		userList.add(new User("0002", "Tom", "1234"));
		userList.add(new User("0003", "Terry", "1234"));
		for (int i = 0; i < userList.size(); i++) {
			User user = (User) userList.get(i);
			if (user.getUsername().equals(username))
				return user;
		}
		throw new UsernameNotFoundException("User " + username
				+ " has no GrantedAuthority");
	}

}
