/**
 * 
 */
package cn.com.sinosafe.service.padb.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import cn.com.sinosafe.api.CommonService;
import cn.com.sinosafe.common.util.JSONUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.dao.PaIndCrtRepayPlanMapper;
import cn.com.sinosafe.dao.SentStatusMapper;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.PaIndCrtRepayPlan;
import cn.com.sinosafe.domain.entity.SentStatus;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.service.padb.PaFeeBatchOutService;

/**  
* <p>Title: paFeeBatchOutServiceImpl</p>  
* <p>Description: 独立承保批减保费</p>  
* @author longxiaoqiang  
* @date 2019年11月13日  
*/
@Service
public class paFeeBatchOutServiceImpl implements PaFeeBatchOutService {

	Logger logger = LoggerFactory.getLogger(paFeeBatchOutServiceImpl.class);
	@Autowired
	PaIndCrtRepayPlanMapper paIndCrtRepayPlanMapper;
	@Autowired
	LstIqpInfoMapper lstIqpInfoMapper;
	@Autowired
	private CommonService commonService;
	@Autowired
	private SentStatusMapper sentStatusMapper;
	@Override
	public String feeBatchOut() {
		
		try {
			logger.info("==============独立承保批减保费退保start===============");
			//1、获取待批减保费的数据
			List<PaIndCrtRepayPlan> paIndCrtRepayPlanList = paIndCrtRepayPlanMapper.getBatchOutData();
			logger.info("结清状态的数据为：{}", JSONUtils.getSingleInstance().toJSon(paIndCrtRepayPlanList));
			
			//2、筛选核心批减保费已实收的数据
			//List<PaIndCrtRepayPlan> needBatchOut = getNeedBatchOutData(paIndCrtRepayPlanList);
			//logger.info("筛选后的数据为：{}", JSONUtils.getSingleInstance().toJSon(needBatchOut));
			
			//3、将数据分组（提前结清、代偿结清）及组装参数
			if (!StringUtils.isEmpty(paIndCrtRepayPlanList)) {
				
				List<JSONObject> sendData = slipData(paIndCrtRepayPlanList);
				logger.info("数据组装参数后：{}",JSONUtils.getSingleInstance().toJSon(sendData));
				
				//4、发送批减
				for (JSONObject jsonObject : sendData) {
					try {
						logger.info("独立承保批减退保请求参数：{}",jsonObject.toJSONString());
						JsonProtocol protocol = commonService.policySurrender(jsonObject);
						logger.info("独立承保批减退保返回结果：{}",JSON.toJSON(protocol));
						
						if (0 != protocol.getCode()) {
							throw new Exception(protocol.getMessage());
						} else {
							JSONObject jsonObject2 = JSONObject.parseObject(JSON.toJSONString(protocol));
							String status = (String)JSONPath.eval(jsonObject2, "$.data.status");
							String errorMessage = (String)JSONPath.eval(jsonObject2, "$.data.errorMessage");
							String policyNo = (String)JSONPath.eval(jsonObject2, "$.data.policyNo");
							if ("0".equals(status)) {
								//5、记录已批减数据PAPH_BATCH_OUT
								insertSendStatus(jsonObject);
							} else {
								logger.info("保单号：{}退保失败原因为：{}",policyNo,errorMessage);
							}
						}
					} catch (Exception e) {
						logger.error("PaIndBatchOutServiceImpl平安独立承保批减保费失败！",e);
						continue;
					}
				}
			} else {
				logger.info("独立承保没有需要批减退保的数据");
			}
			logger.info("==============独立承保批减保费退保end===============");
		} catch (Exception e) {
			logger.error("PaIndBatchOutServiceImpl平安独立承保批减保费失败！",e);
		}
		
		return "";
	}

	/**  
	 * <p>Title: insertSendStatus</p>  
	 * <p>Description: </p>  
	 * @param jsonObject  
	 */
	private void insertSendStatus(JSONObject jsonObject) {
		
		String lstInfo = (String)JSONPath.eval(jsonObject, "$.policyNo");
		LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByListSerno(lstInfo);
		
		SentStatus ss = new SentStatus();
		ss.setSentType("PAPH_BATCH_OUT");
		ss.setSentSerno(lstIqpInfo.getIqpLoanSerno());
		ss.setSentStatus("01");
		sentStatusMapper.insertSelective(ss);
		
	}

