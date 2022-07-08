package com.lbw.common.utils.time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author LiuBaoWen
 *
 */
public class DateUtil {

	private DateUtil() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * 线程安全方式
	 */
	private static final ThreadLocal<DateFormat> DATE_FORMAT_THREAD_LOCAL = ThreadLocal
			.withInitial(() -> new SimpleDateFormat("yyMMddHHmmssSSS"));

	private static final ThreadLocal<DateFormat> DATE_FORMATY_YYYMMDD = ThreadLocal
			.withInitial(() -> new SimpleDateFormat("yyyyMMdd"));

	private static final ThreadLocal<DateFormat> DATE_FORMAT_YYYYMM = ThreadLocal
			.withInitial(() -> new SimpleDateFormat("yyyyMM"));

	private static final ThreadLocal<DateFormat> DATE_FORMAT_NORMAL_THREAD_LOCAL = ThreadLocal
			.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

	private static final ThreadLocal<DateFormat> DATE_FORMATY_YYYMMDD2 = ThreadLocal
			.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

	/**
	 * 格式化时间为时间戳：yyyyMMddHHmmssS
	 * 
	 * @param date 时间
	 * @return 时间字符
	 */
	public static String formatDate(Date date) {
		return DATE_FORMAT_THREAD_LOCAL.get().format(date);
	}

	/**
	 * 解析字符串形式的时间戳为java.util.Date
	 * 
	 * @param timeStampStr 时间戳字符
	 * @return 时间
	 */
	public static Date parseDateFromStr(String timeStampStr) {
		try {
			return DATE_FORMAT_THREAD_LOCAL.get().parse(timeStampStr);
		} catch (ParseException e) {
			throw new IllegalArgumentException("解析'yyyyMMddHHmmssS'形式时间戳为java.util.Date失败");
		}
	}

	public static void remove() {
		DATE_FORMAT_THREAD_LOCAL.remove();
	}

	/**
	 * 格式化时间为时间戳：yyyyMMdd
	 * 
	 * @param date 时间
	 * @return 时间字符
	 */
	public static String formatDateYyyyMMdd(Date date) {
		return DATE_FORMATY_YYYMMDD.get().format(date);
	}

	/**
	 * 解析字符串形式的时间戳为java.util.Date
	 * 
	 * @param timeStampStr 时间戳字符
	 * @return 日期
	 */
	public static Date parseDateFromStrYyyyMMdd(String timeStampStr) {
		try {
			return DATE_FORMATY_YYYMMDD.get().parse(timeStampStr);
		} catch (ParseException e) {
			throw new IllegalArgumentException("解析'yyyyMMdd'形式时间戳为java.util.Date失败");
		}
	}

	/**
	 * 
	 */
	public static void removeYyyyMMdd() {
		DATE_FORMATY_YYYMMDD.remove();
	}

	/**
	 * 格式化时间为时间戳：yyyyMM
	 * 
	 * @param date 时间
	 * @return 时间字符
	 */
	public static String formatNormalDate(Date date) {
		return DATE_FORMAT_NORMAL_THREAD_LOCAL.get().format(date);
	}

	/**
	 * 解析字符串形式的时间戳为java.util.Date
	 * 
	 * @param timeStampStr 时间戳字符
	 * @return 时间
	 */
	public static Date parseNormalDateFromStr(String timeStampStr) {
		try {
			return DATE_FORMAT_NORMAL_THREAD_LOCAL.get().parse(timeStampStr);
		} catch (ParseException e) {
			throw new IllegalArgumentException(("解析'yyyy-MM-dd HH:mm:ss'形式时间戳为java.util.Date失败"));
		}
	}

	public static void removeNormal() {
		DATE_FORMAT_NORMAL_THREAD_LOCAL.remove();
	}

	/**
	 * 格式化时间为时间戳：yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date 时间
	 * @return 时间字符
	 */
	public static String formatDateYyyyMM(Date date) {
		return DATE_FORMAT_YYYYMM.get().format(date);
	}

	/**
	 * 解析字符串形式的时间戳为java.util.Date yyyy-MM-dd HH:mm:ss
	 * 
	 * @param timeStampStr 时间戳字符
	 * @return 时间
	 */
	public static Date parseDateFromStrYyyyMM(String timeStampStr) {
		try {
			return DATE_FORMAT_YYYYMM.get().parse(timeStampStr);
		} catch (ParseException e) {
			throw new IllegalArgumentException(("解析'yyyyMM'形式时间戳为java.util.Date失败"));
		}
	}

	public static void removeYyyyMM() {
		DATE_FORMAT_YYYYMM.remove();
	}

	/**
	 * 格式化时间为时间戳：yyyy-MM-dd
	 * 
	 * @param date 时间
	 * @return 时间字符
	 */
	public static String formatDateYyyyMMdd2(Date date) {
		return DATE_FORMATY_YYYMMDD2.get().format(date);
	}

	/**
	 * 解析字符串形式的时间戳为java.util.Date yyyy-MM-dd
	 * 
	 * @param timeStampStr 时间戳字符
	 * @return 时间
	 */
	public static Date parseDateFromStrYyyyMMdd2(String timeStampStr) {
		try {
			return DATE_FORMATY_YYYMMDD2.get().parse(timeStampStr);
		} catch (ParseException e) {
			throw new IllegalArgumentException(("解析'yyyy-MM-dd'形式时间戳为java.util.Date失败"));
		}
	}

	public static void removeYyyyMMdd2() {
		DATE_FORMATY_YYYMMDD2.remove();
	}

}
