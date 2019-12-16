package com.sinosafe.xinbao.dubbo.service;


import com.sinosafe.app.pbc.bean.ParamerBean;
import com.sinosafe.app.pbc.bean.ResultPbcBean;

import java.util.Map;

/**
 * @author LMH
 *
 */
public interface CreditQueryService {
	
	/***
	 * 人行个人征信报告查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public ResultPbcBean accessPbc(Map<String, String> map) throws Exception;


	/***
	 * 人行企业征信报告查询
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public ResultPbcBean accessEnterprisePbc(Map<String, String> map) throws Exception;


	/***
	 * 公民联网核查
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public ResultPbcBean accessPoliceVerify(Map<String, String> map) throws Exception;
	
	/***
	* @Title: getCreditFcioData
	* @Description: 获取征信fico 评分数据
	* @param @param bean
	* @param @return
	* @param @throws Exception    参数
	* @return Map<Object,Object>    返回类型
	* @throws
	 */
	public ResultPbcBean getCreditFcioData(ParamerBean bean) throws Exception;
	
	

}
