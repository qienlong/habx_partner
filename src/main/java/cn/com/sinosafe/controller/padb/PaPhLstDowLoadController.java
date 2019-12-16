/**   
* @Title:：PaPhLstDowLoadController.java 
* @Package ：cn.com.sinosafe.controller.padb 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月10日 下午12:51:56 
* @version ： 1.0   
*/
package cn.com.sinosafe.controller.padb;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import cn.com.sinosafe.common.annotation.Log;
import cn.com.sinosafe.service.padb.PaLstIqpDowloadMsgService;
import cn.com.sinosafe.service.padb.PaPhCommonService;
import cn.com.sinosafe.service.padb.impl.FO002003ServiceImpl;

/**
* @ClassName:：PaPhLstDowLoadController 
* @Description： 平安投保单下载通知（定制器调用触发）
* @author ：xiewei
* @date ：2019年6月12日 上午9:24:57
 */
@Log
@RestController
@RequestMapping("/pa/lst_dowload")
public class PaPhLstDowLoadController {
	
	@Autowired
	private PaLstIqpDowloadMsgService paLstIqpDowloadMsgService;
	@Autowired
	private PaPhCommonService paPhCommonService;
	
	/**
	 * 
	* @Title：queryInfo 
	* @Description：平安投保单下载通知（定制器调用触发）
	* @param ：@param map
	* @param ：@return 
	* @return ：JSONObject 
	* @throws
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/msg" , method=RequestMethod.POST,consumes="application/json; charset=utf-8")
	public JSONObject queryInfo(@RequestBody Map<String, Object> map) {
		List<String> list=(List<String>) map.get("inpoList");
		paLstIqpDowloadMsgService.lstDowloadMsg(list);
		return null;
	}
	
	@GetMapping(value="/lsturl/{applNo}")
	public String downloadFile(HttpServletResponse response, @PathVariable() String applNo) throws IOException{
		// 被下载文件的名称
		String fileName = applNo + ".pdf";
        String surl = paPhCommonService.getPolicyUrl(applNo);
        response.setContentType("application/force-download");// 设置强制下载不打开            
        response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
        byte[] buffer = new byte[1024];
        BufferedInputStream bis = null;
        
        URL url = new URL(surl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();  
		con.setConnectTimeout(5*1000);
        InputStream fis = con.getInputStream();
        
        try {
            bis = new BufferedInputStream(fis);
            OutputStream outputStream = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                outputStream.write(buffer, 0, i);
                i = bis.read(buffer);
            }
            return "下载成功";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
       return "下载失败";    
    }
}
