package cn.com.sinosafe.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PubExpenSettlement {
    /**
     * 主键
     */
    private String uuid;

    /**
     * 合作方
     */
    private String insuCompany;

    /**
     * 追偿服务费月份
     */
    private String accountMonth;

    /**
     * 追偿服务费总额
     */
    private BigDecimal accountTotal;

    /**
     * 基础费单价
     */
    private BigDecimal basePrice;

    /**
     * 活跃账户数总量
     */
    private String accountNum;

    /**
     * 基础费总额
     */
    private BigDecimal basePriceTotal;

    /**
     * 浮动费资产包所属月份
     */
    private String floatingMonth;

    /**
     * 资产包净赔付
     */
    private BigDecimal assetPoolPa;

    /**
     * 资产包保费收入
     */
    private BigDecimal assetPoolInsur;

    /**
     * 资产包理赔率
     */
    private BigDecimal assetPoolOdds;

    /**
     * 浮动费单价
     */
    private BigDecimal floatingPrice;

    /**
     * 浮动费资产包有效账龄
     */
    private String floatingAge;

    /**
     * 浮动费总额
     */
    private BigDecimal floatingTotal;

    /**
     * 风控技术费月份
     */
    private String singleFeeDate;

    /**
     * 风控技术费单价
     */
    private BigDecimal singleFeeRate;

    /**
     * 投保成功申请笔数
     */
    private BigDecimal coverFiAmt;

    /**
     * 风控技术费总额
     */
    private BigDecimal singleFeeTotal;

    /**
     * 追偿服务费结果
     */
    private String accountResult;

    /**
     * 出单费/风控技术费结果
     */
    private String singlefeeResult;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 修改人
     */
    private String modifyedBy;

    /**
     * 修改时间
     */
    private Date modifyedDate;
    
    /**
     * 合作方编号
     */
    private String copNo;
    /**
     * 合作方名称
     */
    private String copName;
    
    private BigDecimal overdueTotal;
    private String overdueFeeList;
    

    /**
	 * @return the overdueTotal
	 */
	public BigDecimal getOverdueTotal() {
		return overdueTotal;
	}

	/**
	 * @param overdueTotal the overdueTotal to set
	 */
	public void setOverdueTotal(BigDecimal overdueTotal) {
		this.overdueTotal = overdueTotal;
	}

	/**
	 * @return the overdueFeeList
	 */
	public String getOverdueFeeList() {
		return overdueFeeList;
	}

	/**
	 * @param overdueFeeList the overdueFeeList to set
	 */
	public void setOverdueFeeList(String overdueFeeList) {
		this.overdueFeeList = overdueFeeList;
	}

	/**
	 * @return the copNo
	 */
	public String getCopNo() {
		return copNo;
	}

	/**
	 * @param copNo the copNo to set
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}

	/**
	 * @return the copName
	 */
	public String getCopName() {
		return copName;
	}

	/**
	 * @param copName the copName to set
	 */
	public void setCopName(String copName) {
		this.copName = copName;
	}

	/**
     * 主键
     * @return UUID 主键
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 主键
     * @param uuid 主键
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    /**
     * 合作方
     * @return INSU_COMPANY 合作方
     */
    public String getInsuCompany() {
        return insuCompany;
    }

    /**
     * 合作方
     * @param insuCompany 合作方
     */
    public void setInsuCompany(String insuCompany) {
        this.insuCompany = insuCompany == null ? null : insuCompany.trim();
    }

    /**
     * 追偿服务费月份
     * @return ACCOUNT_MONTH 追偿服务费月份
     */
    public String getAccountMonth() {
        return accountMonth;
    }

    /**
     * 追偿服务费月份
     * @param accountMonth 追偿服务费月份
     */
    public void setAccountMonth(String accountMonth) {
        this.accountMonth = accountMonth == null ? null : accountMonth.trim();
    }

    /**
     * 追偿服务费总额
     * @return ACCOUNT_TOTAL 追偿服务费总额
     */
    public BigDecimal getAccountTotal() {
        return accountTotal;
    }

    /**
     * 追偿服务费总额
     * @param accountTotal 追偿服务费总额
     */
    public void setAccountTotal(BigDecimal accountTotal) {
        this.accountTotal = accountTotal;
    }

    /**
     * 基础费单价
     * @return BASE_PRICE 基础费单价
     */
    public BigDecimal getBasePrice() {
        return basePrice;
    }

    /**
     * 基础费单价
     * @param basePrice 基础费单价
     */
    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    /**
     * 活跃账户数总量
     * @return ACCOUNT_NUM 活跃账户数总量
     */
    public String getAccountNum() {
        return accountNum;
    }

    /**
     * 活跃账户数总量
     * @param accountNum 活跃账户数总量
     */
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum == null ? null : accountNum.trim();
    }

    /**
     * 基础费总额
     * @return BASE_PRICE_TOTAL 基础费总额
     */
    public BigDecimal getBasePriceTotal() {
        return basePriceTotal;
    }

    /**
     * 基础费总额
     * @param basePriceTotal 基础费总额
     */
    public void setBasePriceTotal(BigDecimal basePriceTotal) {
        this.basePriceTotal = basePriceTotal;
    }

    /**
     * 浮动费资产包所属月份
     * @return FLOATING_MONTH 浮动费资产包所属月份
     */
    public String getFloatingMonth() {
        return floatingMonth;
    }

    /**
     * 浮动费资产包所属月份
     * @param floatingMonth 浮动费资产包所属月份
     */
    public void setFloatingMonth(String floatingMonth) {
        this.floatingMonth = floatingMonth == null ? null : floatingMonth.trim();
    }

    /**
     * 资产包净赔付
     * @return ASSET_POOL_PA 资产包净赔付
     */
    public BigDecimal getAssetPoolPa() {
        return assetPoolPa;
    }

    /**
     * 资产包净赔付
     * @param assetPoolPa 资产包净赔付
     */
    public void setAssetPoolPa(BigDecimal assetPoolPa) {
        this.assetPoolPa = assetPoolPa;
    }

    /**
     * 资产包保费收入
     * @return ASSET_POOL_INSUR 资产包保费收入
     */
    public BigDecimal getAssetPoolInsur() {
        return assetPoolInsur;
    }

    /**
     * 资产包保费收入
     * @param assetPoolInsur 资产包保费收入
     */
    public void setAssetPoolInsur(BigDecimal assetPoolInsur) {
        this.assetPoolInsur = assetPoolInsur;
    }

    /**
     * 资产包理赔率
     * @return ASSET_POOL_ODDS 资产包理赔率
     */
    public BigDecimal getAssetPoolOdds() {
        return assetPoolOdds;
    }

    /**
     * 资产包理赔率
     * @param assetPoolOdds 资产包理赔率
     */
    public void setAssetPoolOdds(BigDecimal assetPoolOdds) {
        this.assetPoolOdds = assetPoolOdds;
    }

    /**
     * 浮动费单价
     * @return FLOATING_PRICE 浮动费单价
     */
    public BigDecimal getFloatingPrice() {
        return floatingPrice;
    }

    /**
     * 浮动费单价
     * @param floatingPrice 浮动费单价
     */
    public void setFloatingPrice(BigDecimal floatingPrice) {
        this.floatingPrice = floatingPrice;
    }

    /**
     * 浮动费资产包有效账龄
     * @return FLOATING_AGE 浮动费资产包有效账龄
     */
    public String getFloatingAge() {
        return floatingAge;
    }

    /**
     * 浮动费资产包有效账龄
     * @param floatingAge 浮动费资产包有效账龄
     */
    public void setFloatingAge(String floatingAge) {
        this.floatingAge = floatingAge == null ? null : floatingAge.trim();
    }

    /**
     * 浮动费总额
     * @return FLOATING_TOTAL 浮动费总额
     */
    public BigDecimal getFloatingTotal() {
        return floatingTotal;
    }

    /**
     * 浮动费总额
     * @param floatingTotal 浮动费总额
     */
    public void setFloatingTotal(BigDecimal floatingTotal) {
        this.floatingTotal = floatingTotal;
    }

    /**
     * 风控技术费月份
     * @return SINGLE_FEE_DATE 风控技术费月份
     */
    public String getSingleFeeDate() {
        return singleFeeDate;
    }

    /**
     * 风控技术费月份
     * @param singleFeeDate 风控技术费月份
     */
    public void setSingleFeeDate(String singleFeeDate) {
        this.singleFeeDate = singleFeeDate == null ? null : singleFeeDate.trim();
    }

    /**
     * 风控技术费单价
     * @return SINGLE_FEE_RATE 风控技术费单价
     */
    public BigDecimal getSingleFeeRate() {
        return singleFeeRate;
    }

    /**
     * 风控技术费单价
     * @param singleFeeRate 风控技术费单价
     */
    public void setSingleFeeRate(BigDecimal singleFeeRate) {
        this.singleFeeRate = singleFeeRate;
    }

    /**
     * 投保成功申请笔数
     * @return COVER_FI_AMT 投保成功申请笔数
     */
    public BigDecimal getCoverFiAmt() {
        return coverFiAmt;
    }

    /**
     * 投保成功申请笔数
     * @param coverFiAmt 投保成功申请笔数
     */
    public void setCoverFiAmt(BigDecimal coverFiAmt) {
        this.coverFiAmt = coverFiAmt;
    }

    /**
     * 风控技术费总额
     * @return SINGLE_FEE_TOTAL 风控技术费总额
     */
    public BigDecimal getSingleFeeTotal() {
        return singleFeeTotal;
    }

    /**
     * 风控技术费总额
     * @param singleFeeTotal 风控技术费总额
     */
    public void setSingleFeeTotal(BigDecimal singleFeeTotal) {
        this.singleFeeTotal = singleFeeTotal;
    }

    /**
     * 追偿服务费结果
     * @return ACCOUNT_RESULT 追偿服务费结果
     */
    public String getAccountResult() {
        return accountResult;
    }

    /**
     * 追偿服务费结果
     * @param accountResult 追偿服务费结果
     */
    public void setAccountResult(String accountResult) {
        this.accountResult = accountResult == null ? null : accountResult.trim();
    }

    /**
     * 出单费/风控技术费结果
     * @return SINGLEFEE_RESULT 出单费/风控技术费结果
     */
    public String getSinglefeeResult() {
        return singlefeeResult;
    }

    /**
     * 出单费/风控技术费结果
     * @param singlefeeResult 出单费/风控技术费结果
     */
    public void setSinglefeeResult(String singlefeeResult) {
        this.singlefeeResult = singlefeeResult == null ? null : singlefeeResult.trim();
    }

    /**
     * 创建人
     * @return CREATED_BY 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 创建人
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * 创建时间
     * @return CREATED_DATE 创建时间
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * 创建时间
     * @param createdDate 创建时间
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 修改人
     * @return MODIFYED_BY 修改人
     */
    public String getModifyedBy() {
        return modifyedBy;
    }

    /**
     * 修改人
     * @param modifyedBy 修改人
     */
    public void setModifyedBy(String modifyedBy) {
        this.modifyedBy = modifyedBy == null ? null : modifyedBy.trim();
    }

    /**
     * 修改时间
     * @return MODIFYED_DATE 修改时间
     */
    public Date getModifyedDate() {
        return modifyedDate;
    }

    /**
     * 修改时间
     * @param modifyedDate 修改时间
     */
    public void setModifyedDate(Date modifyedDate) {
        this.modifyedDate = modifyedDate;
    }
}