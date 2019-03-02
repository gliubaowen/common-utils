package com.ibm.common.utils.bak;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;

public class DateUtil {
	
	private final static Calendar calendar = Calendar.getInstance();

	/**
	 * 字符串转java.sql.Date
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static java.sql.Date formatToDate(String date, String format) {
		java.sql.Date sqlDate = null;
		try {
			if (date != null && date.length() > 0) {
				java.util.Date _date = new SimpleDateFormat(format).parse(date);
				sqlDate = new java.sql.Date(_date.getTime());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;
	}

	/**
	 * TimeStamp转字符串(ymd)
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatTimeStampToString(Timestamp date, String format) {
		if (date == null)
			return "";
		SimpleDateFormat df = new SimpleDateFormat(format);
		String str = df.format(date);
		return str;
	}
	
	
	// 日期格式字符串格式化
	public static String formatToDateStr(String time) {
		SimpleDateFormat in_sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat out_sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		if (StringUtils.isNotEmpty(time) && !"null".equalsIgnoreCase(time)) {
			try {
				date = in_sdf.parse(time);
				time = out_sdf.format(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return time;
	}
	
	/**
	 * 获取下月第1天
	 * 秦桂俊
	 */
	public static String nextMonthFirstDate(String startDate) {
		SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");
		calendar.setTime(DateUtil.formatToDate(startDate, "yyyy-MM-dd"));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        return  ymdFormat.format(calendar.getTime());
    }

	/**
	 * 获取当前timestamp()
	 * 
	 * @param format
	 *            if format==null, return yyyy-MM-dd HH:mm:ss
	 * @return
	 */

	public static Timestamp getCurrentTimeStamp(String format) {
		String fm = "yyyy-MM-dd HH:mm:ss";
		if (format != null)
			fm = format;
		SimpleDateFormat df = new SimpleDateFormat(fm);
		String time = df.format(new Date());
		Timestamp ts = Timestamp.valueOf(time);
		return ts;
	}

	/**
	 * 返回当前时间
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static Timestamp getCurrentTimeStamp() {
		return getCurrentTimeStamp(null);
	}

	/**
	 * 获取当前timestamp(仅精确到日期) yyyy-MM-dd 00:00:00
	 * 
	 * @return
	 */
	public static Timestamp getCurrentTimeStampYMD() {
		return getCurrentTimeStamp("yyyy-MM-dd 00:00:00");
	}

	/**
	 * 获取当前timestamp结束(仅精确到日期) yyyy-MM-dd 23:59:59.9
	 * 
	 * @return
	 */
	public static Timestamp getCurrentTimeStampYMDEnd() {
		return getCurrentTimeStamp("yyyy-MM-dd 23:59:59.9");
	}

	/**
	 * 获取当年最后一天 timestamp yyyy-12-31 23:59:59.9
	 * 
	 * @return
	 */
	public static Timestamp getCurrentTimeStampYear() {
		return getCurrentTimeStamp("yyyy-12-31 23:59:59.9");
	}

