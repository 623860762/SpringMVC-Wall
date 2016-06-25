package com.ceit.ebs.cn.assys.overallScore.entity;


import com.ceit.common.entity.BaseEntity;


/**
 * AssOverallScore entity. @author MyEclipse Persistence Tools
 */

public class AssOverallScore extends BaseEntity implements java.io.Serializable {


	private static final long serialVersionUID = -3593466651137215830L;
	
	private String overallScoreId;
     private String wallId;
     private String overallScore;
     private String wallSecuRemark;
     private String securityStatus;
     private String securityLevel;
     public String getOverallScoreId() {
 		return overallScoreId;
 	}
 	public void setOverallScoreId(String overallScoreId) {
 		this.overallScoreId = overallScoreId;
 	}
 	public String getWallId() {
 		return wallId;
 	}
 	public void setWallId(String wallId) {
 		this.wallId = wallId;
 	}
 	public String getOverallScore() {
 		return overallScore;
 	}
 	public void setOverallScore(String overallScore) {
 		this.overallScore = overallScore;
 	}
 	public String getWallSecuRemark() {
 		return wallSecuRemark;
 	}
 	public void setWallSecuRemark(String wallSecuRemark) {
 		this.wallSecuRemark = wallSecuRemark;
 	}
 	public String getSecurityStatus() {
 		return securityStatus;
 	}
 	public void setSecurityStatus(String securityStatus) {
 		this.securityStatus = securityStatus;
 	}
 	public String getSecurityLevel() {
 		return securityLevel;
 	}
 	public void setSecurityLevel(String securityLevel) {
 		this.securityLevel = securityLevel;
 	}



}