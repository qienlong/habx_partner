package cn.com.sinosafe.service.padb;

public interface NoticeInsureIqpResultService {

	/**
    *
    * 方法说明：获取投保结果信息
    * @author pengll
    * @param applNo 申请号
    * @param resultCode 投保结果
    * @return String类型
    * @time 2019-06-06
    */
	String queryInsureIqpResult(String accToken, String applNo,String resultCode);
	
}
