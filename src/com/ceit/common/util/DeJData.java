package com.ceit.common.util;


public class DeJData {
	
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

	public DeJData(String levelVal) {
		if("1".equals(levelVal)){
			this.securityLevel="一级";
			this.securityStatus="良好";
			this.security_remark="挡土墙剪应力比规范值小，功能良好。只需常规保样、小修即可";
		}else if("2".equals(levelVal)){
			this.securityLevel="二级";
			this.securityStatus="较好";
			this.security_remark="挡土墙剪应力比规范值稍大，但在安全富于度内，挡土墙墙体强度较好";			
		}else if("3".equals(levelVal)){
			this.securityLevel="三级";
			this.securityStatus="一般";
			this.security_remark="挡土墙剪应力比规范值大，强度一般，墙体出现些许裂缝，但仍能正常使用";			
		}else if("4".equals(levelVal)){
			this.securityLevel="四级";
			this.securityStatus="较差";
			this.security_remark="剪应力超出规范要求值较大，裂缝宽度扩展，已影响挡土墙的正常使用，需定期检测、中或大修";			
		}else if("5".equals(levelVal)){
			this.securityLevel="五级";
			this.securityStatus="差";
			this.security_remark="挡土墙剪应力值超出规范要求值很多，有发生剪切破坏的前兆，挡土墙应进行大修";			
		}else if("6".equals(levelVal)){
			this.securityLevel="六级";
			this.securityStatus="危险";
			this.security_remark="挡土墙处于剪切破坏边缘，随时可能发生剪切破坏，挡土墙应进行大修或专项加固";			
		}
	}

	public static void main(String[] args) {
	}

}
