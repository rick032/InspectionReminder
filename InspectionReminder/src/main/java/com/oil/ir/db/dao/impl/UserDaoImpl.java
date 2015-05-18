package com.oil.ir.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.oil.ir.db.dao.UserDao;
import com.oil.ir.db.model.User;

@Repository
public class UserDaoImpl extends AbstractDaoImpl implements UserDao {

	@Override
	public User findByUserId(String userId) {

		Criteria criteria = getSession().createCriteria(User.class);

		criteria.add(Restrictions.eq("userId", userId));
		criteria.setFirstResult(0);
		@SuppressWarnings("unchecked")
		List<User> results = criteria.list();
		return results.isEmpty() ? null : results.get(0);
	}

}
