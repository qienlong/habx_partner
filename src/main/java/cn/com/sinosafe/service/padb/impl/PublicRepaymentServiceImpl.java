/**
 * projectName: haxb_partner
 * fileName: PublicRepaymentServiceImpl.java
 * packageName: cn.com.sinosafe.service.padb.impl
 * date: 2019-09-05 9:45
 * copyright(c) 2019-  华安保险公司
 */
package cn.com.sinosafe.service.padb.impl;

import cn.com.sinosafe.common.config.constant.LstIqpApplyConstant;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.dao.PublicRepaymentMapper;
import cn.com.sinosafe.domain.bean.PaResultCode;
import cn.com.sinosafe.domain.bean.PaResultGenerator;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.PublicRepayment;
import cn.com.sinosafe.service.padb.PaPhService;
import com.alibaba.fastjson.JSON;
import com.yzj.util.UUID32;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version: v1.0
 * @author: xiehanchun
 * @className: PublicRepaymentServiceImpl
 * @packageName: cn.com.sinosafe.service.padb.impl
 * @description: 对公还款存入通知接口
 * @data: 2019-09-05 9:45
 **/
@Service("FCFPBX6001")
public class PublicRepaymentServiceImpl implements PaPhService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PublicRepaymentMapper publicRepaymentMapper;
    @Autowired
    private AsyncDealService asyncDealService;
    @Autowired
    private LstIqpInfoMapper lstIqpInfoMapper;

    @Override
    public String service(Map<String, Object> paramMap){
        logger.info("*****************************公还款存入通知 start*****************************");
        logger.info("param:{}",paramMap);
        String resultCode = "";
        Map<String, String> resultMap=new HashMap<String, String>();

            //校验字段
            if (LstIqpApplyConstant.checkFieldDefect(paramMap, new String[]{"batchNo","batchCount","insuCompany","claimsApplyList"})) {
                resultCode = PaResultCode.PA_FIELD_DELETION.code();
                resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FIELD_DEL_MESSAGE);
            } else if(LstIqpApplyConstant.checkListFieldDefectByStr("claimsApplyList",paramMap,new String[]{"serNo","policyNo","applNo","custName","reBurAmt","reBurDate","reBurFromName"})){
                resultCode = PaResultCode.PA_FIELD_DELETION.code();
                resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FIELD_DEL_MESSAGE);
            }else{
                try{
                    List<PublicRepayment> publicRepaymentList = new ArrayList<>();
                    List<Map<String,Object>> claimsApplyList= (List<Map<String, Object>>) paramMap.get("claimsApplyList");
                    for (Map<String, Object> map : claimsApplyList) {
                        LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByApplNoAndListSerno(map.get("applNo").toString(), map.get("policyNo").toString());
                        if(StringUtils.isNull(lstIqpInfo)){
                            logger.info("申请号："+map.get("applNo").toString()+"和保单号："+ map.get("policyNo").toString()+"------->不存在");
                            resultCode = PaResultCode.PA_FAIL.code();
                            resultMap.put("resultMsg", PaResultGenerator.DEFAULT_FAIL_MESSAGE);
                        }else {
                            PublicRepayment publicRepayment = buildPublicRepayment(map);
                            publicRepayment.setBatchNo(paramMap.get("batchNo").toString()); //批次号
                            publicRepayment.setInsuCompany(paramMap.get("insuCompany").toString()); //保险公司合作方
                            publicRepayment.setBatchCount(paramMap.get("batchCount").toString()); //借据总笔数
                            publicRepaymentList.add(publicRepayment);
                        }
                    }
                    if(StringUtils.isNotEmpty(publicRepaymentList)){
                        //入对公还款的明细表
                        publicRepaymentMapper.insertPublicRepayment(publicRepaymentList);
                        resultCode = PaResultCode.PA_SUCCESS.code();
                        resultMap.put("resultMsg", PaResultGenerator.DEFAULT_SUCCESS_MESSAGE);
                    }
               }catch (Exception e){
                   logger.error("errorInfo:"+e.getMessage());
                   throw new BusinessException(e.getMessage());
               }
            }

        resultMap.put("resultCode",String.valueOf(resultCode));
        String resultMsg = JSON.toJSONString(resultMap);
        //平安调用接口日志记录
        insertBizLog(paramMap,resultMsg);
        logger.info("*****************************公还款存入通知 end*****************************");
        return resultMsg;
    }

    private PublicRepayment buildPublicRepayment(Map<String, Object> map) {
        PublicRepayment publicRepayment = new PublicRepayment();
        publicRepayment.setId(UUID32.getUUID()); //主键

        publicRepayment.setApplNo(map.get("applNo").toString());
        publicRepayment.setCustName(map.get("custName").toString());
        publicRepayment.setSerNo(map.get("serNo").toString());
        publicRepayment.setPolicyNo(map.get("policyNo").toString());
        publicRepayment.setReBurAmt(map.get("reBurAmt").toString());
        publicRepayment.setReBurDate(map.get("reBurDate").toString());
        publicRepayment.setReBurFromName(map.get("reBurFromName").toString());
        publicRepayment.setReBurStatus("1"); // 1 未处理
        publicRepayment.setNoticeResult("00"); //00 未通知
        return publicRepayment;
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
            asyncDealService.insertBizLog((String)paramMap.get("applNo"), "FCFPBX6001", paramMap, resultMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
