package cn.com.sinosafe.service.msxf.impl;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yzj.util.UUID32;
import cn.com.sinosafe.api.CommonService;
import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.exception.ParamException;
import cn.com.sinosafe.common.util.Convert;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.SequenceUtil;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.CusBaseMapper;
import cn.com.sinosafe.dao.CusIndivMapper;
import cn.com.sinosafe.dao.IqpMeLoanAppMapper;
import cn.com.sinosafe.dao.PartnerBusiImportDetailMapper;
import cn.com.sinosafe.dao.PrdBasicinfoMapper;
import cn.com.sinosafe.dao.RuleResultInfoMapper;
import cn.com.sinosafe.domain.bean.MsxfStatus;
import cn.com.sinosafe.domain.dto.MsxfResponse;
import cn.com.sinosafe.domain.entity.CusBase;
import cn.com.sinosafe.domain.entity.CusIndiv;
import cn.com.sinosafe.domain.entity.IqpMeApiCop;
import cn.com.sinosafe.domain.entity.IqpMeLoanApp;
import cn.com.sinosafe.domain.entity.PartnerBusiImportDetail;
import cn.com.sinosafe.domain.entity.PrdBasicinfo;
import cn.com.sinosafe.domain.entity.RuleResultInfo;
import cn.com.sinosafe.domain.msxf.request.BizParams;
import cn.com.sinosafe.domain.msxf.request.Msxf1001Request;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.service.msxf.MsxfBaseService;

/**
 * 
 * 马上消费--核保申请接口 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年9月2日<br>
 */
@Service(MsxfConstant.MSXF_PL1001)
public class MsxfPL1001Service extends MsxfBaseService {

	@Autowired
	private CommonService commonService;
    @Autowired
    private PartnerBusiImportDetailMapper partnerBusiImportDetailMapper;
    @Autowired
    private CusBaseMapper cusBaseMapper;
    @Autowired
    private CusIndivMapper cusIndivMapper;
    @Autowired
    private IqpMeLoanAppMapper iqpMeLoanAppMapper;
    @Autowired
    private PrdBasicinfoMapper prdBasicinfoMapper;
    @Autowired
    private RuleResultInfoMapper ruleResultInfoMapper;


    @Override
    public MsxfResponse busiDeal(String param) throws Exception {
        logger.info(MsxfConstant.MSXF_PL1001 + "=======开始=======" + param);
        MsxfResponse msxfResponse = MsxfResponse.CODE_0000;
        // 解密
        String reqStr = decrypt(param);
        logger.info("[{}]请求参数解密后：{}",MsxfConstant.MSXF_PL1001, reqStr);
        if (StringUtils.isEmpty(reqStr)) {
            logger.info("{}接口请求参数为空", MsxfConstant.MSXF_PL1001);
            throw new ParamException("请求参数不能为空!");
        }
        //请求参数转换
        Msxf1001Request request = JSON.parseObject(reqStr, Msxf1001Request.class);
        //参数校验
        checkRequestParam(request);
        //查询合作方关联表
        iqpMeApiCop = iqpMeApiCopMapper.selectByAccid(MsxfConstant.MSXF);
        //判断外部订单号是否存在
        PartnerBusiImportDetail isExistpartnerBusi = partnerBusiImportDetailMapper.selectByReqListSerno(request.getLoanNoExt());
        if (isExistpartnerBusi == null) {
            //  根据身份证和姓名查询客户基础表  判断客户是否已经开户
            CusBase cusBase = cusBaseMapper.selectCusInfoByNameId(request.getBizParams().getCustName(), request.getBizParams().getIdNo());
            //客户信息不存在
            if (cusBase == null) {
                //业务数据
                BizParams bizParams = request.getBizParams();
                //生成客户编码
                String cusId = cusBaseMapper.createCusId();
                //插入客户基础信息
                cusBase = insertCusBase(bizParams, cusId,iqpMeApiCop);
                //插入客户信息表
                insertCusIndiv(bizParams, cusBase,iqpMeApiCop);
            }
            //插入申请表
            IqpMeLoanApp iqpMeLoanApp = insertIqpMeLoanApp(request, cusBase.getCusId(),iqpMeApiCop);
            // 插入轨迹
            msxfAsynDealService.insertLstOperDetailsStatus(iqpMeLoanApp.getSerno(), MsxfStatus.核保申请, null);
            //插入渠道业务明细表
            PartnerBusiImportDetail detail = insertPartnerDetail(request,iqpMeLoanApp);
            //调用审批规则
    		JSONObject report = rule(iqpMeApiCop,iqpMeLoanApp,request);
    		logger.info("{}调用规则完成，返回结果：{}",iqpMeLoanApp.getSerno(),report.toJSONString());
    		
    		String status = report.getString("rtnCode");
    		setApproveResult(iqpMeLoanApp, detail, report, status);

            //更新iqp_me_loan_app
    		iqpMeLoanAppMapper.updateByPrimaryKeySelective(iqpMeLoanApp);
    		logger.info("{}更新申请表完成",iqpMeLoanApp.getSerno());
    		
    		//partner_busi_import_detail
    		partnerBusiImportDetailMapper.insertSelective(detail);
    		logger.info("{}新增渠道业务明细表完成",iqpMeLoanApp.getSerno());
            
            // 异步处理
            msxfAsynDealService.approve(reqStr,iqpMeLoanApp.getSerno());
        }
        logger.info(MsxfConstant.MSXF_PL1001 + "========结束========" + reqStr);
        return msxfResponse;
    }

