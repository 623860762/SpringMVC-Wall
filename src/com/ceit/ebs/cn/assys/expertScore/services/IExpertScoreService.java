package com.ceit.ebs.cn.assys.expertScore.services;


import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cn.assys.expertScore.entity.AssExpertScore;

public interface IExpertScoreService {
	
	public boolean persistObj(AssExpertScore assExpertScore);
	
	public boolean delObjById(String expertScoreId);
	
	public boolean delObjsByIds(String expertScoreIds);
	
	public boolean mergeObj(AssExpertScore assExpertScore);
	
	public AssExpertScore getObjById(String expertScoreId);
	
	public PageInfo<AssExpertScore> getObjList(int pageindex, int pagesize,String wallId);
	
	public List<AssExpertScore> getAll();
	
	public Integer getListSize();
	
	public Integer getListSizeByWallId(String wallId);
	
	public List getListByWallId(String wallId);

}
