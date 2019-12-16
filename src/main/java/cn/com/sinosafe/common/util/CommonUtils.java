package cn.com.sinosafe.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import cn.com.sinosafe.common.config.constant.RspMsgConstant;
import cn.com.sinosafe.common.config.constant.SystemConstant;
import cn.com.sinosafe.common.config.properties.MailProperties;
import cn.com.sinosafe.domain.bean.JsonRsp;
import cn.com.sinosafe.domain.bean.Require;
import cn.com.sinosafe.service.common.EmailPushService;

/**
 * 
 * 功能说明：辅助性的工具类
 * @author liansonghui
 * @version 0.1.0
 * @time 2017年11月9日
 */
@Component
public class CommonUtils {
	private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);
	@Autowired
	private EmailPushService emailPushService;
	@Autowired
	private MailProperties mailProperties;
	private static final String[] CN_UPPER_NUMBER = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
    private static final String[] RADICES = {"", "拾", "佰", "仟"};
    private static final String[] BIG_RADICES = {"", "万", "亿", "兆"};
    
	/**
	 * 方法说明：释放内存
	 * @version 0.1.0
	 * @time 2017年12月18日
	 */
	public static void setNull(Object... obj) {
		if(obj != null) {
			for(Object o : obj) {
				if(o != null) {
					o = null;
				}
			}
		}
	}
	
	/**
	 * 方法说明：检查参数是否不为空
	 * @param 参数
	 * @return 
	 * @version 0.1.0
	 * @time 2017年12月18日
	 */
