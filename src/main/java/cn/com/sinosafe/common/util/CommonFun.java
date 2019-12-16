package cn.com.sinosafe.common.util;

import java.beans.PropertyDescriptor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.codec.binary.Base64;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/***
 * @ClassName: CommonFun
 * @Description:<p>Title: 公共函数库</p>
 * @author longmeihua
 * @date 2016年8月8日
 *
 */
public class CommonFun {
	// protected static RunLog m_log = new RunLog(); //日志句柄
	protected static boolean m_bNeedLog = true; // 是否需要写日志
	private static long startVaue = 0;

	public CommonFun() {

	}

	/*********************************************************************
	 * 删除当前目录下所有文件和文件夹(当前目录保留)
	 *
	 * @param String
	 *            sPath:要删除的文件所在的目录名
	 * @author zwf
	 ********************************************************************/
	public static void DelFiles(String sPath) {

		String sFilepath = "";
		// String sFilename = "";
		File oFile = null, oTmpFile = null;
		File oFiles[] = null;
		int iCount = 0, i = 0;
		try {
			oFile = new File(sPath);
			if (!oFile.exists())
				return;
			oFiles = oFile.listFiles();
			iCount = oFiles.length;
			for (i = 0; i < iCount; i++) {
				oTmpFile = oFiles[i];
				if (oTmpFile.isFile())
					try {
						oTmpFile.delete();
					} catch (Exception exc) {
						System.out.println("删除文件异常(DelFiles):" + exc.getMessage());
						exc.printStackTrace();
					}
				else if (oTmpFile.isDirectory()) {
					sFilepath = oTmpFile.getAbsolutePath();
					Deldir(sFilepath);
				} else
					try {
						oTmpFile.delete();
					} catch (Exception exc) {
						System.out.println("删除文件异常(DelFiles):" + exc.getMessage());
						exc.printStackTrace();
					}
			}

		} catch (Exception exc) {
			System.out.println("删除文件异常(DelFiles):" + exc.getMessage());
		}
	}

