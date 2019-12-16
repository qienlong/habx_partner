package cn.com.sinosafe.controller.gbcn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.dom.DOMSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.sinosafe.common.annotation.Log;
import cn.com.sinosafe.common.util.ThreadLocalUtil;
import cn.com.sinosafe.lina.common.protocol.JsonProtocol;
import cn.com.sinosafe.service.gbcn.BaseService;

import com.alibaba.fastjson.JSONObject;


@RestController
@RequestMapping("gbcn")
public class GbcnController {
	
	
	@Autowired
	public BaseService baseService;
	
	/**
	 * 工保对接 xml入参
	 * @param domsource
	 * @param type
	 * @return
	 * @throws Exception 
	 */
	@PostMapping(value = "/{type}", consumes = "application/xml", produces = "application/xml")
	public String gbAndXb(HttpServletRequest request, @RequestBody DOMSource domsource, @PathVariable String type){
		ThreadLocalUtil.set("request",request);
		return baseService.invoke(domsource, type);
	}
	
	   
	/**
	 * 回调处理 json + 发送电子快递接口
	 * @param requestJson
	 * @param type
	 * @return
	 * @throws Exception
	 * 支付回调 {type=payCallBack, requestJson={"payType":"1","payTime":"2019-10-11 09:10:58","serno":"LSTI2019101139361","policyNo":"6290401052720190000059","iqpLoanSerno":"WXSQ20191011048800"}}
	 * 电子签章回调{type=insuranceCallBack, requestJson={"code":0,"data":{"pdfUrl":"http://10.1.109.61:8080//store_down_new/download?Type=1&SystemCode=DZBDSYS&BusinessCode=6290401052720190000059&FileId=ECONTRACTPDFUPTOIMAGESYSTEM_6290401052720190000059.pdf","listSerno":"6290401052720190000059"},"message":"Success","timestamp":1570755881634}}
	 * 电子保函回调 {type=guaranteeCallBack, requestJson={"code":0,"data":{"pdfUrl":"http://10.1.109.61:8080//store_down_new/download?Type=1&SystemCode=DZBDSYS&BusinessCode=LSTI2019101139361&FileId=ECONTRACTPDFUPTOIMAGESYSTEM_LSTI2019101139361.pdf","listSerno":"6290401052720190000059"},"message":"Success","timestamp":1570755885955}}
	 */
	@PostMapping(value = "/{type}", consumes = "application/json", produces = "application/json")
	public JsonProtocol callBank(HttpServletRequest request,@RequestBody JSONObject requestJson, @PathVariable String type){
    	ThreadLocalUtil.set("request",request);
		return baseService.callBank(requestJson,type);
	}
	
	/**
	 * 查询保单数据 及影像 发票等
	 * @return
	 */
	@PostMapping(value ="/query", consumes = "application/json", produces = "application/json")
	@Log
    public JsonProtocol query(@RequestBody JSONObject requestJson){
    	return baseService.query(requestJson);
    }
	
	/**
	 * 下载保单
	 * @param response
	 * @param applNo
	 * @return
	 */
	@GetMapping(value="/download/{applNo}")
	@Log
	public String downloadFile(HttpServletResponse response, @PathVariable(required = false,value = "applNo") String applNo){
		try {
			return baseService.downloadFile(response,applNo);
		} catch (Exception e) {
			e.printStackTrace();
			return "下载失败";
		}
	}	
	
}
