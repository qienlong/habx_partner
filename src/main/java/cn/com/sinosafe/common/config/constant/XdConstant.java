package cn.com.sinosafe.common.config.constant;

/**
 * @version 1.0
 * @Description 小贷参数配置
 * @auther 林良
 * @Date 2019-11-07
 */
public class XdConstant {

    public static final String[] mustCheckFields1 = new String[]{"contNo","cusName","certType","certNo","rsdRelId","rsdAddress","regRelId","registerAddress","cusBankCardNo","phone",
            "bankCardNo","marryStatus","spouseName","spouseCertType","spouseCertNo","spousePhone","comName","comRelId","comAddr","comPhone","education","applyAmt","termType","term","repayModel","payeeBankCusName",
            "payeeBankCardNo","loanUse","filePaths","busiType","liveStatus","payType","occupation","validation","paymentAccount","idStartDate"};

    public static final String[] mustCheckFields2 = new String[]{"contNo","cusName","certType","certNo","rsdRelId","rsdAddress","regRelId","registerAddress","cusBankCardNo","phone",
            "bankCardNo","marryStatus","comName","comRelId","comAddr","comPhone","education","applyAmt","termType","term","repayModel","payeeBankCusName",
            "payeeBankCardNo","loanUse","filePaths","busiType","liveStatus","payType","occupation","validation","paymentAccount","idStartDate"};

    //消费贷去掉 comPhone校验 by fankun 20191204 
    public static final String[] mustCheckFields3 = new String[]{"contNo","cusName","certType","certNo","rsdRelId","rsdAddress","regRelId","registerAddress","cusBankCardNo","phone",
        "bankCardNo","marryStatus","comName","comRelId","comAddr","education","applyAmt","termType","term","repayModel","payeeBankCusName",
        "payeeBankCardNo","loanUse","filePaths","busiType","liveStatus","payType","occupation","validation","paymentAccount","idStartDate"};

    //消费贷
    public static final String consumerLoan = "05210305";

    //经营贷
    public static final String operatingLoan = "05210304";

    //120-个人经营性客户；260-个体工商户主；211-小企业主
    public static final String cusType = "120|260|211";

    //所属行业编码
    public static final String industryCode = "A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|AA|AB|AC";

    //经营贷借款用途
    public static final String OLLoanUse = "0009|0010|0011";

    //消费贷借款用途
    public static final String CLLoanUse = "0001|0002|0003|0004|0005|0006|0007|0008";

    //教育程度
    public static final String eduLevel = "00|10|20|30|40|50|60|70|80|90|99";

    //居住状况类型
    public static final String liveStatus = "0|1|2|3|4|5|6|7|9";

    //三湘资金方编号
    public static final String SXPN = "PRJ20170930049711";

    //民泰资金方编号
    public static final String MTPN = "PRJ20171115000297";

    //重庆农商行资金方编号
    public static final String CQNSHPN = "PRJ20150209000248";

    //哈密资金方编号
    public static final String HMPN = "PRJ20190801091636";

    //浩森资金方编号
    public static final String HSPN = "PRJ20190506088134";
}
