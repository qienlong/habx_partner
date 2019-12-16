package cn.com.sinosafe.service.xd;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import cn.com.sinosafe.dao.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import com.alibaba.fastjson.JSONObject;

import cn.com.sinosafe.common.config.SystemConfig;
import cn.com.sinosafe.common.util.DesEncrypter;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.common.util.ThreadLocalUtil;
import cn.com.sinosafe.domain.entity.IqpMeApiCop;
import cn.com.sinosafe.domain.xd.XdFileInfo;
import cn.com.sinosafe.domain.xd.XdRequest;

import javax.sql.DataSource;

/**
 * 
 * 小贷对接父类 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年11月6日<br>
 */
public abstract class XdBaseService implements XdService<String,XdRequest> {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	protected IqpMeApiCopMapper iqpMeApiCopMapper;
	@Autowired
	protected SystemConfig systemConfig;
	@Autowired
	protected XdAsynService xdAsynService;
	@Autowired
	protected IqpMeLoanAppMapper iqpMeLoanAppMapper;
	@Autowired
	protected PartnerBusiImportDetailMapper partnerBusiImportDetailMapper;
	@Autowired
	protected PrjCopAccMapper prjCopAccMapper;
	@Autowired
	protected FeeRateMapper feeRateMapper;
	@Autowired
	protected DataSource dataSource;
	@Autowired
	protected CusBaseMapper cusBaseMapper;
	@Autowired
	protected CusIndivMapper cusIndivMapper;
	@Autowired
	protected PartnerBusiImportListMapper partnerBusiImportListMapper;
	@Autowired
	protected LstIqpInfoMapper lstIqpInfoMapper;
	@Autowired
	protected AccLoanMapper accLoanMapper;
	@Autowired
	protected SentStatusMapper sentStatusMapper;

    public String invoke(XdRequest xdRequest) throws Exception {
		//校验accid
    	IqpMeApiCop iqpMeApiCop = iqpMeApiCopMapper.selectByAccid(xdRequest.getAccid());
    	ThreadLocalUtil.set("iqpMeApiCop", iqpMeApiCop);
    	if(ObjectUtils.isEmpty(iqpMeApiCop)) {
    		throw new Exception("accid不合法");
    	}
    	// 校验接口权限
    	if(StringUtils.isNotBlank(iqpMeApiCop.getIntefaces())) {
    		String[] intefaces = iqpMeApiCop.getIntefaces().split("\\|");
    		if(!Arrays.asList(intefaces).contains(xdRequest.getType())) {
    			throw new Exception("type不合法");
    		}
    	}
		//params解密
    	if(StringUtils.isEmpty(iqpMeApiCop.getKey())) {
    		throw new Exception("无密钥配置");
    	}
    	DesEncrypter desEncrypter=new DesEncrypter(iqpMeApiCop.getKey());
		String params = desEncrypter.decrypt(xdRequest.getParams());
		logger.info("解密后参数："+ params);
    	xdRequest.setParams(params);
    	logger.info("入参："+ JSONObject.toJSONString(xdRequest));
		return process(xdRequest);
    }
    
    /**
     * 校验必填项
     * @param loanInfo
     * @param mustCheckFields
     * @throws Exception
     */
    public void checkDatas (Object loanInfo,String[] mustCheckFields) throws Exception {
        //利用反射获取loanInfo的属性,根据属性获取对应的必输字段
        Field[] fields=loanInfo.getClass().getDeclaredFields();
        for(Field field:fields){
            String name=field.getName();
            for (String fieldName : mustCheckFields) {
                if(fieldName.equalsIgnoreCase(name)){
                    name=name.substring(0,1).toUpperCase()+name.substring(1);
                    Method m = loanInfo.getClass().getMethod("get" + name);
                    Object value = (Object) m.invoke(loanInfo, (Object[])null);
                    if(ObjectUtils.isEmpty(value)){
                        throw new Exception(name +"不能为空");
                    }
                    break;
                }
            }
        }
    }
    
    /**
     * 校验文件是否存在
     * @param paramerValue
     * @param files
     * @return
     */
    public String getNotFileTypes(String paramerValue,List<XdFileInfo> files){
		String fileLess = "";
		String [] fileTypes =paramerValue.split(",");
		for (String fileType : fileTypes) {
			boolean isHas = false;
			for (XdFileInfo file : files) {
				if(fileType.equalsIgnoreCase(file.getFileType())){
					isHas = true;
					break;
				}
			}
			if(!isHas){
				fileLess += fileType + ",";
			}
		}
		return fileLess;
	}
    
	public IqpMeApiCop getIqpMeApiCop() {
		return ThreadLocalUtil.get("iqpMeApiCop");
	}
    
    
}
