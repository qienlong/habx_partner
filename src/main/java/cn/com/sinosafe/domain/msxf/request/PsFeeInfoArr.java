package cn.com.sinosafe.domain.msxf.request;

import java.math.BigDecimal;

/**
 * 
 * 分期计划接口相关参数 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月5日<br>
 */
@Deprecated
public class PsFeeInfoArr {
	private BigDecimal psCoverageFee;
	private String psDueDate;
	public BigDecimal getPsCoverageFee() {
		return psCoverageFee;
	}
	public void setPsCoverageFee(BigDecimal psCoverageFee) {
		this.psCoverageFee = psCoverageFee;
	}
	public String getPsDueDate() {
		return psDueDate;
	}
	public void setPsDueDate(String psDueDate) {
		this.psDueDate = psDueDate;
	}
	
	
}
