package com.ibm.common.utils.time;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class DateUtils {

	public static final String DEFAULT_PATTERN = "yyyy-MM-dd";

	public static final String DEFAULT_LONG_PATTERN = "yyyy-MM-dd hh:mm:ss";

	public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
	public static final String HOUR_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	public static final String MONTH_PATTERN = "yyyy-MM";
	public static final String YEAR_PATTERN = "yyyy";
	public static final String MINUTE_ONLY_PATTERN = "mm";
	public static final String HOUR_ONLY_PATTERN = "HH";

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
		Date startTime = DateUtils.parseToSqlDate(startDate, DEFAULT_PATTERN);
		Date endTime = DateUtils.parseToSqlDate(endDate, DEFAULT_PATTERN);
		Date currentDate = DateUtils.parseToSqlDate(date, DEFAULT_PATTERN);
		if (currentDate.compareTo(startTime) >= 0 && currentDate.compareTo(endTime) <= 0) {
			return true;
		}
		return false;
	}

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
		if (StringUtils.isNotEmpty(dateStr) && !"null".equalsIgnoreCase(dateStr)) {
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

}
