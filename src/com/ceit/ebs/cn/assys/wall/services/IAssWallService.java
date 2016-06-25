package com.ceit.ebs.cn.assys.wall.services;

import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cn.assys.wall.entity.AssWall;

public interface IAssWallService {
	
	public List<AssWall> getAll();
	
	public boolean assWallPersist(AssWall assWall);
	
	public Integer getListSize();
	
	public PageInfo<AssWall> getWallList(int pageindex, int pagesize);
	
	public AssWall getWallById(String wallId);
	
	public boolean delWallById(String wallId);
	
	public boolean delWallByIds(String wallIds);
	
	public boolean WallMerge(AssWall assWall);
	
	public boolean uptWallStatu(String wallId,String assWallStatu);

}
