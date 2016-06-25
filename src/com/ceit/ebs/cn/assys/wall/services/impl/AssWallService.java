package com.ceit.ebs.cn.assys.wall.services.impl;

import java.util.List;

import com.ceit.ebs.cn.assys.wall.entity.AssWall;
import com.ceit.ebs.cn.assys.wall.services.IAssWallService;
import com.ceit.common.dao.ITableDao;
import com.ceit.common.util.PageInfo;

public class AssWallService implements IAssWallService{
	private ITableDao tableDao;
	
	public void setTableDao(ITableDao tableDao) {
		this.tableDao = tableDao;
	}

	@SuppressWarnings("unchecked")
	public List<AssWall> getAll(){
		String sql = "from AssWall";
		try {
			return this.tableDao.querydata(sql, true, 0, 10, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean assWallPersist(AssWall assWall){
		if(tableDao.insertNew(assWall))
			return true;
		return false;
	}
	
	public Integer getListSize(){
		String sql = "select count(wallId) from AssWall";
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
	
	public PageInfo<AssWall> getWallList(int pageindex, int pagesize){
		String sql = "from AssWall";
		try {
			List<AssWall> list = this.tableDao.querydataNew(sql, true, pageindex, pagesize, null);
			int size = this.getListSize();
			return new PageInfo<AssWall>(list,size,pageindex,pagesize);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public AssWall getWallById(String wallId){
		
		try {
			return (AssWall) this.tableDao.getEntitybyIdNew(wallId, AssWall.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean delWallById(String wallId){
		return this.tableDao.deleteNew(wallId, AssWall.class);
	}
	public boolean delWallByIds(String wallIds){
		String[] IdArray = wallIds.split(",");
		boolean b = true;
		try {
			for (int i = 0; i < IdArray.length; i++) {
				this.tableDao.deleteNew(IdArray[i], AssWall.class);
			}
		} catch (Exception e) {
			b = false;
		}
		return true;
	}
	public boolean WallMerge(AssWall assWall){
		return this.tableDao.update(assWall);
	}

	public boolean uptWallStatu(String wallId,String assWallStatu) {
		AssWall assWall = this.getWallById(wallId);
		assWall.setAssWallStatu(assWallStatu);
		return this.WallMerge(assWall);
		
	}
}