    /**
     * 回写审批结果
     * @param iqpMeLoanApp
     * @param detail
     * @param report
     * @param status
     */
	public void setApproveResult(IqpMeLoanApp iqpMeLoanApp, PartnerBusiImportDetail detail, JSONObject report,
			String status) {
        //根据产品编码查询产品信息
        PrdBasicinfo prdBasicinfo = prdBasicinfoMapper.selectByPrdId(iqpMeLoanApp.getPrdId());
        if (prdBasicinfo != null){
            iqpMeLoanApp.setPrdName(prdBasicinfo.getPrdName());
        }
        logger.info("{}产品编号{}，产品名称{}",iqpMeLoanApp.getSerno(),iqpMeLoanApp.getPrdId(),iqpMeLoanApp.getPrdName());

        if ("0000".equals(status)){ //核保成功
			iqpMeLoanApp.setAppStatus(MsxfConstant.PASS);
			iqpMeLoanApp.setApproveStatus(MsxfConstant.PASS);
			iqpMeLoanApp.setNewApproveStatus(MsxfConstant.PASS);
			detail.setApprResult(MsxfConstant.PASS);
			msxfAsynDealService.insertLstOperDetailsStatus(iqpMeLoanApp.getSerno(), MsxfStatus.核保通过, null);
		}else { //核保失败
			iqpMeLoanApp.setAppStatus(MsxfConstant.NO_PASS);
			iqpMeLoanApp.setApproveStatus(MsxfConstant.NO_PASS);
			iqpMeLoanApp.setNewApproveStatus(MsxfConstant.NO_PASS);
			detail.setApprResult(MsxfConstant.NO_PASS);
			// 拒绝原因
			JSONArray jsonArray = report.getJSONArray("errMsg");
			if(StringUtils.isNotEmpty(jsonArray)) {
				detail.setNoPassReason(StringUtils.join(jsonArray, ";"));
			}else {
				detail.setNoPassReason("审批拒绝");
			}
			msxfAsynDealService.insertLstOperDetailsStatus(iqpMeLoanApp.getSerno(), MsxfStatus.核保拒绝, detail.getNoPassReason());
		}
	}
    
