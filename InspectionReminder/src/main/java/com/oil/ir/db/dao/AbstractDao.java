package com.oil.ir.db.dao;

import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;

public interface AbstractDao {

	public Session getSession();

	public JdbcTemplate getJdbcTemplate();

	public void save(Object entity);

	public void delete(Object entity);

	public void update(Object entity);
	
	public Object find(Object entity);

}
