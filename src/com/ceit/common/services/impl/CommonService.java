package com.ceit.common.services.impl;

import java.util.List;

import com.ceit.ebs.cn.assys.wall.entity.AssWall;
import com.ceit.ebs.cn.assys.wall.services.IAssWallService;
import com.ceit.common.dao.ITableDao;
import com.ceit.common.entity.BaseEntity;
import com.ceit.common.services.ICommonService;
import com.ceit.common.util.PageInfo;

public class CommonService implements ICommonService{
	private ITableDao tableDao;
	
	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

	public boolean delObjById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delObjsByIds(String ids) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Object> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getListSize() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getObjById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public PageInfo<Object> getObjList(int pageindex, int pagesize) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean mergeObj(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean persistObj(Object obj) {
		tableDao.insertNew((BaseEntity) obj);
		return true;
	}

}
