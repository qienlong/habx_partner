package cn.com.sinosafe.service.xd.impl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import cn.com.sinosafe.common.config.constant.XdConstant;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.SequenceUtil;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.domain.entity.CusBase;
import cn.com.sinosafe.domain.entity.CusIndiv;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.xd.XdFileInfo;
import cn.com.sinosafe.domain.xd.XdLoanInfoRequest;
import cn.com.sinosafe.domain.xd.XdRequest;
import cn.com.sinosafe.domain.xd.XdResponse;
import cn.com.sinosafe.service.xd.XdBaseService;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * 小贷申请进件 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年11月6日<br>
 */
@Service(value = "HAXB0511")
public class HAXB0511 extends XdBaseService{

    @Override
    public String process(XdRequest xdRequest) throws Exception {

        logger.info("------"+xdRequest.getAccid()+" loanApply ---- start -----");
        String serno;
        XdLoanInfoRequest loanInfo = JSONObject.parseObject(xdRequest.getParams(), XdLoanInfoRequest.class);
        if (ObjectUtils.isEmpty(loanInfo)) {
            throw new Exception("申请信息为空");
        }
        loanInfo.setAccid(xdRequest.getAccid());
        loanInfo.setType(xdRequest.getType());
        //参数校验
        Map<String, String> map = checkParam(loanInfo);
        //校验数据是否重复
        if(checkRepeat(loanInfo.getContNO())){
            throw new Exception("合同号【"+ loanInfo.getContNO() + "】重复申请");
        }

        // 校验文件
        List<XdFileInfo> files = loanInfo.getFilePaths();
        if(StringUtils.isEmpty(files)){
            throw new Exception("文件不能为空");
        }else{
            String paramerValue = systemConfig.getValue("WSXD_FIRST_DOM_TYPES");
            String checkResult = getNotFileTypes(paramerValue,files);
            if(StringUtils.isNotEmpty(checkResult)){
                throw new Exception("【"+loanInfo.getContNO()+"】缺少文件类型为【"+checkResult.substring(0,checkResult.lastIndexOf(","))+"】的文件");
            }
        }
        Connection conn = dataSource.getConnection();
        serno = SequenceUtil.getWXSerno(conn);
        if (conn != null) {
            conn.close();
        }
        loanInfo.setSerno(serno);
        // 开户
        openCus(loanInfo);
        // 贷款申请表
        IqpMeLoanApp iqpMeLoanApp = insertIqpMeLoanApp(loanInfo,map);
        // 异步处理
        xdAsynService.loanApply(xdRequest.getParams(),loanInfo,getIqpMeApiCop(),iqpMeLoanApp);
        logger.info("------"+xdRequest.getAccid()+" loanApply ---- end -----");
        return JSONObject.toJSONString(new XdResponse("0000",serno,null));
    }

