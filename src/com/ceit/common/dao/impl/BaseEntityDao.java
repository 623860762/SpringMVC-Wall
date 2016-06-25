package com.ceit.common.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ceit.common.dao.IBaseEntityDao;
import com.ceit.common.entity.BaseEntity;

public class BaseEntityDao<E extends BaseEntity> extends HibernateDaoSupport implements IBaseEntityDao<E> {

	public void injectSessionFactory() {
		
	}
 
	public void setInjectionSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	public void persist(E entity) {
		entity.setOpTime(System.currentTimeMillis());
		getHibernateTemplate().persist(entity);
	}

	public void merge(E entity) {
		entity.setOpTime(System.currentTimeMillis());
		getHibernateTemplate().merge(entity);
	}
 

}