    /**
	 * 调用规则
	 * @param iqpMeApiCop
     * @param iqpMeLoanApp 
     * @param request 
	 * @return
	 * @throws Exception
	 */
	private JSONObject rule(IqpMeApiCop iqpMeApiCop, IqpMeLoanApp iqpMeLoanApp, Msxf1001Request request) throws Exception {
		JSONObject report = null;
		if(StringUtils.equals(iqpMeApiCop.getPreRule(), "1") || StringUtils.equals(iqpMeApiCop.getAutoRule(), "1")) {
			// 预审
			if(StringUtils.equals(iqpMeApiCop.getPreRule(), "1")) {
				// 预审
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("serno", iqpMeLoanApp.getSerno());
				map.put("account_name", iqpMeLoanApp.getCusName());
				map.put("id_number", iqpMeLoanApp.getCertCode());
				map.put("account_mobile", iqpMeLoanApp.getPhone());
				// 支付宝则不传
				if(!StringUtils.equals(request.getBizParams().getRcvAcctType(), "4")) {
					map.put("card_number", iqpMeLoanApp.getBankCardNo());
				}
				map.put("busi_resources", iqpMeApiCop.getAccid());
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("paramStr", JSON.toJSONString(map));
				String preParam = JSON.toJSONString(param);
				logger.info("{}预审请求参数：{}",iqpMeLoanApp.getSerno(),preParam);
				JsonProtocol rule = commonService.rule(preParam, "pcPre");
				logger.info("{}预审返回结果：{}",iqpMeLoanApp.getSerno(),JSON.toJSONString(rule));
				if(0 != rule.getCode()) {
					throw new Exception(rule.getMessage());
				}
				String data = Convert.toStr(rule.getData());
				JSONObject jsonObject = JSON.parseObject(data);
				report = JSONObject.parseObject(jsonObject.getString("preReport"));
				insertPreRuleResultInfoBlobData(iqpMeLoanApp.getSerno(),report);
        		logger.info("{}新增RuleResultInfo完成",iqpMeLoanApp.getSerno());
			}
			
			// 终审
			if(StringUtils.equals(iqpMeApiCop.getAutoRule(), "1")) {
				if(!StringUtils.equals(iqpMeApiCop.getPreRule(), "1") || (StringUtils.isNotNull(report) 
						&& ( StringUtils.equals("0000", report.getString("rtnCode")) 
								|| StringUtils.equals("0003", report.getString("rtnCode")) ) )) {
					// 自动审批
					Map<String, Object> param = new HashMap<String, Object>();
					// 规则判断统一按accid
					String prdId = iqpMeLoanApp.getPrdId();
					iqpMeLoanApp.setPrdId(iqpMeApiCop.getAccid());
					param.put("loanInfoJson", JSON.toJSONString(iqpMeLoanApp));
					iqpMeLoanApp.setPrdId(prdId);
					param.put("creditInfoJson", JSON.toJSONString(request.getCreditdata()));
					param.put("cusInfoJson", "{}");
					param.put("guarCreditInfoJson", "{}");
					param.put("otherInfoJson", "{}");
					String autoParam = JSON.toJSONString(param);
					logger.info("{}终审请求参数：{}",iqpMeLoanApp.getSerno(),autoParam);
					JsonProtocol rule = commonService.rule(autoParam, "pcAuto");
					logger.info("{}终审返回结果：{}",iqpMeLoanApp.getSerno(),JSON.toJSONString(rule));
					if(0 != rule.getCode()) {
						throw new Exception(rule.getMessage());
					}
					String data = Convert.toStr(rule.getData());
					JSONObject jsonObject = JSON.parseObject(data);
					report = JSONObject.parseObject(jsonObject.getString("result"));
					insertRuleResultInfoBlobData(iqpMeLoanApp.getSerno(),report);
	        		logger.info("{}新增RuleResultInfo完成",iqpMeLoanApp.getSerno());
				}
			}
			
		}else {
			report = new JSONObject();
			report.put("rtnCode", "0000");
		}
		return report;
	}
	
	/**
	 * 插入规则结果表 
	 * @param kColl
	 * @param report
	 * @param conn
	 * @throws Exception
	 */
	private void insertPreRuleResultInfoBlobData(String serno,JSONObject report) throws Exception {
		// 先删除
		ruleResultInfoMapper.deleteBySernoAndFlag(serno,"02");
		
		RuleResultInfo resultInfo = new RuleResultInfo();
		resultInfo.setPkId(UUID32.getUUID());
		resultInfo.setSerno(serno);
		resultInfo.setRtnCode(report.getString("rtnCode"));
		resultInfo.setErrMsg(JSON.toJSONString(report.get("errMsg")));
		resultInfo.setDetailMsg(JSON.toJSONString(report.get("detailMsg")));
		resultInfo.setPersonMsg(JSON.toJSONString(report.get("personMsg")));
		resultInfo.setOperTime(DateUtils.getDate());
		resultInfo.setFlag("02");
		ruleResultInfoMapper.insertSelective(resultInfo);
	}
	
