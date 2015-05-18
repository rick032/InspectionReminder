package com.oil.ir.db.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.oil.ir.db.dao.AbstractDao;
import com.oil.ir.db.model.ModelBean;

public abstract class AbstractDaoImpl implements AbstractDao {

	protected Logger logger;

	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private JdbcTemplate jdbcTemplate;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(Object entity) {
		getSession().persist(entity);
	}

	public void delete(Object entity) {
		getSession().delete(entity);
	}

	public void update(Object entity) {
		getSession().update(entity);
	}

	public Object find(Object entity) {
		ModelBean pojo = (ModelBean) entity;
		return getSession().get(pojo.getClass(), pojo.getId());
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
