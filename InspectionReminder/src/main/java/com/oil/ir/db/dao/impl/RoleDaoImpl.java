package com.oil.ir.db.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.oil.ir.db.dao.RoleDao;
import com.oil.ir.db.model.Role;

@Repository
public class RoleDaoImpl extends AbstractDaoImpl implements RoleDao {

	@Override
	public Role findByRoldId(String roleId) {

		Criteria criteria = getSession().createCriteria(Role.class);
		criteria.setFirstResult(0);
		criteria.add(Restrictions.eq("roleId", roleId));

		@SuppressWarnings("unchecked")
		List<Role> results = criteria.list();
		return results.isEmpty() ? null : results.get(0);
	}

}