    private Map<String, String> checkParam(XdLoanInfoRequest loanInfo) throws Exception {
        if(StringUtils.isNotEmpty(loanInfo.getMarryStatus()) && ("20".equals(loanInfo.getMarryStatus()) || "21".equals(loanInfo.getMarryStatus()))){
            if (!"P93YJ05".equals(loanInfo.getAccid())) {//友金的不校验
                //校验必要参数 已婚
                checkDatas(loanInfo, XdConstant.mustCheckFields1);
            }
        }else {
            //浩森不需要填comPhone
        	if(XdConstant.HSPN.equals(getIqpMeApiCop().getCopNo())){
                checkDatas(loanInfo, XdConstant.mustCheckFields3);
        	}else{
                checkDatas(loanInfo, XdConstant.mustCheckFields2);
        	}
        }

        // 身份证大写
        loanInfo.setCertNo(StringUtils.upperCase(loanInfo.getCertNo()));

        //业务类型 05210305-消费贷； 05210304 -经营贷
        String busiType = loanInfo.getBusiType();
        String[] mustCheckFields;
        if (XdConstant.consumerLoan.equals(busiType) || XdConstant.operatingLoan.equals(busiType)) {
            if (XdConstant.operatingLoan.equals(busiType)) {
            	if(XdConstant.HSPN.equals(getIqpMeApiCop().getCopNo())){
            		mustCheckFields = new String[]{"comCertNo","comFld"};//经营贷是必输
            	}else{
            		mustCheckFields = new String[]{"cusType","comCertNo","comFld"};//经营贷是必输
            	}
                checkDatas (loanInfo,mustCheckFields);
                //浩森不传客户类型
                if(!XdConstant.HSPN.equals(getIqpMeApiCop().getCopNo())){
                    mustCheckFields = XdConstant.cusType.split("\\|");
                   if (!Arrays.asList(mustCheckFields).contains(loanInfo.getCusType())) {
                       throw new Exception("客户类型有误！");
                    }
                }
                mustCheckFields = XdConstant.industryCode.split("\\|");
                if (!Arrays.asList(mustCheckFields).contains(loanInfo.getComFld())) {
                    throw new Exception("所属行业编码有误！");
                }
                mustCheckFields = XdConstant.OLLoanUse.split("\\|");
                if (!Arrays.asList(mustCheckFields).contains(loanInfo.getLoanUse())) {
                    throw new Exception("借款用途参数有误！");
                }
            }else {
                mustCheckFields = XdConstant.CLLoanUse.split("\\|");
                if (!Arrays.asList(mustCheckFields).contains(loanInfo.getLoanUse())) {
                    throw new Exception("借款用途参数有误！");
                }
                loanInfo.setCusType("");
            }
        }else {
            throw new Exception("业务类型有误！");
        }

        //查询合作方对应资金方
        Map<String, String> map = getProperties(loanInfo);

        //资金方编号
        String pn= loanInfo.getPartnerNo();
        if (StringUtils.isEmpty(pn)) {
            // 如果资金方没有传，则取默认资金方，然后重新校验
            pn = map.get("PARTNERNO");
        }
        String allowPn = systemConfig.getValue("WSXD_COP_NO");
        mustCheckFields = allowPn.split("\\|");
        if (!Arrays.asList(mustCheckFields).contains(pn)) {
            throw new Exception("合作方类型有误！");
        }else {
            if (XdConstant.SXPN.equals(pn)) {//三湘必输
                mustCheckFields = new String[]{"loanPurpose"};//经营贷是必输
                checkDatas (loanInfo,mustCheckFields);

                loanInfo.setBankNo("323551000015");//固定填写三湘银行行号323551000015
            } else if (XdConstant.MTPN.equals(pn)) {//民泰经营贷必输
                if (XdConstant.operatingLoan.equals(busiType)) {
                    mustCheckFields = new String[]{"industry","industryName"};//经营贷是必输
                    checkDatas (loanInfo,mustCheckFields);
                }
            } else if(XdConstant.CQNSHPN.equals(pn)) {
                // 重庆农商行 accid需更换
                //accid += "_CQNSH";
            }
        }

        //校验教育程度
        mustCheckFields = XdConstant.eduLevel.split("\\|");
        if (!Arrays.asList(mustCheckFields).contains(loanInfo.getEducation())) {
            throw new Exception("教育程度类型有误！");
        }
        //是否受托支付0-否 1-是  系统10自主支付 20受托支付
        String pt = loanInfo.getPayType();
        if (!"0".equals(pt) && !"1".equals(pt)) {
            throw new Exception("受托支付类型有误！");
        } else {
            loanInfo.setPayType("0".equals(pt) ? "10" : "20");
        }
        //0 自建1 自置2 按揭3 亲属楼宇4 集体宿舍5 租房6 共有住宅7 其他9 未知
        if (XdConstant.liveStatus.indexOf(loanInfo.getLiveStatus())==-1) {
            throw new Exception("居住状况类型有误！");
        }

        // 校验地址信息  #-（）& ；.
        String regEx = systemConfig.getValue("WSXD_REG");
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(loanInfo.getRegisterAddress());
        if(!m.matches()) {
            throw new Exception("registerAddress不合法");
        }

        m = p.matcher(loanInfo.getRsdAddress());
        if(!m.matches()) {
            throw new Exception("rsdAddress不合法");
        }
        return map;
    }

