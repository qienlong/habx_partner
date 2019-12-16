package cn.com.sinosafe.domain.bean;

import cn.com.sinosafe.common.util.StringUtils;

/**
 * 
 * 马上消费资金方编号与简称对应枚举 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月3日<br>
 */
public enum MsxfBankType {

	哈密城商行		("PRJ20190801091636",	"HMBANK"),
	重庆银行		("PRJ20181130087414",	"CQBANK"),
	南京银行		("PRJ20190925093534",	"NJBANK");
	
	private String partner;
	private String bank;
	
	/**
	 * 根据资金方编号获取银行简称
	 * @param partner
	 * @return
	 */
	public static String getBank(String partner) {
		String bank = null;
		for (MsxfBankType fileType : MsxfBankType.values()) {
			if(StringUtils.equals(fileType.getPartner(), partner)) {
				bank = fileType.getBank();
				break;
			}
		}
		return bank;
	}

	private MsxfBankType(String partner, String bank) {
		this.partner = partner;
		this.bank = bank;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}
	
	
	
}