	private void insertRuleResultInfoBlobData(String serno,JSONObject report) {
		// 先删除
		ruleResultInfoMapper.deleteBySernoAndFlag(serno,null);
		
		// pk_id, serno, rtn_code, loan_amt, err_msg, detail_msg, person_msg, oper_time,pass_Msg,rule_rtn_code,term,rate,RULE_JSON
		RuleResultInfo resultInfo = new RuleResultInfo();
		resultInfo.setPkId(UUID32.getUUID());
		resultInfo.setSerno(serno);
		resultInfo.setRtnCode(report.getString("rtnCode"));
		resultInfo.setLoanAmt(Convert.toBigDecimal(report.get("loanAmt")));
		resultInfo.setErrMsg(JSON.toJSONString(report.get("errMsg")));
		resultInfo.setDetailMsg(JSON.toJSONString(report.get("detailMsg")));
		resultInfo.setPersonMsg(JSON.toJSONString(report.get("personMsg")));
		resultInfo.setOperTime(DateUtils.getDate());
		resultInfo.setPassMsg(JSON.toJSONString(report.get("passMsg")));
		resultInfo.setTerm(Convert.toBigDecimal(report.get("term")));
		resultInfo.setRuleJson(report.toJSONString());
		ruleResultInfoMapper.insertSelective(resultInfo);
	}

    //插入渠道业务明细表
    private PartnerBusiImportDetail insertPartnerDetail(Msxf1001Request request, IqpMeLoanApp iqpMeLoan) throws Exception {
        logger.info("{}插入渠道业务明细表表开始:客户证件号:{}",MsxfConstant.MSXF_PL1001,request.getBizParams().getIdNo());
        PartnerBusiImportDetail detail = new PartnerBusiImportDetail();
        detail.setBatchNo(iqpMeLoan.getSerno()); //批次号
        detail.setSerno(iqpMeLoan.getSerno()); //业务流水号
        detail.setLoanContNo(iqpMeLoan.getAccAgreeNo()); //  借款合同号 取请求参数中的外部订单号?
        detail.setLoanStartDate(DateUtils.getDate("yyyy-MM-dd")); //  借款起期 当前时间
        // 借款止期
        if("02".equals(iqpMeLoan.getTermTimeType())){
            detail.setLoanEndDate(DateUtils.formatDate((DateUtils.addMonths(DateUtils.parseDate(detail.getLoanStartDate()), Convert.toInt(iqpMeLoan.getTerm()))),"yyyy-MM-dd"));
        }else{
           detail.setLoanEndDate(DateUtils.formatDate((DateUtils.addDays(DateUtils.parseDate(detail.getLoanStartDate()), Convert.toInt(iqpMeLoan.getTermDay()))),"yyyy-MM-dd"));
        }
        detail.setApprResult("111"); // 默认为审批中 111
        detail.setAmount(iqpMeLoan.getApplyAmount().toString());  //借款本金
        detail.setCertCode(iqpMeLoan.getCertCode());
        detail.setCusName(iqpMeLoan.getCusName());
        detail.setPhone(iqpMeLoan.getPhone());
        detail.setLoanUse(iqpMeLoan.getLoanUse());
        detail.setLiveAddr(request.getBizParams().getHomeAddress()); //居住地址
        detail.setCertType(iqpMeLoan.getCertType());
        detail.setRepayModel(iqpMeLoan.getRepaymentMode());  //还款方式  RepaymentMode
        detail.setBankCardNo(iqpMeLoan.getRepayAccount()); //
        detail.setTerm(Convert.toStr(iqpMeLoan.getTerm()));
        detail.setReqSeqNo(request.getBizRequestNo()); //渠道进件业务流水号  请求流水号
        detail.setReqListSerno(request.getLoanNoExt()); // 平安保单号 外部订单号
        detail.setAmtLx(Convert.toStr(request.getLoanInterest())); //借款利息
        logger.info("{}插入渠道业务明细表成功:客户证件号:{}",MsxfConstant.MSXF_PL1001,request.getBizParams().getIdNo());
        return detail;
    }