    private boolean checkRepeat (String loanBillNo){
        boolean flag = false;
        IqpMeLoanApp iqpMeLoanApp = iqpMeLoanAppMapper.getByAccAgreeNo(loanBillNo);
        if (!ObjectUtils.isEmpty(iqpMeLoanApp)) {
            flag = true;
        }else {
            String contNo = iqpMeLoanAppMapper.getContNoByAccAgreeNo(loanBillNo);
            if (StringUtils.isNotEmpty(contNo)) {
                flag = true;
            }else {
                String loanContNo = partnerBusiImportDetailMapper.selectPartnerContNoByLoanContNo(loanBillNo);
                if (StringUtils.isNotEmpty(loanContNo)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private Map<String, String> getProperties(XdLoanInfoRequest loanInfo) {
        //查询合作方对应资金方
        Map<String, String> map = new HashMap<>();
        map.put("prdId", loanInfo.getBusiType());
        map.put("copNo", getIqpMeApiCop().getCopNo());
        if(StringUtils.isEmpty(loanInfo.getPartnerNo())){
            map = prjCopAccMapper.getByPrdIdAndCopNo(map);
        }else{
            map.put("partnerNo", loanInfo.getPartnerNo());
            map = prjCopAccMapper.getByPrdIdAndCopNoAndPartnerNo(map);
        }
        return map;
    }

    private void openCus(XdLoanInfoRequest loanInfo) throws Exception {
        //判断用户是否开过户
        CusBase exist = cusBaseMapper.queryByCertCode(loanInfo.getCertNo());
        if(ObjectUtils.isEmpty(exist)){
            Connection conn = dataSource.getConnection();
            //客户不存在，开户
            String cusId=SequenceUtil.getCusNo(conn);
            if (conn != null) {
                conn.close();
            }
            logger.info("客户不存在,新cusId={}",cusId);
            loanInfo.setCusId(cusId);

            String cusName = loanInfo.getCusName();
            String certType = "10";
            String certCode = loanInfo.getCertNo();
            String indSex = StringUtils.getSexByCertNo(certCode);
            String birthdayDate = StringUtils.getBirthdayByCertNo(certCode);

            CusBase cusBase = new CusBase();
            cusBase.setCusId(cusId);
            cusBase.setCusName(cusName);
            cusBase.setCertType(certType);
            cusBase.setCertCode(certCode);
            cusBase.setBelongTo("BL_ALL");
            cusBase.setMainBrId(getIqpMeApiCop().getBrId());
            cusBase.setCustMgr(getIqpMeApiCop().getCusMgr());
            cusBaseMapper.insertSelective2(cusBase);

            CusIndiv cusIndiv = new CusIndiv();
            cusIndiv.setCusId(cusId);
            cusIndiv.setCusName(cusName);
            cusIndiv.setCertType(certType);
            cusIndiv.setCertCode(certCode);
            String ct = StringUtils.isEmpty(loanInfo.getCusType())?"110":loanInfo.getCusType();
            cusIndiv.setCusType(ct);
            cusIndiv.setBelongTo("BL_ALL");
            cusIndiv.setIndivSex(indSex);
            cusIndiv.setIndivDtOfBirth(birthdayDate);
            cusIndiv.setCusStatus("20");
            cusIndiv.setInputDate(DateUtils.getDate1());
            cusIndiv.setLastUpdDate(DateUtils.getDate1());
            cusIndiv.setIndivBrtPlace(loanInfo.getRegisterAddress());
            cusIndiv.setIndivMarSt(StringUtils.isEmpty(loanInfo.getSpouseName())?"10":"20");
            cusIndiv.setIndivRsdAddr(loanInfo.getRsdAddress());
            cusIndiv.setMobile(loanInfo.getPhone());
            cusIndiv.setInputId(getIqpMeApiCop().getInputId());
            cusIndiv.setCustMgr(getIqpMeApiCop().getCusMgr());
            cusIndiv.setMainBrId(getIqpMeApiCop().getBrId());
            cusIndiv.setInputBrId(getIqpMeApiCop().getBrId());
            cusIndiv.setComCountry("CDL");
            cusIndiv.setBankCardNo(loanInfo.getCusBankCardNo());
            cusIndiv.setIndivSpsName(loanInfo.getSpouseName());
            cusIndiv.setIndivSpsIdCode(loanInfo.getSpouseCertNo());
            cusIndiv.setIndivSpsPhn(loanInfo.getSpousePhone());
            cusIndiv.setIndivSpsIdTyp(loanInfo.getSpouseCertType());
            cusIndivMapper.insertSelective(cusIndiv);
        }else{
            loanInfo.setCusId(exist.getCusId());
        }
    }

    private IqpMeLoanApp insertIqpMeLoanApp(XdLoanInfoRequest loanInfo,Map<String, String> map) {
        IqpMeLoanApp iqpMeLoanApp = new IqpMeLoanApp();
        iqpMeLoanApp.setSerno(loanInfo.getSerno());
        iqpMeLoanApp.setCusId(loanInfo.getCusId());
        String ct = StringUtils.isEmpty(loanInfo.getCusType())?"110":loanInfo.getCusType();
        iqpMeLoanApp.setCusType(ct);
        iqpMeLoanApp.setCusName(loanInfo.getCusName());
        iqpMeLoanApp.setCertType(loanInfo.getCertType());
        iqpMeLoanApp.setCertCode(loanInfo.getCertNo());
        iqpMeLoanApp.setApplyDate(DateUtils.getDate());
        iqpMeLoanApp.setPhone(loanInfo.getPhone());
        iqpMeLoanApp.setLoanUse(loanInfo.getLoanUse());
        iqpMeLoanApp.setInfoChannel(getIqpMeApiCop().getCopNo());
        iqpMeLoanApp.setInputId(getIqpMeApiCop().getInputId());
        iqpMeLoanApp.setInputName(getIqpMeApiCop().getMgrName());

        iqpMeLoanApp.setRepaymentMode(loanInfo.getRepayModel());
        if("02".equals(loanInfo.getTermType())){
            iqpMeLoanApp.setTerm(new BigDecimal(loanInfo.getTerm()));
        }else if("01".equals(loanInfo.getTermType())){
            iqpMeLoanApp.setTermDay(new BigDecimal(loanInfo.getTerm()));
        }
        iqpMeLoanApp.setTermTimeType(loanInfo.getTermType());
        iqpMeLoanApp.setInputBrId(getIqpMeApiCop().getBrId());
        iqpMeLoanApp.setCusSex(StringUtils.getSexByCertNo(loanInfo.getCertNo()));
        iqpMeLoanApp.setAmount(new BigDecimal(loanInfo.getApplyAmt()));
        //iqpMeLoanApp.setCusType(loanInfo.getCusType());
        iqpMeLoanApp.setPayType(loanInfo.getPayType());

        iqpMeLoanApp.setPrdId(map.get("PRDID"));
        iqpMeLoanApp.setPrdName(map.get("PRDNAME"));
        iqpMeLoanApp.setPartnerNo(map.get("PARTNERNO"));
        iqpMeLoanApp.setPartnerName(map.get("PARTNERNAME"));
        iqpMeLoanApp.setUsingIr(getIqpMeApiCop().getGrossRate());// 利率
        iqpMeLoanApp.setPartnerType(map.get("PARTNERTYPE"));
        iqpMeLoanApp.setPartnerCertCode(map.get("PARTNERCERTCODE"));
        iqpMeLoanApp.setPartnerCertType(map.get("PARTNERCERTTYPE"));

        iqpMeLoanApp.setInputDate(DateUtils.getDate1());
        iqpMeLoanApp.setAppStatus("111");
        iqpMeLoanApp.setApproveStatus("111");
        iqpMeLoanApp.setNewApproveStatus("111");
        iqpMeLoanApp.setIsAutoApprove("1");
        iqpMeLoanApp.setBankCardNo(loanInfo.getCusBankCardNo());
        iqpMeLoanApp.setApplyCurType("CNY");
        iqpMeLoanApp.setIsAssure("2");
        iqpMeLoanApp.setAssureMeansMain("00");
        iqpMeLoanApp.setBizMode("22");
        iqpMeLoanApp.setBelongBrId(getIqpMeApiCop().getBrId());
        iqpMeLoanApp.setMainBrId(getIqpMeApiCop().getBrId());
        iqpMeLoanApp.setCusMgr(getIqpMeApiCop().getCusMgr());
        iqpMeLoanApp.setMainUserId(getIqpMeApiCop().getCusMgr());
        iqpMeLoanApp.setBusinessPersionId(getIqpMeApiCop().getCusMgr());
        iqpMeLoanApp.setBusinessPersionName(getIqpMeApiCop().getMgrName());
        iqpMeLoanApp.setBusinessPersionPhone(getIqpMeApiCop().getMgrPhone());
        iqpMeLoanApp.setAccAgreeNo(loanInfo.getContNO());
        iqpMeLoanApp.setOptType("1");
        iqpMeLoanApp.setIsCancel("2");
        iqpMeLoanApp.setCancelFailCause("00");
        iqpMeLoanApp.setPayWay("1");

        iqpMeLoanApp.setPayeeAccount(loanInfo.getPayeeBankCardNo());
        iqpMeLoanApp.setPayeeAccountName(loanInfo.getPayeeBankCusName());
        iqpMeLoanApp.setRepayAccount(loanInfo.getBankCardNo());
        iqpMeLoanApp.setRepayAccountName(loanInfo.getCusName());
        iqpMeLoanApp.setRepayBank(loanInfo.getBankName());
        iqpMeLoanApp.setBankNo(loanInfo.getBankNo());
        iqpMeLoanApp.setLoanDirection(loanInfo.getIndustry());
        iqpMeLoanApp.setDirectionName(loanInfo.getIndustryName());
        iqpMeLoanApp.setPaymentAccount(loanInfo.getPaymentAccount());

        iqpMeLoanAppMapper.insertSelective(iqpMeLoanApp);
        return iqpMeLoanApp;
    }

}
