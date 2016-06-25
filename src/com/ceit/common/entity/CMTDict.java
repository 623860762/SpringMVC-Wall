package com.ceit.common.entity;

import java.io.Serializable;

import com.ceit.common.entity.BaseEntity;
import com.ceit.common.enumDefine.YesNoEnum;

/**
 * 字典表实体类
 * @author wujinshui
 * 
 */

public class CMTDict extends BaseEntity implements Serializable,Comparable<CMTDict>{
	private static final long serialVersionUID = 2123268741974488717L;
	
	private String dicId; 
	
	private String dicName; 
	 	 
	private String dicParentId; 
	 
	private YesNoEnum isValid;
	
	private String dicCompanyId;
 
	private Integer dicOrder;
	
	private String dicRemark;
	
	

	public String getDicId() {
		return dicId;
	}



	public void setDicId(String dicId) {
		this.dicId = dicId;
	}



	public String getDicName() {
		return dicName;
	}



	public void setDicName(String dicName) {
		this.dicName = dicName;
	}



	public String getDicParentId() {
		return dicParentId;
	}



	public void setDicParentId(String dicParentId) {
		this.dicParentId = dicParentId;
	}



	public YesNoEnum getIsValid() {
		return isValid;
	}



	public void setIsValid(YesNoEnum isValid) {
		this.isValid = isValid;
	}



	public String getDicCompanyId() {
		return dicCompanyId;
	}



	public void setDicCompanyId(String dicCompanyId) {
		this.dicCompanyId = dicCompanyId;
	}



	public Integer getDicOrder() {
		return dicOrder;
	}



	public void setDicOrder(Integer dicOrder) {
		this.dicOrder = dicOrder;
	}



	public String getDicRemark() {
		return dicRemark;
	}



	public void setDicRemark(String dicRemark) {
		this.dicRemark = dicRemark;
	}



	public int compareTo(CMTDict o) {
		if(getDicId().equals(o.getDicId())) {
			return 0;
		}else{
			if(getDicOrder()==o.getDicOrder()) { 
				return 1;
			}else{
				return  getDicOrder().compareTo(o.getDicOrder());
			}
		} 
	}
	
	public boolean equals(CMTDict o){
		return  getDicId().equals(o.getDicId());
	}
	
	public int hashCode(){
		return  getDicId().hashCode();
	}

}
