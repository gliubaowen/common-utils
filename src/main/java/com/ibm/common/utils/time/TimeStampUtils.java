/**
 * 
 */
package com.ibm.common.utils.time;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LiuBaoWen
 *
 */
public class TimeStampUtils {

	/**
	 * 获取当前timestamp()
	 * 
	 * @param pattern if format==null, return yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Timestamp getCurrentTimeStamp(String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		String time = df.format(new Date());
		Timestamp ts = Timestamp.valueOf(time);
		return ts;
	}

	/**
	 * 获取当前timestamp(仅精确到日期) yyyy-MM-dd 00:00:00
	 * 
	 * @param date
	 * @return
	 */
	public static Timestamp getCurrentTimeStampYMD() {
		return getCurrentTimeStamp("yyyy-MM-dd 00:00:00");
	}

	/**
	 * 获取当前timestamp结束(仅精确到日期) yyyy-MM-dd 23:59:59.9
	 * 
	 * @param date
	 * @return
	 */
	public static Timestamp getCurrentTimeStampYMDEnd() {
		return getCurrentTimeStamp("yyyy-MM-dd 23:59:59.9");
	}

	/**
	 * 获取当年最后一天 timestamp yyyy-12-31 23:59:59.9
	 * 
	 * @param date
	 * @return
	 */
	public static Timestamp getCurrentTimeStampYear() {
		return getCurrentTimeStamp("yyyy-12-31 23:59:59.9");
	}

	/**
	 * 获取当前date(仅精确到日期) yyyy-MM-dd"
	 * 
	 * @param date
	 * @return
	 */
	public static Date getCurrentDateYMD() {
		SimpleDateFormat df = new SimpleDateFormat(DateUtils.DEFAULT_PATTERN);
		String date = df.format(new Date());
		return DateUtils.parseToDate(date, DateUtils.DEFAULT_PATTERN);
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
	 * @param date
	 * @return
	 */
	public static Timestamp getCurrentTimeStampMillis() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String time = df.format(new Date());
		Timestamp ts = Timestamp.valueOf(time);
		return ts;
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
	 * @param format 例：yyyy-MM-dd hh:mm:ss.SSS
	 * @return
	 */
	public static Timestamp getTimeStampMillis(Date date, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		String time = df.format(date);
		Timestamp ts = Timestamp.valueOf(time);
		return ts;
	}

}