	/***************************************************************************
	 * 功能:计算两个日期之间相间隔的秒数
	 *
	 * @param dOld
	 *            -老日期
	 * @param dNew
	 *            -新日期
	 * @return 数字=以秒计算的两个日期相隔的时间
	 ****************************************************************************/
	public static long compareDate(Date dOld, Date dNew) throws Exception {
		long lSeconds = -1;

		if (null == dOld || null == dNew)
			throw new Exception("两个比较值其中有一个为null");
		try {
			if (m_bNeedLog) {
				// m_log.writeLog(false,3,null,"|公共模块|CommonFun.java|compareDate()函数|老日期="
				// + dateFormat(dOld,true) + ",值=" +
				// dOld.getTime(),"C:\\",0,false);
				// m_log.writeLog(false,3,null,"|公共模块|CommonFun.java|compareDate()函数|新日期="
				// + dateFormat(dNew,true) + ",值=" +
				// dNew.getTime(),"C:\\",0,false);
			}
			lSeconds = (dNew.getTime() - dOld.getTime()) / 1000;
			// m_log.writeLog(false,3,null,"|公共模块|CommonFun.java|compareDate()函数|两者间隔秒数="
			// + lSeconds,"C:\\",0,false);

			return lSeconds;

		} catch (Exception exc) {
			throw exc;
		}
	}
	
	
	/***
	 * compareDay:比较两日期相差天数. <br/>
	 * @author longmeihua
	 * @param date1
	 *            日期1
	 * @param date2
	 *            日期2
	 * @return
	 * @throws ParseException
	 * @since JDK 1.6
	 */
	public static long compareDay(String date1, String date2) throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String a = date1;
		String b = date2;
		Long c = sf.parse(b).getTime() - sf.parse(a).getTime();
		long d = c / 1000 / 60 / 60 / 24;// 天
		return d;
	}
	
	
	
	
	
	public static String dateLocalFormat(int iFlag) {
		String sRet = "";
		java.text.SimpleDateFormat formatter;
		Date oDate =new Date();
		try {
			if (iFlag == 1)
				formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			else if (iFlag == 2)
				formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
			else if (iFlag == 3)
				formatter = new java.text.SimpleDateFormat("yyyy/MM/dd");
			else if (iFlag == 4)
				formatter = new java.text.SimpleDateFormat("yyyyMMdd");
			else if (iFlag == 5)
				formatter = new java.text.SimpleDateFormat("HH:mm:ss");
			else if (iFlag == 6)
				formatter = new java.text.SimpleDateFormat("yyyy");
			else if (iFlag == 7)
				formatter = new java.text.SimpleDateFormat("yyyy 年 MM 月 dd 日");
			else if (iFlag == 8)
				formatter = new java.text.SimpleDateFormat("MM");
			else if (iFlag == 9)
				formatter = new java.text.SimpleDateFormat("yyyy-MM");
			else
				formatter = new java.text.SimpleDateFormat("yyyy");
			sRet = formatter.format(oDate);
		} catch (Exception e) {
		}
		return sRet;

	}
	
	public static String dateLocalFormat(Date oDate, int iFlag) {
		String sRet = "";
		java.text.SimpleDateFormat formatter;
		try {
			if (iFlag == 1)
				formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			else if (iFlag == 2)
				formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
			else if (iFlag == 3)
				formatter = new java.text.SimpleDateFormat("yyyy/MM/dd");
			else if (iFlag == 4)
				formatter = new java.text.SimpleDateFormat("yyyyMMdd");
			else if (iFlag == 5)
				formatter = new java.text.SimpleDateFormat("HH:mm:ss");
			else if (iFlag == 6)
				formatter = new java.text.SimpleDateFormat("yyyy");
			else if (iFlag == 7)
				formatter = new java.text.SimpleDateFormat("yyyy 年 MM 月 dd 日");
			else if (iFlag == 8)
				formatter = new java.text.SimpleDateFormat("MM");
			else if (iFlag == 9)
				formatter = new java.text.SimpleDateFormat("yyyy-MM");
			else
				formatter = new java.text.SimpleDateFormat("yyyy");
			sRet = formatter.format(oDate);
		} catch (Exception e) {
		}
		return sRet;

	}

	/**************************************************************
	 * <p>
	 * 功能:去除字符串中的回车\换行符
	 * </p>
	 * <p>
	 * 作者: lee
	 * </p>
	 * <p>
	 * 最后更新:
	 * </p>
	 * 
	 * @param String
	 *            -输入的带回车换行符的字符串
	 * @return String无回车换行符的字符串
	 *************************************************************/
	public static String delrn(String str) throws Exception {
		return str.replaceAll("(\r\n|\r|\n|\n\r)", "");
	}

	/**************************************************************
	 * <p>
	 * 功能:将UniCode码转换为Ascii码
	 * </p>
	 * <p>
	 * 作者: hbmd
	 * </p>
	 * <p>
	 * 最后更新:
	 * </p>
	 * 
	 * @param sUniCode
	 *            -输入的UniCode码字符串
	 * @return Ascii码字符串
	 *************************************************************/
	public String Un2Ascii(String sUniCode) {
		if (sUniCode == null)
			return "";

		String sRet = null;
		try {
			byte[] byteTemp = sUniCode.getBytes();
			sRet = new String(byteTemp, "ISO8859_1");
			return sRet;

		} catch (Exception ue) {
			System.out.println("Uni2Ascii:" + ue.getMessage());
			return sRet;
		}
	}

	/**
	 * 转ABC_DEF为abcDef
	 * 
	 * @param connectedByUnderline
	 * @return
	 */
	public static String caseConvert(String connectedByUnderline) {
		StringBuilder result = new StringBuilder();
		String tmp = connectedByUnderline.toLowerCase();
		String[] words = tmp.split("_");
		result.append(words[0]);
		for (int i = 1; i < words.length; i++)
			if (words[i].length() > 0 && Character.isLetter(words[i].charAt(0))) {
				result.append((char) (words[i].charAt(0) ^ 32));
				if (words[i].length() > 1)
					result.append(words[i].substring(1));
			}
		return result.toString();
	}

	/****************************************************************
	 * 功能:将sAscII码转换为UniCode码 作者: hbmd 最后更新:
	 * 
	 * @param sAscII
	 *            -AscII码字符串
	 * @return UniCode码字符串
	 ***************************************************************/
	public String Ascii2Un(String sAscII) {
		if (sAscII == null)
			return "";
		String sRet = null;
		try {
			byte[] byteTemp = sAscII.getBytes("ISO8859_1");
			sRet = new String(byteTemp);
			return sRet;

		} catch (Exception ue) {
			System.out.println("Ascii2Un:" + ue);
			return sRet;
		}
	}

	/****************************************************************
	 * 功能:将字符串sourse中的Oldstr替换为newstr 作者: lsx 最后更新:
	 * 
	 * @param sSource
	 *            -源字符串
	 * @param sOld
	 *            -源串中需要被替换的字符串
	 * @param sNew
	 *            -替换成的新字符串
	 * @return 替换后的新字符串
	 *****************************************************************/
	public static String replace(String sSource, String sOld, String sNew) {
		if (sSource == null || sOld == null || sNew == null)
			return "";
		String res = "", tmps = sSource;
		try {
			int i;
			while ((i = tmps.indexOf(sOld)) != -1) {
				res = res + tmps.substring(0, i) + sNew;
				tmps = tmps.substring(i + sOld.length(), tmps.length());
			}
			res = res + tmps;
		} catch (Exception ue) {
			System.out.println("Replace:" + ue);
		}
		return res;
	}

	/****************************************************************
	 * 功能:将double型数值四舍五入，返回String型 作者: lsx 最后更新:
	 * 
	 * @param dSource
	 *            -源Double型数值
	 * @param iDig
	 *            -小数部分
	 * @return
	 *****************************************************************/
	public String fmtdouble(double dSource, int iDig) {
		NumberFormat tmpformat = NumberFormat.getNumberInstance();
		String resstr = "";
		String tmpstr = "";
		tmpformat.setMinimumFractionDigits(iDig);
		tmpformat.setMaximumFractionDigits(iDig);
		resstr = tmpformat.format(dSource);
		for (int i = 0; i < resstr.length(); i++)
			if (resstr.charAt(i) != ',')
				tmpstr = tmpstr + resstr.charAt(i);
		return tmpstr;
	}

	/******************************************************************
	 * 将String型Double数值四舍五入，返回String型
	 * 
	 * @param sDouble
	 * @param iDig
	 * @return
	 ******************************************************************/
	public String fmtdouble(String sDouble, int iDig) {
		double sourse = 0;
		if (sDouble == null)
			sDouble = "";
		if (sDouble.equals(""))
			sDouble = "0";
		try {
			sourse = Double.valueOf(sDouble).doubleValue();
		} catch (NumberFormatException e) {
			sourse = 0;
		}
		NumberFormat tmpformat = NumberFormat.getNumberInstance();
		String resstr = "";
		String tmpstr = "";
		tmpformat.setMinimumFractionDigits(iDig);
		tmpformat.setMaximumFractionDigits(iDig);
		resstr = tmpformat.format(sourse);
		for (int i = 0; i < resstr.length(); i++)
			if (resstr.charAt(i) != ',')
				tmpstr = tmpstr + resstr.charAt(i);
		return tmpstr;
	}

	/*******************************************************************
	 * 功能:将Double型数值四舍五入，返回String型，按千分位分割，即2,323,234,343,343.00 作者: lsx 最后更新:
	 * 
	 * @param dSource
	 * @param iDig
	 * @return
	 ******************************************************************/
	public String fmtKiloDouble(double dSource, int iDig) {
		NumberFormat tmpformat = NumberFormat.getNumberInstance();
		String resstr = "";
		tmpformat.setMinimumFractionDigits(iDig);
		tmpformat.setMaximumFractionDigits(iDig);
		resstr = tmpformat.format(dSource);
		return resstr;
	}

	/*******************************************************************
	 * 功能:将String型数值四舍五入，返回String型，按千分位分割，即2,323,234,343,343.00 作者: lsx 最后更新:
	 * 
	 * @param sDouble
	 * @param iDig
	 * @return
	 *******************************************************************/
	public String fmtKiloDouble(String sDouble, int iDig) {
		double sourse = 0;
		if (sDouble == null)
			sDouble = "";
		if (sDouble.equals(""))
			sDouble = "0";
		try {
			sourse = Double.valueOf(sDouble).doubleValue();
		} catch (NumberFormatException e) {
			sourse = 0;
		}
		NumberFormat tmpformat = NumberFormat.getNumberInstance();
		String resstr = "";
		tmpformat.setMinimumFractionDigits(iDig);
		tmpformat.setMaximumFractionDigits(iDig);
		resstr = tmpformat.format(sourse);
		return resstr;
	}

	public String fmtdouble(double sourse) {
		return fmtdouble(sourse, 2);
	}

	/*******************************************************************
	 * 将double型数值变为百分数
	 * 
	 * @param sDouble
	 * @return
	 *******************************************************************/
	public String fmtbecomePercent(double sDouble) {
		String resstr = "";
		try {
			NumberFormat tmpformat = NumberFormat.getPercentInstance();
			resstr = tmpformat.format(sDouble);
		} catch (Exception e) {
			System.out.println("fmtbecamepercent:" + e);
		}
		return resstr;
	}

	/*********************************************************************
	 * 删除目录
	 * 
	 * @param String
	 *            sPath:要删除的目录名
	 * @author lsx
	 ********************************************************************/
	public static void Deldir(String sPath) {
		String sFilepath = "";
		// String sFilename = "";
		File oFile = null, oTmpFile = null;
		File oFiles[] = null;
		int iCount = 0, i = 0;
		try {
			oFile = new File(sPath);
			if (!oFile.exists())
				return;
			oFiles = oFile.listFiles();
			iCount = oFiles.length;
			for (i = 0; i < iCount; i++) {
				oTmpFile = oFiles[i];
				if (oTmpFile.isFile())
					try {
						oTmpFile.delete();
					} catch (Exception exc) {

					}
				else if (oTmpFile.isDirectory()) {
					sFilepath = oTmpFile.getAbsolutePath();
					Deldir(sFilepath);
				} else
					try {
						oTmpFile.delete();
					} catch (Exception exc) {

					}
			}
			oFile.delete();
		} catch (Exception exc) {

		}
	}

	/*********************************************************************
	 * 功能：字符串编码转换
	 * 
	 * @param sConvert
	 *            :要转换的字符串
	 * @param 返回
	 *            ：返回转换后的字符串 Date Author Changes 2003/06/06 lsx Created
	 ********************************************************************/
	public static String charsetConvert(String sConvert) {
		String bRet = "";
		try {
			bRet = new String(sConvert.getBytes("ISO-8859-1"), "UTF-8");
			// bRet=sConvert;
		} catch (Exception e) {
			bRet = sConvert;
		}
		return bRet;
	}

	/*********************************************************************
	 * 功能：字符串编码转换
	 * 
	 * @param sConvert
	 *            :要转换的字符串数组
	 * @param 返回
	 *            ：返回转换后的字符串数组 Date Author Changes 2003/06/06 lsx Created
	 ********************************************************************/
	public static String[] charsetConvert(String[] sConvert) {
		String[] sRet = sConvert;
		try {
			for (int i = 0; i < sRet.length; i++)
				sRet[i] = new String(sConvert[i].getBytes("ISO-8859-1"), "UTF-8");
		} catch (Exception e) {
			sRet = sConvert;
		}
		return sRet;
	}

	/*********************************************************************
	 * 功能：判断传入的日期是否合法
	 * 
	 * @param sDate
	 *            :要校验的日期 返回：判断传入的日期是否合法 Date Author Changes 2003/06/06 lsx
	 *            Created
	 ********************************************************************/
	public static String ValidateDate(String sDate) throws Exception {
		String sRetDate = "";
		Exception e = null;

		try {
			sDate = sDate.trim();
			if (sDate.compareTo("") != 0 && sDate.length() != 10 && sDate.length() != 8) {
				e = new Exception("请正确输入日期,如2002-01-01，或20020101！");
				throw e;
				// return sRetDate;
			}
			sRetDate = sDate;
			if (sDate.length() == 8)
				sRetDate = sDate.substring(0, 4) + "-" + sDate.substring(4, 6) + "-" + sDate.substring(6, 8);
			// 判断日期格式是否合法
			java.util.Date TempDate = null;
			try {
				TempDate = java.sql.Date.valueOf(sRetDate);
			} catch (Exception exc) {
				exc = new Exception("请正确输入日期,如2002-01-01，或20020101！");
				throw exc;
			}

			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
			sRetDate = formatter.format(TempDate);

			int year, month, day;
			year = Integer.parseInt(sRetDate.substring(0, 4));
			month = Integer.parseInt(sRetDate.substring(5, 7));
			day = Integer.parseInt(sRetDate.substring(8, 10));
			if (month == 4 || month == 6 || month == 9 || month == 11)
				if (day > 30) {
					e = new Exception(String.valueOf(year) + "年的" + String.valueOf(month) + "月份的日期不能大于" + String.valueOf(day));
					throw e;
				}
			if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
				if (month == 2)
					if (day > 29) {
						e = new Exception(String.valueOf(year) + "年的2月份的日期不能大于" + String.valueOf(day));
						throw e;
					}
			} else if (month == 2)
				if (day > 28) {
					e = new Exception(String.valueOf(year) + "年的2月份的日期不能大于" + String.valueOf(day));
					throw e;
				}

		} catch (Exception exc) {
			throw exc;
		}
		return sRetDate;
	}

	/*********************************************************************
	 * 取子串操作函数
	 * 
	 * @param sourceString
	 * @param start
	 * @param end
	 * @param interval
	 * @return
	 ********************************************************************/
	public static String getString(String sourceString, int start, int end, String interval) {
		// as the return value of Function sGetString()
		String resultString = new String();
		// the real start and end position of the retrived substring in the
		// specified source String
		int startPosition, endPosition;
		// as recurrence variable for searching for the real start position of
		// the retrived substring in the specified source String
		int count;
		// the length of the interval string
		int overlap = interval.length();
		// look up the real start position of the retrived substring in the
		// specified source String
		for (count = 0, startPosition = 0; count < start; count++) {
			startPosition = sourceString.indexOf(interval, startPosition);
			// start position beyond the mark,return empty string
			if (startPosition == -1)
				return resultString;
			else
				startPosition = startPosition + overlap;
		}
		endPosition = sourceString.indexOf(interval, startPosition);
		// retrieve the last substring of the specified source string
		if (endPosition == -1)
			resultString = sourceString.substring(startPosition);
		else
			resultString = sourceString.substring(startPosition, endPosition);
		return resultString;
	}

	/*********************************************************************
	 * 产生一个唯一ID值
	 * 
	 * @return
	 ********************************************************************/
	public static synchronized String getID() {
		java.util.Date oToday;
		SimpleDateFormat oFormat;
		String id;
		startVaue++;
		startVaue = startVaue % 1000;
		java.text.DecimalFormat format = new java.text.DecimalFormat("000");

		String sStartVaue = format.format(startVaue);
		oToday = new Date();
		oFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String sDate = oFormat.format(oToday);
		id = sDate + sStartVaue;
		return id;
	}

	/**
	 * @function 取得当前年份的字符串，yyyy
	 * @return
	 * @throws Exception
	 */
	public static String getYear() {
		String sDate = "";

		Date oExcuteTime = new Date();
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy");
		sDate = formatter.format(oExcuteTime);

		return sDate;
	}

	public static String StrNullConvert(Object obj) {

		if (null == obj)
			return "";
		else
			return obj.toString().trim();
	}

	/**
	 * @desc 对象强转数字
	 * @param o
	 *            某对象
	 * @return 转换后结果
	 */
	public static int parseToNum(Object o) {
		try {
			return Integer.parseInt(StrNullConvert(o));
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static float parseToFloat(Object o) {
		try {
			return Float.parseFloat(StrNullConvert(o));
		} catch (NumberFormatException e) {
			return 0F;
		}
	}

	public static double parseToDouble(Object o) {
		try {
			return Double.parseDouble(StrNullConvert(o));
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static boolean parseToBoolean(Object o) {
		return Boolean.parseBoolean(CommonFun.StrNullConvert(o));
	}

	@SuppressWarnings("unused")
	public static String ISOToNative(String str) {

		String sRtn = "";
		try {
			if (sRtn == null)
				return null;
			sRtn = new String(str.getBytes("ISO8859_1"), "UTF-8");
		} catch (Exception e) {

		}
		return sRtn;

	}

	@SuppressWarnings("unused")
	public static String NativeToISO(String str) {
		String sRtn = "";
		try {
			if (sRtn == null)
				return null;
			sRtn = new String(str.getBytes("UTF-8"), "ISO8859_1");
		} catch (Exception e) {

		}
		return sRtn;
	}

	/**
	 * 删除文件，同时父目录无文件时也删除
	 * 
	 * @param str
	 *            文件全路径
	 */
	public static void DelFileAndClearPath(String str) {
		String sUpPath = "";
		try {
			String sSeparator = System.getProperty("file.separator");

			File oFile = new File(str);
			if (oFile.isFile()) {
				oFile.delete();
				sUpPath = str.substring(0, str.lastIndexOf(sSeparator));
				DelFileAndClearPath(sUpPath);
			} else if (oFile.isDirectory())
				if (oFile.listFiles().length < 1) {
					oFile.delete();
					sUpPath = str.substring(0, str.lastIndexOf(sSeparator));
					DelFileAndClearPath(sUpPath);
				}
		} catch (Exception e) {

		}
		return;
	}

	/**
	 * 补齐字符串至指定长度（空格补齐）
	 * 
	 * @param src
	 * @param length
	 * @return
	 * @throws java.lang.Exception
	 */
	public static String FormatLengthString(String src, long length) throws Exception {
		String sRtn = src;

		sRtn = FormatLengthString(src, length, " ");

		return sRtn;
	}

	/**
	 * 补齐字符串至指定长度（指定字符）
	 * 
	 * @param src
	 * @param length
	 * @param format
	 * @return
	 * @throws java.lang.Exception
	 */
	public static String FormatLengthString(String src, long length, String fmtchar) throws Exception {
		String sRtn = src;
		String tmp = "";
		long srclen = 0;
		long formatlen = 0;

		if (src != null) {
			srclen = src.length();
			tmp = src;
		}

		formatlen = length - srclen;

		for (long i = 0; i < formatlen; i++)
			tmp = tmp + fmtchar;

		sRtn = tmp;

		return sRtn;
	}

	/**
	 * @function 取得当前时间的字符串，yyyyMMdd
	 * @return
	 * @throws Exception
	 */
	public static String getCurDate() {
		String sDate = "";

		Date oExcuteTime = new Date();
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
		sDate = formatter.format(oExcuteTime);
		return sDate;
	}

	/**
	 * @function 取得当前时间的字符串 格式为yyyy-MM-dd hh:mm:ss
	 * @return
	 * @throws Exception
	 */
	public static String getCurTime() {
		String sDate = "";

		Date oExcuteTime = new Date();
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sDate = formatter.format(oExcuteTime);
		return sDate;
	}

	/**
	 * @function 取得当前时间的字符串 格式为yyyy-MM-dd hh:mm:ss.SSS
	 * @return
	 * @throws Exception
	 */
	public static String getCurTime3() {
		String sDate = "";

		Date oExcuteTime = new Date();
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		sDate = formatter.format(oExcuteTime);
		return sDate;
	}

	/**
	 * @function 取得当前时间的字符串 默认格式为yyyy-MM-dd HH:mm:ss
	 * @param iDays
	 *            可以是负数,负数代表距离今天几天以前的时间,正数代表距离今天几天以后的时间
	 * @param pattern
	 *            标示时间格式
	 * @return
	 * @throws Exception
	 */
	public static String getDateBydays(int iDays, String pattern) {
		String sDate = "";
		String sPatten = "";
		if ("".equalsIgnoreCase(pattern))
			sPatten = "yyyy-MM-dd HH:mm:ss";
		else
			sPatten = pattern;
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(sPatten);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, iDays);
		sDate = formatter.format(cal.getTime());
		return sDate;

	}

	/**
	 * @function 取得当前时间的字符串 默认格式为yyyy-MM-dd HH:mm:ss
	 * @param iDays
	 *            可以是负数,负数代表距离今天几天以前的时间,正数代表距离今天几天以后的时间
	 * @param pattern
	 *            标示时间格式
	 * @return
	 * @throws Exception
	 */
	public static String getAddDateBydays(int iDays, String date) {
		String sDate = "";
		try {
			date = date.replaceAll("  ", " ");
			Calendar c = Calendar.getInstance();
			c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date));
			c.add(Calendar.SECOND, iDays);
			java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sDate = formatter.format(c.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sDate;
	}

	/**
	 * @function 取得当前时间的字符串，yyyyMMddhhmmss
	 * @return
	 * @throws Exception
	 */
	public static String getCurTime2() {
		String sDate = "";

		Date oExcuteTime = new Date();
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMddhhmmss");
		sDate = formatter.format(oExcuteTime);
		return sDate;
	}

	/**
	 * 获取当前系统时间
	 * 
	 * @return
	 */
	public static Calendar getSystemTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal;
	}

	/**
	 * @Description:空值转化
	 * @return String
	 */
	public static String isNull(Object obj) {
		if (obj == null)
			return "";
		else
			return (String) obj;
	}

	/**
	 * @Description:空值转化
	 * @return String
	 */
	public static String nullFormat(Object obj) {
		if (obj == null || "".equals(obj))
			return "无";
		else
			return (String) obj;
	}

	// 将 s 进行 base64 编码
	public static String encodeBase64(byte[] b) {
		if (b == null)
			return null;
		return new String(Base64.encodeBase64(b));
	}

	// 将String转换成yyyy-mm-dd hh:mm:ss 如果小于14位返回空
	public static String stringtodatetime(String datetime) {
		String datetimetem = "";
		if (datetime.length() > 14)
			datetimetem = datetime.substring(0, 4) + "-" + datetime.substring(4, 6) + "-" + datetime.substring(6, 8) + " " + datetime.substring(8, 10) + ":"
					+ datetime.substring(10, 12) + ":" + datetime.substring(12, 14);
		return datetimetem;
	}

	/**
	 * 捕捉回车符号
	 * 
	 * @param catched
	 *            要捕捉的字符
	 * @param replaced
	 *            　替换的字符
	 * @param noted
	 *            　文本内容
	 * @return
	 * @author Joe_zhang
	 */
	public static String catchEnter(String catched, String replaced, String noted) {
		Matcher match = null;
		// Pattern patten = Pattern.compile("\r");
		Pattern patten = Pattern.compile(catched);
		StringBuffer sb = new StringBuffer();
		match = patten.matcher(noted);
		boolean result = match.find();
		// 使用循环将句子里所有的catched找出并替换再将内容加到sb里
		while (result) {
			match.appendReplacement(sb, replaced);
			// 继续查找下一个匹配对象
			result = match.find();
		}
		// 最后调用appendTail()方法将最后一次匹配后的剩余字符串加到sb里；
		match.appendTail(sb);
		noted = sb.toString();
		return noted;
	}

	/**
	 * 格式化数字，为空时设值为0
	 * 
	 * @param i
	 *            要格式化的字符
	 * @return
	 * @author xyhe
	 */
	public static int fmtInt(String str) {
		int flag = 0;
		if (str == null || "".equals(str))
			return flag;
		else
			return Integer.parseInt(str);
	}

	/*
	 * <p>功能:格式化日期</p> <p>作者: xyhe</p> <p>最后更新:20081015</p>
	 * 
	 * @param
	 * 
	 * @param 输入:
	 * 
	 * @param date -要格式化的日期
	 * 
	 * @param i -格式化类型:1:yyyy-mm-dd,2:yyyy-mm-dd hh:mm:ss 3:HH:mm:ss 默认为1
	 */
	public static String fmtDate(String date, int i) throws Exception {
		String sRet = "";
		java.text.SimpleDateFormat formatter;

		if (i == 2)
			formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		else if (i == 1)
			formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		else if (i == 3)
			formatter = new java.text.SimpleDateFormat("HH:mm:ss");
		else
			formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		sRet = formatter.format(date);

		return sRet;

	}

	/*
	 * <p>功能:格式化日期</p> <p>作者: xyhe</p> <p>最后更新:20081015</p>
	 * 
	 * @param
	 * 
	 * @param 输入:
	 * 
	 * @param date -要格式化的日期
	 * 
	 * @param i -格式化类型:1:yyyy-mm-dd,2:yyyy-mm-dd hh:mm:ss 3:HH:mm:ss 默认为1
	 */
	public static Date fmtStrtoDate(String date, int i) throws Exception {
		Date sRet = null;
		java.text.SimpleDateFormat formatter;

		if (i == 2)
			formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		else if (i == 1)
			formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		else if (i == 3)
			formatter = new java.text.SimpleDateFormat("HH:mm:ss");
		else
			formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		sRet = formatter.parse(date);
		return sRet;
	}

	/**
	 * 获取2日期之间的所有周日,周六的list
	 *
	 * @param startday
	 *            格式yyyy-MM-dd
	 * @param endday
	 *            格式yyyy-MM-dd
	 * @return list(String(格式yyyyMMdd))
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List getWeekEndDayS(String startday, String endday) {
		List list = new ArrayList();
		String[] sd = startday.split("-");
		String[] ed = endday.split("-");

		Calendar scal = new GregorianCalendar(Integer.parseInt(sd[0]), Integer.parseInt(sd[1]) - 1, Integer.parseInt(sd[2]));
		Calendar ecal = new GregorianCalendar(Integer.parseInt(ed[0]), Integer.parseInt(ed[1]) - 1, Integer.parseInt(ed[2]));
		int i = 0;
		SimpleDateFormat simformat = new SimpleDateFormat("yyyyMMdd");
		while (scal.compareTo(ecal) <= 0) {
			int week = scal.get(Calendar.DAY_OF_WEEK);
			if (week == 7) {
				list.add(simformat.format(scal.getTime()));
				i++;
			} else if (week == 1) {
				list.add(simformat.format(scal.getTime()));
				i += 6;
			} else
				i++;
			scal = new GregorianCalendar(Integer.parseInt(sd[0]), Integer.parseInt(sd[1]) - 1, Integer.parseInt(sd[2]) + i);
		}

		return list;
	}

	/**
	 * 授信－持卡记录－》前24期最高延滞期数 取24个数字、字母按以下优先级从低到高F\C\Z\0\1\2\3\4\5\6\7\8\9，取最高的
	 */
	public static String getHeightLaste(String str) {
		String tt = "";
		String myStr = "9,8,7,6,5,4,3,2,1,0,Z,C,F";
		String[] iStr = myStr.split(",", -1);
		for (int i = 0; i < iStr.length; i++)
			if (str.indexOf(iStr[i]) != -1) {
				tt = iStr[i];
				break;
			}
		return tt;
	}

	/**
    *
    */
	public static String getEID() {
		String EID = "";
		EID = getID();
		if (EID.length() > 4)
			EID = EID.substring(4, EID.length());
		return EID;
	}


	/**
	 * 根据条形码 生成 in 限制条件
	 * 
	 * @param set
	 *            字符串集合
	 * @return in 限制条件
	 */
	public static String listToInSql(Collection<?> set, String column) {
		StringBuffer sb = new StringBuffer(150);
		sb.append(" ").append(column);
		sb.append(" IN(");
		int i = 0;
		int size = set.size();
		for (Object str : set) {

			i++;
			int f = i % 900;
			if (f == 0 && i != size) {
				sb.append("'").append((String) str).append("') or ");
				sb.append(column).append(" IN(");
			} else if (i == size)
				sb.append("'").append((String) str).append("')");
			else
				sb.append("'").append((String) str).append("',");
		}
		return sb.toString();
	}

	public static String listToNotInSql(Collection<?> set, String column) {
		StringBuffer sb = new StringBuffer(150);
		sb.append(" ").append(column);
		sb.append(" NOT IN(");
		int i = 0;
		int size = set.size();
		for (Object str : set) {

			i++;
			int f = i % 900;
			if (f == 0 && i != size) {
				sb.append("'").append((String) str).append("') or ");
				sb.append(column).append(" NOT IN(");
			} else if (i == size)
				sb.append("'").append((String) str).append("')");
			else
				sb.append("'").append((String) str).append("',");
		}
		return sb.toString();
	}

	public static boolean isNullObj(Object obj) {
		if (obj instanceof String) {
			if (obj == null || "".equals(obj.toString().trim()))
				return true;
		} else if (obj == null)
			return true;
		return false;

	}

	public static Object deepClone(Object o) throws IOException, ClassNotFoundException {
		Object temp = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(o);
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		temp = ois.readObject();
		ois.close();
		bis.close();
		oos.close();
		bos.close();
		return temp;
	}

	/**
	 * Map比较 两对象是否完全相等
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List checkMap(HashMap oldMap, HashMap newMap) throws Exception {
		List list = new ArrayList();

		if (oldMap == null || newMap == null)
			throw new Exception("传入的Map值为空");

		Iterator it = oldMap.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			if (!CommonFun.StrNullConvert(oldMap.get(key)).equals(CommonFun.StrNullConvert(newMap.get(key))))
				list.add(key);
		}
		return list;
	}

	/**
	 * 判断是否全部为空值
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List testAllValue(HashMap valueMap) throws Exception {
		List list = new ArrayList();

		if (valueMap == null)
			throw new Exception("传入的Map值为空");

		Iterator it = valueMap.keySet().iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			if (!valueMap.get(key).equals(""))
				list.add(key);
		}
		return list;
	}

	/**
	 * 身份证转换
	 * 
	 * @param sourceID
	 * @return
	 */
	public static String transID(String sourceID) {
		if (sourceID != null)
			try {
				if (sourceID.length() == 15)
					return transID15to18(sourceID);
				else if (sourceID.length() == 18)
					return transID18to15(sourceID);
				else
					return sourceID;
			} catch (Exception e) {
				System.out.println(e.getMessage());
				return sourceID;
			}
		else
			return "";
	}

	/**
	 * 身份证18转15位
	 * 
	 * @param id18
	 * @return
	 * @throws Exception
	 */
	public static String transID18to15(String ID18) throws Exception {
		if (null == ID18 || ID18.length() != 18)
			throw new Exception("传入的身份证号码不是18位");
		return ID18.substring(0, 6) + ID18.substring(8, 17);
	}

	/**
	 * 身份证15转18位
	 * 
	 * @param ID15
	 * @return
	 * @throws Exception
	 */
	public static String transID15to18(String ID15) throws Exception {
		if (null == ID15 || ID15.length() != 15)
			throw new Exception("传入的身份证号码不是15位");
		final int[] W = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
		final String[] A = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
		int i, j, s = 0;
		String ID18;
		ID18 = ID15.substring(0, 6) + "19" + ID15.substring(6, ID15.length());
		for (i = 0; i < ID18.length(); i++) {
			j = Integer.parseInt(ID18.substring(i, i + 1)) * W[i];
			s = s + j;
		}
		s = s % 11;
		ID18 = ID18 + A[s];
		return ID18;
	}

	public static String cutWord(String cardName, int count) {
		if (cardName.length() > count)
			return cardName.substring(0, count + 1);
		else
			return cardName;
	}

	/**
	 * 去掉LIST中的空项
	 * 
	 * @param list
	 * @return
	 */
	public static List<String> filtrateList(List<String> list) {
		List<String> tempList = new ArrayList<String>();
		for (String obj : list)
			if (!StrNullConvert(obj).equals(""))
				tempList.add(obj);
		return tempList;
	}

	/**
	 * 获得字串中中文字符个数
	 * 
	 * @param str
	 * @return
	 */
	public static int chineseNum(String str) {
		if (str == null || str.trim().equals(""))
			return 0;
		int countChinese = 0;
		String expr1 = "[\u4e00-\u9fa5]+";
		for (int i = 0; i < str.length(); i++)
			if (str.substring(i, i + 1).matches(expr1))
				countChinese++;
		return countChinese;
	}

	/**
	 * 根据中文个数获得中文域字符串长度
	 * 
	 * @param str
	 * @param chineseNum
	 * @return
	 */
	public static int getChineseLength(String str) {
		if (str == null || str.trim().equals(""))
			return 0;
		int chineseNum = chineseNum(str);
		int chineseLength = 0;
		int str_length = str.length();
		chineseLength = (str_length - chineseNum) + (chineseNum * 6);
		return chineseLength;
	}

	public static String clearNull(String paramString) {
		if ((paramString == null) || (paramString.trim().length() == 0) || (paramString.trim().equals("null"))) {
			return "";
		}
		return paramString.trim();
	}
	
	
	@SuppressWarnings("rawtypes")
	public static String getMapValue(String key, Map map) {
		String value = "";
		if ("".equals(clearNull(map.get(key)))) {
			value = clearNull(map.get(key.toLowerCase()));
			if ("".equals(value)) {
				value = clearNull(map.get(key.toUpperCase()));
			}
		} else {

			value = clearNull(map.get(key));
		}
		return value;
	}

	public static String clearNull(Object obj) {
		String paramString = String.valueOf(obj);
		if ((paramString == null) || (paramString.trim().length() == 0) || (paramString.trim().equals("null"))) {
			return "";
		}
		return paramString.trim();
	}

	/*********************************************************************
	 * 组装指定类的JSON字符串 author TNT_WL
	 * 
	 * @param Object
	 * @return String
	 ********************************************************************/
	public static String packageJson(Object obj) throws Exception {
		StringBuffer sb = new StringBuffer();
		Class<?> targit = obj.getClass();
		Field[] fields = targit.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			String name = fields[i].getName();
			String type = fields[i].getGenericType().toString();
			if ("class java.lang.String".equals(type)) {
				Method m = obj.getClass().getMethod("get" + (name.substring(0, 1).toUpperCase() + name.substring(1)));
				String value = (String) m.invoke(obj);
				if (null != value) {
					sb.append(value).append(",");
				}
			}
			if ("class java.lang.Integer".equals(type)) {
				Method m = obj.getClass().getMethod("get" + (name.substring(0, 1).toUpperCase() + name.substring(1)));
				Integer value = (Integer) m.invoke(obj);
				if (null != value) {
					sb.append(value).append(",");
				}
			}
			if ("class java.lang.Short".equals(type)) {
				Method m = obj.getClass().getMethod("get" + (name.substring(0, 1).toUpperCase() + name.substring(1)));
				Short value = (Short) m.invoke(obj);
				if (null != value) {
					sb.append(value).append(",");
				}
			}
			if ("class java.lang.Double".equals(type)) {
				Method m = obj.getClass().getMethod("get" + (name.substring(0, 1).toUpperCase() + name.substring(1)));
				Double value = (Double) m.invoke(obj);
				if (null != value) {
					sb.append(value).append(",");
				}
			}
			if ("class java.lang.Boolean".equals(type)) {
				Method m = obj.getClass().getMethod("get" + (name.substring(0, 1).toUpperCase() + name.substring(1)));
				Boolean value = (Boolean) m.invoke(obj);
				if (null != value) {
					sb.append(value).append(",");
				}
			}
			if ("class java.util.Date".equals(type)) {
				Method m = obj.getClass().getMethod("get" + (name.substring(0, 1).toUpperCase() + name.substring(1)));
				Date value = (Date) m.invoke(obj);
				if (null != value) {
					sb.append(value).append(",");
				}
			}

		}
		return sb.substring(0, sb.lastIndexOf(","));
	}

	/*********************************************************************
	 * 组装指定集合（元素为Collection）的JSON字符串 author TNT_WL
	 * 
	 * @param Object
	 * @return String
	 ********************************************************************/
	public static void packageJson(Collection<String> params, StringBuffer sb) {
		Collection<String> c = params;
		Iterator<String> it = c.iterator();
		while (it.hasNext()) {
			sb.append(it.next());
			sb.append(",");
		}
	}

	public static String packageJson(Map<String, String> map) {
		StringBuffer sb = new StringBuffer();
		String str = sb.append(map.entrySet()).toString();
		return str.substring((str.indexOf("[") + 1), str.indexOf("]"));
	}

	/*********************************************************************
	 * 首字母大写 author TNT_WL
	 * 
	 * @param String
	 * @return String
	 ********************************************************************/
	public static String upcaseFirst(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/*********************************************************************
	 * 分割字符为数组
	 ********************************************************************/
	public static String[] getArray(String str, String splitStr) {
		if (str.indexOf(splitStr) != -1) {
			return str.split(splitStr);
		}
		return new String[] { str };
	}

	/*********************************************************************
	 * 打印指定类的所有属性及其数据
	 ********************************************************************/
	public static void printObjectInfo(Object obj) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Class<?> cls = obj.getClass();
		Field[] fields = cls.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			String type = fields[i].getGenericType().toString();
			if ("class java.lang.String".equals(type)) {
				Method m = cls.getMethod("get" + upcaseFirst(fields[i].getName()));
				String value = (String) m.invoke(obj);
				System.out.println(value);
			}
			if ("class java.lang.Integer".equals(type)) {
				Method m = cls.getMethod("get" + upcaseFirst(fields[i].getName()));
				Integer value = (Integer) m.invoke(obj);
				System.out.println(value);
			}
			if ("class java.lang.Double".equals(type)) {
				Method m = cls.getMethod("get" + upcaseFirst(fields[i].getName()));
				Double value = (Double) m.invoke(obj);
				System.out.println(value);
			}
		}
	}

	/*********************************************************************
	 * 打印指定集合的所有属性及其数据
	 ********************************************************************/

	public static void printListInfo(List<?> list) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		for (int i = 0; i < list.size(); i++) {
			printObjectInfo(list.get(i));
		}
	}

	/*********************************************************************
	 * 设置联名人的bean的值 author TNT_WL
	 * 
	 * @param Object
	 *            空对象
	 * @param Object
	 *            装载值的对象
	 * @param String
	 *            设置字段
	 * @return
	 ********************************************************************/
	public static void setParams(Object targitObj, Object paramObj, String params) throws SecurityException, NoSuchFieldException, NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		String[] str = getArray(params, ",");
		for (int i = 0; i < str.length; i++) {
			Field field = targitObj.getClass().getDeclaredField((str[i].contains("unoin_") ? str[i].substring(str[i].indexOf("_") + 1) : str[i]));
			field.setAccessible(true);
			Method m = paramObj.getClass().getMethod("get" + upcaseFirst(str[i]));
			field.set(targitObj, m.invoke(paramObj));
		}
	}

	/**
	 * 验证插入数据库的返回值 此方法可通用 如果参数不够直接装进最后一个参数
	 * */
	public static boolean verifyFlag(int flag1, int flag2, int flag3, int flag4, int[] flagArray) {
		boolean flag = false;
		if (flagArray.length != 1) {
			for (int i = 0; i < flagArray.length; i++) {
				if (flagArray[i] < 1) {
					return flag;
				}
			}
		}
		if (flag1 > 0 && flag2 > 0 && flag3 > 0 && flag4 > 0) {
			flag = true;
			return flag;
		}
		return flag;
	}

	/** 获取系统当前日期 */
	public static String GetNowDate() {
		String temp_str = "";
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		temp_str = sdf.format(dt);
		return temp_str;
	}

	/** 获取系统当前日期 */
	public static String GetNowDate(int flag) {
		String temp_str = "";
		Date dt = new Date();
		SimpleDateFormat sdf = null;
		if (flag == 1) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			temp_str = sdf.format(dt);
		} else if (flag == 2) {
			sdf = new SimpleDateFormat("yyyy/MM/dd");
			temp_str = sdf.format(dt);
		}

		return temp_str;
	}

	public static String GetNowDetailDate() {
		String temp_str = "";
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		temp_str = sdf.format(dt);
		return temp_str;
	}

	/**
	 * <LMH> 返回 页面显示的JSONObject 此方法遍历实体类所有属性， 对于常用的java包装类类型,
	 * 输出其属性值，如果有其它类型，则需自己扩展。 Map<key,value> key=字段名,value=字段对于的值
	 * 
	 * @param model
	 *            实体Bean
	 * @throws Exception
	 */
	public static Object getJSONObjectData(Object model) throws Exception {
		Field field2 = null;
		Field[] field = model.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
		for (int j = 0; j < field.length; j++) { // 遍历所有属性
			String name = field[j].getName(); // 获取属性的名字
			field2 = field[j];
			String type = field[j].getGenericType().toString(); // 获取属性的类型
			if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
				Method m = model.getClass().getMethod("get" + name);
				String value = (String) m.invoke(model); // 调用getter方法获取属性值
				field2.set(name, value);
				continue;
			}
			if (type.equals("class java.lang.Integer")) {
				Method m = model.getClass().getMethod("get" + name);
				Integer value = (Integer) m.invoke(model);
				if (null == value) {
					field2.set(name, value);
				} else {
					field2.set(name, value);
				}
				continue;
			}
			if (type.equals("class java.lang.Short")) {
				Method m = model.getClass().getMethod("get" + name);
				Short value = (Short) m.invoke(model);
				if (null == value) {
					field2.set(name, value);
				} else {
					field2.set(name, value);
				}
				continue;
			}
			if (type.equals("double")) {
				Method m = model.getClass().getMethod("get" + name);
				Double value = (Double) m.invoke(model);
				if (value == 0.0) {
					field2.set(name, value);
				} else if (null == value) {
					field2.set(name, value);
				} else {
					field2.set(name, value);
				}
				continue;
			}
			if (type.equals("class java.lang.Double")) {
				Method m = model.getClass().getMethod("get" + name);
				Double value = (Double) m.invoke(model);
				if (value == 0.0) {
					field2.set(name, value);
				} else if (null == value) {
					field2.set(name, value);
				} else {
					field2.set(name, value);
				}
				continue;
			}
			if (type.equals("class java.lang.Boolean")) {
				Method m = model.getClass().getMethod("get" + name);
				Boolean value = (Boolean) m.invoke(model);
				field2.set(name, value);
				continue;
			}
			if (type.equals("class java.util.Date")) {
				Method m = model.getClass().getMethod("get" + name);
				Date value = (Date) m.invoke(model);
				if (null != value) {
					field2.set(name, value);
				} else {
					field2.set(name, value);
				}
				continue;
			}
		}
		return field2;
	}

	/**
	 * 获取SQL 中 (?) 值
	 * 
	 * @param obj
	 * @return
	 */
	public static String getObjParamValue(Object[] obj) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < obj.length; i++) {
			buffer.append(" (?值" + (i + 1) + ")= " + obj[i]);
		}
		return buffer.toString();

	}

	/**
	 * 转换日期格式 yyyy/MM/dd 为 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static String getDate(String dateStr, int flag) throws ParseException {
		if (flag == 1) {
			Date date = new SimpleDateFormat("yyyy/MM/dd").parse(dateStr);
			String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			return now;
		} else {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
			String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			return now;
		}

	}

	/*********************************************************************
	 * DoubleFormat 格式化 保留4位小数 后补0
	 * 
	 * @param Double
	 *            d
	 * @return String #.0000
	 ********************************************************************/
	public static String DoubleFormat(Double d) {
		DecimalFormat df = new DecimalFormat("#0.0000");
		return df.format(d);
	}

	/**
	 * @Title: getTimeMs
	 * @Description: 将服务器时间 时和分转换成秒数
	 * @return
	 * @throws ParseException
	 */
	public static Long getTimeMs() throws ParseException {
		Date oExcuteTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String str = sdf.format(oExcuteTime);
		String[] strarr = str.split(":");
		double d1 = Double.parseDouble(strarr[0]) * 3600;
		double d2 = Double.parseDouble(strarr[1]) * 60;
		BigDecimal b = new BigDecimal(d1 + d2);
		return b.longValue();
	}

	/**
	 * 
	 * @Title: subStringForDec
	 * @Description: 截取字符串 (.00,.10)
	 * @param str
	 * @return
	 */
	public static String subStringForDec(String str) {
		StringBuffer sb = new StringBuffer(str);
		int i = sb.length() - 1;
		int flag = 1;
		for (; i > 0 && flag == 1; i--) {
			String str2 = sb.substring(i, i + 1);
			if (str2.equals("0")) {
				sb.deleteCharAt(i);
				flag = 1;

			} else if (str2.equals(".")) {
				sb.deleteCharAt(i);
				flag = 0;
			} else {
				flag = 0;
			}
		}
		return sb.toString();
	}

	/**
	 * @Title: getInstrCondition
	 * @Description: 字段模糊匹配,效率比like '%%'高
	 * @param column
	 *            字段名
	 * @param value
	 *            传入的值 以,分割
	 * @return 返回条件 instr(column,'value')>0 or instr(column,'value')>0 or
	 *         instr(column,'value')>0 为空就不需要关联查询
	 * @author： 隆美华
	 * @date： 2013-12-26下午7:23:39
	 */
	public static String getInstrCondition(String column, String value, String splitVar) {
		StringBuffer stringBuffer = new StringBuffer();
		if (!"".equals(CommonFun.clearNull(value))) {
			String splitStr[] = value.split(splitVar);
			for (int i = 0; i < splitStr.length; i++) {
				if (i == 0) {
					stringBuffer.append(" ( ");
				}
				if (splitStr.length == 1) {
					stringBuffer.append("instr(" + column + ",'" + splitStr[i] + "')>0");
				} else if ((i + 1) == splitStr.length) {
					stringBuffer.append("instr(" + column + ",'" + splitStr[i] + "')>0");
				} else {
					stringBuffer.append("instr(" + column + ",'" + splitStr[i] + "')>0").append(" or ");
				}
			}
			stringBuffer.append(" ) ");
		} else {
			stringBuffer.append(" ( 1=2 )");
		}
		return stringBuffer.toString();
	}

	/**
	 * 
	 * @Title: CommStringTo
	 * @Description: 解决Double.parseDouble(String str)str为null或""异常
	 * @param str
	 * @return
	 */
	public static String CommStringTo(String str) {
		if ("".equals(CommonFun.clearNull(str))) {
			return "0";
		} else {
			return str;
		}
	}

	/***
	 * @Title: clearObject
	 * @Description:释放对象
	 * @param obj
	 */
	public static void clearObject(Object obj) {
		if (null != obj) {
			if (obj instanceof List) {
				obj = null;
			} else if (obj instanceof Map) {
				obj = null;
			} else if (obj instanceof String) {
				obj = null;
			}
		}
	}

	/***
	 * 释放List资源
	 * 
	 * @param list
	 */
	@SuppressWarnings({ "rawtypes" })
	public static void clearList(List list) {
		if (null != list) {
			list.clear();
			list = null;
		}
	}

	/**
	 * 指定时间+月
	 * 
	 * @param month
	 * @param day
	 * @param partner
	 * @return
	 * @throws ParseException
	 */
	public static String getDayForMonth(int month, String day, String partner) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(partner);
		Date now = sdf.parse(day);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.MONTH, month);
		return sdf.format(calendar.getTime());
	}

	/** 下划线转驼峰 */
	public static String lineToHump(String str) {
		str = str.toLowerCase();
		Matcher matcher = Pattern.compile("_(\\w)").matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}
	
	/***
	 * 根据表名生产驼峰
	 */
	public static String createTableName(String table) {
		StringBuffer sc=new StringBuffer();
		  String[] className = table.toLowerCase().split("_");
		  for (String code : className)
		  {
		    if (code.length() > 1)
		      sc.append(code.substring(0, 1).toUpperCase() + code.substring(1, code.length()));
		    else {
		      sc.append(code.toUpperCase());
		    }
		  }
		  return sc.toString();
	}

	/***
	 * @Title: getEquals
	 * @Description:判断Map中重复相等个数
	 * @param @param map
	 * @param @return 参数
	 * @return int 返回类型
	 * @throws
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static int getMapEquals(Map map) {

		Map values = new HashMap();
		List list = new ArrayList();
		int count = 0;

		if (map != null && map.size() > 0) {
			Iterator iterator = map.keySet().iterator();
			while (iterator.hasNext()) {
				Object key = iterator.next();
				Object value = map.get(key);
				if (map.containsValue(value)) {
					if (values.containsKey(value)) {
						list = (List) values.get(value);
					} else {
						list = new ArrayList();
					}
					list.add(key);
					values.put(value, list);
				}
			}

			iterator = values.keySet().iterator();
			while (iterator.hasNext()) {
				Object value = iterator.next();
				List result = (List) values.get(value);
				if (result.size() > 1) {
					count = result.size();
				}
			}
		}

		return count;
	}

	public static List<Entry<String, Double>> getSortList(Map<String, Double> map) {
		List<Entry<String, Double>> list = new ArrayList<Entry<String, Double>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			// 升序排序
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		return list;
	}

	/***
	 * @Title: getRandomList
	 * @Description: 获取随机数
	 * @param @param userList
	 * @param @return 参数
	 * @return List 返回类型
	 * @throws
	 */
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	public static List getRandomList(List userList) {
//
//		List newUserList = new ArrayList();
//		for (Iterator iterator = userList.iterator(); iterator.hasNext();) {
//			Map useridMap = (Map) iterator.next();
//			String userid = (String) useridMap.get("userid");
//			Map map = new HashMap();
//			if (userid.startsWith("U.")) {
//				map.put("multeitFlag", useridMap.get("multeitFlag"));
//				map.put("username", useridMap.get("username"));
//				map.put("userid", useridMap.get("userid"));
//				newUserList.add(map);
//			}
//		}
//		userList = newUserList;
//		for (int i = 0; i < userList.size(); i++) {
//			Collections.shuffle(userList);
//			Object e = userList.get(0);
//			userList = new ArrayList();
//			userList.add(e);
//			break;
//		}
//		return userList;
//	}

	public static String getEncoding(String str) {
		String encode = "GB2312";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s = encode;
				return s;
			}
		} catch (Exception exception) {
		}
		encode = "ISO-8859-1";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s1 = encode;
				return s1;
			}
		} catch (Exception exception1) {
		}
		encode = "UTF-8";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s2 = encode;
				return s2;
			}
		} catch (Exception exception2) {
		}
		encode = "GBK";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s3 = encode;
				return s3;
			}
		} catch (Exception exception3) {
		}
		return "";
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}
	
	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate String
	 *            较小的时间
	 * @param bdate String
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysStringBetween(String smdate, String bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date smdate1 = sdf.parse(smdate);
		Date bdate1 = sdf.parse(bdate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate1);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate1);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	
	/**
	 * 计算两个日期之间相差的月份数
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int monthBetween(String date1, String date2) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//		String str1 = "2012-02";
//		String str2 = "2010-01";
		Calendar bef = Calendar.getInstance();
		Calendar aft = Calendar.getInstance();
		bef.setTime(sdf.parse(date1));
		aft.setTime(sdf.parse(date2));
		int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
		int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
		return Math.abs(month + result);
	}

	/***
	 * 字符串的日期格式的计算
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return
	 * @throws ParseException
	 */
	public static int daysBetween(String smdate, String bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 移除map中空key或者value空值
	 * 
	 * @param map
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void removeNullEntry(Map map) {
		removeNullKey(map);
		removeNullValue(map);
	}

	/**
	 * 移除map的空key
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> removeNullKey(Map<String, Object> map) {
		Set set = map.keySet();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Object obj = (Object) iterator.next();
			remove(obj, iterator);
		}
		return map;
	}

	
	/***
	 * requestParamtersMap:把请求参数转换为 Map对象 . <br/>
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @throws Exception 
	 * @since JDK 1.6
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, Object> requestParamtersMap(String request, String json) {
		Map map = new HashMap();
		try {
			Map<String, Object> paramters1 = CommonFun.removeNullValue(JSONUtils.getSingleInstance().readMapValue(request));
			map.putAll(paramters1);
			for (Map.Entry<String, Object> entry : paramters1.entrySet()) {
				map.put(entry.getKey().toLowerCase(), entry.getValue());
			}
			for (Map.Entry<String, Object> entry : paramters1.entrySet()) {
				map.put(entry.getKey().toUpperCase(), entry.getValue());
			}

			Map<String, Object> paramters2 = CommonFun.removeNullValue(JSONUtils.getSingleInstance().readMapValue(json));
			map.putAll(paramters2);
			for (Map.Entry<String, Object> entry : paramters2.entrySet()) {
				map.put(entry.getKey().toLowerCase(), entry.getValue());
			}
			for (Map.Entry<String, Object> entry : paramters2.entrySet()) {
				map.put(entry.getKey().toUpperCase(), entry.getValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	/***
	 * requestParamtersMap:把请求参数转换为 Map对象 . <br/>
	 * @author longmeihua
	 * @param request
	 * @param json
	 * @return
	 * @throws Exception 
	 * @since JDK 1.6
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map<String, Object> jsonToMap(String json) throws Exception {
		Map map = new HashMap();
		try {
			map.putAll(CommonFun.removeNullValue(JSONUtils.getSingleInstance().readMapValue(json)));
		} catch (Exception e) {
			throw e;
		}
		return map;
	}
	
	
	
	
	/**
	 * 移除map中的value空值
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, Object> removeNullValue(Map<String, Object> map) {
		Set set = map.keySet();
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			Object obj = (Object) iterator.next();
			Object value = (Object) map.get(obj);
			remove(value, iterator);
		}
		return map;
	}

	public static boolean isEmpty(Object obj) {
		if ("".equals(clearNull(obj))) {
			return true;
		}
		return false;

	}

	/**
	 * Iterator 是工作在一个独立的线程中，并且拥有一个 mutex 锁。 Iterator
	 * 被创建之后会建立一个指向原来对象的单链索引表，当原来的对象数量发生变化时，这个索引表的内容不会同步改变，
	 * 所以当索引指针往后移动的时候就找不到要迭代的对象，所以按照 fail-fast 原则 Iterator 会马上抛出
	 * java.util.ConcurrentModificationException 异常。 所以 Iterator
	 * 在工作的时候是不允许被迭代的对象被改变的。 但你可以使用 Iterator 本身的方法 remove() 来删除对象，
	 * Iterator.remove() 方法会在删除当前迭代对象的同时维护索引的一致性。
	 * 
	 * @param obj
	 * @param iterator
	 */
	@SuppressWarnings("rawtypes")
	private static void remove(Object obj, Iterator iterator) {
		if (obj instanceof String) {
			String str = (String) obj;
			if (isEmpty(str)) {
				iterator.remove();
			}
		} else if (obj instanceof Collection) {
			Collection col = (Collection) obj;
			if (col == null || col.isEmpty()) {
				iterator.remove();
			}

		} else if (obj instanceof Map) {
			Map temp = (Map) obj;
			if (temp == null || temp.isEmpty()) {
				iterator.remove();
			}

		} else if (obj instanceof Object[]) {
			Object[] array = (Object[]) obj;
			if (array == null || array.length <= 0) {
				iterator.remove();
			}
		} else {
			if (obj == null) {
				iterator.remove();
			}
		}
	}

	public static synchronized String getCurrentDate_yyyymmdd() {
		return new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
	}

	

	
	/***
	 * 根据传入参数 组装查询条件
	 * 
	 * @param paramterMap
	 *            传入参数
	 * @param paramter
	 *            组装 ？ 值
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void getCondition(Map<String, Object> paramterMap, List paramter, StringBuilder condition) throws Exception {

		if (paramterMap != null && paramterMap.size() > 0) {
			Iterator<Map.Entry<String, Object>> it = paramterMap.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, Object> entry = it.next();
				if (it.hasNext()) {
					condition.append(entry.getKey()).append(" =? ").append(" AND ");
					paramter.add(entry.getValue());
				} else {
					condition.append(entry.getKey() + " = ? ");
					paramter.add(entry.getValue());
				}
			}
		} else {
			throw new Exception(" 接口传入参数为空");
		}
	}

	

	/**
	 * <LMH> 根据javaBean对象返回 页面字段集合 此方法遍历实体类所有属性， 对于常用的java包装类类型,
	 * 输出其属性值，如果有其它类型，则需自己扩展。 Map<key,value> key=字段名,value=字段对于的值
	 * 
	 * @param model
	 *            实体Bean
	 * @throws Exception
	 */
	public static Map<String, String> getModeMap(Class<?> clzz) throws Exception {
		PropertyDescriptor destDescriptors[] = PropertyUtils.getPropertyDescriptors(clzz);
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < destDescriptors.length; i++) {
			String name = destDescriptors[i].getName().toUpperCase();
			if (name == null || "class".equals(name)) {
				continue;
			}
			map.put(name, name);
		}

		return map;
	}



	/**
	 * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
	 * 
	 * @param strxml
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map doXMLParse(String strxml) throws JDOMException, IOException {
		// strxml = strxml.replaceFirst("encoding=\".*\"",
		// "encoding=\"UTF-8\"");
		if (null == strxml || "".equals(strxml)) {
			return null;
		}
		Map map = new HashMap();
		InputStream in = new ByteArrayInputStream(strxml.getBytes("UTF-8"));
		SAXBuilder builder = new SAXBuilder();
		org.jdom.Document doc = builder.build(in);
		org.jdom.Element root = doc.getRootElement();
		List list = root.getChildren();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			org.jdom.Element e = (org.jdom.Element) it.next();
			String k = e.getName();
			String v = "";
			List children = e.getChildren();
			if (children.isEmpty()) {
				v = e.getTextNormalize();
			} else {
				CommonFun.getChildrenText(children, map);
			}
			map.put(k, v);
		}
		// 关闭流
		in.close();
		return map;
	}

	/**
	 * 获取子结点的xml
	 * 
	 * @param children
	 * @return String
	 */
	@SuppressWarnings({ "rawtypes" })
	public static Map getChildrenText(List children, Map<String, String> map) {
		StringBuffer sb = new StringBuffer();
		if (!children.isEmpty()) {
			Iterator it = children.iterator();
			while (it.hasNext()) {
				org.jdom.Element e = (org.jdom.Element) it.next();
				String name = e.getName();
				String value = e.getTextNormalize();
				List list = e.getChildren();
				if (!list.isEmpty()) {
					sb.append(CommonFun.getChildrenText(list, map));
				}
				map.put(name, value);
			}
		}

		return map;
	}

	/**
	 * MethodsTitle: 获取本机的IP
	 * 
	 * @version 1.0
	 */
	public static String getLoalhostIP() {
		String hostAddress = "";
		try {
			Enumeration<?> enumeration = NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			while (enumeration.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) enumeration.nextElement();
				Enumeration<?> addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					ip = (InetAddress) addresses.nextElement();
					System.out.println("服务地址:" + ip.getHostName());
					if (ip != null && ip instanceof Inet4Address) {
						String ip1 = ip.getHostAddress();
						if (!"127.0.0.1".equals(ip1) && !"localhost".equals(ip1)) {
							hostAddress = ip1;
							break;
						}
						System.out.println("本机所有的IP地址:" + ip1);
					}
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}

		return hostAddress;
	}

	/**
	 * 原map中的value是一个数组 将原map转换成key是原来的key value取数组的第一位的值的新map
	 * 
	 * @author liminxin
	 * @param map
	 *            是request.getParameterMap()获得
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String, Object> getMapFormParameterMap(Map map, String... arrName) throws Exception {
		Map<String, Object> valueMap = null;
		if (map != null) {
			valueMap = new HashMap();
			String key = null;
			String[] value = null;
			for (Iterator it = map.keySet().iterator(); it.hasNext();) {
				key = (String) it.next();
				value = (String[]) map.get(key);
				if (value != null) {
					// --判断当前key是否已数组的形式返回
					if (isInArr(arrName, key)) {
						valueMap.put(key, value);
					} else {
						if (value[0] != null) {
							valueMap.put(key, StrNullConvert(value[0]));
						} else {
							valueMap.put(key, "");
						}
					}
				} else {
					valueMap.put(key, "");
				}
			}
		}
		return valueMap;
	}

	private static boolean isInArr(String[] arrName, String key) {
		if (arrName == null) {
			return false;
		}
		for (String n : arrName) {
			if (key.equalsIgnoreCase(n)) {
				return true;
			}
		}
		return false;
	}
	

	
	
	/**
	 * List 数据去重
	 * @param list
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List removeDuplicateWithOrder(List list) {
		Set set = new HashSet();
		List newList = new ArrayList();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (set.add(element))
				newList.add(element);
		}
		return newList;
	}
	
	/**
	 * 计算执行时间
	 * 
	 * @param start
	 * @return 时间
	 */
