package cn.com.sinosafe.service.gbcn.impl;

import cn.com.sinosafe.common.util.*;
import cn.com.sinosafe.dao.GbcnClaimMapper;
import cn.com.sinosafe.dao.GbcnInvoiceMapper;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.dao.PolicyModifyRecordMapper;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.PolicyModifyRecord;
import cn.com.sinosafe.domain.gbcn.ResponseBody;
import cn.com.sinosafe.domain.gbcn.claim.ClaimRequest;
import cn.com.sinosafe.domain.gbcn.claim.ClaimRequestBody;
import cn.com.sinosafe.domain.gbcn.correct.*;
import cn.com.sinosafe.domain.gbcn.invoice.InvoiceRequest;
import cn.com.sinosafe.domain.gbcn.invoice.InvoiceRequestBody;
import cn.com.sinosafe.domain.gbcn.surrend.SurrendRequest;
import cn.com.sinosafe.domain.gbcn.surrend.SurrendRequestBody;
import cn.com.sinosafe.service.gbcn.IGbcnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @version 1.0
 * @Description 对接工保网
 * @auther 林良
 * @Date 2019-09-02
 */
@Service
public class GbcnServiceImpl implements IGbcnService {

    private static final Logger logger = LoggerFactory.getLogger(GbcnServiceImpl.class);

    @Autowired
    private GbcnClaimMapper gbcnClaimMapper;

    @Autowired
    private PolicyModifyRecordMapper pmRecordMapper;

    @Autowired
    private LstIqpInfoMapper lstIqpInfoMapper;

    @Autowired
    private GbcnInvoiceMapper invoiceMapper;

    @Autowired
    private DataSource dataSource;

    /**
     * @Description 理赔受理
     * @Date 2019/9/2 10:41
     * @param claimRequest
     * @return cn.com.sinosafe.domain.gbcn.claim.ClaimResponse
     */
    @Override
    @Transactional
    public ResponseBody claimAccept(ClaimRequest claimRequest) {
        //验签
        boolean verify = SignVerifyUtil.verify(
                claimRequest.getRequestHead().getSign(),
                claimRequest.getRequestBody());
        if(!verify){
            return new ResponseBody(DateUtils.getDateTime(),false,"验签失败");
        }

        try {
            //理赔信息入库报表
            ClaimRequestBody requestBody = claimRequest.getRequestBody();
            requestBody.setPkId(claimRequest.getRequestHead().getRequestUUID());
            requestBody.setClaimStatus("0");
            requestBody.setCreateTime(DateUtils.getDateTime());
            //gbcnClaimMapper.insert(requestBody);
            return new ResponseBody(DateUtils.getDateTime(),true,"受理申请");
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseBody(DateUtils.getDateTime(),false,"服务器繁忙");
        }
    }

