package com.ceit.ebs.cn.assys.detailScore.entity;


import com.ceit.common.entity.BaseEntity;


/**
 * AssDetailScore entity. @author MyEclipse Persistence Tools
 */

public class AssDetailScore extends BaseEntity  implements java.io.Serializable {


	private static final long serialVersionUID = -9217406140844740703L;
	private String detailScoreId;
     private String wallSecuRemark;
     private String securityStatus;
     private String securityLevel;
     private String scoreName;
     private String wallId;
     private String detailScore;
     

     public String getDetailScoreId() {
    	 return detailScoreId;
     }
     public void setDetailScoreId(String detailScoreId) {
    	 this.detailScoreId = detailScoreId;
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
	public String getScoreName() {
		return scoreName;
	}
	public void setScoreName(String scoreName) {
		this.scoreName = scoreName;
	}
	public String getWallId() {
		return wallId;
	}
	public void setWallId(String wallId) {
		this.wallId = wallId;
	}
	public String getDetailScore() {
		return detailScore;
	}
	public void setDetailScore(String detailScore) {
		this.detailScore = detailScore;
	}
     
}