    //申请表信息
    private IqpMeLoanApp insertIqpMeLoanApp(Msxf1001Request request, String cusId,IqpMeApiCop iqpMeApiCop) throws Exception{
        logger.info("{}插入申请表开始:客户证件号:{}",MsxfConstant.MSXF_PL1001,request.getBizParams().getIdNo());
        IqpMeLoanApp iqpMeLoanApp = new IqpMeLoanApp();
        BizParams bizParams = request.getBizParams();
        iqpMeLoanApp.setSerno(SequenceUtil.getWXSerno(dataSource.getConnection())); //业务流水号
        iqpMeLoanApp.setCusId(cusId);//客户编号
        iqpMeLoanApp.setCusType("110"); // 客户类型  默认一般自然人
        iqpMeLoanApp.setCusName(bizParams.getCustName()); //客户姓名
        iqpMeLoanApp.setCertType("10"); //证件类型 默认身份证
        iqpMeLoanApp.setCertCode(bizParams.getIdNo()); //证件号码
        //iqpMeLoanApp.setApplyDate(request.getBizTime()); // 申请日期取请求参数中的业务数据？
        iqpMeLoanApp.setPhone(bizParams.getPhone()); //手机号码
        iqpMeLoanApp.setLoanUse(bizParams.getUseful()); // 贷款用途  按数据字典转换
        iqpMeLoanApp.setInfoChannel(iqpMeApiCop.getCopNo()); // 信息渠道 系统合作方编号
        iqpMeLoanApp.setInputId(iqpMeApiCop.getInputId());  // 待确认 录入人编号 默认录入人
//        iqpMeLoanApp.setInputName(iqpMeApiCop.getMgrName());  // 待确认 录入人姓名 默认客户经理
        iqpMeLoanApp.setRepaymentMode("3");  //还款方式  默认 :等额本息分期还款
        iqpMeLoanApp.setTermTimeType("02"); // 期限类型 月
        iqpMeLoanApp.setTerm(new BigDecimal(bizParams.getTotalInstallmentNo()));  // 期数
        iqpMeLoanApp.setInputBrId(iqpMeApiCop.getBrId()); // 业务归属机构
        iqpMeLoanApp.setCusSex(bizParams.getSex());
        iqpMeLoanApp.setAmount(request.getApplyAmount());//申请金额
        iqpMeLoanApp.setApplyAmount(request.getApplyAmount()); //  建议金额（元）
        iqpMeLoanApp.setPayType("10");  //支付方式 自主支付
        iqpMeLoanApp.setPayWay("10"); // 自主缴费
        iqpMeLoanApp.setSinglePrem("1"); //缴费途径 期缴
        iqpMeLoanApp.setPrdId(request.getProductCode());  // 产品编号
        iqpMeLoanApp.setUsingIr(request.getLoanRate());// 执行利率(年)
        iqpMeLoanApp.setInputDate(DateUtils.getDate("yyyy-MM-dd"));  //录入日期
        iqpMeLoanApp.setAppStatus("111");//审批状态:STD_ZB_APPR_STATUS 000-待发起,111-审批中,991-拿回,992-打回,997-通过,998-否决(不同意)
        iqpMeLoanApp.setApproveStatus("111"); //  审批状态
        iqpMeLoanApp.setNewApproveStatus("111");  //审批状态:STD_ZB_APPR_STATUS 000-待发起,111-审批中,991-拿回,992-打回,997-通过,998-否决(不同意)
        iqpMeLoanApp.setIsAutoApprove("1"); //是否自动审批
        iqpMeLoanApp.setBankCardNo(bizParams.getDepAcctNbr());  //银行卡号  放款入账账号
        iqpMeLoanApp.setApplyCurType("CY"); //申请币种
        iqpMeLoanApp.setIsAssure("2"); //是否联保
        iqpMeLoanApp.setAssureMeansMain("00");//主担保方式
        iqpMeLoanApp.setBizMode("27");//业务模式
        iqpMeLoanApp.setBelongBrId(iqpMeApiCop.getBrId());//  业务归属机构 默认业务机构
        iqpMeLoanApp.setMainBrId(iqpMeApiCop.getBrId()); // 业务受理机构 默认业务机构
        iqpMeLoanApp.setCusMgr(iqpMeApiCop.getCusMgr()); // 客户经理 默认客户经理编号
        iqpMeLoanApp.setMainUserId(iqpMeApiCop.getCusMgr());  // 主办人编号 默认客户经理编号
        iqpMeLoanApp.setBusinessPersionId(iqpMeApiCop.getCusMgr()); // todo 业务人员编号 默认客户经理编号
        iqpMeLoanApp.setBusinessPersionName(iqpMeApiCop.getMgrName()); //todo 业务人员名称 默认客户经理
        iqpMeLoanApp.setBusinessPersionPhone(iqpMeApiCop.getMgrPhone());//todo 业务人员电话 默认客户经理手机号
        iqpMeLoanApp.setAccAgreeNo(request.getLoanNoCtr()); //  2019.10.24值更改
        iqpMeLoanApp.setoContNo(request.getLoanNoExt()); //  原合同编号取请求参数中的外部订单号？
        iqpMeLoanApp.setOptType("1"); //操作标识:STD_IQP_OPT_TYPE 1-新增,2-补录
        iqpMeLoanApp.setIsCancel("2"); //是否已注销:STD_ZX_YES_NO 1-是 2-否
        iqpMeLoanApp.setCancelFailCause("00"); //注销失败原因
        iqpMeLoanApp.setPayeeAccount(bizParams.getDepAcctNbr());   // 收款人账户号  放款入账账号
        iqpMeLoanApp.setPayeeAccountName(bizParams.getRcvAcctName());  // 收款人账户名  放款入账账号账户名称
        iqpMeLoanApp.setRepayAccount(bizParams.getWthAcctNbr());  //还款人账户号
        iqpMeLoanApp.setRepayAccountName(bizParams.getPayAcctName());  // 还款人账户名 2019.10.24值更改
        //iqpMeLoanApp.setRepayBank(bizParams.getPayAcctName());  // 还款人开户行  2019.10.24 删除
        iqpMeLoanApp.setPayeeBank(bizParams.getDepBankName()); //收款人开户行 2019.10.24 新加
        // iqpMeLoanApp.setValidResult("0000".equals(ruleResult.get("rtnCode"))?"000":null); // 预审结果
        //iqpMeLoanApp.setBankNo(loanInfo.getBankNo()); //联行号 字典STD_BANK_NO
        //iqpMeLoanApp.setLoanDirection(loanInfo.getIndustry());  //贷款投向
        //iqpMeLoanApp.setDirectionName(loanInfo.getIndustryName()); //贷款投向说明
        //iqpMeLoanApp.setPaymentAccount(loanInfo.getPaymentAccount());  //缴费帐户
        iqpMeLoanAppMapper.insertSelective(iqpMeLoanApp);
        logger.info("{}插入申请表成功:客户证件号:{}",MsxfConstant.MSXF_PL1001,request.getBizParams().getIdNo());
        return iqpMeLoanApp;
    }

