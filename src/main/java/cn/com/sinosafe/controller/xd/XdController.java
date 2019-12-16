package cn.com.sinosafe.controller.xd;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sinosafe.common.annotation.Log;
import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.common.util.DesEncrypter;
import cn.com.sinosafe.common.util.SpringUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.common.util.ThreadLocalUtil;
import cn.com.sinosafe.domain.xd.XdRequest;
import cn.com.sinosafe.domain.xd.XdResponse;
import cn.com.sinosafe.service.xd.XdBaseService;
import cn.com.sinosafe.service.xd.XdService;

import com.alibaba.fastjson.JSONObject;

/**
 *
 * 小贷对接服务 <br>
 * @Author : ChenLiang <br>
 * @Date : 2019年11月6日<br>
 */
@RestController
@RequestMapping("cop/xd/")
public class XdController {

	private final static Logger logger = LoggerFactory.getLogger(XdController.class);
/*
	@Autowired
	private XdPostLoanUpload4Hmyh xdPostLoanUpload4Hmyh;*/


	@PostMapping("test1")
	public String test1(@RequestBody JSONObject jsonObject) throws Exception {
		Object obj = jsonObject.get("params");
		String aa = jsonObject.toJSONString(obj);
		DesEncrypter desEncrypter=new DesEncrypter("973079a2d56c5d5e2c230ab425ae1d24");
		String params = desEncrypter.encrypt(aa);
//       / System.out.println(params);
//        jsonObject.remove("params");
//        jsonObject.put("params",params);
        XdRequest xdRequest = new XdRequest();
        xdRequest.setAccid(jsonObject.getString("accid"));
        xdRequest.setParams(params);
        xdRequest.setType(jsonObject.getString("type"));
        System.out.println(JSONObject.toJSONString(xdRequest));
        return loanApply(xdRequest);
    }
	

	/**
	 * 外部小贷渠道对接
	 * @param xdRequest
	 * @return
	 */
	@PostMapping("loanApply")
	public String loanApply(@RequestBody XdRequest xdRequest){
		  String resultObj = null;
		  long start = System.currentTimeMillis();
		try {
			//增加线程号
			String sessionID = "wsxd"+DateUtils.getMillisecond();
			MDC.put("sessionID",sessionID);	
			ThreadLocalUtil.set("sessionID",sessionID);
			logger.info("Method={};入参Json={}",xdRequest.getType(),JSONObject.toJSONString(xdRequest));
			String accid = xdRequest.getAccid();
			String params = xdRequest.getParams();
			if (StringUtils.isEmpty(accid)) {
				throw new Exception("accid为空");
			}
			if (StringUtils.isEmpty(xdRequest.getType())) {
				throw new Exception("type为空");
			}
			if (StringUtils.isEmpty(params)) {
				throw new Exception("params为空");
			}
			XdBaseService xdBaseService = (XdBaseService) SpringUtils.getBean(xdRequest.getType());
		    resultObj = xdBaseService.invoke(xdRequest);
		} catch (Exception e) {
			logger.error("invoke="+xdRequest.getType(),e);
			resultObj = JSONObject.toJSONString(new XdResponse("9999",e.getMessage()));
		} finally {
			logger.info("------ loanApply ---- end  total time "+ (System.currentTimeMillis()-start)+" ms-----");
			logger.info("接口出参--->"+resultObj);
			MDC.clear();
			ThreadLocalUtil.remove();
		}
		return resultObj;
	}


	/**
	 * json入参 查询待签署列表，签署完成回调接口 ,出参为String,JsonProtocol
	 * @param jsonObject
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/{type}")
	@SuppressWarnings("unchecked")
	@Log
	public <T> T paramJsonProcess(@PathVariable String type,@RequestBody JSONObject requestJson) throws Exception{
		XdService<T,JSONObject> service = SpringUtils.getBean(type,XdService.class);
		return service.process(requestJson);
	}

	
/*
	@PostMapping("XdPostLoanUpload4Hmyh")
	public JsonProtocol XdPostLoanUpload4Hmyh(){
		return xdPostLoanUpload4Hmyh.uploadLoanAfterFilesForXD();
	}*/
	
}