	/**
	 * 获取当前date(仅精确到日期) yyyy-MM-dd"
	 * 
	 * @return
	 */
	public static Date getCurrentDateYMD() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(new Date());
		return DateUtil.formatToDate(date, "yyyy-MM-dd");
	}

	public static Date timestampToDate(Timestamp tt) {
		return new Date(tt.getTime());
	}

	/**
	 * 判断日期是否有效
	 * 
	 * @param startDate,endDate,date
	 */
	public static boolean isDateValidInRange(String startDate, String endDate, String date) {
		Date startTime = DateUtil.formatToDate(startDate, "yyyy-MM-dd");
		Date endTime = DateUtil.formatToDate(endDate, "yyyy-MM-dd");
		Date currentDate = DateUtil.formatToDate(date, "yyyy-MM-dd");
		if (currentDate.compareTo(startTime) >= 0 && currentDate.compareTo(endTime) <= 0) {
			return true;
		} else {
			return false;
		}
	}


	/**
	 * 判断时间字符串是否指定格式
	 * @param dateStr
	 * @param datePattern
	 * @return
	 */
	public static boolean checkDateFormat(String dateStr, String datePattern){
		if(StringUtils.isNotEmpty(dateStr) && StringUtils.length(dateStr) == StringUtils.length(datePattern)){
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
				Date date = sdf.parse(dateStr);
				if(sdf.format(date).equals(dateStr)){
					return true;
                }
			} catch (Exception e) {

			}
		}

		return false;
	}

	/**
	 * 当前日期是否在开始日期结束日期范围之内
	 * 
	 * @param startDate,endDate
	 */
	public static boolean isDateValid(String startDate, String endDate) {
		Date startTime = DateUtil.formatToDate(startDate, "yyyy-MM-dd");
		Date endTime = DateUtil.formatToDate(endDate, "yyyy-MM-dd");
		Date currentDate = DateUtil.getCurrentDateYMD();
		if (currentDate.compareTo(startTime) >= 0 && currentDate.compareTo(endTime) <= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 字符串转java.sql.Timestamp
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static java.sql.Timestamp formatToTimestamp(String date, String format) {
		java.sql.Timestamp timestamp = null;
		try {
			if (date != null && date.length() > 0) {
				java.util.Date _date = new SimpleDateFormat(format).parse(date);
				timestamp = new java.sql.Timestamp(_date.getTime());
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timestamp;
	}

	public static String formatToStr(java.sql.Date date, String format) {
		String dateStr = null;
		if (date != null) {
			dateStr = new SimpleDateFormat(format).format(date);
		}
		return dateStr;
	}

	public static String formatToStr(Date date, String format) {
		String dateStr = null;
		if (date != null) {
			dateStr = new SimpleDateFormat(format).format(date);
		}
		return dateStr;
	}
	public static Timestamp getDayStart(Timestamp date){
		if(date != null){
			long t = date.getTime();
			Calendar cal  = Calendar.getInstance();
			cal.setTimeInMillis(t);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.MILLISECOND, 0);
			return new Timestamp(cal.getTimeInMillis());
		}
		
		
		return date;
	}
	public static Timestamp getDayEnd(Timestamp date){
		if(date != null){
			long t = date.getTime();
			Calendar cal  = Calendar.getInstance();
			cal.setTimeInMillis(t);
			cal.set(Calendar.HOUR_OF_DAY, 23);
			cal.set(Calendar.SECOND, 59);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.MILLISECOND, 59);
			
			return new Timestamp(cal.getTimeInMillis());
		}
		return date;
	}
	
	public static String formatToStr(java.sql.Timestamp date, String format) {
		String dateStr = null;
		if (date != null) {
			dateStr = new SimpleDateFormat(format).format(date);
		}
		return dateStr;
	}

	// 日期格式字符串格式化
	public static String formatDate(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		if (StringUtils.isNotEmpty(time) && !"null".equalsIgnoreCase(time)) {
			try {
				date = sdf.parse(time);
				time = sdf.format(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return time;
	}

	// 日期格式字符串格式化
	public static String formatDateTime(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		if (StringUtils.isNotEmpty(time) && !"null".equalsIgnoreCase(time)) {
			try {
				date = sdf.parse(time);
				time = sdf.format(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return time;
	}

	// 计算日期相隔天数
	public static long dateDiff(String startTime, String endTime, String format) throws ParseException {
		// 按照传入的格式生成一个simpledateformate对象
		SimpleDateFormat sd = new SimpleDateFormat(format);
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		long ns = 1000;// 一秒钟的毫秒数long diff;try {
		// 获得两个时间的毫秒时间差异
		long diff = sd.parse(startTime).getTime() - sd.parse(endTime).getTime();
		long day = diff / nd;// 计算差多少天
		long hour = diff % nd / nh;// 计算差多少小时
		long min = diff % nd % nh / nm;// 计算差多少分钟
		long sec = diff % nd % nh % nm / ns;// 计算差多少秒//输出结果
		System.out.println("时间相差：" + day + "天" + hour + "小时" + min + "分钟" + sec + "秒。");
		return day;
	}

	// 计算日期相隔毫秒
	public static long dateDiff(Date startTime, Date endTime) {
		// 按照传入的格式生成一个simpledateformate对象
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long nh = 1000 * 60 * 60;// 一小时的毫秒数
		long nm = 1000 * 60;// 一分钟的毫秒数
		long ns = 1000;// 一秒钟的毫秒数long diff;try {
		// 获得两个时间的毫秒时间差异
		if (endTime != null && startTime != null) {
			long diff = endTime.getTime() - startTime.getTime();
			return diff;
		} else {
			return 0;
		}
	}

	// 日期转化为字符串
	public static String getStrFromDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		return str;
	}

	/**
	 * 转换日期字符串为日期对象 yyyy-MM-dd
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date getDateFromStr(String dateStr) {
		return DateUtil.formatToDate(dateStr, "yyyy-MM-dd");
	}

	/**
	 * 获得指定日期的前后日期 t为正表示后 负表示前
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static Date getSpecifiedDay(Date date, int t) {
		if (date == null)
			return null;

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, t);
		return c.getTime();
	}

	/**
	 * 获得指定日期的前后日期 t为正表示后 负表示前
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static Date getSpecifiedDayByHour(Date date, int t) {
		if (date == null)
			return null;

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR, t);
		return c.getTime();
	}

	/**
	 * 返回中间没有分隔符的时间戳:yyyyMMddHHmmssSS
	 * 
	 * @return
	 */
	public static String getPureCurrentTs() {
		return getPureCurrent("yyyyMMddHHmmssSSS");
	}
	
	
	public static String getPureCurrent(String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		String time = df.format(new Timestamp(System.currentTimeMillis()));
		return time;
	}

	/**
	 * 获取当前timestamp(仅精确到日期) yyyy-MM-dd HH:mm:ss.SSS
	 * 
	 * @return
	 */
	public static Timestamp getCurrentTimeStampMillis() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String time = df.format(new Date());
		Timestamp ts = Timestamp.valueOf(time);
		return ts;
	}

	/**
	 * 在日期上增加/减少指定的月数
	 * 
	 * @param date
	 * @param month
	 * @return
	 */
	public static Date addDayToDate(Date date, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + month);
		return calendar.getTime();
	}

	/**
	 * 获取指定日期的timestamp
	 * 
	 * @param date
	 * @return
	 */
	public static Timestamp getTimeStampMillis(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		String time = df.format(date);
		Timestamp ts = Timestamp.valueOf(time);
		return ts;
	}

	/**
	 * 获取指定日期的timestamp
	 * 
	 * @param date
	 * @param format
	 *            例：yyyy-MM-dd hh:mm:ss.SSS
	 * @return
	 */
	public static Timestamp getTimeStampMillis(Date date, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		String time = df.format(date);
		Timestamp ts = Timestamp.valueOf(time);
		return ts;
	}
	
	/**
	 * 获取上月第1天
	 * 秦桂俊
	 */
	public static String getDayOfThisMonthEnd(String date) {
		SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");
		calendar.setTime(DateUtil.formatToDate(date, "yyyy-MM-dd"));
		calendar.add(calendar.MONTH, -1);
		return ymdFormat.format(calendar.getTime());
	}
	
	public static String getLastDayOfThisMonthEnd(String date) {
		SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");
		calendar.setTime(DateUtil.formatToDate(date, "yyyy-MM-dd"));
		calendar.add(calendar.MONTH, 1);
		calendar.add(calendar.DAY_OF_MONTH, -1);
		return ymdFormat.format(calendar.getTime());
	}
	
	public static String getDayOfThisMonthEnd(String date,String format) {
		SimpleDateFormat ymdFormat = new SimpleDateFormat(format);
		calendar.setTime(DateUtil.formatToDate(date, "yyyy-MM-dd"));
		calendar.add(calendar.MONTH, -1);
		return ymdFormat.format(calendar.getTime());
	}
	
	public static String getDayOfMonths(String date, int n) {
		SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");
		calendar.setTime(DateUtil.formatToDate(date, "yyyy-MM-dd"));
		calendar.add(calendar.MONTH, n);
		return ymdFormat.format(calendar.getTime());
	}
	
	public static String nextDate(String startDate) {
		SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");
		calendar.setTime(DateUtil.formatToDate(startDate, "yyyy-MM-dd"));
        calendar.add(Calendar.DATE, 1);
        return  ymdFormat.format(calendar.getTime());
    }
	
	/**
	 * 获取当月第1天
	 * 秦桂俊
	 */
	public static String getFisrtDateOfMonth() {
		Calendar date = Calendar.getInstance();
		date.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");
		return ymdFormat.format(date.getTime());
	}
	
	public static String getFisrtDateOfLastMonth() {
		Calendar date = Calendar.getInstance();
		date.set(Calendar.DAY_OF_MONTH, 1);
		date.add(Calendar.MONTH, -1);
		SimpleDateFormat ymdFormat = new SimpleDateFormat("yyyy-MM-dd");
		return ymdFormat.format(date.getTime());
	}
	
	public static void main(String[] args) throws ParseException, InterruptedException {
		
//		System.out.println(getMonthEnd("2017-02-01"));
//		Timestamp now = new Timestamp(new Date().getTime());
//		System.out.println(getDayStart(now));
//		System.out.println(getDayEnd(now));

		System.out.println(checkDateFormat("2017-05-12","yyyy-MM-dd"));

		String aaa=DateUtil.getFisrtDateOfMonth();
		System.out.println(aaa);
		aaa=DateUtil.nextDate(aaa);
		System.out.println(aaa);
		
//		DateUtil t = new DateUtil();
//		System.out.println("t.getCurrentDateYMD()=>" + t.getCurrentTimeStampYMD().toString());
//		System.out.println("t.getCurrentDateYMD()=>" + t.getCurrentDateYMD().toString());
//		System.out.println(t.getDateFromStr("2015-11-06").getTime());
//		System.out.println(t.getDateFromStr("2015-11-07").getTime());
		/*
		 * t.dateDiff("2014-12-15","2014-12-11","yyyy-MM-dd"); Date
		 * startTime=t.formatToDate("2015-6-19", "yyyy-MM-dd"); Date
		 * endTime=t.formatToDate("2015-6-19", "yyyy-MM-dd"); Date
		 * currentDate=t.getCurrentDateYMD();
		 * System.out.println("currentDate=>"+currentDate.toString());
		 * System.out.println("startTime=>"+startTime.toString());
		 * System.out.println("endTime=>"+endTime.toString()); if
		 * (currentDate.compareTo(startTime)>=0 &&
		 * currentDate.compareTo(endTime)<=0) { System.out.println("时间范围有效");
		 * }else{ System.out.println("时间范围无效"); }
		 * System.out.println("date"+DateUtil.formatToDate("2014-09-23",
		 * "yyyy-MM-dd"));
		 * 
		 * startTime=new Date(); for(int i=0;i<100;i++){
		 * Thread.currentThread().sleep((long) (Math.random()*100));
		 * System.out.println(t.getPureCurrentTs()); } endTime=new Date();
		 * System.out.println(DateUtil.dateDiff(startTime, endTime)/1000);
		 * PointsCalculator calculator=new PointsCalculator();
		 * System.out.println(calculator.isBirthDayMatched("2", "4", "8",
		 * "2015")); SimpleDateFormat df = new
		 * SimpleDateFormat("YYYYMMDDHHMISS"); String time = df.format(new
		 * Timestamp(System.currentTimeMillis())); System.out.println(time);
		 */
	}

	public static String getYear() {
		return formatDate(new Date(), new Object[] { "yyyy" });
	}

	public static String formatDate(Date date, Object... pattern) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String f = sf.format(new Date());
		String formatDate = null;
		if ((pattern != null) && (pattern.length > 0)) {
			formatDate = formatt(date, pattern[0].toString());
		} else {
			formatDate = formatt(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	public static String formatt(Date date, String pattern) {
		return formats(date, pattern, null, null);
	}

	public static String formats(Date date, String pattern, TimeZone timeZone, Locale locale) {
		FastDateFormat df = FastDateFormat.getInstance(pattern, timeZone, locale);
		return df.format(date);
	}

	/**
	 * 得到指定日期的前n天的日期
	 */
	public static Date getBeforeNDate(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(cal.DATE, -n);
		return cal.getTime();
	}

	
	public static String getMonthEnd(String startDate) {
		String str = "";
		calendar.setTime(getDateFromStr(startDate));
		calendar.roll(Calendar.DATE, - 1);
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		str = sdf.format(calendar.getTime());
		return str;
	}
	
	
	
}
