package cn.com.sinosafe.domain.entity;

import java.util.Date;
/**
 * @Project	: Rest_HAXB_Service
 * @Desc	: 系统配置实体类
 * @Author	: hesong
 * @Date	: 2018年12月25日 上午16:15:03
 * @Version	: 1.0
 */
public class SysConfig {
	
    /**
     * 配置编号
     * @Author	: hesong
     */
    private Integer configId;

    /**
     * 配置类型（0：Redis类型；）
     */
    private String configType;

    /**
     * 配置的值
     */
    private String configValue;

    /**
     * 备注说明
     */
    private String remark;

    /**
     * 配置添加日期
     */
    private Date createDate;

    /**
     * 
     */
    private Date updateDate;

    /**
     * 配置编号
     * @return config_id 配置编号
     */
    public Integer getConfigId() {
        return configId;
    }

    /**
     * 配置编号
     * @param configId 配置编号
     */
    public void setConfigId(Integer configId) {
        this.configId = configId;
    }

    /**
     * 配置类型（0：Redis类型；）
     * @return config_type 配置类型（0：Redis类型；）
     */
    public String getConfigType() {
        return configType;
    }

    /**
     * 配置类型（0：Redis类型；）
     * @param configType 配置类型（0：Redis类型；）
     */
    public void setConfigType(String configType) {
        this.configType = configType == null ? null : configType.trim();
    }

    /**
     * 配置的值
     * @return config_value 配置的值
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * 配置的值
     * @param configValue 配置的值
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
    }

    /**
     * 备注说明
     * @return remark 备注说明
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注说明
     * @param remark 备注说明
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 配置添加日期
     * @return create_date 配置添加日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 配置添加日期
     * @param createDate 配置添加日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 
     * @return update_date 
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 
     * @param updateDate 
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}