/*	public static JsonProtocol checkParams(Require rules) {
		JsonProtocol result = null;
		if (rules != null && rules.getLength() > 0) {
			result = new JsonProtocol();
			result.setup(RspMsgConstant.ARGUMENT_ERROR);
			for (int i = 0, total = rules.getLength(); i < total; i++) {
				Object key = rules.get(i);
				String message = rules.getMessage(i);
				if (key == null) {
					result.setMessage(message);
					return result;
				} 
				if (key instanceof String && StringUtils.isEmpty((String) key)) {
					result.setMessage(message);
					return result;
				}
			}
			result = null;
		}
		return result;
	}
*/	public static JsonRsp checkParams(Require rules) {
		JsonRsp result = null;
		if (rules != null && rules.getLength() > 0) {
			result = new JsonRsp();
			result.setup(RspMsgConstant.ARGUMENT_ERROR);
			for (int i = 0, total = rules.getLength(); i < total; i++) {
				Object key = rules.get(i);
				String message = rules.getMessage(i);
				if (key == null) {
					result.setMessage(message);
					return result;
				} 
				if (key instanceof String && StringUtils.isEmpty((String) key)) {
					result.setMessage(message);
					return result;
				}
			}
			result = null;
		}
		return result;
	}
	
	/**
	 * 获取客户端的ip
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) { 
	    String ip = request.getHeader("x-forwarded-for"); 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("WL-Proxy-Client-IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_CLIENT_IP"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
	    } 
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	      ip = request.getRemoteAddr(); 
	    } 
	    return ip; 
	  } 
	/**
     * 根据指定长度随机生成小写字母
     * @param length 长度
     * @return 指定长度的随机小写字母字符串
     */
    public static String randomLowerWords(int length) {
        /*
           0~9的ASCII为48~57
           A~Z的ASCII为65~90
           a~z的ASCII为97~122
         */
        StringBuilder sb = new StringBuilder();
        Random randData = new Random();


        int data = 0;
        for(int i = 0; i < length; i++)
        {
        	//保证只会产生97~122之间的整数
            data=randData.nextInt(26)+97;
            sb.append((char)data);
        }
        return sb.toString();
    }


    /**
     * 根据指定长度随机生成大写字母
     * @param length 长度
     * @return 指定长度的随机大写字母字符串
     */
    public static String randomUpperWords(int length) {
        /*
           0~9的ASCII为48~57
           A~Z的ASCII为65~90
           a~z的ASCII为97~122
         */
        StringBuilder sb = new StringBuilder();
        Random randData = new Random();


        int data = 0;
        for(int i = 0; i < length; i++)
        {
        	//保证只会产生97~122之间的整数
            data=randData.nextInt(26)+65;
            sb.append((char)data);
        }
        return sb.toString();
    }


    /**
     * 根据指定长度随机生成数字
     * @param length 长度
     * @return 指定长度的随机数字
     */
    public static String randomNumbers(int length) {
        /*
           0~9的ASCII为48~57
           A~Z的ASCII为65~90
           a~z的ASCII为97~122
         */
        StringBuilder sb = new StringBuilder();
        Random randData = new Random();


        int data = 0;
        for(int i = 0; i < length; i++)
        {
        	//仅仅会生成0~9
            data=randData.nextInt(10);
            sb.append(data);
        }
        return sb.toString();
    }	
    
    public static Map<String,Object> getFiledValues(Object obj) throws Exception{  
    	Map<String,Object> map = new HashMap<String,Object>(16);
    	if(obj != null) {
    		Field[] fields = obj.getClass().getDeclaredFields();
    		if(fields != null) {
    			String name = null;
    			for(Field field : fields) {
    				name = field.getName();
    				 // 获取原来的访问控制权限  
    		         boolean accessFlag = field.isAccessible(); 
    				// 修改访问控制权限  
    		         field.setAccessible(true);  
    		         Object  value = field.get(obj);  
    		         map.put(name, value);
    		         // 恢复访问控制权限  
    		         field.setAccessible(accessFlag);  
    			}
    		}
    	}
        return map;  
    } 
    
	/**
	 * 方法说明：数据排序
	 * @param asc true升序 false倒序
	 * @param column 数字型的字段
	 * @version 1.0.0
	 * @time 2018年2月8日
	 */
	public static List<JSONObject> sort(List<JSONObject> list, final boolean asc, final String column) {
		if(list != null && !list.isEmpty()) {
			Collections.sort(list, new Comparator<JSONObject>() {

				@Override
				public int compare(JSONObject o1, JSONObject o2) {
					int a = o1.getIntValue(column);
					int b = o2.getIntValue(column);
					if(asc) {
						return a>b?1:(a==b?0:-1);
					} else {
						return a>b?-1:(a==b?0:1);
					}
				}
			});
		}
		return list;
	}
	
	/**
	 * 方法说明：通过影像目录号获取对应中文名
	 * @version 1.0.0
	 * @time 2018年3月3日
	 */
	public static String imgPathName(String fileType) {
		String result = fileType;
		if(StringUtils.isNotEmpty(fileType)) {
			if("ZXD_00101".equals(fileType)) {
				result = "身份证";
			} else if("ZXD_00102".equals(fileType)) {
				result = "户口本";
			} else if("ZXD_00201".equals(fileType)) {
				result = "录取通知书";
			} else if("ZXD_00202".equals(fileType)) {
				result = "学生证";
			} else if("ZXD_00203".equals(fileType)) {
				result = "高校回执";
			} else if("ZXD_00301".equals(fileType)) {
				result = "贫困证明";
			} else if("ZXD_00401".equals(fileType)) {
				result = "监护人同意贷款证明";
			} else if("ZXD_00501".equals(fileType)) {
				result = "申请表";
			} else if("ZXD_00502".equals(fileType)) {
				result = "借款合同";
			} else if("ZXD_00503".equals(fileType)) {
				result = "还款说明";
			} else if("ZXD_00504".equals(fileType)) {
				result = "贷款告知函";
			} else if("ZXD_00601".equals(fileType)) {
				result = "华安征信授权书";
			} else if("ZXD_00602".equals(fileType)) {
				result = "邮储征信授权书";
			} else if("ZXD_00701".equals(fileType)) {
				result = "展期申请表";
			} else if("ZXD_00702".equals(fileType)) {
				result = "还款确认书";
			} else if("ZXD_00801".equals(fileType)) {
				result = "还款卡变更补充协议";
			} else if("ZXD_00802".equals(fileType)) {
				result = "信息补录补充协议";
			} else if("ZXD_00901".equals(fileType)) {
				result = "申请表";
			} else if("ZXD_00902".equals(fileType)) {
				result = "还款卡变更补充协议";
				result = "借款合同";
			} else if("ZXD_01001".equals(fileType)) {
				result = "高校回执模板";
			} else if("ZXD_01002".equals(fileType)) {
				result = "展期申请表模板";
			} else if("ZXD_01003".equals(fileType)) {
				result = "华安助学App使用协议";
			} else if("ZXD_01004".equals(fileType)) {
				result = "展期协议";
			} else if("ZXD_01005".equals(fileType)) {
				result = "其他";
			}
				
		}
		return result;
	}
	
	
	
	/**
	 * 方法说明：阿拉伯数据转成大写的中文:如1转壹
	 * @version 1.0.0
	 * @time 2018年3月26日
	 */
	public static String upperNumber(String number) {
		String result = "";
		switch(number) {
		case "1":
			result = "壹";
			break;
		case "2":
			result = "贰";
			break;
		case "3":
			result = "叁";
			break;
		case "4":
			result = "肆";
			break;
		case "5":
			result = "伍";
			break;
		case "6":
			result = "陆";
			break;
		case "7":
			result = "柒";
			break;
		case "8":
			result = "捌";
			break;
		case "9":
			result = "玖";
			break;
		case "10":
			result = "拾";
			break;
		case "100":
			result = "佰";
			break;
		case "1000":
			result = "仟";
			break;
		case "10000":
			result = "万";
			break;
		case "0.1":
			result = "角";
			break;
		case "0.01":
			result = "分";
			break;
		default: 
			result = "";
			break;
		}
		return result;
	}
	
	/**
	 * 方法说明：数字型金钱转用繁体字,到分
	 * @version 1.0.0
	 * @time 2018年3月26日
	 */
	public static String transferMoney(long money) {
		StringBuilder result = new StringBuilder("");
        if (money == 0) {
            return "零元整";
        }
        //整数部分
        long integral = money / 100;
        int integralLen = (integral + "").length();
        //小数部分
        int decimal = (int) (money % 100);
        if (integral > 0) {
            int zeroCount = 0;
            for (int i = 0; i < integralLen; i++) {
                int unitLen = integralLen - i - 1;
              //当前数字的值
                int d = Integer.parseInt((integral + "").substring(i, i + 1));
              //大单位的下标{"", "万", "亿"}
                int quotient = unitLen / 4;
                int modulus = unitLen % 4;
                if (d == 0) {
                    zeroCount++;
                } else {
                    if (zeroCount > 0) {
                        result.append(CN_UPPER_NUMBER[0]);
                    }
                    zeroCount = 0;
                    result.append(CN_UPPER_NUMBER[d]).append(RADICES[modulus]);
                }
                if (modulus == 0 && zeroCount < 4) {
                    result.append(BIG_RADICES[quotient]);
                }
            }
            result.append("圆");
        }
        if (decimal > 0) {
            int j = decimal / 10;
            if (j > 0) {
                result.append(CN_UPPER_NUMBER[j]).append("角");
            }
            j = decimal % 10;
            if (j > 0) {
                result.append(CN_UPPER_NUMBER[j]).append("分");
            }
        } else {
            result.append("整");
        }
		return result.toString();
	}

	/**
	 * 方法说明：数字转大写
	 * @version 1.0.0
	 * @time 2018年4月7日
	 */
	public static String transferUpperNum(String number) {
		String result = "";
		switch(number) {
		case "1":
			result = "一";
			break;
		case "2":
			result = "二";
			break;
		case "3":
			result = "三";
			break;
		case "4":
			result = "四";
			break;
		case "5":
			result = "五";
			break;
		case "6":
			result = "六";
			break;
		case "7":
			result = "七";
			break;
		case "8":
			result = "八";
			break;
		case "9":
			result = "九";
			break;
		case "10":
			result = "十";
			break;
		default:
			break;
		}
		return result;
	}

	
	
	/**
	 * 下载远程文件,并获取流
	 * @param urlString 远程文件地址
	 * @throws Exception
	 */
	public static InputStream download(String urlString) throws Exception {
		InputStream is = null;
		try {
			// 构造URL
			URL url = new URL(urlString);
			// 打开连接
			URLConnection con = url.openConnection();
			//设置请求超时为5s
			con.setConnectTimeout(5*1000);
			// 输入流
			is = con.getInputStream();
			
			return is;
		} catch(Exception e) {
			throw e;
		} finally {
			// 完毕，关闭所有链接
			/*if(is != null) {
				is.close();
			}*/
		}
	}
	
	/**
	 * 下载远程文件，并保存到指定目录
	 * @param urlString 远程文件地址
	 * @param filename 远程文件名
	 * @param savePath 保存路径
	 * @throws Exception
	 */
	public static void download(String urlString, String filename,String savePath) throws Exception {
		InputStream is = null;
		OutputStream os = null;
		try {
			// 构造URL
			URL url = new URL(urlString);
			// 打开连接
			URLConnection con = url.openConnection();
			//设置请求超时为5s
			con.setConnectTimeout(5*1000);
			// 输入流
			is = con.getInputStream();
			
			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流
			if(StringUtils.isEmpty(savePath)) {
				savePath = "hastudy" + File.separator + "temp" + File.separator + "pic";
			}
			File sf=new File(savePath);
			if(!sf.exists()){
				sf.mkdirs();
			}
			os = new FileOutputStream(sf.getPath() + File.separator + filename);
			// 开始读取
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
		} catch(Exception e) {
			logger.error("【下载远程文件】", e);
			throw e;
		} finally {
			// 完毕，关闭所有链接
			if(os != null) {
				os.close();
			}
			if(is != null) {
				is.close();
			}
		}
	} 
	
	
	/**
	 * 计算时间
	 * @author Hirson
	 * @param serno			业务标识
	 * @param interfaceName	接口名
	 * @param lStart		开始时间
	 */
	public static void logReqTime(String serno,String interfaceName, long lStart) {
		logger.info("【接口响应计时】接口{}调用耗时{},业务标识{}",interfaceName, CommonFun.calculation(lStart), serno);
	}
	/**
	 * 根据身份证获取性别
	 * @param certNo
	 * @return
	 */
	public static String getSexByCertNo (String certNo){
		if(certNo.length()==18) {
	        char sex = certNo.charAt(16);
	        return Integer.valueOf(sex)%2==1 ? "1" : "2";
	    }
		return null;
	}
	/**
	 * 根据身份证获取生日
	 * @param certNo
	 * @return
	 */
	public static String getBirthdayByCertNo (String certNo){
		String birthdayYear = certNo.substring(6,10);
	    String birthdayMonth = certNo.substring(10,12);
	    String birthdayDay = certNo.substring(12,14);
		return birthdayYear+"-"+birthdayMonth+"-"+birthdayDay;
	}
	
	 /** * 生成时间戳 */ 
	public static String getDateTime(){
		DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS"); 
		return sdf.format(new Date()); 
	}
	
	/**
	 * 异常信息邮件发送
	 * @author	: hirson
	 * @date	: 2019年6月27日 下午6:06:55
	 * @param t
	 * @param values	:
	 */
	public void exceptionMail(Throwable t, String...values) {
		String content = CommonFun.getExceptionTrace(t);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < values.length; i++) {
			sb.append(values[i] + "：");
			if (i == values.length-1) {
				content = sb.toString().substring(0,sb.length()-1) + "\n\n      异常信息==========================>>>>>>>>>>>>>" + content;
			}
		}
		commomMail(SystemConstant.EXCETPTION_MAIL_TITLE, content, mailProperties.getReciverAddress(), mailProperties.getCcAddress());
	}
	
	public void commomMail(String emailTile, String emailContent, String reciverAddress, String ccAddress) {
		emailPushService.pushMessage(emailTile, emailContent, reciverAddress, ccAddress, "");
	}
}
