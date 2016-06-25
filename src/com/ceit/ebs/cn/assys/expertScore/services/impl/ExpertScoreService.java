package com.ceit.ebs.cn.assys.expertScore.services.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ceit.ebs.cn.assys.expertScore.entity.AssExpertScore;
import com.ceit.ebs.cn.assys.expertScore.services.IExpertScoreService;
import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;

public class ExpertScoreService implements IExpertScoreService{
	private ITableDao tableDao;
	
	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

	public boolean persistObj(AssExpertScore assExpertScore) {
		return tableDao.insertNew(assExpertScore);
	}

	public boolean delObjById(String expertScoreId) {
		return this.tableDao.deleteNew(expertScoreId, AssExpertScore.class);
	}

	public boolean delObjsByIds(String expertScoreIds) {
		String[] IdArray = expertScoreIds.split(",");
		boolean b = true;
		try {
			for (int i = 0; i < IdArray.length; i++) {
				this.tableDao.deleteNew(IdArray[i], AssExpertScore.class);
			}
		} catch (Exception e) {
			b = false;
		}
		return true;
	}

	public List<AssExpertScore> getAll() {
		String sql = "from AssExpertScore";
		try {
			return this.tableDao.otherQuery(sql, true, true, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer getListSize() {
		String sql = "select count(expertScoreId) from AssExpertScore";
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
		String sql = "select count(expertScoreId) from AssExpertScore where wallId=:wallId";
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
		String sql = "from AssExpertScore where wallId=:wallId";
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

	public AssExpertScore getObjById(String expertScoreId) {
		try {
			return (AssExpertScore) this.tableDao.getEntitybyIdNew(expertScoreId, AssExpertScore.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public PageInfo<AssExpertScore> getObjList(int pageindex, int pagesize, String wallId) {
		String sql = "from AssExpertScore where wallId=:wallId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("wallId", wallId);
		try {
				List<AssExpertScore> list = this.tableDao.querydataNew(sql, true, pageindex, pagesize, params);
				int size = this.getListSizeByWallId(wallId);
				return new PageInfo<AssExpertScore>(list,size,pageindex,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean mergeObj(AssExpertScore assExpertScore) {
		return this.tableDao.update(assExpertScore);
	}
	
}
