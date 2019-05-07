/**
 * 
 */
package com.spring.demo.util;

import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间工具类
 * 
 * @author Administrator
 * 
 */
public class DateUtil {
	public static Log log = LogFactory.getLog(DateUtil.class);

	private static Map<String, DateFormat> formatMap = new WeakHashMap<>();

	public static final String  YYYY_MM_DD_MM_HH_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String  YYYY_MM_DD_MM_HH = "yyyy-MM-dd HH:mm";
	public static final String  YYYY_MM_DD = "yyyy-MM-dd";
	public static final String  YYYY_MM = "yyyy-MM";
	public static final String  YYYYMMDDMMHHSSSSS = "yyyyMMddHHmmssSSS";
	public static final String  YYYYMMDDSSS = "yyyyMMddSSS";
	public static final String  YYYYMMDD = "yyyyMMdd";
	public static final String  CN_YYYY_MM_DD_MM_HH = "yyyy年MM月dd日HH时mm分";
	public static final String  CN_YYYY_MM_DD_HH = "yyyy年MM月dd日HH时";
	public static final String  CN_YYYY_MM_DD = "yyyy年MM月dd日";

	public static synchronized  Date parseToDate(String datetime, String formatStr) {
		DateFormat dateFormat = formatMap.get(formatStr);
		if (null == dateFormat){
			dateFormat = new SimpleDateFormat(formatStr, Locale.getDefault());
			formatMap.put(formatStr, dateFormat);
		}

		Date date = null;
		try {
			date = dateFormat.parse(datetime);
		}catch(ParseException e){
			log.error("日期解析失败", e);
		}

		return date;
	}

	public static synchronized String formatDate(Date date, String formatStr){
		DateFormat dateFormat = formatMap.get(formatStr);
		if (null == dateFormat){
			dateFormat = new SimpleDateFormat(formatStr, Locale.getDefault());
			formatMap.put(formatStr, dateFormat);
		}

		return dateFormat.format(date);
	}

	/**
	 * 日期转化
	 */
	public static String getYmd(Date date) {
		return date2String(date, YYYY_MM_DD);
	}

	/**
	 * 当前日期
	 */
	public static String getCurrentDay() {
		return date2String(new Date(), YYYYMMDD);
	}
	
