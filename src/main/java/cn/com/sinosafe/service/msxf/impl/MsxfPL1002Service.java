package cn.com.sinosafe.service.msxf.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.config.constant.Status;
import cn.com.sinosafe.common.exception.ParamException;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.PartnerBusiImportDetailMapper;
import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.domain.entity.PartnerBusiImportDetail;
import cn.com.sinosafe.domain.msxf.request.Msxf1002Request;
import cn.com.sinosafe.service.msxf.MsxfBaseService;

/**
 * 
 * 马上消费--核保申请结果查询接口 <br>
 * @Author : ex-tangzhenzhen001 <br>
 * @Date : 2019年9月4日<br>
 */
@Service(MsxfConstant.MSXF_PL1002)
public class MsxfPL1002Service extends MsxfBaseService {

    @Autowired
    private PartnerBusiImportDetailMapper partnerBusiImportDetailMapper;

    @Override
    public MsxfResponse busiDeal(String param) throws Exception {
        logger.info(MsxfConstant.MSXF_PL1002 + "=======开始=======" + param);
        MsxfResponse msxfResponse = new MsxfResponse(MsxfResponse.CODE_0000.getRetCode(),MsxfResponse.CODE_0000.getRetMsg());

        // 解密
		String reqStr = decrypt(param);
        //String reqStr = param;
		logger.info("[{}]请求参数解密后：{}",MsxfConstant.MSXF_PL1002, reqStr);
        //请求参数判空
        if (StringUtils.isEmpty(reqStr)) {
            throw new ParamException("请求参数不能为空!");
        }
        //请求参数转换
        Msxf1002Request request = JSON.parseObject(reqStr, Msxf1002Request.class);

        //参数校验
        logger.info("[{}]开始校验必填参数",MsxfConstant.MSXF_PL1002);
        checkRequestParam(request);

        // 外部订单号--借据号
        String billNo = request.getLoanNoExt();

        //根据外部订单号查询渠道业务明细表
        logger.info("[{}][{}]根据外部订单号查询渠道业务明细表",MsxfConstant.MSXF_PL1002, billNo);
        PartnerBusiImportDetail parBusiImpDetail = partnerBusiImportDetailMapper.selectByReqListSerno(billNo);
        
        //返回查询结果
        if (StringUtils.isNull(parBusiImpDetail)){
        	logger.info("[{}][{}]根据外部订单号查询渠道业务明细表为空",MsxfConstant.MSXF_PL1002, billNo);
            msxfResponse = MsxfResponse.CODE_9003;
        }else {
            String apprResult = parBusiImpDetail.getApprResult();
            if (MsxfConstant.PASS.equals(apprResult)){
                 msxfResponse.setStatus(Status.成功.getResponseStatus());
                 msxfResponse.setPreInsuranceNo(parBusiImpDetail.getSerno());
            }else if(MsxfConstant.NO_PASS.equals(apprResult)){
                 msxfResponse.setStatus(Status.失败.getResponseStatus());
                 msxfResponse.setRetMsg(parBusiImpDetail.getNoPassReason());
            }else {
                 msxfResponse.setStatus(Status.处理中.getResponseStatus());
            }
        }
        return msxfResponse;
    }

    /**
     * 参数校验
     * @param request
     * @throws Exception
     */
    private void checkRequestParam(Msxf1002Request request) throws Exception {
        String[] mustCheckFields = new String[]{"bizRequestNo", "loanNoExt"};
        checkDatas(request, mustCheckFields);
    }

}
