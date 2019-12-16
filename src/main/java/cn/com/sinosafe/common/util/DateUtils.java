/**   
* @Title:：DateUtils.java 
* @Package ：cn.com.sinosafe.common.util 
* @Description： TODO
* @author：xiewei
* @date： 2019年6月3日 下午2:49:09 
* @version ： 1.0   
*/
package cn.com.sinosafe.common.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.time.DateFormatUtils;

/** 
 * @ClassName:：DateUtils 
 * @Description： TODO
 * @author ：xiewei
 * @date ：2019年6月3日 下午2:49:09  
 */
	public class DateUtils extends org.apache.commons.lang3.time.DateUtils{

	    private static String[] parsePatterns = { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
	            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss",
	            "yyyy.MM.dd HH:mm", "yyyy.MM" };

	    /**
	     * 得到当前日期字符串 格式（yyyy-MM-dd HH:mm:ss）
	     */
	    public static String getDate() {
	        return getDate("yyyy-MM-dd HH:mm:ss");
	    }
	    /**
	     * 得到当前日期字符串 格式（yyyy-MM-dd）
	     */
	    public static String getDate1() {
	    	return getDate("yyyy-MM-dd");
	    }


	    /**
	     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	     */
	    public static String getDate(String pattern) {
	        return DateFormatUtils.format(new Date(), pattern);
	    }

	    /**
	     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	     */
	    public static String formatDate(Date date, Object... pattern) {
	        if (date == null) {
	            return null;
	        }
	        String formatDate = null;
	        if (pattern != null && pattern.length > 0) {
	            formatDate = DateFormatUtils.format(date, pattern[0].toString());
	        } else {
	            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
	        }
	        return formatDate;
	    }
	    /**
	     * yyyyMMdd字符串格式转为  yyyy-MM-dd格式
	     */
	    public static String formatDate1(String date){
	    	DateFormat format = new SimpleDateFormat("yyyyMMdd");         
	    	try {    
	    		Date date1 = format.parse(date); 
	    		return  DateFormatUtils.format(date1, "yyyy-MM-dd");
	    	} catch (ParseException e) {    
	    	    e.printStackTrace(); 
	    	    return null;
	    	}   
	    }

	    /**
	     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
	     */
	    public static String formatDateTime(Date date) {
	        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	    }

	    /**
	     * 得到当前时间字符串 格式（HH:mm:ss）
	     */
	    public static String getTime() {
	        return formatDate(new Date(), "HH:mm:ss");
	    }

	    /**
	     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	     */
	    public static String getDateTime() {
	        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	    }

	    /**
	     * 得到当前年份字符串 格式（yyyy）
	     */
	    public static String getYear() {
	        return formatDate(new Date(), "yyyy");
	    }

	    /**
	     * 得到当前月份字符串 格式（MM）
	     */
	    public static String getMonth() {
	        return formatDate(new Date(), "MM");
	    }

	    /**
	     * 得到当天字符串 格式（dd）
	     */
	    public static String getDay() {
	        return formatDate(new Date(), "dd");
	    }

	    /**
	     * 得到当前星期字符串 格式（E）星期几
	     */
	    public static String getWeek() {
	        return formatDate(new Date(), "E");
	    }

	    /**
	     * 日期型字符串转化为日期 格式
	     * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
	     * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
	     * "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
	     */
	    public static Date parseDate(Object str) {
	        if (str == null) {
	            return null;
	        }
	        try {
	            return parseDate(str.toString(), parsePatterns);
	        } catch (ParseException e) {
	            return null;
	        }
	    }

	    /**
	     * 获取过去的天数
	     *
	     * @param date
	     * @return
	     */
	    public static long pastDays(Date date) {
	        long t = new Date().getTime() - date.getTime();
	        return t / (24 * 60 * 60 * 1000);
	    }

	    /**
	     * 获得当前时间的字符串类型
	     * @return
	     */
	    public static String toStr() {
	        return toStr(new Date());
	    }

	    /**
	     * Date转成"yyyy-MM-dd HH:mm:ss"格式的字符串
	     * @param date
	     * @return
	     */
	    public static String toStr(Date date) {
	        return format(date, "yyyy-MM-dd HH:mm:ss");
	    }

	    /**
	     * 将一个 Date 格式化为日期/时间字符串
	     * @param date 要格式化为时间字符串的时间值
	     * @param pattern 日期和时间格式的模式
	     * @return 已格式化的时间字符串
	     */
	    public static String format(Date date, String pattern) {
	        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	        return sdf.format(date);
	    }
	    
	    public static String format2(Date date){
	    		return format(date, "yyyy年MM月dd日");
	    }
	    
	    public static String format2(String date,String pattern){
	    	DateFormat format = new SimpleDateFormat(pattern);         
	    	try {    
	    		Date date1 = format.parse(date); 
	    		return format(date1, "yyyy年MM月dd日");
	    	} catch (ParseException e) {    
	    	    e.printStackTrace(); 
	    	    return null;
	    	}   
	    }
	    
	    /**
	     * 获取过去的小时
	     *
	     * @param date
	     * @return
	     */
	    public static long pastHour(Date date) {
	        long t = new Date().getTime() - date.getTime();
	        return t / (60 * 60 * 1000);
	    }

	    /**
	     * 获取过去的分钟
	     *
	     * @param date
	     * @return
	     */
	    public static long pastMinutes(Date date) {
	        long t = new Date().getTime() - date.getTime();
	        return t / (60 * 1000);
	    }

	    /**
	     *  将毫秒值转换为时间（天,时:分:秒.毫秒）
	     *
	     * @param timeMillis
	     * @return
	     */
	    public static String formatDateTime(long timeMillis) {
	        long day = timeMillis / (24 * 60 * 60 * 1000);
	        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
	        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
	        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
	        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
	        return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
	    }

	    /**
	     * 获取两个日期之间的天数
	     *
	     * @param before
	     * @param after
	     * @return
	     */
	    public static double getDaysBetweenDate(Date before, Date after) {
	        return getMillisecBetweenDate(before,after) / (1000 * 60 * 60 * 24);
	    }

	/**
	 * 计算日期之间的天??
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public static long getDays(String startDate, String endDate) throws Exception
	{
		DateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date stDate = new java.util.Date();
		java.util.Date edDate = new java.util.Date();
		try
		{
			Calendar tempCal = Calendar.getInstance();
			tempCal.setTime(dt.parse(startDate));
			stDate = tempCal.getTime();
			tempCal.setTime(dt.parse(endDate));
			edDate = tempCal.getTime();
		}catch(ParseException e)
		{
			throw e;
		}
		return getDays(edDate, stDate);
	}

	/**
	 * 计算日期之间的天??
	 * @param dateOne
	 * @param dateTwo
	 * @return
	 */
	public static long getDays(Date dateOne, Date dateTwo)
	{
		long days = dateOne.getTime() - dateTwo.getTime();
		days = Math.abs(days) / (24 * 60 * 60 * 1000) + 1;
		return days;
	}

	    /**
	     * 获取两个日期之间的毫秒数
	     * @param before
	     * @param after
	     * @return
	     */
	    public static long getMillisecBetweenDate(Date before, Date after){
	        long beforeTime = before.getTime();
	        long afterTime = after.getTime();
	        return afterTime - beforeTime;
	    }

	    /**
	     * 获取当前月的第一天
	     * @return
	     */
	    public static String getFirstDayOfMonth() {
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	        //获取当前月第一天：
	        Calendar c = Calendar.getInstance();
	        c.add(Calendar.MONTH, 0);
	        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
	        String first = format.format(c.getTime());
	        return first;
	    }
	    
	    /**
	     * 获取指定日期当月的第一天
	     * @param currentDay
	     * @return
	     */
	     public static String getFirstDayOfCurrentDay(String currentDay){
	    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 			Date date = null;
			try {
				date = sdf.parse(currentDay);
			} catch (ParseException e) {
				e.printStackTrace();
			}
 			Calendar calendar = Calendar.getInstance();
 			calendar.setTime(date);
 			calendar.set(Calendar.DAY_OF_MONTH,1);
 			calendar.add(Calendar.MONTH, 0);
 			return sdf.format(calendar.getTime());
	 		
	     }
	    
	    /**
		 * 获取当月月末
		 * @Description
		 * @date 2019年9月27日  
		 * @return
		 */
	    public static String getLastDayOfMonth(){
	    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			try {
				calendar.setTime(format.parse(getDate1()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			return format.format(calendar.getTime());
		}
	    
	    /**
		 * 获取获取指定日期当月月末
		 * @Description
		 * @date 2019年9月27日  
		 * @return
		 */
	    public static String getLastDayOfCurrentDay(String currentDay){
	    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			try {
				calendar.setTime(format.parse(currentDay));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			return format.format(calendar.getTime());
		}
	    
	    /**
	     * 两个日期，取小值
	     * @param date1
	     * @param date2
	     * @return
	     */
	    public static String comparamDay(String date1,String date2){
			String calculateDate ="";//计算日期, T -1 与结算当月月末比较，取小值
			if(date1.compareTo(date2) > 0){
				calculateDate = date2;  
			}else if(date1.compareTo(date2) < 0){
				calculateDate = date1;
			}else{
				calculateDate = date2;
			}
			return calculateDate;
		}

	    /**
	     * 获得当前时间的时间戳
	     * @return
	     */
	    public static long getTimestamp() {
	        return new Date().getTime();
	    }

	    /**
	     * 
	    * 方法名: getDoubleType 
	    * 描述: 返回时间的 double 
	    * 参数: @param dateString
	    * 参数: @return
	    * 参数: @throws ParseException    设定文件 
	     */
	    public static double getDoubleType(String dateString) throws ParseException {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date date = sdf.parse(dateString);
	        return date.getTime();
	    }


	    /**
	     * 获得两个Date之间的秒数
	     * @param startTime 开始时间
	     * @param endTime   结束时间
	     * @return
	     */
	    public static int calLastedTime(Date startTime, Date endTime) {
	        long a = startTime.getTime();
	        long b = endTime.getTime();
	        int c = (int) ((a - b) / 1000);
	        return c;
	    }

	    /**
	     * 获取若干个小时之后的时间（字符串类型）
	     * @param startTime
	     * @param hours
	     * @return
	     */
	    public static String getPassHours(String startTime, int hours) {
	        // 获取一个小时以后的时间  
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        java.util.Date date = null;
	        try {
	            date = df.parse(startTime);
	        } catch (ParseException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(date);
	        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + hours);
	        return df.format(calendar.getTime());
	    }


	    /**
	     * "yyyy-MM-dd HH:mm:ss"格式的日期在若干天数后的时间（字符串）
	     * @param time
	     * @param days
	     * @return
	     */
	    public static String getAddDate(String time,int days) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        Date date = null;
	        try {
	            date = dateFormat.parse(time);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        } // 指定日期
	        Date newDate = null;
	        try {
	            newDate = addDate(date, days);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        } // 指定日期加上20天
	        String st = dateFormat.format(newDate);
	        return st;
	    }
	    /**
	     * "yyyy-MM-dd HH:mm:ss"格式的日期在若干天数后的时间（字符串）
	     * @param time
	     * @param days
	     * @return
	     */
	    public static String getAddDate1(String time,int days) {
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    	Date date = null;
	    	try {
	    		date = dateFormat.parse(time);
	    	} catch (ParseException e) {
	    		e.printStackTrace();
	    	} // 指定日期
	    	Date newDate = null;
	    	try {
	    		newDate = addDate(date, days);
	    	} catch (ParseException e) {
	    		e.printStackTrace();
	    	} // 指定日期加上20天
	    	String st = dateFormat.format(newDate);
	    	return st;
	    }
	    
	    /**
	     * 指定时间在若干天后的时间
	     * @param date
	     * @param day
	     * @return
	     * @throws ParseException
	     */
	    public static Date addDate(Date date,long day) throws ParseException {
	        long time = date.getTime(); // 得到指定日期的毫秒数
	        day = day*24*60*60*1000; // 要加上的天数转换成毫秒数
	        time+=day; // 相加得到新的毫秒数
	        return new Date(time); // 将毫秒数转换成日期
	   }
	    
	    /**
	     * 指定时间在若干天后的时间
	     * @param date
	     * @param year
	     * @return
	     * @throws ParseException
	     */
	    public static Date addYear(Date date,int year) throws ParseException {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(date);//设置起时间
	        cal.add(Calendar.YEAR, year);//增加一年
	    	return cal.getTime(); // 将毫秒数转换成日期
	   }
	    
	    /**
	     * 获取当天的某一时刻Date
	     * @param hour      24小时
	     * @param min       分钟
	     * @param sec       秒
	     * @param mill      毫秒
	     * @return
	     */
	    public static Date getMoment(int hour,int min,int sec,int mill){
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(new Date());
	        calendar.set(Calendar.HOUR_OF_DAY,hour);
	        calendar.set(Calendar.MINUTE,min);
	        calendar.set(Calendar.SECOND,sec);
	        calendar.set(Calendar.MILLISECOND,mill);
	        return calendar.getTime();
	    }

	    /**
	     * 获得指定某年某月某日某刻的Date
	     * @param year      年
	     * @param month 月
	     * @param day       日
	     * @param hour      24小时制
	     * @param min       分钟
	     * @param sec       秒
	     * @param mill      毫秒
	     * @return
	     */
	   public static Date getMoment(int year,int month,int day,int hour,int min,int sec,int mill){
	       Calendar calendar = Calendar.getInstance();
	       calendar.set(Calendar.YEAR,year);
	       calendar.set(Calendar.MONTH,month);
	       calendar.set(Calendar.DAY_OF_MONTH,day);
	       calendar.set(Calendar.HOUR_OF_DAY,hour);
	       calendar.set(Calendar.MINUTE,min);
	       calendar.set(Calendar.SECOND,sec);
	       calendar.set(Calendar.MILLISECOND,mill);
	       return calendar.getTime();
	   }
	   
	   /**
	     * 得到当前日期字符串 格式（yyyyMMddHHmmss）
	     */
	    public static String getDateStr() {
	        return getDate("yyyyMMddHHmmss");
	    }
	    /*
	     * 得到毫秒时间格式
	     */
	    public static String getMillisecond() {
	        return getDate("yyyy-MM-dd_HH:mm:ss_SSS");
	    }
	    
	    public static String getDateCalStr(Calendar calendar){
	    	return calendar.get(Calendar.YEAR)+"年"+(calendar.get(Calendar.MONTH) + 1)+"月"+calendar.get(Calendar.DAY_OF_MONTH)+"日";
	    }
	    
	    
	    public static final Date strToDate(final String format, final String ts)
	    {
	        try
	        {
	            return new SimpleDateFormat(format).parse(ts);
	        }
	        catch (ParseException e)
	        {
	            throw new RuntimeException(e);
	        }
	    }

	/**
	 * 得到新增某个月之后几个月2012-02 +5 2012-07
	 *
	 * @return
	 */
	public static String getAddMonthDate$1(String date, int ik) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		try {
			/* 年月 */
			date = date.replace(".", "-");
			date = date.replace("/", "-");
			Date now = sim.parse(date);
			cal.setTime(now);
			cal.add(Calendar.MONTH, ik);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sim.format(cal.getTime());
	}

	/**
	 * 日期加天??
	 * @param date
	 * @param day
	 * @return
	 * @throws Exception
	 */
	public static String getAddDayDate(String date,int day) {
		SimpleDateFormat sim =new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date_ = sim.parse(date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date_);
			cal.add(Calendar.DAY_OF_MONTH, day);
			return sim.format(cal.getTime());
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 格式化日期
	 */
	public static Date getCtDate(String dt,String fmt) {
		Date ft = null;
		try {
			ft = new Timestamp(new SimpleDateFormat(fmt).parse(dt).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return ft;
	}
	    
	/**
	 * 两个日期差
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getItDifferenceDate(Date date1, Date date2) {
		return (date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24);
	}
	
	/**
	 * 两个日期差
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getItDifferenceDate(String date1, String date2) {
		Date endDate = getCtDate(date2, "yyyy-MM-dd");
		Date startDate = getCtDate(date1, "yyyy-MM-dd");
		return (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24);
	}
	
	   public static String getRelativeDate(Date date, int iYear, int iMonth, int iDate, String sFormat) {
	        SimpleDateFormat sdf = new SimpleDateFormat(sFormat);            //定义格式
	        GregorianCalendar gc = new GregorianCalendar();            //

	        gc.setTime(date);           //设置时间

	        gc.add(Calendar.YEAR, iYear);               //算术求和
	        gc.add(Calendar.MONTH, iMonth);
	        gc.add(Calendar.DATE, iDate);

	        return sdf.format(gc.getTime());
	    }
	    
	
	public static boolean isDate(String str){
        boolean result = true;
        SimpleDateFormat format = new SimpleDateFormat(parsePatterns[1]);
        try {
        	format.setLenient(false);
            Date a= format.parse(str);
        }catch (Exception e){
            result = false;
        }
        return result;
    }
	
	
}
