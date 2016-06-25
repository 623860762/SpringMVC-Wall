package com.ceit.ebs.cn.assys.detailScore.services;


import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cn.assys.detailScore.entity.AssDetailScore;
import com.ceit.ebs.cn.assys.expertScore.entity.AssExpertScore;

public interface IDetailScoreService {
	
	public boolean persistObj(AssDetailScore assDetailScore);
	
	public boolean delObjById(String id);
	
	public boolean delObjsByIds(String ids);
	
	public boolean mergeObj(AssDetailScore assDetailScore);
	
	public AssDetailScore getObjById(String id);
	
	public PageInfo<AssDetailScore> getObjList(int pageindex, int pagesize,String wallId);
	
	public List<AssDetailScore> getAll();
	
	public Integer getListSize();
	
	public Integer getListSizeByWallId(String wallId);
	
	public List getListByWallId(String wallId);

}