    //客户信息
    private CusIndiv insertCusIndiv(BizParams bizParams, CusBase cusBase,IqpMeApiCop iqpMeApiCop) throws Exception{
        logger.info("{}插入客户信息CusIndiv开始:客户证件号:{}",MsxfConstant.MSXF_PL1001,bizParams.getIdNo());
        CusIndiv cusIndiv = new CusIndiv();
        cusIndiv.setCusId(cusBase.getCusId());//客戶编号
        cusIndiv.setCusName(cusBase.getCusName());//客户姓名
        cusIndiv.setCertType(cusBase.getCertType());//证件类型
        cusIndiv.setCertCode(cusBase.getCertCode());//证件号码
        cusIndiv.setCusType(cusBase.getCusType());//客户类型  默认为 一般自然人
        cusIndiv.setPhone(bizParams.getPhone());//家庭电话
        cusIndiv.setMobile(bizParams.getPhone());//手机号码
        cusIndiv.setIndivIdExpDt(bizParams.getDueDate());//证件到期日
        cusIndiv.setComCountry("CDL");//国别 见字典码（国籍）
        cusIndiv.setIndivSex(bizParams.getSex()); //性别 见字典码（性别）
        cusIndiv.setIndivRsdAddr(bizParams.getHomeAddress()); //居住地址
        cusIndiv.setIndivOcc(OccTypeMap.get(bizParams.getOccupation()));//职业 见字典码（职业）
        cusIndiv.setBelongTo(cusBase.getBelongTo());  //业务条线归属 BL_ALL
        cusIndiv.setIndivDtOfBirth(getBirthdayByCertNo(cusBase.getCertCode()));
        cusIndiv.setCusStatus("20");  //状态
        cusIndiv.setInputDate(DateUtils.getDate("yyyy-MM-dd")); //登记日期
        cusIndiv.setLastUpdDate(DateUtils.getDate("yyyy-MM-dd")); //更新日期
        cusIndiv.setIndivBrtPlace(bizParams.getHomeAddress()); //户籍地址
        cusIndiv.setIndivMarSt("26"); // 婚姻状况 默认其他
        cusIndiv.setInputId(iqpMeApiCop.getInputId()); //登记人
        cusIndiv.setCustMgr(iqpMeApiCop.getCusMgr()); //主管客户经理
        cusIndiv.setMainBrId(iqpMeApiCop.getBrId()); //主管机构
        cusIndiv.setInputBrId(iqpMeApiCop.getBrId()); //登记机构
        cusIndiv.setBankCardNo(bizParams.getDepAcctNbr()); //银行卡号  放款入账账号
        //插入客户信息表
        cusIndivMapper.insertSelective(cusIndiv);
        logger.info("{}插入客户信息CusIndiv成功:客户证件号:{}",MsxfConstant.MSXF_PL1001,bizParams.getIdNo());
        return cusIndiv;
    }