	/**  
	 * <p>Title: getNeedBatchOutData</p>  
	 * <p>Description: 判断收付系统的实收和信保的是否一致，如一致则加入待批减集合</p>  
	 * @param paIndCrtRepayPlanList
	 * @return  
	 * @throws Exception 
	 */
	private List<PaIndCrtRepayPlan> getNeedBatchOutData(List<PaIndCrtRepayPlan> paIndCrtRepayPlanList) throws Exception {
		
		List<PaIndCrtRepayPlan> list = new ArrayList<PaIndCrtRepayPlan>();
		if (!StringUtils.isEmpty(paIndCrtRepayPlanList)) {
			for (PaIndCrtRepayPlan paIndCrtRepayPlan : paIndCrtRepayPlanList) {
				try {
					//当前保单信保实收金额
					BigDecimal xbAmt = paIndCrtRepayPlanMapper.getXbTotalAmt(paIndCrtRepayPlan.getApplNo());
					if (xbAmt==null||(xbAmt.compareTo(new BigDecimal(0))!=1)) {
						throw new Exception(paIndCrtRepayPlan.getApplNo()+"信保结清的保费实收金额为0");
					}
					//当前保单收付实收金额
					BigDecimal sfAmt = paIndCrtRepayPlanMapper.getSfTotalAmt(paIndCrtRepayPlan.getApplNo());
					if (sfAmt==null||(sfAmt.compareTo(new BigDecimal(0))!=1)) {
						throw new Exception(paIndCrtRepayPlan.getApplNo()+"收付结清的保费实收金额为0");
					}
					if (xbAmt.compareTo(sfAmt)==0) {
						list.add(paIndCrtRepayPlan);
					}
				} catch (Exception e) {
					logger.error(e.getMessage(),e);
				}
			}
		}
		return list;
	}

	/**  
	 * <p>Title: slipData</p>  
	 * <p>Description: 获取发送退保数据</p>  
	 * @param paIndCrtRepayPlanList
	 * @return  
	 */
	private List<JSONObject> slipData(List<PaIndCrtRepayPlan> paIndCrtRepayPlanList) {
		
		List<JSONObject> list = new ArrayList<JSONObject>();
		
		for (PaIndCrtRepayPlan paIndCrtRepayPlan:paIndCrtRepayPlanList) {
			try {
				JSONObject jsonObject = new JSONObject();
				if ("05".equals(paIndCrtRepayPlan.getStatus())) {
					jsonObject = getSendDataByOver(paIndCrtRepayPlan);
				} else if ("09".equals(paIndCrtRepayPlan.getStatus())) {
					jsonObject = getSendDataByPay(paIndCrtRepayPlan);
				}
				list.add(jsonObject);
			} catch (Exception e) {
				logger.error(paIndCrtRepayPlan.getApplNo()+"PaIndBatchOutServiceImpl组装数据失败！",e);
				continue;
			}
		}
		return list;
	}

