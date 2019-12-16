package cn.com.sinosafe.service.gbcn;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.exception.BusinessException;
import cn.com.sinosafe.common.util.AmountUtil;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.GBCNConstant;
import cn.com.sinosafe.common.util.GbcnDutyEnum;
import cn.com.sinosafe.common.util.IpAddressUtils;
import cn.com.sinosafe.common.util.Leaf;
import cn.com.sinosafe.common.util.Md5Util;
import cn.com.sinosafe.common.util.RedisUtils;
import cn.com.sinosafe.common.util.XmlUtil;
import cn.com.sinosafe.common.util.httpclient.HttpClientUtil;
import cn.com.sinosafe.dao.CusBaseMapper;
import cn.com.sinosafe.dao.CusComMapper;
import cn.com.sinosafe.dao.GbcnClaimMapper;
import cn.com.sinosafe.dao.GbcnInvoiceMapper;
import cn.com.sinosafe.dao.GbcnSurrendMapper;
import cn.com.sinosafe.dao.IqpMeApiCopMapper;
import cn.com.sinosafe.dao.IqpMeCusComAppMapper;
import cn.com.sinosafe.dao.IqpMeInsuranceInfoMapper;
import cn.com.sinosafe.dao.IqpMeInsuredMapper;
import cn.com.sinosafe.dao.IqpMeLoanAppMapper;
import cn.com.sinosafe.dao.IqpMePrjCopDao;
import cn.com.sinosafe.dao.IqpMeProjectInfoMapper;
import cn.com.sinosafe.dao.LstIqpInfoMapper;
import cn.com.sinosafe.dao.PolicyModifyRecordMapper;
import cn.com.sinosafe.dao.SOrgMapper;
import cn.com.sinosafe.dao.TElecPolicyInfoMapper;
import cn.com.sinosafe.domain.entity.IqpMeProjectInfo;
import cn.com.sinosafe.domain.entity.LstIqpInfo;
import cn.com.sinosafe.domain.entity.PolicyModifyRecord;
import cn.com.sinosafe.domain.entity.SOrg;
import cn.com.sinosafe.lina.shortdomain.dubbo.service.ShortDomainDubboService;
import cn.com.sinosafe.lina.shortdomain.model.ShortDomain;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.sinosafe.service.cmis.HaXbCmisAppApiServiceV2;

import dub.provider.outsys.facade.InfOutSystemService;

public abstract class CommonService{
	
    private static final Logger logger = LoggerFactory.getLogger(CommonService.class);

    @Autowired
    protected GbcnClaimMapper gbcnClaimMapper;

    @Autowired
    protected PolicyModifyRecordMapper pmRecordMapper;
    
//    public static GbcnProperties gbcnProperties;
   // @Autowired
   // protected GbcnProperties gbcnProperties = new GbcnProperties();

    @Autowired
    protected LstIqpInfoMapper lstIqpInfoMapper;
    
    @Autowired
    protected IqpMeInsuredMapper iqpMeInsuredMapper;
    
    @Autowired
    protected IqpMePrjCopDao iqpMePrjCopDao;

    @Autowired
    protected GbcnInvoiceMapper invoiceMapper;

    @Autowired
    protected GbcnSurrendMapper surrendMapper;

    @Autowired
    protected DataSource dataSource;

    @Autowired
    protected CusBaseMapper cusBaseMapper;

    @Autowired
    protected  CusComMapper cusComMapper;

    @Autowired
    protected IqpMeLoanAppMapper iqpMeLoanAppMapper;

    @Autowired
    protected IqpMeCusComAppMapper iqpMeCusComAppMapper;

    @Autowired
    protected IqpMeProjectInfoMapper iqpMeProjectInfoMapper;
    
    @Autowired
    protected IqpMeInsuranceInfoMapper  iqpMeInsuranceInfoMapper;
    
    @Autowired
    protected IqpMeApiCopMapper iqpMeApiCopMapper;

