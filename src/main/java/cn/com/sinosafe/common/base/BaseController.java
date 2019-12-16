package cn.com.sinosafe.common.base;

import cn.com.sinosafe.common.config.constant.CommonConstant;
import cn.com.sinosafe.common.config.constant.RspMsgConstant;
import cn.com.sinosafe.common.exception.ParamException;
import cn.com.sinosafe.common.util.CommonUtils;
import cn.com.sinosafe.domain.bean.JsonRsp;
import cn.com.sinosafe.domain.bean.Require;

/**
 * @Project	: Rest_HAXB_Service
 * @Desc	: 基础控制器
 * @Author	: hesong
 * @Date	: 2018年12月29日 下午2:10:39
 * @Version	: 1.0
 */
public class BaseController {
	
	/**
	 * 提取偶数的除法基数：2
	 * （主要是为了通过阿里插件关于魔法值的校验）
	 */
	private static final int EVENBASE = 2;
	
	/**
	 * 操作成功码值的引用
	 */
	protected static int SUC_CDE = RspMsgConstant.SUCCESS;
	
	/**
	 * 操作成功提示语的引用
	 */
	protected static String SUC_MSG = RspMsgConstant.SUCCESS_MSG;
	
	/**
	 * 操作失败码值的引用
	 */
	protected static int FAIL_CDE = RspMsgConstant.FAIL;
	
	/**
	 * 操作失败提示语的引用
	 */
	protected static String FAIL_MSG = RspMsgConstant.FAIL_MSG;
	
	/**
	 * 校验参数是否为空:
	 * @desc	: 必须传递偶数个参数;
	 * 			    且每两个参数的关系为("参数值","参数名")
	 * @author	: hirson
	 * @date	: 2018年12月29日 下午2:12:18
	 * @param params
	 * 			    必须传递偶数个参数;
	 * 			    且每两个参数的关系为("参数值","参数名")，如（fileSize, 文件大小）。
	 * @return	:
	 * @throws ParamException 参数个数为奇数时抛出此异常
	 */
	public JsonRsp checkParams(Object...params) throws ParamException {
		int length = params.length;
		if ((length % EVENBASE) != 0) {
			throw new ParamException("校验参数个数有误，当前个数为" + length + "个！");
		}
		
		Require me = Require.me();
		for (int i = 0; i < params.length; i += EVENBASE) {
			me.put(params[i], String.valueOf(params[i+1]) + CommonConstant.CHECK_PARAM);
		}
		return CommonUtils.checkParams(me);
	}
}
