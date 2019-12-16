package cn.com.sinosafe.domain.bean;

import com.alibaba.fastjson.JSON;

/**
 * @Desc   : 统一API响应结果封装  <br>
 * @Author : XieWei <br>
 * @Date   : 2019年5月30日<br>
 */
public class PaResult {
	/**
	 * 处理状态
	 */
    private String resultCode;
    /**
     * 处理信息
     */
    private String resultMsg;
    

    public PaResult() {
		super();
	}

	public PaResult(PaResultCode resultCode, String resultMsg) {
		super();
		this.resultCode = resultCode.code();
		this.resultMsg = resultMsg;
	}

	public PaResult setCode(PaResultCode resultCode) {
        this.resultCode = resultCode.code();
        return this;
    }

    public String getCode() {
        return resultCode;
    }

    public String getMessage() {
        return resultMsg;
    }

	public PaResult setMessage(String message) {
        this.resultMsg = message;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
