package cn.com.sinosafe.domain.bean;

/**
 * @Desc   : 邮件模板枚举  <br>
 * @Author : hrison <br>
 * @Date   : 2019年6月5日<br>
 */
public enum EmailTemplateEnum {

	/**
	 * 费率不一致
	 */
	INCONSISTENT_RATES(1, "平安独立承保项目，平安申请号：{paserno}，华安业务流水号：{haserno}，平安保费费率码值：{painsureRateCode}与华安保费费率码值：{hainsureRateCode}，费率：{insureRate}保费率不一致，请及时处理。"),
	/**
	 * 
	 */
	INCONSISTENT_RATES1(2, "平安独立承保项目，平安申请号：{appno}，华安业务流水号：{pkid}，索赔申请核赔不通过，不通过原因：{content}"),
	/**
	 * 
	 */
	INCONSISTENT_RATES2(3, "平安独立承保项目，平安申请号：{申请号}，华安业务流水号：{华安业务流水号}，理赔支付失败，支付失败原因：{content}。");
	
	
	private final int code;
	private final String content;

    EmailTemplateEnum(int code, String content) {
        this.code = code;
        this.content = content;
    }

    public int code() {
        return code;
    }
    
    public String content() {
        return content;
    }
    
    // 根据短信模板ID获取枚举
    public static String getTemplate(int id){
        for(EmailTemplateEnum temp:EmailTemplateEnum.values()){
            if(temp.code() == id){
                return temp.content;
            }
        }
        return null;
    }
}
