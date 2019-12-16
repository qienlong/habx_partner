/**   
* @Title:：IssuedMsgConstant.java 
* @Package ：cn.com.sinosafe.common.config.constant 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月8日 下午6:28:37 
* @version ： 1.0   
*/
package cn.com.sinosafe.common.config.constant;

import java.math.BigDecimal;
import java.util.Date;

import cn.com.sinosafe.common.util.DateUtils;
import cn.com.sinosafe.domain.dto.PaPolicyInfo;
import cn.com.sinosafe.domain.entity.LstIqpInfo;

/** 
 * @ClassName:：IssuedMsgConstant 
 * @Description： TODO
 * @author ：xiewei
 * @date ：2019年6月8日 下午6:28:37  
 */
public class IssuedMsgConstant {
	//对象转换
	public static LstIqpInfo dtoToBo(LstIqpInfo lstIqpInfo,PaPolicyInfo paPolicyInfo){
		lstIqpInfo.setMobile(paPolicyInfo.getMobile());
		//lstIqpInfo.setAmount(paPolicyInfo.getInAmt());
		lstIqpInfo.setToubaoDate(paPolicyInfo.getLnDate());
		lstIqpInfo.setTerm(String.valueOf(paPolicyInfo.getLnTerm()));
		//lstIqpInfo.setcOprtType(paPolicyInfo.getProductType());
		lstIqpInfo.setGuarantyName(paPolicyInfo.getMortgageAddr());
		lstIqpInfo.setIndivComName(paPolicyInfo.getGuaranteeCompany());
		lstIqpInfo.setIndivComAddr(paPolicyInfo.getGuaranteeCompanyAddr());
		lstIqpInfo.setReceiverCusAddress(paPolicyInfo.getHolderAddr());
		//lstIqpInfo.setExcuseRate(paPolicyInfo.getAbatementRate());
		lstIqpInfo.setCoverStartDate(DateUtils.getDate("yyyy-MM-dd"));
		BigDecimal terms = paPolicyInfo.getLnTerm();
		Date endDate = DateUtils.addMonths(new Date(),terms.intValue());
		lstIqpInfo.setCoverEndDate(DateUtils.formatDate(endDate, "yyyy-MM-dd"));
		lstIqpInfo.setLoanStartDate(DateUtils.getDate("yyyy-MM-dd"));
		lstIqpInfo.setLoanEndDate(DateUtils.formatDate(endDate, "yyyy-MM-dd"));
		lstIqpInfo.setForeignKey(paPolicyInfo.getCheckNo());
//		借款人陆金所ID
//		安硕贷款受理号
//		征信授权书影像编码
//		业务类型		
		return lstIqpInfo;
	}
}
