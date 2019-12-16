package com.sinosafe.xinbao.dubbo.service;

import java.util.Map;


/**
 * 
 * Copy Right Information : SINOSAFE <br>
 * Description : 封装规则引擎webservice调用，发布至dubbo<br>
 * Author : ChenLiang <br>
 * Version : 1.0.0 <br>
 * Since : 1.0 <br>
 * Date : 2016年9月7日<br>
 */
public interface RuleService {
	
	/**
	 * 自动审批规则库调用
	 * @param param
	 * @return
	 */
	public String rule(Map<String, Object> param);
	
	/**
	 * 预审规则库调用
	 * @param otherInfoJson
	 * @return
	 */
	public String preRule(String otherInfoJson);
	
	/**
	 * 根据身份证查询调用规则详情
	 * @param certno 身份证号
	 * @param ruleType 规则类型 1预审 2终审
	 * @return {"retCode":"0000","count":"4"}
	 */
	public String queryRuleBusiInfo(String certno, String ruleType);
	
	/**
	 * APP-自动审批规则库调用
	 * @param param
	 * @return
	 */
	public String appRule(Map<String, Object> param);
	
	/**
	 * APP-预审规则库调用
	 * @param otherInfoJson
	 * @return
	 */
	public String appPreRule(String otherInfoJson);
	
}