	/**  
	 * <p>Title: getSendDataByPay</p>  
	 * <p>Description: 获取代偿结清退保数据</p>  
	 * @return  
	 */
	private JSONObject getSendDataByPay(PaIndCrtRepayPlan paIndCrtRepayPlan) {
		
		//应收减实收
		BigDecimal xbAmt = paIndCrtRepayPlanMapper.getXbTotalAmt(paIndCrtRepayPlan.getApplNo());
		BigDecimal sfAmt = paIndCrtRepayPlanMapper.getSfTotalAmt(paIndCrtRepayPlan.getApplNo());
		LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByIqpLoanSerno2(paIndCrtRepayPlan.getApplNo());
		//BigDecimal surrenderNo =  lstIqpInfoMapper.selectSurrenderNo(lstIqpInfo.getSerno());
		String maxPerno = paIndCrtRepayPlanMapper.getMaxPerdNo(paIndCrtRepayPlan.getApplNo());
		String minPerno = paIndCrtRepayPlanMapper.getMinPerno(lstIqpInfo.getSerno());
		
		//当结清的期次应还等于实还的时候开始逾期期次为改期次加一
		if ((xbAmt.compareTo(new BigDecimal(0)))==0) {
			int mp = Integer.valueOf(maxPerno);
			maxPerno = String.valueOf(mp+1);
			minPerno = String.valueOf(mp+1);
		}
		
		JSONObject jsonReq = new JSONObject();
		jsonReq.put("surrenderType", "4"); // 3-提前还款,(信保平安共保使用）
		jsonReq.put("cmisFlag", "1");//1-独保 2-共保
		jsonReq.put("sumGrossPremium", sfAmt);// 总保险费(退保后)
		jsonReq.put("requestType", "1");// 请求类型: 0 表示还没有批改保费计算，保费计算由服务器负责； 1 表示已保费计算
		jsonReq.put("policyNo", lstIqpInfo.getListSerno());
		jsonReq.put("surrenderNo", maxPerno);//逾期买断时必传（买断期数）
		jsonReq.put("overdueNo", minPerno);//开始逾期期次
		jsonReq.put("overdueAmount", xbAmt);//总逾期金额

		//因为是必传的而独立承保又是按期收费的故不存在保费退费收款账户，因此就取华安在华夏银行开立的账户
		JSONObject bankInfo = new JSONObject();
		bankInfo.put("accountName","华安财产保险股份有限公司");//帐户名称
		bankInfo.put("accountNo","10856000000296788"); //银行账号
		bankInfo.put("payeeBankCityCode","5840");//开户银行省市代码
		bankInfo.put("payeeBankCity","广东省_深圳市");//开户银行省市
		bankInfo.put("payeeBankCode","304");//收款方银行编码
		bankInfo.put("payeeBankName","华夏银行");//收款方银行名称
		bankInfo.put("bankCode","304584040839");//开户银行名称代码
		bankInfo.put("bankBranchName","华夏银行股份有限公司深圳深南支行");//收款人开户银行名称
		jsonReq.put("bankInfo",bankInfo);
		
		return jsonReq;
	}

	/**  
	 * <p>Title: getSendDataByOver</p>  
	 * <p>Description: 获取提前结清退保数据</p>  
	 * @return  
	 */
	private JSONObject getSendDataByOver(PaIndCrtRepayPlan paIndCrtRepayPlan) {
		
		BigDecimal xbAmt = paIndCrtRepayPlanMapper.getXbTotalAmt(paIndCrtRepayPlan.getApplNo());
		BigDecimal sfAmt = paIndCrtRepayPlanMapper.getSfTotalAmt(paIndCrtRepayPlan.getApplNo());
		LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByIqpLoanSerno2(paIndCrtRepayPlan.getApplNo());
		String maxPerno = paIndCrtRepayPlanMapper.getMaxPerdNo(paIndCrtRepayPlan.getApplNo());
		//String minPerno = paIndCrtRepayPlanMapper.getMinPerno(lstIqpInfo.getSerno());

		JSONObject jsonReq = new JSONObject();
		jsonReq.put("surrenderType", "3"); // 3-提前还款,(信保平安共保使用）
		jsonReq.put("cmisFlag", "1");//1-独保 2-共保
		jsonReq.put("sumGrossPremium", sfAmt);// 总保险费(退保后)
		jsonReq.put("requestType", "1");// 请求类型: 0 表示还没有批改保费计算，保费计算由服务器负责； 1 表示已保费计算
		jsonReq.put("policyNo", lstIqpInfo.getListSerno());
		jsonReq.put("surrenderNo", maxPerno);//逾期买断时必传（买断期数）
		//jsonReq.put("overdueNo", minPerno);//开始逾期期次
		//jsonReq.put("overdueAmount", xbAmt);//总逾期金额

		//因为是必传的而独立承保又是按期收费的故不存在保费退费收款账户，因此就取华安在华夏银行开立的账户
		JSONObject bankInfo = new JSONObject();
		bankInfo.put("accountName","华安财产保险股份有限公司");//帐户名称
		bankInfo.put("accountNo","10856000000296788"); //银行账号
		bankInfo.put("payeeBankCityCode","5840");//开户银行省市代码
		bankInfo.put("payeeBankCity","广东省_深圳市");//开户银行省市
		bankInfo.put("payeeBankCode","304");//收款方银行编码
		bankInfo.put("payeeBankName","华夏银行");//收款方银行名称
		bankInfo.put("bankCode","304584040839");//开户银行名称代码
		bankInfo.put("bankBranchName","华夏银行股份有限公司深圳深南支行");//收款人开户银行名称
		jsonReq.put("bankInfo",bankInfo);
		
		return jsonReq;
	}

}
