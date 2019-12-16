package cn.com.sinosafe.common.util;

/**
 * @version 1.0
 * @Description 保险责任
 * @auther 林良
 * @Date 2019-09-10
 */
public enum GbcnDutyEnum {
    //责任类别
    TENDER("01","投标保证"),
    PERFORMANCE("02","履约保证"),
    PAY("03","支付保证");

    private String key;

    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    GbcnDutyEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValueByKey(String key){
        String value = null;
        for (GbcnDutyEnum e : GbcnDutyEnum.values()){
            if (e.getKey().equals(key)) {
                value = e.getValue();
                break;
            }
        }
        return value;
    }
}
