package com.ceit.ebs.cn.assys.detailScore.services.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.ebs.cn.assys.detailScore.entity.AssDetailScore;
import com.ceit.ebs.cn.assys.detailScore.services.IDetailScoreService;
import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;

public class DetailScoreService implements IDetailScoreService{
	private ITableDao tableDao;
	
	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

	public boolean persistObj(AssDetailScore assDetailScore) {
		return tableDao.insertNew(assDetailScore);
	}

	public boolean delObjById(String id) {
		return this.tableDao.deleteNew(id, AssDetailScore.class);
	}

	public boolean delObjsByIds(String ids) {
		String[] IdArray = ids.split(",");
		boolean b = true;
		try {
			for (int i = 0; i < IdArray.length; i++) {
				this.tableDao.deleteNew(IdArray[i], AssDetailScore.class);
			}
		} catch (Exception e) {
			b = false;
		}
		return true;
	}

	public List<AssDetailScore> getAll() {
		String sql = "from AssDetailScore";
		try {
			return this.tableDao.querydata(sql, true, 0, 10, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getListSize() {
		String sql = "select count(detailScoreId) from AssDetailScore";
		Integer ListSize = -1;
		try {
			List list = this.tableDao.otherQuery(sql, true, true, null);
			Object o = list.get(0);
			ListSize =  Integer.valueOf(o.toString());
			System.out.println("查询到记录数:"+ListSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListSize;
	}
	public Integer getListSizeByWallId(String wallId) {
		String sql = "select count(detailScoreId) from AssDetailScore where wallId=:wallId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("wallId", wallId);
		Integer ListSize = -1;
		try {
			
			List list = this.tableDao.otherQuery(sql, true, true, params);
			Object o = list.get(0);
			ListSize =  Integer.valueOf(o.toString());
			System.out.println("查询到记录数:"+ListSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListSize;
	}
	public List getListByWallId(String wallId){
		String sql = "from AssDetailScore where wallId=:wallId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("wallId", wallId);
		try {
			return this.tableDao.otherQuery(sql, true, true, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public AssDetailScore getObjById(String id) {
		try {
			return (AssDetailScore) this.tableDao.getEntitybyIdNew(id, AssDetailScore.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public PageInfo<AssDetailScore> getObjList(int pageindex, int pagesize, String wallId) {
		String sql = "from AssDetailScore where wallId=:wallId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("wallId", wallId);
		try {
				List<AssDetailScore> list = this.tableDao.querydataNew(sql, true, pageindex, pagesize, params);
				int size = this.getListSizeByWallId(wallId);
				return new PageInfo<AssDetailScore>(list,size,pageindex,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean mergeObj(AssDetailScore assDetailScore) {
		return this.tableDao.update(assDetailScore);
	}
}
