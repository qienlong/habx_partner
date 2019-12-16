package cn.com.sinosafe.common.config.constant;


/**
 * @version 1.0
 * @Description 单位所属行业
 * @auther 林良
 * @Date 2019-11-07
 */
public enum  XdEnum {

    A("A", "A"),
    B("B", "B"),
    C("C", "C"),
    D("D", "D"),
    E("E", "E"),
    F("F", "H"),
    G("G", "F"),
    H("H", "I"),
    I("I", "G"),
    J("J", "J"),
    K("K", "K"),
    L("L", "L"),
    M("M", "M"),
    N("N", "N"),
    O("O", "O"),
    P("P", "P"),
    Q("Q", "Q"),
    R("R", "R"),
    S("S", "S"),
    T("T", "T"),
    U("U", "Z"),
    V("V", "Z"),
    W("W", "Z"),
    X("X", "Z"),
    Y("Y", "Z"),
    Z("Z", "Z"),
    AA("AA", "Z"),
    AB("AB", "Z"),
    AC("AC", "Z");

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

    XdEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String getValueByKey(String key){
        String value = null;
        for (XdEnum e : XdEnum.values()){
            if (e.getKey().equals(key)) {
                value = e.getValue();
                break;
            }
        }
        return value;
    }
}
