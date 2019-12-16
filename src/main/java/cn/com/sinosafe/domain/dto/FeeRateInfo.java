package cn.com.sinosafe.domain.dto;

public class FeeRateInfo {

	
	/**
	 * 费用基数
	 */
	private String feeBase;
	/**
	 * 费率单位
	 */
	private String feeRateUnit;

	/**
	 * 费率
	 */
	private String feeRate;
	/**
	 * 费用编码
	 */
	private String feeCode;
	
	/**
	 * 增信方编码
	 */
	private String increaseCreditCode;
	/**
	 * 保险公司合作方
	 */
	private String insuCompany;
	
	/**
	 * 系统编码
	 */
	private String systemCode;

	public String getFeeBase() {
		return feeBase;
	}

	public void setFeeBase(String feeBase) {
		this.feeBase = feeBase;
	}

	public String getFeeRateUnit() {
		return feeRateUnit;
	}

	public void setFeeRateUnit(String feeRateUnit) {
		this.feeRateUnit = feeRateUnit;
	}

	public String getFeeRate() {
		return feeRate;
	}

	public void setFeeRate(String feeRate) {
		this.feeRate = feeRate;
	}

	public String getFeeCode() {
		return feeCode;
	}

	public void setFeeCode(String feeCode) {
		this.feeCode = feeCode;
	}

	public String getIncreaseCreditCode() {
		return increaseCreditCode;
	}

	public void setIncreaseCreditCode(String increaseCreditCode) {
		this.increaseCreditCode = increaseCreditCode;
	}

	public String getInsuCompany() {
		return insuCompany;
	}

	public void setInsuCompany(String insuCompany) {
		this.insuCompany = insuCompany;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FeeRateInfo [feeBase=");
		builder.append(feeBase);
		builder.append(", feeRateUnit=");
		builder.append(feeRateUnit);
		builder.append(", feeRate=");
		builder.append(feeRate);
		builder.append(", feeCode=");
		builder.append(feeCode);
		builder.append(", increaseCreditCode=");
		builder.append(increaseCreditCode);
		builder.append(", insuCompany=");
		builder.append(insuCompany);
		builder.append(", systemCode=");
		builder.append(systemCode);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