    /**
     * @Description 批改受理
     * @Date 2019/9/3 15:56
     * @param correctRequest
     * @return cn.com.sinosafe.domain.gbcn.correct.CorrectResponse
     */
    @Override
    @Transactional
    public CorrectResponseBody correctAccept(CorrectRequest correctRequest) {
        //验签
        boolean verify = SignVerifyUtil.verify(
                correctRequest.getRequestHead().getSign(),
                correctRequest.getRequestBody());
        if (!verify) {
            return new CorrectResponseBody(DateUtils.getDateTime(), false,"验签失败");
        }

        CorrectRequestBody requestBody = correctRequest.getRequestBody();
        LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByListSerno(requestBody.getPolicyno());
        if(lstIqpInfo == null){
            return new CorrectResponseBody(DateUtils.getDateTime(), false,"无此保单号，请核验后再试");
        }
        try {
            PolicyModifyRecord record = new PolicyModifyRecord();
            //原保单信息
            record.setCoverSerno(lstIqpInfo.getCoverSerno()); //投保单编号
            record.setListSerno(lstIqpInfo.getListSerno()); //保单编号
            record.setCoverStartDate(lstIqpInfo.getCoverStartDate()); //保险起期
            record.setCoverEndDate(lstIqpInfo.getCoverEndDate()); //保险止期
            record.setCoverAmount(lstIqpInfo.getCoverAmount()); //保额合计（保单金额）
            record.setIqpLoanSerno(lstIqpInfo.getIqpLoanSerno()); //调查流水号
            record.setCoverageFee(lstIqpInfo.getCoverageFee()); //原保费合计
            record.setCoverCreateStatus(lstIqpInfo.getCoverCreateStatus()); //原保单状态
            record.setcAppntOrig(lstIqpInfo.getcAppnt()); //原特别约定
            record.setLstiqpSerno(lstIqpInfo.getSerno()); //信保业务流水号
            record.setCusName(lstIqpInfo.getCusName()); //投保人名称
            record.setCertCode(lstIqpInfo.getCertCode()); //投保人证件号码
            record.setIndivSex(lstIqpInfo.getIndivSex()); //投保人性别
            record.setMobile(lstIqpInfo.getMobile()); //投保人联系电话
            record.setAddress(lstIqpInfo.getAddress()); //投保人地址
            record.setReceiveCusName(lstIqpInfo.getReceiveCusName());//被保险人姓名
            record.setReceiverCusId(lstIqpInfo.getReceiverCusId()); //被保险人编号
            record.setReceiveCusCertCode(lstIqpInfo.getReceiveCusCertCode()); //被保险人证件号码
            record.setReceiveCusPhone(lstIqpInfo.getReceiveCusPhone()); //被保险人联系电话
            record.setReceiveCusCertType(lstIqpInfo.getReceiveCusCertType()); //被保险人证件类型
            record.setReceiverCusAddress(lstIqpInfo.getReceiverCusAddress()); //被保险人地址

            //批改信息
            record.setModfReceiveCusName(requestBody.getCorrectInfo().getInsuredInfo().getName()); //批改后被保险人名称
            record.setModfReceiveCusCertCode(requestBody.getCorrectInfo().getInsuredInfo().getIdNumber()); //批改后被保险人证件号码
            record.setModfReceiveCusPhone(requestBody.getCorrectInfo().getInsuredInfo().getMobile()); //批改后被保险人联系电话
            record.setModfReceiverCusAddress(requestBody.getCorrectInfo().getBaqRequiredInfo().getTendereeAddress()); //批改后被保险人地址
            record.setModfCoverEndDate(requestBody.getCorrectInfo().getDateInfo().getEndDate()); //批改后保险止期
            record.setModType("03"); //批改类型 03批改标的信息
            record.setApproveStatus("997"); //审批状态
            if ("1".equals(requestBody.getIsPtextFlag())) {
                record.setcAppntCurr(requestBody.getEndorseText()); //现特别约定
                lstIqpInfo.setcAppnt(requestBody.getEndorseText());
            }
            //批改信息入库
            //pmRecordMapper.insertSelective(record);

            //更新原保单信息
            Connection connection = dataSource.getConnection();
            lstIqpInfo.setReceiveCusName(requestBody.getCorrectInfo().getInsuredInfo().getName()); //被保险人姓名
            lstIqpInfo.setReceiverCusId(SequenceUtil.getPrjCopNo(connection)); //被保险人编号
            lstIqpInfo.setReceiveCusPhone(requestBody.getCorrectInfo().getInsuredInfo().getMobile()); //被保险人联系电话
            lstIqpInfo.setReceiverCusAddress(requestBody.getCorrectInfo().getBaqRequiredInfo().getTendereeAddress()); //被保险人地址
            lstIqpInfo.setReceiveCusCertCode(requestBody.getCorrectInfo().getInsuredInfo().getIdNumber()); //被保险人证件号码
            lstIqpInfo.setCoverEndDate(requestBody.getCorrectInfo().getDateInfo().getEndDate());
            lstIqpInfoMapper.updateByPrimaryKeySelective(lstIqpInfo);
            return new CorrectResponseBody(DateUtils.getDateTime(), true,"处理成功");
        }catch (Exception e){
            e.printStackTrace();
            return new CorrectResponseBody(DateUtils.getDateTime(), false,"系统繁忙");
        }
    }

