package com.ceit.common.services;

import java.util.List;

import com.ceit.common.util.PageInfo;

public interface ICommonService {
	
	public List<Object> getAll();
	
	public boolean persistObj(Object obj);
	
	public boolean mergeObj(Object obj);
	
	public boolean delObjById(String id);
	
	public Integer getListSize();
	
	public PageInfo<Object> getObjList(int pageindex, int pagesize);
	
	public Object getObjById(String id);
	
	
	public boolean delObjsByIds(String ids);
	

}