/*	public static String calculation(long start) {
		String res = "";
		long time = System.currentTimeMillis() - start;
		if (time == 0)
			return "少于 1 毫秒";
		int d = (int) (time / (24 * 3600 * 1000));
		int h = (int) ((time / 3600000) % 24);
		int m = (int) ((time / 60000) % 60);
		int s = (int) ((time / 1000) % 60);
		int ms = (int) (time % 1000);
		
		res = (d > 0 ? d + " 天 " : "") + (h > 0 ? h + " 小时 " : "") + (m > 0 ? m + " 分 " : "") + (s > 0 ? s + " 秒 " : "") + (ms > 0 ? ms + " 毫秒" : "");
		return "当前系统时间:【"+dateLocalFormat(new Date(), 1)+"】  执行耗时 ：  "+res;
	}
*/	
	public static String calculation(long start) {
		String res = "";
		long time = System.currentTimeMillis() - start;
		if (time == 0)
			return "少于 1 毫秒";
		int d = (int) (time / (24 * 3600 * 1000));
		int h = (int) ((time / 3600000) % 24);
		int m = (int) ((time / 60000) % 60);
		int s = (int) ((time / 1000) % 60);
		int ms = (int) (time % 1000);

		res = (d > 0 ? d + " 天 " : "") + (h > 0 ? h + " 小时 " : "") + (m > 0 ? m + " 分 " : "") + (s > 0 ? s + " 秒 " : "") + (ms > 0 ? ms + " 毫秒" : "");
		return res;
	}
	
	/***
	 * getExceptionTrace:处理异常. <br/>
	 * @author longmeihua
	 * @param t
	 * @return
	 * @since JDK 1.6
	 */
	public static String getExceptionTrace(Throwable t) {
		StringWriter stringWriter 	= null;
		PrintWriter writer 			= null;
		StringBuffer buffer 		= null;
		try {
			stringWriter 	= new StringWriter();
			writer 			= new PrintWriter(stringWriter);
			t.printStackTrace(writer);
			buffer 			= stringWriter.getBuffer();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if (writer != null) {
				writer.close();
			}
			if (stringWriter != null) {
				try {
					stringWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return buffer.toString();
	}
}