    /**
     * @Description 退保受理
     * @Date 2019/9/4 9:35
     * @param surrendRequest
     * @return cn.com.sinosafe.domain.gbcn.surrend.SurrendResponse
     */
    @Override
    @Transactional
    public ResponseBody surrendAccept(SurrendRequest surrendRequest) {
        //验签
        boolean verify = SignVerifyUtil.verify(
                surrendRequest.getRequestHead().getSign(),
                surrendRequest.getRequestBody());
        if (!verify) {
            return new ResponseBody(DateUtils.getDateTime(), false,"验签失败");
        }
        SurrendRequestBody requestBody = surrendRequest.getRequestBody();
        LstIqpInfo lstIqpInfo = lstIqpInfoMapper.selectByListSerno(requestBody.getPolicyno());
        if(lstIqpInfo == null){
            return new ResponseBody(DateUtils.getDateTime(), false,"无此保单号，请核验后再试");
        }
        try {
            //批改入库
            PolicyModifyRecord record = new PolicyModifyRecord();
            record.setCoverSerno(lstIqpInfo.getCoverSerno());
            record.setListSerno(requestBody.getPolicyno());
            record.setContNo(lstIqpInfo.getContNo());
            record.setCoverStartDate(lstIqpInfo.getCoverStartDate());
            record.setCoverEndDate(lstIqpInfo.getCoverEndDate());
            record.setCoverAmount(lstIqpInfo.getCoverAmount());
            record.setIqpLoanSerno(lstIqpInfo.getIqpLoanSerno());
            record.setCoverageFee(lstIqpInfo.getCoverageFee());
            record.setCoverCreateStatus(lstIqpInfo.getCoverCreateStatus());
            record.setcAppntOrig(lstIqpInfo.getcAppnt());
            record.setReceiveCusName(lstIqpInfo.getReceiveCusName());
            record.setReceiverCusId(lstIqpInfo.getReceiverCusId());
            record.setLstiqpSerno(lstIqpInfo.getSerno());
            record.setCusName(lstIqpInfo.getCusName());
            record.setCertCode(lstIqpInfo.getCertCode());
            record.setIndivSex(lstIqpInfo.getIndivSex());
            record.setMobile(lstIqpInfo.getMobile());
            record.setAddress(lstIqpInfo.getAddress());
            record.setReceiveCusCertCode(lstIqpInfo.getReceiveCusCertCode());
            record.setReceiveCusPhone(lstIqpInfo.getReceiveCusPhone());
            record.setReceiveCusCertType(lstIqpInfo.getReceiveCusCertType());
            record.setReceiverCusAddress(lstIqpInfo.getReceiverCusAddress());
            record.setModType("01");
            record.setApproveStatus("000");
            if (StringUtils.isNotEmpty(requestBody.getAccountNo())) {
                record.setAccountName(requestBody.getAccountNo());
                record.setAccountNo(requestBody.getBankNo());
                record.setPayeeBankName(requestBody.getBankName());
            }
            //pmRecordMapper.insertSelective(record);
            return new ResponseBody(DateUtils.getDateTime(), true,"处理成功");
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseBody(DateUtils.getDateTime(), false,"系统繁忙");
        }
    }

    /**
     * @Description 申请发票
     * @Date 2019/9/4 15:35
     * @param invoiceRequest
     * @return cn.com.sinosafe.domain.gbcn.ResponseBody
     */
    @Override
    @Transactional
    public ResponseBody invoiceAccept(InvoiceRequest invoiceRequest) {
        //验签
        boolean verify = SignVerifyUtil.verify(
                invoiceRequest.getRequestHead().getSign(),
                invoiceRequest.getRequestBody());
        if (!verify) {
            return new ResponseBody(DateUtils.getDateTime(), false,"验签失败");
        }
        InvoiceRequestBody requestBody = invoiceRequest.getRequestBody();
        if (!"1".equals(requestBody.getInvoiceType())) {
            return new ResponseBody(DateUtils.getDateTime(), false,"暂只支持电子发票");
        }
        try {
            requestBody.setPkId(invoiceRequest.getRequestHead().getRequestUUID());
            requestBody.setCreateTime(DateUtils.getDateTime());
            requestBody.setInvoiceStatus("0");
            //invoiceMapper.insertSelective(requestBody);
            return new ResponseBody(DateUtils.getDateTime(), true,"处理成功");
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseBody(DateUtils.getDateTime(), false,"系统繁忙");
        }
    }
}