	public static Date getCurrentDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}
	
	public static String getCurrentDay1() {
		return date2String(new Date(), YYYY_MM_DD);
	}

	/**
	 * 当前日期
	 */
	public static String getCurrentDateTime() {
		return date2String(new Date(), YYYY_MM_DD_MM_HH_SS);
	}

	public static String getCurrentCnDay() {
		return date2String(new Date(), CN_YYYY_MM_DD);
	}

	public static String getCurrentCnDateAndHour() {
		return date2String(new Date(), CN_YYYY_MM_DD_HH);
	}
	
	public static String getCurrentCnDateAndHourAndMinute() {
		return date2String(new Date(), CN_YYYY_MM_DD_MM_HH);
	}

	public static String getCurrentDateTime(String format) {
		return date2String(new Date(), format);
	}
	/**
	 * 日期按照指定格式转换为字符串
	 */
	public static String date2String(Date date, String formatStr) {
		return formatDate(date, formatStr);
	}


	
	 /**
     * 获取当前日期是星期几<br>
     * 
     * @param dt
     * @return 当前日期是星期几
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"7", "1", "2", "3", "4", "5", "6"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;

        return weekDays[w];
    }

	public static int getWeekOfYear(Date dt) {
           return new org.joda.time.DateTime(dt).getWeekOfWeekyear();
	}
    // 获取某年的第几周的开始日期
    public static Date getFirstDayOfWeek(int year, int week) {
        Calendar c = new GregorianCalendar();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, 1);
 
        Calendar cal = (GregorianCalendar) c.clone();
        cal.add(Calendar.DATE, week * 7);
 
        return getFirstDayOfWeek(cal.getTime());
    }

    // 获取当前时间所在周的开始日期
    public static Date getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        return c.getTime();
    }
    
 // / <summary>
 	// / 获取两个时间段之间的月份
 	// / </summary>
 	// / <param name="minDate">开始月份</param>
 	// / <param name="maxDate">结束月份</param>
 	// / <returns>月份字符串</returns>
    public static List<String> getMonthBetween(String minDate, String maxDate)
 			throws ParseException {
 		ArrayList<String> result = new ArrayList<String>();
 		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 格式化为年月

 		Calendar min = Calendar.getInstance();
 		Calendar max = Calendar.getInstance();

 		min.setTime(sdf.parse(minDate));
 		min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

 		max.setTime(sdf.parse(maxDate));
 		max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

 		Calendar curr = min;
 		while (curr.before(max)) {
 			result.add(sdf.format(curr.getTime()));
 			curr.add(Calendar.MONTH, 1);
 		}
 		return result;
 	}
    
	/**
	 * 计算两个时间之间相差的天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long diffDays(Date startDate, Date endDate) {
		long days = 0;
		long start = startDate.getTime();
		long end = endDate.getTime();
		// 一天的毫秒数1000 * 60 * 60 * 24=86400000
		days = (end - start) / 86400000;
		return days;
	}
	
	/**
	 * 计算两个时间之间相差的天数是否大于day1天
	 * 
	 * @param endDate
	 * @param day1
	 * @return
	 */
	public static synchronized Boolean diffDays(String endDate,long day1) {
		long days = 0;
		Date startDate = new Date();
		long start = startDate.getTime();
		Date endDates;

		endDates = parseToDate(endDate, YYYY_MM_DD);
		long end = endDates.getTime();
		// 一天的毫秒数1000 * 60 * 60 * 24=86400000
		days = ( start - end) / 86400000;
		if(days > day1) {
			return true;
		}
		return false;
	}
	
	
	/**  
     * 计算两个日期之间相差的天数  
     * @param smdate 较小的时间 
     * @param bdate  较大的时间 
     * @return 相差天数 
     * @throws ParseException  
     */    
    public static int daysBetween(Date smdate,Date bdate) throws ParseException    
    {    
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
        smdate=sdf.parse(sdf.format(smdate));  
        bdate=sdf.parse(sdf.format(bdate));  
        Calendar cal = Calendar.getInstance();    
        cal.setTime(smdate);    
        long time1 = cal.getTimeInMillis();                 
        cal.setTime(bdate);    
        long time2 = cal.getTimeInMillis();         
        long between_days=(time2-time1)/(1000*3600*24);  
            
       return Integer.parseInt(String.valueOf(between_days));           
    }    

	/**
	 * 日期加上月数的时间
	 * 
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date dateAddMonth(Date date, int month) {
		return add(date, Calendar.MONTH, month);
	}

	/**
	 * 日期加上天数的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date dateAddDay(Date date, int day) {
		return add(date, Calendar.DAY_OF_YEAR, day);
	}

	/**
	 * 日期加上年数的时间
	 * 
	 * @param date
	 * @param year
	 * @return
	 */
	public static Date dateAddYear(Date date, int year) {
		return add(date, Calendar.YEAR, year);
	}

	/**
	 * 计算剩余时间 (多少天多少时多少分)
	 *
	 * @return
	 */
	public static String remainDateToString(Date startDate, Date endDate) {
		StringBuilder result = new StringBuilder();
		long times = endDate.getTime() - startDate.getTime();
		if (times < -1) {
			result.append("过期");
		} else {
			long temp = 1000 * 60 * 60 * 24;
			// 天数
			long d = times / temp;

			// 小时数
			times %= temp;
			temp /= 24;
			long m = times / temp;
			// 分钟数
			times %= temp;
			temp /= 60;
			long s = times / temp;

			result.append(d);
			result.append("天");
			result.append(m);
			result.append("小时");
			result.append(s);
			result.append("分");
		}
		return result.toString();
	}

	
	
    public static Date getCurrYearLast(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        calendar.roll(Calendar.DAY_OF_YEAR, -1);  
        Date currYearLast = calendar.getTime();  
          
        return currYearLast;  
    } 
   
	private static Date add(Date date, int type, int value) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(type, value);
		return calendar.getTime();
	}
	
	public static Date dateAddHour(Date date, int hour) {
		return add(date, Calendar.HOUR_OF_DAY, hour);
	}
	
	/**
	 * 日期加上分钟的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date dateAddMinute(Date date, int minute) {
		return add(date, Calendar.MINUTE, minute);
	}
	/**
	 * 获取年
	 * @param date
	 * @return
	 */
	public static String getYear(Date date){
		return new SimpleDateFormat("yyyy").format(date);
	}
	/**
	 * 获取月
	 * @param date
	 * @return
	 */
	public static String getMM(Date date){
		return new SimpleDateFormat("MM").format(date);
	}
	/**
	 * 获取日
	 * @param date
	 * @return
	 */
	public static String getdd(Date date){
		return new SimpleDateFormat("dd").format(date);
	}
	/**
	 * 获取时
	 * @param date
	 * @return
	 */
	public static String getHH(Date date){
		return new SimpleDateFormat("HH").format(date);
	}
	/**
	 * 获取分
	 * @param date
	 * @return
	 */
	public static String getmm(Date date){
		return new SimpleDateFormat("mm").format(date);
	}
	/**
	 * 获取秒
	 * @param date
	 * @return
	 */
	public static String getss(Date date){
		return new SimpleDateFormat("ss").format(date);
	}

	/**
	 * 获取指定时间戳日期的23:59:59
	 * @param seconds
	 * @return
	 */
	public static int getDefindDataSeconds(int seconds) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date(seconds * 1000));
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return (int) (cal.getTimeInMillis() / 1000);
	}

	/**
	 * 获取指定时间的当天零点时间
	 * @param date
	 * @return
	 */
	public static Date getDefindDataStart(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 00);
		cal.set(Calendar.MINUTE, 00);
		cal.set(Calendar.SECOND, 00);
		return cal.getTime();
	}

	/****
	 * 传入具体日期 ，返回具体日期增加一个月。
	 * @param date 日期(2017-04-13)
	 * @return 2017-05-13
	 * @throws ParseException
	 */
	public static String subMonth(String date, int count) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = sdf.parse(date);
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);
		rightNow.add(Calendar.MONTH, count);
		Date dt1 = rightNow.getTime();
		String reStr = sdf.format(dt1);
		return reStr;
	}

	/**
	 * excel中取出的日期数字改成java日期
	 * @param amount
	 * @return
	 */
	public static Date getJavaDate(int amount) {
		Calendar c = new GregorianCalendar(1900,0,-1);

		Date time = c.getTime();
		Date date = DateUtils.addDays(time, amount);  //amount是距离1900年1月1日的天数
		return date;
	}

	/**
	 * 获取指定数量个工作日后的日期。
	 * 如：获取20个工作日后的日期。
	 * @param daysNum 工作日
	 * @param holidaysList 节假日日期
	 * @return
	 */
	public static Date getDate(int daysNum, List<String> holidaysList) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int num = 0;
		while (num != daysNum) {
			cal.add(Calendar.DAY_OF_YEAR, 1);
			String dateStr = formatDate(cal.getTime(),YYYY_MM_DD);
			if (null!=holidaysList && holidaysList.contains(dateStr)) { // 是节假日
				continue; // 结束当前循环
			} else if (isWeekend(cal)) { // 是周末
				continue;
			} else {
				num++;
			}
		}
		// System.out.println("结果：" + sdf.format(cal.getTime()));
		return cal.getTime();
	}
	// 判断是不是周末
	public static boolean isWeekend(Calendar cal) {
		if (cal != null) {
			if ((cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断一个字符串是不是一个合法的日期格式
	 * @param str
	 * @return
	 */
	public static boolean isValidDate(String str) {
		boolean convertSuccess=true;
		DateFormat df = new SimpleDateFormat(YYYY_MM_DD);
		//指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		try {
			//设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			df.setLenient(false);
			df.parse(str);
		} catch (ParseException e) {
			// e.printStackTrace();
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess=false;
		}
		return convertSuccess;
	}

	public static void main(String []args){
		Date d = new Date();
		String dateStr = formatDate(d, YYYY_MM_DD_MM_HH_SS);
		System.out.println(formatDate(d, YYYY_MM_DD));
		System.out.println(formatDate(d, YYYY_MM));
		System.out.println(formatDate(d, YYYY_MM_DD_MM_HH_SS));
		System.out.println(formatDate(d, YYYY_MM_DD_MM_HH));
		System.out.println(formatDate(d, CN_YYYY_MM_DD));
		System.out.println(formatDate(d, CN_YYYY_MM_DD_HH));
		System.out.println(parseToDate(dateStr,YYYY_MM_DD_MM_HH_SS));
		System.out.println(parseToDate(dateStr,YYYY_MM));
		System.out.println(parseToDate(dateStr,YYYY_MM_DD));
		System.out.println(parseToDate(dateStr,YYYYMMDDSSS));
		String dateStrCN = formatDate(d, CN_YYYY_MM_DD_MM_HH);
		System.out.println(parseToDate(dateStrCN,CN_YYYY_MM_DD));
		System.out.println(parseToDate(dateStrCN,CN_YYYY_MM_DD_MM_HH));
		System.out.println(parseToDate(dateStrCN,CN_YYYY_MM_DD_HH));
	}
}
