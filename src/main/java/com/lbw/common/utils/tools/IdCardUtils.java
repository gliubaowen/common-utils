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
 * 
 * @author LiuBaoWen
 *
 */
public class IdCardUtils {

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

		String birth = cardNo.substring(6, 14);// 获得年份
		String year = cardNo.substring(6, 10);// 获得年份
		String month = cardNo.substring(10, 12);// 获得月份
		String day = cardNo.substring(12, 14);// 获得日
		idCardInfoMap.put("birth", birth);// 区域代码
		idCardInfoMap.put("area", cardNo.substring(0, 6));// 区域代码
		idCardInfoMap.put("year", year);
		idCardInfoMap.put("month", month);
		idCardInfoMap.put("day", day);
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
		Date nowdate = new Date();// 得到当前的系统时间
		String dataStr = new SimpleDateFormat("yyyy-MM-dd").format(nowdate);
		String nYear = dataStr.substring(0, 4);// 当前年份
		String nMonth = dataStr.substring(5, 7);// 月份
		// String nDay=format.format(date).substring(8,10);
		int age = 0;
		if (Integer.parseInt(month) <= Integer.parseInt(nMonth)) { // 当前月份大于用户出身的月份表示已过生
			age = Integer.parseInt(nYear) - Integer.parseInt(year) + 1;
		} else {// 当前用户还没过生
			age = Integer.parseInt(nYear) - Integer.parseInt(year);
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
		String sex;
		if (Integer.parseInt(cardNo.substring(16, 17)) % 2 == 0) {// 判断性别
			sex = "女";
		} else {
			sex = "男";
		}
		return sex;
	}

}
