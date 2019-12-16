package cn.com.sinosafe.common.config.constant;

/**
 * @Desc   : 邮件模板枚举  <br>
 * @Author : hrison <br>
 * @Date   : 2019年6月5日<br>
 */
public enum CheckIssueResultEnum {

	/**
	 * 平安审批成功
	 */
	PA_APPROVE_SUCCESS("0", "平安审批成功"),
	
	/**
	 * 平安审批拒绝
	 */
	PA_APPROVE_REJECT("1", "平安审批拒绝"),
	
	
	/**
	 * 调用命中内部黑名单
	 */
	BLK_REJECT("01", "调用命中内部黑名单"),
	
	
	/**
	 * 调用命中准入规则
	 */
	LOAN_STATUS_REJECT("02", "调用命中准入规则"),
	
	
	/**
	 * 调用命中额度规则
	 */
	AMOUNT_REJECT("03", "调用命中额度规则"),
	
	/**
	 * 增信方拒绝
	 */
	PINGAN_REJECT("06", "增信方拒绝");
	
	
	private final String code;
	private final String content;

    CheckIssueResultEnum(String code, String content) {
        this.code = code;
        this.content = content;
    }

    public String code() {
        return code;
    }
    
    public String content() {
        return content;
    }
    
    // 根据短信模板ID获取枚举
    public static String getTemplate(String id){
        for(CheckIssueResultEnum temp:CheckIssueResultEnum.values()){
            if(id.equals(temp.code())){
                return temp.content;
            }
        }
        return null;
    }
}
