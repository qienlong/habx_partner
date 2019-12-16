/**   
* @Title:：PaLstDownloadMsg.java 
* @Package ：cn.com.sinosafe.domain.dto 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月5日 下午9:32:44 
* @version ： 1.0   
*/
package cn.com.sinosafe.domain.dto;

import cn.com.sinosafe.common.config.constant.LstIqpSyncConstant;
import cn.com.sinosafe.common.util.StringUtils;

/** 
 * @ClassName:：PaLstDownloadMsg 
 * @Description： TODO
 * @author ：xiewei
 * @date ：2019年6月5日 下午9:32:44  
 */
public class PaLstDownloadMsg {
	/**
	 * 申请号
	 */
	private String applNo;
	/**
	 * 保单号
	 */
	private String policyNo;
	/**
	 * 文件名称
	 */
	private String fileName;
	/**
	 * 文件类型
	 */
	private String fileType;
	/**
	 * 文件流向
	 */
	private String fileFlow;
	/**
	 * 保险公司合作方
	 */
	private String insuCompany;
	
	
	public PaLstDownloadMsg() {
		super();
	}
	
	public PaLstDownloadMsg(String applNo, String policyNo, String fileName) {
		super();
		this.applNo = applNo;
		this.policyNo = policyNo;
		this.fileName = fileName;
	}

	public PaLstDownloadMsg(String applNo, String policyNo, String fileName,
			String fileType, String fileFlow, String insuCompany) {
		super();
		this.applNo = applNo;
		this.policyNo = policyNo;
		this.fileName = fileName;
		this.fileType = fileType;
		this.fileFlow = fileFlow;
		this.insuCompany = insuCompany;
	}
	public String getApplNo() {
		return applNo;
	}
	public void setApplNo(String applNo) {
		this.applNo = applNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		if(StringUtils.isEmpty(fileType)){
			fileType=LstIqpSyncConstant.fileType;
		}
		this.fileType = fileType;
	}
	public String getFileFlow() {
		return fileFlow;
	}
	public void setFileFlow(String fileFlow) {
		if(StringUtils.isEmpty(fileFlow)){
			fileFlow=LstIqpSyncConstant.fileFlow;
		}
		this.fileFlow = fileFlow;
	}
	public String getInsuCompany() {
		return insuCompany;
	}
	public void setInsuCompany(String insuCompany) {
		if(StringUtils.isEmpty(insuCompany)){
			insuCompany=LstIqpSyncConstant.insuCompany;
		}
		this.insuCompany = insuCompany;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaLstDownloadMsg [applNo=");
		builder.append(applNo);
		builder.append(", policyNo=");
		builder.append(policyNo);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", fileType=");
		builder.append(fileType);
		builder.append(", fileFlow=");
		builder.append(fileFlow);
		builder.append(", insuCompany=");
		builder.append(insuCompany);
		builder.append("]");
		return builder.toString();
	}
	
	

}
