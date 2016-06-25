package com.ceit.common.util;


public class DeSteadyData {
	
	private String securityLevel;
	private String securityStatus;
	private String security_remark;
	
	public String getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(String securityLevel) {
		this.securityLevel = securityLevel;
	}

	public String getSecurityStatus() {
		return securityStatus;
	}

	public void setSecurityStatus(String securityStatus) {
		this.securityStatus = securityStatus;
	}

	public String getSecurity_remark() {
		return security_remark;
	}

	public void setSecurity_remark(String securityRemark) {
		security_remark = securityRemark;
	}

	public DeSteadyData(String levelVal) {
		if("1".equals(levelVal)){
			this.securityLevel="一级";
			this.securityStatus="良好";
			this.security_remark="挡土墙的稳定性系数大于规范值，挡土墙基本未出现病害，只需加强常规的养护工作即可";
		}else if("2".equals(levelVal)){
			this.securityLevel="二级";
			this.securityStatus="较好";
			this.security_remark="挡土墙的稳定性系数略小于规范值，挡土墙出现一些细微的裂缝等病害，但对挡土墙稳定性影响较小，只需加强常规维护";			
		}else if("3".equals(levelVal)){
			this.securityLevel="三级";
			this.securityStatus="一般";
			this.security_remark="挡土墙的稳定性小于规范值，挡土墙出现较多的病害，挡土墙稳定性受到影响，需要小修 ";			
		}else if("4".equals(levelVal)){
			this.securityLevel="四级";
			this.securityStatus="较差";
			this.security_remark="挡土墙的稳定性系数小于规范值较多，挡土墙病害发展严重，在外力作用下，有继续恶化的趋势，需及时中修";			
		}else if("5".equals(levelVal)){
			this.securityLevel="五级";
			this.securityStatus="差";
			this.security_remark="挡土墙的稳定性较差，挡土墙处于滑动或倾覆破坏的极限，在外力作用下，随时可能倾覆或滑动";			
		}else if("6".equals(levelVal)){
			this.securityLevel="六级";
			this.securityStatus="危险";
			this.security_remark="挡土墙已经滑动或倾覆一部分，需制定专门的措施进行修缮";			
		}
	}

	public static void main(String[] args) {
	}

}
