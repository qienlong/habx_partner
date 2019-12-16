package cn.com.sinosafe.domain.bean;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.util.StringUtils;

/**
 * 
 * 马上贷后借据状态枚举 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年10月22日<br>
 */
public enum MsxfLoanStatus {
	
	正常		("1",	"1",	MsxfConstant.MSXF_AL100201),
	延期		("2",	"4",	MsxfConstant.MSXF_AL100203),
	提前结清	("3",	"9",	MsxfConstant.MSXF_AL100202),
	逾期		("4",	"4",	MsxfConstant.MSXF_AL100204),
	结清		("5",	"9",	MsxfConstant.MSXF_AL100201),
	非应计	("8",	"4",	""),
	理赔结清	("9",	"9",	""),
	正常终止	("17",	"1",	MsxfConstant.MSXF_AL100206),
	逾期终止	("47",	"4",	MsxfConstant.MSXF_AL100206);
	
	// 马上借据状态
	private String msStatus;
	// 对应华安借据状态
	private String haStatus;
	// 贷后数据处理接口名
	private String interfaceName;
	
	private MsxfLoanStatus(String msStatus,String haStatus,String interfaceName) {
		this.msStatus = msStatus;
		this.haStatus = haStatus;
		this.interfaceName = interfaceName;
	}
	
	public static String getHaStatue(String msStatus) {
		String haStatus = null;
		for (MsxfLoanStatus status : MsxfLoanStatus.values()) {
			if(StringUtils.equals(msStatus, status.getMsStatus())) {
				haStatus = status.getHaStatus();
				break;
			}
		}
		return haStatus;
	}
	
	public static String getInterfaceName(String msStatus) {
		String interfaceName = null;
		for (MsxfLoanStatus status : MsxfLoanStatus.values()) {
			if(StringUtils.equals(msStatus, status.getMsStatus())) {
				interfaceName = status.getInterfaceName();
				break;
			}
		}
		return interfaceName;
	}

	public String getMsStatus() {
		return msStatus;
	}

	public void setMsStatus(String msStatus) {
		this.msStatus = msStatus;
	}

	public String getHaStatus() {
		return haStatus;
	}

	public void setHaStatus(String haStatus) {
		this.haStatus = haStatus;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	
}
