/**
 * 
 */
package cn.com.sinosafe.domain.bean;

/**  
* <p>Title: ClaimResultEnum</p>  
* <p>Description: </p>  
* @author longxiaoqiang  
* @date 2019年8月29日  
*/
public enum ClaimResultEnum {

	CLAIM_SESULT_TYPE1("01","01-借据信息有误"),
	
	CLAIM_SESULT_TYPE2("02","02-校验本金不通过"),
	
	CLAIM_SESULT_TYPE3("03","03-校验保额不通过");
	
	private final String code;
	private final String content;
	
	/**
	 * @param code
	 * @param content
	 */
	private ClaimResultEnum(String code, String content) {
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
    public static String getContent(String code){
        for(ClaimResultEnum temp:ClaimResultEnum.values()){
            if(temp.code() == code){
                return temp.content;
            }
        }
        return null;
    }
}
