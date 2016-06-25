package com.ceit.ebs.cn.assys.wall.entity;

import java.io.Serializable;
import com.ceit.common.entity.BaseEntity;

/**
 * AssWall entity. @author MyEclipse Persistence Tools
 */

public class AssWall extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -6525831736799799004L;
	private String wallId;
	private String wallName;
	private String wallLocation;
	private String wallOwer;
	private String wallRemark;
	private String wallHeight;
	private String wallTopWidth;
	private String surfaceSlopeGradient;
	private String backSlopeGradient;
	private String wallBottomWidth;
	private String bottomSlopeGradient;
	private String fillerCohesion;
	private String fillerSevere;
	private String fillerInnerAngle;
	private String wallSevere;
	private String baseFrictionRatio;
	private String outFrictionAngle;
	private String topShiftMax;
	private String filterWaterRate;
	private String volumnEmptyRate;
	private String thickReduceNum;
	private String antiSlipValue;
	private String antiOverturnValue;
	private String shearStressValue;
	private String baseStressDistance;
	private String antiSoftNum;
	private String flowId;
	private String isValid;
	private String isAssed;
	private String assWallStatu;
	private String wallFrictionValue;
	private String backFilterAngle;

	public String getIsAssed() {
		return isAssed;
	}

	public void setIsAssed(String isAssed) {
		this.isAssed = isAssed;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}


	public String getWallId() {
		return this.wallId;
	}

	public void setWallId(String wallId) {
		this.wallId = wallId;
	}

	public String getWallName() {
		return this.wallName;
	}

	public void setWallName(String wallName) {
		this.wallName = wallName;
	}

	public String getWallLocation() {
		return this.wallLocation;
	}

	public void setWallLocation(String wallLocation) {
		this.wallLocation = wallLocation;
	}

	public String getWallOwer() {
		return this.wallOwer;
	}

	public void setWallOwer(String wallOwer) {
		this.wallOwer = wallOwer;
	}

	public String getWallRemark() {
		return this.wallRemark;
	}

	public void setWallRemark(String wallRemark) {
		this.wallRemark = wallRemark;
	}

	public String getWallHeight() {
		return this.wallHeight;
	}

	public void setWallHeight(String wallHeight) {
		this.wallHeight = wallHeight;
	}
	public String getWallTopWidth() {
		return wallTopWidth;
	}

	public void setWallTopWidth(String wallTopWidth) {
		this.wallTopWidth = wallTopWidth;
	}
	public String getSurfaceSlopeGradient() {
		return this.surfaceSlopeGradient;
	}

	public void setSurfaceSlopeGradient(String surfaceSlopeGradient) {
		this.surfaceSlopeGradient = surfaceSlopeGradient;
	}

	public String getBackSlopeGradient() {
		return this.backSlopeGradient;
	}

	public void setBackSlopeGradient(String backSlopeGradient) {
		this.backSlopeGradient = backSlopeGradient;
	}

	public String getWallBottomWidth() {
		return this.wallBottomWidth;
	}

	public void setWallBottomWidth(String wallBottomWidth) {
		this.wallBottomWidth = wallBottomWidth;
	}

	public String getBottomSlopeGradient() {
		return this.bottomSlopeGradient;
	}

	public void setBottomSlopeGradient(String bottomSlopeGradient) {
		this.bottomSlopeGradient = bottomSlopeGradient;
	}

	public String getFillerCohesion() {
		return this.fillerCohesion;
	}

	public void setFillerCohesion(String fillerCohesion) {
		this.fillerCohesion = fillerCohesion;
	}

	public String getFillerSevere() {
		return this.fillerSevere;
	}

	public void setFillerSevere(String fillerSevere) {
		this.fillerSevere = fillerSevere;
	}

	public String getFillerInnerAngle() {
		return this.fillerInnerAngle;
	}

	public void setFillerInnerAngle(String fillerInnerAngle) {
		this.fillerInnerAngle = fillerInnerAngle;
	}

	public String getWallSevere() {
		return this.wallSevere;
	}

	public void setWallSevere(String wallSevere) {
		this.wallSevere = wallSevere;
	}

	public String getBaseFrictionRatio() {
		return this.baseFrictionRatio;
	}

	public void setBaseFrictionRatio(String baseFrictionRatio) {
		this.baseFrictionRatio = baseFrictionRatio;
	}

	public String getOutFrictionAngle() {
		return this.outFrictionAngle;
	}

	public void setOutFrictionAngle(String outFrictionAngle) {
		this.outFrictionAngle = outFrictionAngle;
	}

	public String getTopShiftMax() {
		return this.topShiftMax;
	}

	public void setTopShiftMax(String topShiftMax) {
		this.topShiftMax = topShiftMax;
	}

	public String getFilterWaterRate() {
		return this.filterWaterRate;
	}

	public void setFilterWaterRate(String filterWaterRate) {
		this.filterWaterRate = filterWaterRate;
	}

	public String getVolumnEmptyRate() {
		return this.volumnEmptyRate;
	}

	public void setVolumnEmptyRate(String volumnEmptyRate) {
		this.volumnEmptyRate = volumnEmptyRate;
	}

	public String getThickReduceNum() {
		return this.thickReduceNum;
	}

	public void setThickReduceNum(String thickReduceNum) {
		this.thickReduceNum = thickReduceNum;
	}

	public String getAntiSlipValue() {
		return this.antiSlipValue;
	}

	public void setAntiSlipValue(String antiSlipValue) {
		this.antiSlipValue = antiSlipValue;
	}

	public String getAntiOverturnValue() {
		return this.antiOverturnValue;
	}

	public void setAntiOverturnValue(String antiOverturnValue) {
		this.antiOverturnValue = antiOverturnValue;
	}

	public String getShearStressValue() {
		return this.shearStressValue;
	}

	public void setShearStressValue(String shearStressValue) {
		this.shearStressValue = shearStressValue;
	}

	public String getBaseStressDistance() {
		return this.baseStressDistance;
	}

	public void setBaseStressDistance(String baseStressDistance) {
		this.baseStressDistance = baseStressDistance;
	}

	public String getAntiSoftNum() {
		return this.antiSoftNum;
	}

	public void setAntiSoftNum(String antiSoftNum) {
		this.antiSoftNum = antiSoftNum;
	}

	public String getIsValid() {
		return this.isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getAssWallStatu() {
		return assWallStatu;
	}

	public void setAssWallStatu(String assWallStatu) {
		this.assWallStatu = assWallStatu;
	}

	public String getWallFrictionValue() {
		return wallFrictionValue;
	}

	public void setWallFrictionValue(String wallFrictionValue) {
		this.wallFrictionValue = wallFrictionValue;
	}

	public String getBackFilterAngle() {
		return backFilterAngle;
	}

	public void setBackFilterAngle(String backFilterAngle) {
		this.backFilterAngle = backFilterAngle;
	}
	

}