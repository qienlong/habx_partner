package cn.com.sinosafe.domain.bean;

/**
 * @Desc   : 响应码枚举，参考HTTP状态码的语义  <br>
 * @Author : XieWei <br>
 * @Date   : 2019年5月30日<br>
 */
public enum PaResultCode {
	/**
	 * 调用成功
	 */
    PA_SUCCESS("0000"),
    /**
     * 调用失败
     */
    PA_FAIL("9999"),
    /**
     * 字段缺失
     */
    PA_FIELD_DELETION("7777"),
    /**
     * 未认证（签名错误）
     */
    PA_UNAUTHORIZED("401"),
    /**
     * 接口不存在
     */
    PA_NOT_FOUND("404"),
    /**
     * 服务器内部错误
     */
    PA_INTERNAL_SERVER_ERROR("500");

    private final String code;

    PaResultCode(String code) {
        this.code = code;
    }

    public String code() {
        return code;
    }
}
