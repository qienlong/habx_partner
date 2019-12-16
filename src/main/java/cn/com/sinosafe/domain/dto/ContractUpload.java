package cn.com.sinosafe.domain.dto;


/**
 * 安心签电子合同下载上传影像系统信息对象
 * @Project	: haxb_partner
 * @Author	: hesong
 * @Date	: 2019年6月9日 下午11:15:17
 * @Version	: 1.0
 */
public class ContractUpload {
	
	/**
	 * 安心签合同号
	 */
	private String contractNo;
	/**
	 * 影像系统文件名
	 */
	private String contractName;
	/**
	 * 业务流水号
	 */
	private String serno;
	/**
	 * 影像系统产品号
	 */
	private String prdCodes;
	/**
	 * 影像系统目录号
	 */
	private String dirCodes;
	/**
	 * 合同类型，主要用来管理上传后的影像URL
	 */
	private String textType;
	
	
	public ContractUpload() {
		super();
	}
	public ContractUpload(String contractNo, String contractName, String serno,
			String prdCodes, String dirCodes, String textType) {
		super();
		this.contractNo = contractNo;
		this.contractName = contractName;
		this.serno = serno;
		this.prdCodes = prdCodes;
		this.dirCodes = dirCodes;
		this.textType = textType;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getContractName() {
		return contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getSerno() {
		return serno;
	}
	public void setSerno(String serno) {
		this.serno = serno;
	}
	public String getPrdCodes() {
		return prdCodes;
	}
	public void setPrdCodes(String prdCodes) {
		this.prdCodes = prdCodes;
	}
	public String getDirCodes() {
		return dirCodes;
	}
	public void setDirCodes(String dirCodes) {
		this.dirCodes = dirCodes;
	}
	public String getTextType() {
		return textType;
	}
	public void setTextType(String textType) {
		this.textType = textType;
	}
	
}
