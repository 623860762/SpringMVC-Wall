package com.ceit.common.dao;

import com.ceit.common.entity.BaseEntity;


public interface IBaseEntityDao <E extends BaseEntity>{

	public  void persist(E entity);
	
	public  void merge(E entity); 
}
