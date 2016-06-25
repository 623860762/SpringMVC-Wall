package com.ceit.common.services.impl;

import java.util.List;

import com.ceit.common.dao.ITableDao;
import com.ceit.common.entity.CMTDict;
import com.ceit.common.enumDefine.YesNoEnum;
import com.ceit.common.services.ICMTDictService;

public class CMTDictService implements ICMTDictService {
	private ITableDao tableDao;
	public Integer persist(CMTDict dic) {
		try{
			Integer fieldId = tableDao.insert(dic);
			return fieldId;
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	}
	
	public boolean merge(CMTDict dic) {
        try {
			boolean bool = tableDao.update(dic);
			return bool;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}

	public boolean removeById(String dicId) {
        try {
			CMTDict cmtDict = (CMTDict)tableDao.getEntitybyId(Integer.valueOf(dicId), CMTDict.class);
			cmtDict.setIsValid(YesNoEnum.N);
			boolean bool = tableDao.update(cmtDict);
			return bool;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}

	public boolean removeByIdREAL(String dicId) {
        try {
        	boolean bool = tableDao.delete(Integer.valueOf(dicId), CMTDict.class);
        	return bool;
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return false;
	}
	
	public CMTDict getById(String dicId) {
		try {
			CMTDict cmtDict = (CMTDict)tableDao.getEntitybyId(Integer.valueOf(dicId), CMTDict.class);
			return cmtDict;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<CMTDict> getAll() {
		String hql = "from cmtDict";
		try {
			List<CMTDict> list = tableDao.otherQuery(hql, true, true, null);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<CMTDict> getByParentId(String companyId, String parentId) {
		String hql = "from cmtDict t where";
		try {
			if(!"".equals(parentId) && parentId != null){
				hql += "t.parentId=" + parentId;
				List<CMTDict> list = tableDao.otherQuery(hql, true, true, null); 
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
