package com.ceit.ebs.cn.assys.overallScore.services.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.ebs.cn.assys.overallScore.entity.AssOverallScore;
import com.ceit.ebs.cn.assys.overallScore.services.IOverallScoreService;
import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;

public class OverallScoreService implements IOverallScoreService{
private ITableDao tableDao;
	
	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

	public boolean persistObj(AssOverallScore assOverallScore) {
		return tableDao.insertNew(assOverallScore);
	}

	public boolean delObjById(String id) {
		return this.tableDao.deleteNew(id, AssOverallScore.class);
	}

	public boolean delObjsByIds(String ids) {
		String[] IdArray = ids.split(",");
		boolean b = true;
		try {
			for (int i = 0; i < IdArray.length; i++) {
				this.tableDao.deleteNew(IdArray[i], AssOverallScore.class);
			}
		} catch (Exception e) {
			b = false;
		}
		return true;
	}

	public List<AssOverallScore> getAll() {
		String sql = "from AssOverallScore";
		try {
			return this.tableDao.querydata(sql, true, 0, 10, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getListSize() {
		String sql = "select count(overallScoreId) from AssOverallScore";
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
		String sql = "select count(overallScoreId) from AssOverallScore where wallId=:wallId";
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
	
	public List getListByWallId(String wallId) {
		String sql = "from AssOverallScore where wallId=:wallId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("wallId", wallId);
		Integer ListSize = -1;
		try {
			return this.tableDao.otherQuery(sql, true, true, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public AssOverallScore getObjById(String id) {
		try {
			return (AssOverallScore) this.tableDao.getEntitybyIdNew(id, AssOverallScore.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public PageInfo<AssOverallScore> getObjList(int pageindex, int pagesize, String wallId) {
		String sql = "from AssOverallScore where wallId=:wallId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("wallId", wallId);
		try {
				List<AssOverallScore> list = this.tableDao.querydataNew(sql, true, pageindex, pagesize, params);
				int size = this.getListSizeByWallId(wallId);
				return new PageInfo<AssOverallScore>(list,size,pageindex,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean mergeObj(AssOverallScore assOverallScore) {
		return this.tableDao.update(assOverallScore);
	}
	
}
