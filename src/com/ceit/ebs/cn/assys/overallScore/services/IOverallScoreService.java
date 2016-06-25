package com.ceit.ebs.cn.assys.overallScore.services;


import java.util.List;

import com.ceit.common.util.PageInfo;
import com.ceit.ebs.cn.assys.detailScore.entity.AssDetailScore;
import com.ceit.ebs.cn.assys.expertScore.entity.AssExpertScore;
import com.ceit.ebs.cn.assys.overallScore.entity.AssOverallScore;

public interface IOverallScoreService {
	
	public boolean persistObj(AssOverallScore assOverallScore);
	
	public boolean delObjById(String id);
	
	public boolean delObjsByIds(String ids);
	
	public boolean mergeObj(AssOverallScore assOverallScore);
	
	public AssOverallScore getObjById(String id);
	
	public PageInfo<AssOverallScore> getObjList(int pageindex, int pagesize,String wallId);
	
	public List<AssOverallScore> getAll();
	
	public Integer getListSize();
	
	public Integer getListSizeByWallId(String wallId);
	
	public List getListByWallId(String wallId);

}
