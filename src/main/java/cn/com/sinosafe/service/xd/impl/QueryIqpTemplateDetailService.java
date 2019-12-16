package cn.com.sinosafe.service.xd.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.MoneyUtil;
import cn.com.sinosafe.dao.FeeRateMapper;
import cn.com.sinosafe.dao.IqpMeLoanAppMapper;
import cn.com.sinosafe.dao.QueryIqpTemplateDetailMapper;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.service.xd.XdService;

import com.alibaba.fastjson.JSONObject;

@Service("queryIqpTemplateDetail")
public class QueryIqpTemplateDetailService implements XdService<String,JSONObject>{
	
    private final static Logger logger = LoggerFactory.getLogger(XdPostLoanUpload4Hmyh.class);
	
	@Autowired
	private IqpMeLoanAppMapper iqpMeLoanAppMapper;
	
    @Autowired
	private QueryIqpTemplateDetailMapper queryIqpTemplateDetailMapper;
    
    @Autowired
	private  FeeRateMapper feeRateMapper;
	
	//从json中取出serno
	public  String process(JSONObject json) throws Exception{
	//	JSONObject jsonObj = new JSONObject((Map<String, Object>) json.get("json")) ;
		String serno = json.getString("serno");
	    List<HashMap<String,Object>> list = queryIqpTemplateDetailMapper.queryIqpTemplateDetailMapper(serno);
	    JSONObject resultJson = null;
	    for(HashMap<String,Object> map :list){
    		HashMap<String,Object> resultMap = new HashMap<String, Object>();
	    	 for (String key : map.keySet()) { 
				 String newKey = key.toLowerCase(); 
				 resultMap.put(newKey, map.get(key)); 
            }
	    	if(!resultMap.containsKey("var17")){
	    		 resultMap.put("var17","趸交");// 
	    	}
	    	resultJson = JSONObject.parseObject(JSONObject.toJSONString(resultMap), JSONObject.class);
	    }
	    //查询iqpmeloadapp
	    if(resultJson!=null){
	    	IqpMeLoanApp iqpMeLoanApp = iqpMeLoanAppMapper.selectByPrimaryKey(serno);
	    	//个月
	    	if("PRJ20190506088134".equals(iqpMeLoanApp.getInfoChannel())){
	    		//月份不为0
	    	    if(!ObjectUtils.isEmpty(iqpMeLoanApp.getTerm())&&new BigDecimal(0).compareTo(iqpMeLoanApp.getTerm())!=0){
	    	    	resultJson.put("var12", iqpMeLoanApp.getTerm()+"个月");
	    	    	resultJson.put("var30", iqpMeLoanApp.getTerm()+"个月");
	    	    }
	    	    //天不为0
                if(!ObjectUtils.isEmpty(iqpMeLoanApp.getTermDay())&&new BigDecimal(0).compareTo(iqpMeLoanApp.getTermDay())!=0){
	    	    	resultJson.put("var12",iqpMeLoanApp.getTermDay()+"天");
	    	    	resultJson.put("var30", iqpMeLoanApp.getTermDay()+"天");
	    	    }   
                
                String loan_use_nme = feeRateMapper.getCnnameByEnname(iqpMeLoanApp.getLoanUse());
                
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("term", iqpMeLoanApp.getTerm());
                map.put("term_day", iqpMeLoanApp.getTermDay());
                map.put("cost_rate", iqpMeLoanApp.getCostRate());
                map.put("amount", iqpMeLoanApp.getAmount());
                map.put("repayment_mode", iqpMeLoanApp.getRepaymentMode());
                map.put("using_ir", iqpMeLoanApp.getUsingIr());
                map.put("ransom_type", iqpMeLoanApp.getRansomType());
                map.put("prd_id", iqpMeLoanApp.getPrdId());
                map.put("accessory_risk", iqpMeLoanApp.getAccessoryRisk());

    				// 计算保额，保费
    				double approve_amount = getSlInsureAmount(map);
    				BigDecimal costRate = (BigDecimal) map.get("cost_rate");
    				if (costRate == null || costRate.compareTo(new BigDecimal(0)) <= 0) {
    					throw new Exception("申请信息中没有保存费率");
    				}
    				BigDecimal coverFee = costRate.multiply(new BigDecimal(approve_amount)).setScale(2,
    						BigDecimal.ROUND_HALF_UP);
    				// map1.put("", String.valueOf(approve_amount));
    				String fee = MoneyUtil.toChinese(String.valueOf(coverFee));
    				resultJson.put("var15", "人民币（大写）" + fee + "  ￥" + String.valueOf(coverFee));// 覆盖默认保费
    				resultJson.put("var16", String.valueOf(costRate.setScale(4, BigDecimal.ROUND_HALF_UP)));// 覆盖保险费率
//    				String c_appnt = String.valueOf(map.get("var30"));
//    				if (c_appnt != null) {
//    					// 替换特别约定中的期限
//    					if ("".equals(String.valueOf(map.get("term"))) || "0".equals(String.valueOf(map.get("term")))) {
//    						c_appnt = c_appnt.replace("#term#", String.valueOf(map.get("term_day")) + "日");
//    					} else {
//    						c_appnt = c_appnt.replace("#term#", String.valueOf(map.get("term")) + "个月");
//    					}
//    					/*
//    					 * if (c_appnt.indexOf("#excuse_rate#")!=-1) { c_appnt =
//    					 * c_appnt.replace("#excuse_rate#", "0"); }
//    					 */
//    				}
//    				resultJson.put("var30", c_appnt);// 覆盖特别约定
    			

	    	}
	    }
	    JSONObject result = new JSONObject();
	    if(resultJson!=null){
		    result.put("RESULT", resultJson);
		    result.put("REQUESTTIME", DateUtils.getDate());
		    result.put("STATUS", "0");
		    result.put("ERRORMESSAGE", "成功"); 	
	    }else{
		    result.put("REQUESTTIME", DateUtils.getDate());
		    result.put("STATUS", "1");
		    result.put("ERRORMESSAGE", "根据申请信息获取投保单所需信息为空！"); 	
	    }
	    logger.info("queryIqpTemplateDetail出参:"+JSONObject.toJSONString(result));
		return JSONObject.toJSONString(result);
	}
	
	
	private double getSlInsureAmount(Map map) {
		double cover_amount = 0;
		try {
			BigDecimal loanAmtB = (BigDecimal) map.get("amount");
			String loanAmt = loanAmtB == null ? "0" : String.valueOf(loanAmtB);
			// 批准还款方式
			String approve_repaymode = (String) map.get("repayment_mode");
			// 贷款金额
			// String approve_amount = (String)
			// keyedCollectionIqpMeLoanApp.getDataValue("approve_amount");
			// 批准利率
			BigDecimal approve_rateB = (BigDecimal) map.get("using_ir");
			String approve_rate = approve_rateB == null ? "0" : String.valueOf(approve_rateB);
			BigDecimal approve_termB = (BigDecimal) map.get("term");
			String approve_term = approve_termB == null ? "0" : String.valueOf(approve_termB);
			BigDecimal approve_term_dayB = (BigDecimal) map.get("term_day");
			String approve_term_day = approve_term_dayB == null ? "0" : String.valueOf(approve_term_dayB);
			// 赎楼方式
			String ransom_type = (String) map.get("ransom_type");

			String prd_id = (String) map.get("prd_id");
			// 是否承保附加险
			String accessory_risk = (String) map.get("accessory_risk");

			loanAmt = (loanAmt == null || "".equals(loanAmt)) ? "0" : loanAmt;
			approve_term = (approve_term == null || "".equals(approve_term)) ? "0" : approve_term;
			approve_term_day = (approve_term_day == null || "".equals(approve_term_day)) ? "0" : approve_term_day;

			String cover_start_date = DateUtils.getDate1();
			String end_date = DateUtils.getRelativeDate(DateUtils.getCtDate(cover_start_date, "yyyy-MM-dd"),
					0, new BigDecimal(approve_term).intValue(),
					new BigDecimal(approve_term_day).intValue(), "yyyy-MM-dd");// 保险止期

			if (ransom_type != null && ("02".equals(ransom_type) || "03".equals(ransom_type))) {
				cover_amount = Double.parseDouble(loanAmt) * 1.05;
			} else if ("05140301".equals(prd_id)) {
				cover_amount = (Double.parseDouble(loanAmt) + compute_interest(approve_repaymode,
						Double.parseDouble(loanAmt), Double.parseDouble(approve_rate), cover_start_date, end_date,
						Integer.parseInt(approve_term))) * 1.05;
			} else {
				if (accessory_risk != null && accessory_risk.equals("1")) {
					cover_amount = (Double.parseDouble(loanAmt) + compute_interest(approve_repaymode,
							Double.parseDouble(loanAmt), Double.parseDouble(approve_rate), cover_start_date, end_date,
							Integer.parseInt(approve_term))) * 1.05;
				} else {
					cover_amount = Double.parseDouble(loanAmt) + compute_interest(approve_repaymode,
							Double.parseDouble(loanAmt), Double.parseDouble(approve_rate), cover_start_date, end_date,
							Integer.parseInt(approve_term));
				}
			}
		} catch (Exception e) {
			cover_amount = 0;
		}
		return cover_amount;
	}

	
	public double compute_interest(String payType, double capital, double year_rate, String start_date, String end_date,
			int term_month) throws ParseException {
		double interest = -1;

		if (payType.equals("3")) {
			// 按月等额本息，利息=本金×月利率×期限月×（1+月利率）^期限月/(（1+月利率）^期限月-1)
			interest = capital * year_rate / 12 * term_month * Math.pow(1 + year_rate / 12, term_month)
					/ (Math.pow(1 + year_rate / 12, term_month) - 1) - capital;
			// interest = new BigDecimal(capital*year_rate/12*term_month).multiply(new
			// BigDecimal(Math.pow(1+year_rate/12, term_month))).divide(new
			// BigDecimal(Math.pow(1+year_rate/12, term_month-1)),2).doubleValue();

		} else {
			// 一次性还本付息、按月付息一次性还本、按月付息+部分本，到期还本,利息=本金×日利率×期限天
			interest = capital * year_rate / 360 * getIntervalDays(start_date, end_date);
			// interest = new BigDecimal(capital).multiply(new
			// BigDecimal(year_rate/360)).doubleValue()*getIntervalDays(start_date,end_date);
		}

		return new BigDecimal(interest).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public int getIntervalDays(String fDate, String oDate) throws ParseException {

		if (null == fDate || null == oDate) {
			return -1;
		}

		long intervalMilli = new SimpleDateFormat("yyyy-MM-dd").parse(oDate).getTime()
				- new SimpleDateFormat("yyyy-MM-dd").parse(fDate).getTime();
		return (int) (intervalMilli / (24 * 60 * 60 * 1000));
	}

}
