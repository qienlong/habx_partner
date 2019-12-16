package cn.com.sinosafe.service.gbcn.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.GBCNConstant;
import cn.com.sinosafe.common.util.XmlUtil;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.gbcn.request.ClaimRequest;
import cn.com.sinosafe.domain.gbcn.request.ClaimRequest.ClaimRequestBody;
import cn.com.sinosafe.domain.gbcn.response.BaseResponse.ResponseBody;
import cn.com.sinosafe.domain.gbcn.response.GBResponse;
import cn.com.sinosafe.domain.gbcn.response.GBResponse.ClaimResponse;
import cn.com.sinosafe.lina.common.utils.UUIDUtils;
import cn.com.sinosafe.service.gbcn.CommonService;
import cn.com.sinosafe.service.gbcn.GbcnService;

@Service(value = GBCNConstant.CLAIMl_REQUEST)
public class ClaimRequestService extends CommonService implements GbcnService<ResponseBody,String>{

    private static final Logger logger = LoggerFactory.getLogger(ClaimRequestService.class);

    public GBResponse<ClaimResponse> getResultObj(){
        return ClaimResponse.getInstance();
    }
    
	public ResponseBody process(String param) {
        ClaimRequest claimRequest = (ClaimRequest) XmlUtil.xml2Object(param, ClaimRequest.class);
        try {
            //理赔信息入库报表
        	LstIqpInfo lstiqpInfo = lstIqpInfoMapper.selectByListSerno(claimRequest.getRequestBody().getPolicyno());
        	if(ObjectUtils.isEmpty(lstiqpInfo)){
                return new ResponseBody(DateUtils.getDateTime(),false,"保单号有误");
        	}
            ClaimRequestBody requestBody = claimRequest.getRequestBody();
            requestBody.setPkId(UUIDUtils.generate());
            requestBody.setClaimStatus("0");
            requestBody.setCreateTime(DateUtils.getDateTime());
            gbcnClaimMapper.insert(requestBody);
            return new ResponseBody(DateUtils.getDateTime(),true,"受理申请");
        }catch (Exception e){
            e.printStackTrace();
            logger.info("理赔申请失败--->"+e.getMessage());
            return new ResponseBody(DateUtils.getDateTime(),false,"服务器繁忙");
        }
	}

}
