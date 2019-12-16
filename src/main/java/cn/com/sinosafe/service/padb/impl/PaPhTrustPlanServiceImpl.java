/**
 * projectName: haxb_partner
 * fileName: PaPhTrustPlanServiceImpl.java
 * packageName: cn.com.sinosafe.service.padb.impl
 * date: 2019-09-02 10:50
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.service.padb.impl;

import cn.com.sinosafe.common.config.constant.LstIqpApplyConstant;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.PaPhTrustPlanMapper;
import cn.com.sinosafe.dao.PrjCopAccMapper;
import cn.com.sinosafe.domain.bean.PaResultCode;
import cn.com.sinosafe.domain.bean.PaResultGenerator;
import cn.com.sinosafe.domain.entity.PrjCopAcc;
import cn.com.sinosafe.domain.entity.PrjCopTrustPlan;
import cn.com.sinosafe.service.padb.PaPhService;
import cn.com.sinosafe.service.padb.PaPhTrustPlanService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: PaPhTrustPlanServiceImpl
 * @packageName: cn.com.sinosafe.service.padb.impl
 * @description: 信托计划信息同步
 * @data: 2019-09-02 10:50
 **/
@Service("FCFPBX9001")
public class PaPhTrustPlanServiceImpl implements PaPhService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private PrjCopAccMapper prjCopAccMapper;
    @Autowired
    private PaPhTrustPlanMapper paPhTrustPlanMapper;
    @Autowired
    private AsyncDealService asyncDealService;
    
    @Override
    public String service(Map<String, Object> paramMap){
        logger.info("*****************************信托计划信息同步 start*****************************");
        logger.info("param:{}",paramMap);
        String resultCode = "";
        Map<String, String> resultMap=new HashMap<String, String>();
        try {
            //校验字段
            if (LstIqpApplyConstant.checkFieldDefect(paramMap, new String[]{"trustName", "funderID", "funderName", "settleAtBankName", "settleBankName", "settleAcountName", "settleAcountNo", "insuCompany"})) {
                resultCode = PaResultCode.PA_FIELD_DELETION.code();
                resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FIELD_DEL_MESSAGE);
            } else {
                PrjCopAcc prjCopAcc = prjCopAccMapper.selectByCopCusName(String.valueOf(paramMap.get("trustName")));
                if(StringUtils.isNotNull(prjCopAcc)){
                    PrjCopTrustPlan prjCopTrustPlan = getPrjCopTrustPlan(paramMap,prjCopAcc.getCopNo());
                    paPhTrustPlanMapper.mergePrjCopTrustPlan(prjCopTrustPlan);
                    resultCode = PaResultCode.PA_SUCCESS.code();
                    resultMap.put("resultMsg", PaResultGenerator.DEFAULT_SUCCESS_MESSAGE);
                }else{
                    logger.info("合作额度台账表中没有对应的合作方------->"+String.valueOf(paramMap.get("trustName")));
                    resultCode = PaResultCode.PA_FAIL.code();
                    resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FAIL_MESSAGE);
                }
            }
        }catch (Exception e){
            logger.error("errorInfo:"+e.getMessage());
            throw new BusinessException(e.getMessage());
        }
        resultMap.put("resultCode",String.valueOf(resultCode));
        String resultMsg=JSON.toJSONString(resultMap);
        //平安调用接口日志记录
        insertBizLog(paramMap,resultMsg);
        logger.info("*****************************信托计划信息同步 end*****************************");
        return JSON.toJSONString(resultMap);
    }

    private PrjCopTrustPlan getPrjCopTrustPlan(Map<String, Object> paramMap,String copNo) {
        PrjCopTrustPlan prjCopTrustPlan = new PrjCopTrustPlan();
        prjCopTrustPlan.setPkId("LOP"+DateUtils.getDateStr());
        prjCopTrustPlan.setCopNo(copNo);
        prjCopTrustPlan.setFunderId(String.valueOf(paramMap.get("funderID")));
        prjCopTrustPlan.setPlanName(String.valueOf(paramMap.get("funderName")));
        prjCopTrustPlan.setSettleAcountName(String.valueOf(paramMap.get("settleAcountName")));
        prjCopTrustPlan.setSettleAtBankName(String.valueOf(paramMap.get("settleAtBankName")));
        prjCopTrustPlan.setSettleBankName(String.valueOf(paramMap.get("settleBankName")));
        prjCopTrustPlan.setSettleAcountNo(String.valueOf(paramMap.get("settleAcountNo")));
        prjCopTrustPlan.setInsuCompany(String.valueOf(paramMap.get("insuCompany")));
        prjCopTrustPlan.setOperDate(DateUtils.getDate1());
        prjCopTrustPlan.setOperTime(DateUtils.getTime());//settleBankCityCode settleBankCity settleBankCode
        prjCopTrustPlan.setSettleAtBankCode("");
        prjCopTrustPlan.setSettleBankCityCode("");
        prjCopTrustPlan.setSettleBankCity("");
        prjCopTrustPlan.setSettleBankCode("");
        return prjCopTrustPlan;
    }

    /**
     *
     * @Title：insertBizLog
     * @Description：异步日志记录
     * @param ：@param paramMap
     * @return ：void
     * @throws
     */
    public void insertBizLog(Map<String, Object> paramMap,String resultMsg){
        try {
            asyncDealService.insertBizLog((String)paramMap.get("trustName"), "FCFPBX9001", paramMap, resultMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
