package com.ceit.common.util;


public class LevelData {
	
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

	public LevelData(String levelVal) {
		if("1".equals(levelVal)){
			this.securityLevel="一级";
			this.securityStatus="良好";
			this.security_remark="挡土墙墙体强度、稳定性及地基承载力均在设计范围内，挡土墙工作良好";
		}else if("2".equals(levelVal)){
			this.securityLevel="二级";
			this.securityStatus="较好";
			this.security_remark="挡土墙功能良好，只有局部因为外力作用而产生轻度缺损或变形，不影响挡土墙正常使用";			
		}else if("3".equals(levelVal)){
			this.securityLevel="三级";
			this.securityStatus="一般";
			this.security_remark="挡土墙功能一般，有局部的变形或缺损，但挡土墙仍能继续使用";			
		}else if("4".equals(levelVal)){
			this.securityLevel="四级";
			this.securityStatus="较差";
			this.security_remark="挡土墙有较大的变形或基础有较大沉降，挡土墙本身的承载能力较差，需要中修才能继续使用";			
		}else if("5".equals(levelVal)){
			this.securityLevel="五级";
			this.securityStatus="差";
			this.security_remark="挡土墙有大的变形或基础沉降，墙体强度、稳定性与地基承载力，有一种或多种超过了挡土墙的承受能力，挡土墙需要大修或专项加固措施";			
		}else if("6".equals(levelVal)){
			this.securityLevel="六级";
			this.securityStatus="危险";
			this.security_remark="挡土墙有严重的功能性病害,挡土墙有很大的沉降或变形危险，土墙需要专门检査制定抢险措施好";			
		}
	}

	public static void main(String[] args) {
	}

}