    @Autowired
    protected SOrgMapper orgMapper;

    @Autowired
    protected RedisUtils redisUtils;

    @Reference(retries = 3, timeout = 60000, check = false)
    protected HaXbCmisAppApiServiceV2 haXbCmisAppApiService;

    @Reference(retries = 3, timeout = 60000, check = false)
    protected InfOutSystemService infOutSystemService;
    // 设置调用超时时间
    @Reference( timeout = 60000)
    protected ShortDomainDubboService shortDomainDubboService;
    
    @Autowired
    protected TElecPolicyInfoMapper tElecPolicyInfoMapper;
    
    @Autowired
    protected PolicyModifyRecordMapper recordMapper;
    
    @Value("${info.build.name}")
    protected String SYSTEM_NAME;
    
    /**
     * @Description 原保单信息
     * @Date 2019/9/6 17:45
     * @param lstIqpInfo
     * @param record
     * @return void
     */
    public void oldPolicyModify(LstIqpInfo lstIqpInfo, PolicyModifyRecord record) {
       /*     
        record.setCoverSerno(lstIqpInfo.getCoverSerno()); //投保单编号
        record.setListSerno(lstIqpInfo.getListSerno()); //保单编号
        record.setCoverStartDate(lstIqpInfo.getCoverStartDate()); //保险起期
        record.setCoverEndDate(lstIqpInfo.getCoverEndDate()); //保险止期
        record.setCoverAmount(lstIqpInfo.getCoverAmount()); //保额合计（保单金额）
        record.setIqpLoanSerno(lstIqpInfo.getIqpLoanSerno()); //调查流水号
        record.setCoverageFee(lstIqpInfo.getCoverageFee()); //原保费合计
        record.setCoverCreateStatus(lstIqpInfo.getCoverCreateStatus()); //原保单状态
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
        record.setBelongBrId(lstIqpInfo.getBelongBrId()); //保单业务归属机构
        record.setPrdId(lstIqpInfo.getPrdId());
        record.setPrdName(lstIqpInfo.getPrdName());
        */
    	
        try {
			BeanUtils.copyProperties(record,lstIqpInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
        record.setcAppntOrig(lstIqpInfo.getcAppnt()); //原特别约定
        record.setLstiqpSerno(lstIqpInfo.getSerno()); //信保业务流水号
        record.setApplyUserId(lstIqpInfo.getCusId()); //申请人-投保人客户编号
        record.setApplyDate(DateUtils.getDate1()); //申请时间
    }
    
    
    /**
     * 发送电子保单签章
     * @param lstIqpInfo
     * @throws Exception
     */
    public void sendSeal(LstIqpInfo lstIqpInfo,String callBackUrl,String tender) throws Exception{
		   JSONObject obj = new JSONObject();
	        obj.put("serno",lstIqpInfo.getSerno()); //业务流水号
	        obj.put("listSerno",lstIqpInfo.getListSerno()); //保单号
	        obj.put("configId",SystemConfig.cacheMap.get("GBCN_BD_SEAL")); //签章配置ID
	        obj.put("insType",GBCNConstant.POLICY_NAME); //合同名
	        obj.put("projectType","gcbd"); //电子保单id
	        obj.put("cusName",lstIqpInfo.getCusName()); //投保人
	        obj.put("certCode",lstIqpInfo.getCertCode()); //投保人身份号码
	        obj.put("receiveCusName",lstIqpInfo.getReceiveCusName() ); //被保险人
	        obj.put("receiveCertCode",lstIqpInfo.getReceiveCusCertCode()); //被保险人社会统一号
	        IqpMeProjectInfo projectInfo = iqpMeProjectInfoMapper.selectByIqpSerno(lstIqpInfo.getIqpLoanSerno());
	        obj.put("projectName",projectInfo.getProjectSubject()); //项目名称
	        obj.put("insuranceDuty",GbcnDutyEnum.getValueByKey(lstIqpInfo.getInsuranceType())); //保险责任
	        obj.put("coverAmount",lstIqpInfo.getCoverAmount()); //保险金额
	        obj.put("rate",lstIqpInfo.getRate()); //费率
	        obj.put("amountBig",AmountUtil.convert(lstIqpInfo.getCoverageFee().toString())); //保费大写
	        obj.put("amount",lstIqpInfo.getCoverageFee()); //保费
	        obj.put("excuseRate",lstIqpInfo.getExcuseRate()+"%"); //免赔率
	        if(StringUtils.isEmpty(tender)){
	            tender = "自"+DateUtils.format2(lstIqpInfo.getCoverStartDate(),"yyyy-MM-dd")+"零时起，至"
                        +DateUtils.format2(lstIqpInfo.getCoverEndDate(),"yyyy-MM-dd")+"23:59:59止";	
	        }
	        obj.put("tender",tender); //保险期限
	        obj.put("appnt",lstIqpInfo.getcAppnt());//特别约定 lstIqpInfo.getcAppnt()
	        SOrg sOrg = orgMapper.selectByPrimaryKey(lstIqpInfo.getBelongBrId());
	        obj.put("branchCom",sOrg.getOrganname()); //分公司
	        obj.put("time",DateUtils.format(new Date(), "yyyy年 MM月 dd日")); //签章日期
	        obj.put("comAddress",sOrg.getAddress()); //分公司地址
	        obj.put("phone",sOrg.getTelnum()); //分公司电话
	        obj.put("inputName",lstIqpInfoMapper.getInputNameById(lstIqpInfo.getInputId())); //制单-录入人
	        obj.put("mgrName",lstIqpInfoMapper.getInputNameById(lstIqpInfo.getMgrId())); //经办-客户经理
	        obj.put("resultCallBackUrl", callBackUrl);
	        logger.info("电子保单发送数据--->"+obj.toJSONString());
	        String result = HttpClientUtil.httpPost(SystemConfig.cacheMap.get("GBCN_SEAL_URL")+"/executeSeal", obj.toJSONString());
	        logger.info("电子保单返回数据--->"+result);
	}


    /**
     * @Description 电子保函签章
     * @Date 2019/9/19 9:23
     * @param lstIqpInfo
     * @param insurePdfUrl
     * @return void
     */
    public JSONObject sealAssure(LstIqpInfo lstIqpInfo, String insurePdfUrl,String resultCallBackUrl, 
    		String  projectName,boolean isCorrect) throws Exception {
        //获取工保保函
        JSONObject obj = new JSONObject();
        obj.put("serno",lstIqpInfo.getSerno()); //业务流水号
        obj.put("listSerno",lstIqpInfo.getListSerno()); //保单号
        obj.put("projectType","gcbh"); //工程保函名称
        obj.put("configId", SystemConfig.cacheMap.get("GBCN_BH_SEAL")); //签章配置ID
        obj.put("cusName",lstIqpInfo.getCusName()); //投保人
        obj.put("receiveCusName",lstIqpInfo.getReceiveCusName()); //被保险人
        if(isCorrect){
        	Date startDate = DateUtils.strToDate("yyyy-MM-dd",lstIqpInfo.getCoverStartDate());
        	obj.put("year",DateUtils.format(startDate, "yyyy")); //开标日期-年
            obj.put("month",DateUtils.format(startDate, "MM")); //开标日期-日
            obj.put("day",DateUtils.format(startDate, "dd")); //开标日期-日
        }else {
        	obj.put("year","*"); //开标日期-年
            obj.put("month","*"); //开标日期-日
            obj.put("day","*"); //开标日期-日
		}
        obj.put("projectName",projectName); //项目
        obj.put("coverAmount",lstIqpInfo.getCoverAmount()); //保险金额
        obj.put("rate",lstIqpInfo.getRate()); //费率
        //保留两位小数
	    String amount = String.format("%.2f", lstIqpInfo.getCoverAmount());  
        obj.put("amount",amount); //保费
        obj.put("amountBig", AmountUtil.convert(amount)); //保费
        obj.put("elecUrl",insurePdfUrl); //保单地址
        SOrg org = orgMapper.selectByPrimaryKey(SystemConfig.cacheMap.get("GBCN_PT_ORG"));
        obj.put("legalPer",org.getOrganchief()); //法定代表人
        obj.put("address",org.getAddress()); //地址
        obj.put("postalCode",org.getPostcode()); //邮编
        obj.put("phone",org.getTelnum()); //电话
        obj.put("organName",org.getOrganname()); //保险人名称
        obj.put("fax",org.getTelnum()); //传真
        obj.put("rYear", DateUtils.getYear()); //当前时间-年
        obj.put("rMonth",DateUtils.getMonth()); //当前时间-月
        obj.put("rDay",DateUtils.getDay()); //当前时间-日
        obj.put("resultCallBackUrl", resultCallBackUrl); //保函签章回调地址
        //两个章
        logger.info("保函电子签章发送数据--->"+obj.toJSONString());
        String result = HttpClientUtil.httpPost(SystemConfig.cacheMap.get("GBCN_SEAL_URL")+"/executeSeal", obj.toJSONString());
        logger.info("保函电子签章返回数据--->"+result);
        return JSONObject.parseObject(result);
    }

    /**
     * @Description 短链接
     * @Date 2019/9/19 9:13
     * @param elecUrl
     * @return java.lang.String
     */
    public String getQueryUrl(String elecUrl) {
        ShortDomain sdRe = new ShortDomain();
        sdRe.setRealDomain(elecUrl);
        sdRe.setCreateSystem(SYSTEM_NAME);
        ShortDomain sdRs = shortDomainDubboService.obtainShortDomain(sdRe);
        return sdRs.getShortDomain();
    }
    
    protected Map<String, String> getInputInfo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		String ip = IpAddressUtils.getIpAddr(request);
		StringBuffer url = request.getRequestURL();
		map.put("ip", ip);
		map.put("url", url.toString());
		return map;
	}

	protected void doAuth(String requestXml) throws Exception {
		Element element = XmlUtil.str2Dom(requestXml);
	    List<Leaf> elemList = new ArrayList<>();
	    XmlUtil.getElementList(element, elemList);
	    String sign = "";
	    StringBuffer md5 = new StringBuffer();
	    for (Leaf e:elemList) {
	    	switch (e.getXattribute()) {
			   case "requestUUID":
				break;
			   case "sign":
				sign = e.getValue();
				break;
			   default:
				md5.append(e.getValue());
				break;
			}
		}
	    //验签
	    //参数非空校验
		String sign1 = Md5Util.hash(md5.append(SystemConfig.cacheMap.get("GBCN_SIGN_KEY")).toString());
	    if(!sign.equalsIgnoreCase(sign1)){
	    	logger.info("正确的sign:"+sign1);
	    	throw new BusinessException("验签失败");
	    }
	}
	
	
	  /**
     * @Description 加密
     * @Date 2019/9/3 14:58
     * @param obj
     * @return java.lang.String
     */
    public  String tosign(Object obj){
        String xml = XmlUtil.convertToXml(obj, true);
        xml = XmlUtil.getXmlValue(xml);
        // 过滤空格回车标签
        Pattern pspace = Pattern.compile("\t|\r|\n", Pattern.CASE_INSENSITIVE);
        Matcher mspace = pspace.matcher(xml);
        xml = mspace.replaceAll("");
        //报文加密
        xml = xml + SystemConfig.cacheMap.get("GBCN_SIGN_KEY");
        String hash = Md5Util.hash(xml);
        return hash;
    }
	
	
}
