package com.lbw.common.utils.time;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * 
 * @author LiuBaoWen
 *
 */
public class DateUtils {

	public static final String DEFAULT_PATTERN = "yyyy-MM-dd";

	public static final String DEFAULT_LONG_PATTERN = "yyyy-MM-dd hh:mm:ss";

	public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
	public static final String HOUR_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	public static final String MONTH_PATTERN = "yyyy-MM";

	public static final String YEAR_ONLY_PATTERN = "yyyy";
	public static final String MONTH_ONLY_PATTERN = "MM";
	public static final String DAY_ONLY_PATTERN = "dd";
	public static final String HOUR_ONLY_PATTERN = "HH";
	public static final String MINUTE_ONLY_PATTERN = "mm";

	public static final String HOUR_ONLY_PATTERN_temp = "yyyy-MM-dd HH:mm:ss.SSS";

	/**
	 * Date 转 String
	 * 
	 * @author LiuBaoWen
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatToDateStr(Date date, String pattern) {
		String dateStr = null;
		if (date != null) {
			dateStr = new SimpleDateFormat(pattern).format(date);
		}
		return dateStr;
	}

	/**
	 * java.sql.Date转String
	 * 
	 * @author LiuBaoWen
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatToDateStr(java.sql.Date date, String pattern) {
		String dateStr = null;
		if (date != null) {
			dateStr = new SimpleDateFormat(pattern).format(date);
		}
		return dateStr;
	}

	/**
	 * java.sql.Timestamp 转 String
	 * 
	 * @author LiuBaoWen
	 * @param sqlTimestamp
	 * @param pattern
	 * @return
	 */
	public static String formatToDateStr(Timestamp sqlTimestamp, String pattern) {
		String dateStr = null;
		if (sqlTimestamp != null) {
			dateStr = new SimpleDateFormat(pattern).format(sqlTimestamp);
		}
		return dateStr;
	}

	/**
	 * 日期格式字符串格式化
	 * 
	 * @author LiuBaoWen
	 * @param dateStr
	 * @param patternFrom
	 * @param patternTo
	 * @return
	 */
	public static String formatToDateStr(String dateStr, String patternFrom, String patternTo) {
		SimpleDateFormat in_sdf = new SimpleDateFormat(patternFrom);
		SimpleDateFormat out_sdf = new SimpleDateFormat(patternTo);
		Date date = null;
		if (dateStr != null && dateStr.length() != 0 && !"null".equalsIgnoreCase(dateStr)) {
			try {
				date = in_sdf.parse(dateStr);
				dateStr = out_sdf.format(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return dateStr;
	}

	/**
	 * 解析字符串为Date
	 * 
	 * @author LiuBaoWen
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date parseToDate(String dateStr, String pattern) {
		Date date = null;
		if (dateStr != null && dateStr.length() > 0) {
			try {
				Date _date = new SimpleDateFormat(pattern).parse(dateStr);
				date = new Date(_date.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return date;
	}

	/**
	 * 解析字符串为sqlDate
	 * 
	 * @author LiuBaoWen
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static java.sql.Date parseToSqlDate(String dateStr, String pattern) {
		java.sql.Date sqlDate = null;
		if (dateStr != null && dateStr.length() > 0) {
			try {
				Date _date = new SimpleDateFormat(pattern).parse(dateStr);
				sqlDate = new java.sql.Date(_date.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return sqlDate;
	}

	/**
	 * 解析字符串为Timestamp
	 * 
	 * @author LiuBaoWen
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Timestamp parseToTimestamp(String dateStr, String pattern) {
		Timestamp timestamp = null;
		if (dateStr != null && dateStr.length() > 0) {
			try {
				Date _date = new SimpleDateFormat(pattern).parse(dateStr);
				timestamp = new Timestamp(_date.getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return timestamp;
	}

	/**
	 * 将Timestamp转化为Date
	 * 
	 * @author LiuBaoWen
	 * @param timestamp
	 * @return
	 */
	public static Date timestampToDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}

	/**
	 * 将Date转化为Timestamp
	 * 
	 * @author LiuBaoWen
	 * @param date
	 * @return
	 */
	public static Timestamp dateToTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	/**
	 * 获取当前timestamp()
	 * 
	 * @param pattern if format==null, return yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Timestamp getCurrentTimeStamp(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String time = sdf.format(new Date());
		Timestamp ts = Timestamp.valueOf(time);
		return ts;
	}

	/**
	 * 判断日期是否在范围内
	 * 
	 * @author LiuBaoWen
	 * @param startDate
	 * @param endDate
	 * @param date
	 * @return
	 */
	public static boolean isDateValidInRange(String startDate, String endDate, String date) {
		Date startTime = parseToDate(startDate, DEFAULT_PATTERN);
		Date endTime = parseToDate(endDate, DEFAULT_PATTERN);
		Date currentDate = parseToDate(date, DEFAULT_PATTERN);
		if (currentDate.compareTo(startTime) >= 0 && currentDate.compareTo(endTime) <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * 获取本月第一天的00:00:00
	 * 
	 * @return
	 */
	public static Date getCurrMonthFirstDate() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		String first = DateUtil.formatDateYyyyMMdd2(c.getTime());
		first = first + " 00:00:00";
		Date queryStartDate = DateUtil.parseNormalDateFromStr(first);
		return queryStartDate;
	}

	/**
	 * 获取本月最后一天的23:59:59
	 * 
	 * @return
	 */
	public static Date getCurrMonthEndDate() {
		// 查询结束时间--本月最后一秒
		Calendar lastDay = Calendar.getInstance();
		lastDay.set(Calendar.DAY_OF_MONTH, lastDay.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = DateUtil.formatDateYyyyMMdd2(lastDay.getTime());
		last = last + " 23:59:59";
		Date queryEndDate = DateUtil.parseNormalDateFromStr(last);
		return queryEndDate;
	}

	/**
	 * 获取当前月份整数值--用于表分区
	 * 
	 * @return
	 */
	public static Integer getCurrMonthNum() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 校验传入的Pattern
	 * 
	 * @author LiuBaoWen
	 * @return
	 */
	public static boolean checkPattern() {

		return false;
	}

}
