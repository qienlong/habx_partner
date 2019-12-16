/**   
* @Title:：SentStatusCode.java 
* @Package ：cn.com.sinosafe.common.config.constant 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月6日 上午10:44:53 
* @version ： 1.0   
*/
package cn.com.sinosafe.domain.bean;

/** 
 * @ClassName:：SentStatusCode 
 * @Description： TODO
 * @author ：xiewei
 * @date ：2019年6月6日 上午10:44:53  
 */
public enum SentStatusCode {
	/**
	 * 投保申请
	 */
    PA_01("01"),
    /**
     * 投保成功
     */
    PA_02("02"),
    /**
     * 投保失败
     */
    PA_03("03"),
    /**
     * 已投保通知
     */
    PA_04("04"),
   
    /**
     * 平安已核保通知
     */
    PA_05("05"),
    
    /**
     * 华安核保通过
     */
    PA_06("06"),
    
    /**
     * 华安核保拒绝
     */
    PA_07("07"),
    
    /**
     * 保费校验通过
     */
    PA_08("08"),
    
    /**
     * 保费校验拒绝
     */
    PA_09("09"),
    
    /**
     * 已出单通知
     */
    PA_10("10"),
    
    /**
     * 已出单
     */
    PA_11("11"),
    
    /**
     * 保单已推送
     */
    PA_12("12"),
	/**
	 * 授信制回退
	 */
	PA_13("13"),
	/**
	 * 已放款
	 */
	PA_14("14"),
	/**
	 * 已退票
	 */
	PA_15("15"),
	/**
	 * 已取消
	 */
	PA_16("16"),
	/**
	 * 核赔申请
	 */
	PA_17("17"),
	/**
	 * 核赔通过/核赔拒绝
	 */
	PA_18("18"),
	/**
	 * 理赔交易报盘
	 */
	PA_19("19"),
	/**
	 * 理赔交易完成通知
	 */
	PA_20("20"),
	/**
	 * 代偿结清
	 */
	PA_21("21"),
	/**
	 * 正常结清
	 */
	PA_22("22"),
	/**
	 * 提前结清
	 */
	PA_23("23"),
	/**
	 * 追偿结清
	 */
	PA_24("24");
	
    private final String code;

    SentStatusCode(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }
    
    
}
