package cn.com.sinosafe.domain.gbcn.request;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 投保
 */
@XmlRootElement(name = "insureRequest")
@XmlType(propOrder = { "requestHead", "requestBody" })
public class InsureRequest implements BaseRequest {
	private RequestHead requestHead;

	private InsureRequestBody requestBody;

	public RequestHead getRequestHead() {
		return requestHead;
	}

	public void setRequestHead(RequestHead requestHead) {
		this.requestHead = requestHead;
	}

	public InsureRequestBody getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(InsureRequestBody requestBody) {
		this.requestBody = requestBody;
	}

	@XmlType(propOrder = { "applicantInfo", "policyInfo" })
	public static class InsureRequestBody {
		private InsureApplicantInfo applicantInfo;
		private InsurePolicyInfo policyInfo;

		public InsureApplicantInfo getApplicantInfo() {
			return applicantInfo;
		}

		public void setApplicantInfo(InsureApplicantInfo applicantInfo) {
			this.applicantInfo = applicantInfo;
		}

		public InsurePolicyInfo getPolicyInfo() {
			return policyInfo;
		}

		public void setPolicyInfo(InsurePolicyInfo policyInfo) {
			this.policyInfo = policyInfo;
		}

		@XmlType(name = "applicantInfo", propOrder = { "name", "mobile",
				"idNumber", "projectName", "bidSectionCode", "tendereeName",
				"tendereeCode", "tendereeAddress", "tendereeContactPhoneNumber" })
		public static class InsureApplicantInfo {
			private String name;// 投保人姓名
			private String mobile;// 投保人手机号码
			private String idNumber;// 投保人同意社会信用代码
			private String projectName;// 项目名称
			private String bidSectionCode;// 项目标段编号
			private String tendereeName;// 项目名称
			private String tendereeCode;// 项目标段编号
			private String tendereeAddress;// 招标人名称
			private String tendereeContactPhoneNumber;// 招标人统一社会信用证代码

			@XmlElement(name = "name")
			public void setName(String name) {
				this.name = name;
			}

			@XmlElement(name = "mobile")
			public void setMobile(String mobile) {
				this.mobile = mobile;
			}

			@XmlElement(name = "idNumber")
			public void setIdNumber(String idNumber) {
				this.idNumber = idNumber;
			}

			@XmlElement(name = "ProjectName")
			public void setProjectName(String projectName) {
				this.projectName = projectName;
			}

			@XmlElement(name = "BidSectionCode")
			public void setBidSectionCode(String bidSectionCode) {
				this.bidSectionCode = bidSectionCode;
			}

			@XmlElement(name = "TendereeName")
			public void setTendereeName(String tendereeName) {
				this.tendereeName = tendereeName;
			}

			@XmlElement(name = "TendereeCode")
			public void setTendereeCode(String tendereeCode) {
				this.tendereeCode = tendereeCode;
			}

			@XmlElement(name = "TendereeAddress")
			public void setTendereeAddress(String tendereeAddress) {
				this.tendereeAddress = tendereeAddress;
			}

			@XmlElement(name = "TendereeContactPhoneNumber")
			public void setTendereeContactPhoneNumber(
					String tendereeContactPhoneNumber) {
				this.tendereeContactPhoneNumber = tendereeContactPhoneNumber;
			}

			public String getName() {
				return name;
			}

			public String getMobile() {
				return mobile;
			}

			public String getIdNumber() {
				return idNumber;
			}

			public String getProjectName() {
				return projectName;
			}

			public String getBidSectionCode() {
				return bidSectionCode;
			}

			public String getTendereeName() {
				return tendereeName;
			}

			public String getTendereeCode() {
				return tendereeCode;
			}

			public String getTendereeAddress() {
				return tendereeAddress;
			}

			public String getTendereeContactPhoneNumber() {
				return tendereeContactPhoneNumber;
			}
		}

		@XmlType(propOrder = { "sumPremium", "sumAmount", "endorseText" })
		public static class InsurePolicyInfo {
			private BigDecimal sumPremium;// 保单保费
			private BigDecimal sumAmount;// 保单保额
			private String endorseText;// 特别约定内容

			public BigDecimal getSumPremium() {
				return sumPremium;
			}

			public void setSumPremium(BigDecimal sumPremium) {
				this.sumPremium = sumPremium;
			}

			public BigDecimal getSumAmount() {
				return sumAmount;
			}

			public void setSumAmount(BigDecimal sumAmount) {
				this.sumAmount = sumAmount;
			}

			public String getEndorseText() {
				return endorseText;
			}

			public void setEndorseText(String endorseText) {
				this.endorseText = endorseText;
			}
		}

	}
}
