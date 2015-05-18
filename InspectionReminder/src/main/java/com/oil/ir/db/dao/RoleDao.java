package com.oil.ir.db.dao;

import com.oil.ir.db.model.Role;

public interface RoleDao extends AbstractDao {

	Role findByRoldId(String roleId);

}