    /**
     * 根据身份证获取生日
     * @param certNo
     * @return
     */
    public String getBirthdayByCertNo(String certNo) {
        String birthdayYear = certNo.substring(6, 10);
        String birthdayMonth = certNo.substring(10, 12);
        String birthdayDay = certNo.substring(12, 14);
        return birthdayYear + "-" + birthdayMonth + "-" + birthdayDay;
    }

    //客户基础信息
    private CusBase insertCusBase(BizParams bizParams, String cusId,IqpMeApiCop iqpMeApiCop) throws Exception{
        logger.info("{}插入客户基础信息开始:客户证件号:{}",MsxfConstant.MSXF_PL1001,bizParams.getIdNo());
        CusBase cusBase = new CusBase();
        cusBase.setCusId(cusId);//客户编码
        cusBase.setCusType("110");// 客户类型  默认:一般自然人
        cusBase.setCusName(bizParams.getCustName());//客户姓名
        cusBase.setCertType("10");// 证件类型  默认:身份证
        cusBase.setCertCode(bizParams.getIdNo());//证件号码
        cusBase.setBelongTo("BL_ALL");//客户归属条线
        cusBase.setMainBrId(iqpMeApiCop.getBrId());//主管机构
        cusBase.setCustMgr(iqpMeApiCop.getCusMgr());//客户经理
        //插入客户基础表
        cusBaseMapper.insertSelective(cusBase);
        logger.info("{}插入客户基础信息成功:客户证件号:{}",MsxfConstant.MSXF_PL1001,bizParams.getIdNo());
        return cusBase;
    }

     //参数校验
    private void checkRequestParam(Msxf1001Request request) throws Exception {
        //判断证件类型
        if (!"120001".equals(request.getBizParams().getIdType())){
            throw new ParamException("客户证件类型必须为身份证");
        }
        // 业务参数
        BizParams bizParams = request.getBizParams();
        String[] mustCheckFields = new String[]{"bizRequestNo", "loanNoExt", "loanNoCtr", "channelCode", "productCode", "applyAmount", "loanRate", "loanInterest", "bizTime"};
        checkDatas(request, mustCheckFields);
        mustCheckFields = new String[]{"useful", "repaymentMode", "totalInstallmentNo", "depAcctNbr", "rcvAcctType", "rcvAcctName", "depBankName", "wthAcctNbr", "payAcctName", "payAcctType", "custName", "idType", "idNo", "dueDate", "nationality", "sex", "homeAddress", "phone", "occupation"};
        checkDatas(bizParams, mustCheckFields);
    }
}
