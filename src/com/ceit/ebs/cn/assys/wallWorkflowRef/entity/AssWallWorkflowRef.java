package com.ceit.ebs.cn.assys.wallWorkflowRef.entity;


import com.ceit.common.entity.BaseEntity;

/**
 * AssWallWorkflowRef entity. @author MyEclipse Persistence Tools
 */

public class AssWallWorkflowRef extends BaseEntity implements java.io.Serializable {

	private static final long serialVersionUID = -8918566641608954990L;
	private String wallWorkflowRefId;
	private String wallId;
	private String flowId;
	public String getWallWorkflowRefId() {
		return wallWorkflowRefId;
	}
	public void setWallWorkflowRefId(String wallWorkflowRefId) {
		this.wallWorkflowRefId = wallWorkflowRefId;
	}
	public String getWallId() {
		return wallId;
	}
	public void setWallId(String wallId) {
		this.wallId = wallId;
	}
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	

}