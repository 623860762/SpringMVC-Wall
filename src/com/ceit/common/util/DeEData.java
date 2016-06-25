package com.ceit.common.util;


public class DeEData {
	
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

	public DeEData(String levelVal) {
		if("1".equals(levelVal)){
			this.securityLevel="一级";
			this.securityStatus="良好";
			this.security_remark="偏心距满足规范要求，挡土墙功能良好，只需常规检测及小修保养";
		}else if("2".equals(levelVal)){
			this.securityLevel="二级";
			this.securityStatus="较好";
			this.security_remark="偏心距稍大于规范要求值，且不利于继续发展，挡土墙仍能较好的使用，只需常规检测、小修";			
		}else if("3".equals(levelVal)){
			this.securityLevel="三级";
			this.securityStatus="一般";
			this.security_remark="偏心距大于规范要求值，如不继续发展，挡土墙仍能正常使用，需定期检测、小或中修";			
		}else if("4".equals(levelVal)){
			this.securityLevel="四级";
			this.securityStatus="较差";
			this.security_remark="偏心距超出规范要求值较大，已影响挡土墙的正常使用，需定期检测、中或大修";			
		}else if("5".equals(levelVal)){
			this.securityLevel="五级";
			this.securityStatus="差";
			this.security_remark="偏心距超出规范要求值过大，挡土墙有较大沉降或变形，需连续监测、大修或专项加固";			
		}else if("6".equals(levelVal)){
			this.securityLevel="六级";
			this.securityStatus="危险";
			this.security_remark="偏心距超出规范要求值极多，挡土墙有大的沉降或变形，可能已发生不均匀沉降破坏，需实时监测、专项加固或应急抢险";			
		}
	}

	public static void main(String[] args) {
	}

}
