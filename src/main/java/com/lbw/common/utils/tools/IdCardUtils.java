/**
 * 
 */
package com.lbw.common.utils.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.lbw.common.utils.exception.CommonUtilsException;

/**
 * 身份证工具类
 * <p>
 * 省份证1-6位是区域代码<br>
 * 省份证7-10位是出生日期<br>
 * 省份证11-12位是出生月份<br>
 * 省份证13-14位是出生那天<br>
 * 省份证17位是性别 偶数为女 奇数为男<br>
 * </p>
 * 
 * @author LiuBaoWen
 *
 */
public class IdCardUtils {

	private IdCardUtils() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * 根据身份证的号码获得身份证信息
	 * 
	 * @author LiuBaoWen
	 * @param cardNo
	 * @return
	 * @throws CommonUtilsException
	 */
	public static Map<String, Object> getCarInfo(String cardNo) throws CommonUtilsException {
		Map<String, Object> idCardInfoMap = new HashMap<>();
		idCardInfoMap.put("area", cardNo.substring(0, 6));// 区域代码
		idCardInfoMap.put("birth", cardNo.substring(6, 14));// 生日
		idCardInfoMap.put("year", cardNo.substring(6, 10)); // 出生年份
		idCardInfoMap.put("month", cardNo.substring(10, 12));// 出生月份
		idCardInfoMap.put("day", cardNo.substring(12, 14));// 出生那天
		return idCardInfoMap;
	}

	/**
	 * 获得生日
	 * 
	 * @author LiuBaoWen
	 * @param cardNo
	 * @return
	 */
	public static String getBirth(String cardNo) {
		return cardNo.substring(6, 14);// 获得年份
	}

	/**
	 * 获得年龄
	 * 
	 * @author LiuBaoWen
	 * @param cardNo
	 * @return
	 */
	public static int getAge(String cardNo) {
		String year = cardNo.substring(6, 10);// 获得年份
		String month = cardNo.substring(10, 12);// 获得月份
		String dataStr = new SimpleDateFormat("yyyy-MM-dd").format(new Date());// 得到当前的系统时间
		String nYear = dataStr.substring(0, 4);// 当前年份
		String nMonth = dataStr.substring(5, 7);// 月份
		int age = Integer.parseInt(nYear) - Integer.parseInt(year);
		if (Integer.parseInt(month) <= Integer.parseInt(nMonth)) { // 当前月份大于用户出身的月份表示已过生日
			age++;
		}
		return age;
	}

	/**
	 * 获得性别
	 * 
	 * @author LiuBaoWen
	 * @param cardNo
	 * @return
	 */
	public static String getSex(String cardNo) {
		if (Integer.parseInt(cardNo.substring(16, 17)) % 2 == 0) // 判断性别
			return "女";
		return "男";
	}

}
