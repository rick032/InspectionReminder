package com.oil.ir.db.dao;

import com.oil.ir.db.model.User;

public interface UserDao extends AbstractDao {

	User findByUserId(String userId);

}
