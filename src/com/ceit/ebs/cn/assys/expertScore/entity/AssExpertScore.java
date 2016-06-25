package com.ceit.ebs.cn.assys.expertScore.entity;

import com.ceit.common.entity.BaseEntity;



/**
 * AssExpertScore entity. @author MyEclipse Persistence Tools
 */

public class AssExpertScore extends BaseEntity implements java.io.Serializable {


	private static final long serialVersionUID = 954186165474727019L;
	private String expertScoreId;
    private String wallId;
    private String expertName;
	private String steadyScore;
    private String baseScore;
    private String strenthScore;
	public String getExpertScoreId() {
		return expertScoreId;
	}
	public void setExpertScoreId(String expertScoreId) {
		this.expertScoreId = expertScoreId;
	}
	public String getWallId() {
		return wallId;
	}
	public void setWallId(String wallId) {
		this.wallId = wallId;
	}
	public String getExpertName() {
		return expertName;
	}
	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}
	public String getSteadyScore() {
		return steadyScore;
	}
	public void setSteadyScore(String steadyScore) {
		this.steadyScore = steadyScore;
	}
	public String getBaseScore() {
		return baseScore;
	}
	public void setBaseScore(String baseScore) {
		this.baseScore = baseScore;
	}
	public String getStrenthScore() {
		return strenthScore;
	}
	public void setStrenthScore(String strenthScore) {
		this.strenthScore = strenthScore;
	}
     
}