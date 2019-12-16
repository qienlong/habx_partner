package cn.com.sinosafe.service.gbcn.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.GBCNConstant;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.common.util.XmlUtil;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.PolicyModifyRecord;
import cn.com.sinosafe.domain.gbcn.request.SurrendRequest;
import cn.com.sinosafe.domain.gbcn.request.SurrendRequest.SurrendRequestBody;
import cn.com.sinosafe.domain.gbcn.response.BaseResponse.ResponseBody;
import cn.com.sinosafe.domain.gbcn.response.GBResponse;
import cn.com.sinosafe.domain.gbcn.response.GBResponse.SurrendResponse;
import cn.com.sinosafe.lina.common.utils.UUIDUtils;
import cn.com.sinosafe.service.gbcn.CommonService;
import cn.com.sinosafe.service.gbcn.GbcnService;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;

@Service(value = GBCNConstant.SURREND_REQUEST)
public class SurrendRequestService extends CommonService implements GbcnService<ResponseBody,String>{

    private static final Logger logger = LoggerFactory.getLogger(SurrendRequestService.class);

    public GBResponse<SurrendResponse> getResultObj(){
        return SurrendResponse.getInstance();
    }
    
    @Transactional
	public ResponseBody process(String param) throws Exception {
    	SurrendRequest surrendRequest = (SurrendRequest) XmlUtil.xml2Object(param, SurrendRequest.class);
    	SurrendRequestBody requestBody = surrendRequest.getRequestBody();
        LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByListSerno(requestBody.getPolicyno());
        if(lstIqpInfo == null){
            return new ResponseBody(DateUtils.getDateTime(), false,"无此保单号，请核验后再试");
        }
        SurrendRequestBody requestBody2 = surrendMapper.queryHasSendByPolicyNo(requestBody.getPolicyno());
        if (!ObjectUtils.isEmpty(requestBody2)) {
            return new ResponseBody(DateUtils.getDateTime(), false,"该保单已退保");
        }
        try {
            //退保申请表
            requestBody.setPkId(UUIDUtils.generate());
            requestBody.setCreateTime(DateUtils.getDateTime());
            requestBody.setSurrendStatus("0");
            surrendMapper.insertSelective(requestBody);
            //退保批改入库
            PolicyModifyRecord record = new PolicyModifyRecord();
            oldPolicyModify(lstIqpInfo,record);
            record.setModType("01");
            record.setApproveStatus("000");
            record.setModfDate(DateUtils.getDate1());
            record.setSurrendReason(requestBody.getPolicyReason());
            record.setModfCoverageFee(new BigDecimal("0"));
            record.setCoverageFeeDiff(lstIqpInfo.getCoverageFee().subtract(record.getModfCoverageFee()));
            if (StringUtils.isNotEmpty(requestBody.getAccountNo())) {
                record.setAccountName(requestBody.getAccountNo());
                record.setAccountNo(requestBody.getBankNo());
                record.setPayeeBankName(requestBody.getBankName());
            }
            pmRecordMapper.insertSelective(record);
            return new ResponseBody(DateUtils.getDateTime(), true,"处理成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.info("退保申请失败--->"+e.getMessage());
            return new ResponseBody(DateUtils.getDateTime(), false,"系统繁忙");
        }
	}
}
