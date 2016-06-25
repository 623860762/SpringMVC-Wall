package com.ceit.ebs.cn.assys.workFlow.entity;


import com.ceit.common.entity.BaseEntity;

/**
 * AssWorkFlow entity. @author MyEclipse Persistence Tools
 */

public class AssWorkFlow extends BaseEntity implements java.io.Serializable {

	private static final long serialVersionUID = 7748923914101880121L;
	private String flowId;
	private String flowName;
	private String flowUrl;
	private String flowRemark;
	private String flowState;
	
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getFlowName() {
		return flowName;
	}
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	public String getFlowUrl() {
		return flowUrl;
	}
	public void setFlowUrl(String flowUrl) {
		this.flowUrl = flowUrl;
	}
	public String getFlowRemark() {
		return flowRemark;
	}
	public void setFlowRemark(String flowRemark) {
		this.flowRemark = flowRemark;
	}
	public String getFlowState() {
		return flowState;
	}
	public void setFlowState(String flowState) {
		this.flowState = flowState;
	}

}