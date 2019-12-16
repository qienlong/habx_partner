package cn.com.sinosafe.domain.bean;

/**
 * @Desc   : 短信模板枚举  <br>
 * @Author : hrison <br>
 * @Date   : 2019年6月5日<br>
 */
public enum SmsTemplateEnum {

	/**
	 * 核保
	 */
	UNDERWRITING(1, "非常抱歉，您投保的华安财产保险股份有限公司{0521险种名称}未能通过我司核保。"),
	
	/**
	 * 出单
	 */
	BILLING(2, "您投保的华安财产保险股份有限公司{0521险种名称}已由我司承保，保单号为${ply_no}，您可登录华安保险官网https://www.sinosafe.com.cn/、拨打华安保险客服热线95556、前往华安保险分公司营业网点柜面或登录申请借款时使用的APP查询保单信息。"),
	
	/**
	 * 核赔
	 */
	COMPENSATION(3, "尊敬的客户${cus_name}，您好。您在我司投保的贷款（保单号：${ply_no}）已逾期且触发保险理赔，赔付金额为：${claim_sum}元人民币。根据央行规定，我司会将该笔代偿信息上报至央行征信系统，并在您的个人征信报告中体现。请您及时归还该笔欠款。如您在收到短信前已归还，请忽略本短信。如有问题请联系我司客服热线95556！"),
	
	/**
	 * 注销保单
	 */
	CONCELLST(4, "您投保的保单号为${ply_no}华安财产保险股份有限公司{0521险种名称}，因被保险人放款失败导致未能起保，保单已注销。");
	
	private final int code;
	private final String content;

    SmsTemplateEnum(int code, String content) {
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
        for(SmsTemplateEnum temp:SmsTemplateEnum.values()){
            if(temp.code() == id){
                return temp.content;
            }
        }
        return null;
    }
}
