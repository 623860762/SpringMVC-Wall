package com.ceit.ebs.cn.test.services.impl;

import java.util.List;

import com.ceit.ebs.cn.test.entity.Test;
import com.ceit.ebs.cn.test.services.ITestService;
import com.ceit.common.dao.ITableDao;

public class TestService implements ITestService{
	private ITableDao tableDao;
	
	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

	@SuppressWarnings("unchecked")
	public List<Test> getAll() throws Exception {
		String sql = "from Test";
		return this.tableDao.querydata(sql, true, 0, 10, null);
	}

}
