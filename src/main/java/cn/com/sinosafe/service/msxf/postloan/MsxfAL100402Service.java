package cn.com.sinosafe.service.msxf.postloan;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sinosafe.common.config.constant.MsxfConstant;
import cn.com.sinosafe.common.util.Convert;
import cn.com.sinosafe.common.util.FileUtils;
import cn.com.sinosafe.common.util.StringUtils;
import cn.com.sinosafe.dao.LstSettleInfoMapper;
import cn.com.sinosafe.domain.bean.MsxfBankType;
import cn.com.sinosafe.service.common.ImageOperaService;

/**
 * 退保结果文件处理 <br>
 * @Author : ex-tangzhenzhen001 <br>
 * @Date : 2019年9月25日<br>
 */
@Service(MsxfConstant.MSXF_AL100402)
public class MsxfAL100402Service{

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	protected ImageOperaService imageOperaService;
	@Autowired
	protected LstSettleInfoMapper lstSettleInfoMapper;

	public List<String> getCancellationTxtPath(String param) throws Exception{
		
		logger.info("{}查询退保结果开始",MsxfConstant.MSXF_AL100402);
		//存放文件路径
		List<String> cancellationTxtPathList = new ArrayList<String>();
		for (MsxfBankType e : MsxfBankType.values()) {
			logger.info("{}银行查询退保结果开始",e);
			// 查询对应银行退保结果的信息
			String partner = e.getPartner();
			String bank = e.getBank();
			List<Map<String, String>> cancellationList = lstSettleInfoMapper.selectBySentStatusAndSource(MsxfConstant.MSXF,partner);
			//存放文件数据
			List<String> content = new ArrayList<>();
			if(StringUtils.isNotEmpty(cancellationList)) {
				for(Map<String, String> cancellation:cancellationList){
					String s = buildTextFile(cancellation);
					content.add(s);
				}
			}
			// 本地目录  D:\apps\MSXF\2019-09-25
			String localBasePath = imageOperaService.getLocalPath(MsxfConstant.MSXF);
			
			// 创建本地银行文件夹,写文件,添加到上传路径
			String newFilePath = localBasePath + File.separator + bank;
			FileUtils.initFiles(newFilePath);
			String fullFilePath = newFilePath + File.separator + MsxfConstant.MSXF_AL100402_FILENAME;
			FileUtils.write(content, fullFilePath);
			cancellationTxtPathList.add(fullFilePath);
			// 写.OK文件
			String okFilePath = newFilePath + File.separator + MsxfConstant.MSXF_AL100402_FILENAME_OK;
			FileUtils.writeOne(Convert.toStr(content.size()) + "|" + new File(fullFilePath).length(), okFilePath);
			cancellationTxtPathList.add(okFilePath);
			
			// 批量更新sent_status
			if (StringUtils.isNotEmpty(cancellationList)){
				lstSettleInfoMapper.updateAll(cancellationList);
			}
			logger.info("{}银行处理退保结果结束",e);
		}
		logger.info("{}查询退保结果结束,txt文档本地路径:{}",MsxfConstant.MSXF_AL100402,cancellationTxtPathList);
		
		return cancellationTxtPathList;
	}


	//组装txt文档
	private String buildTextFile(Map<String, String> cancellation){
		StringBuffer buffer = new StringBuffer();
		buffer.append(cancellation.get("REF_NBR")).append("|").append(cancellation.get("POLICY_NO")).
				append("|").append(cancellation.get("CANCEL_STATUS")).append("|")
				.append(cancellation.get("CANCEL_DATE").substring(0, 10).replace("-", ""));
        return buffer.toString();
	}
}
