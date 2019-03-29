/**
 * @Probject Name: common-core
 * @Path: com.ibm.sc.core.utilsNumberUtils.java
 * @Create By fanshunqing
 * @Create In 2014年10月22日 下午6:48:12
 * TODO
 */
package com.ibm.common.utils.math;

import java.security.SecureRandom;
import java.util.regex.Pattern;

/**
 * 数字工具类
 * 
 * @author LiuBaoWen
 *
 */
public class NumUtils {

	/**
	 * 判断String是否能转化成BigDecimal
	 * 
	 * @author LiuBaoWen
	 * @param str
	 * @return
	 */
	public static boolean isBigDecimal(String str) {
		if (str == null || str.trim().length() == 0) {
			return false;
		}
		char[] chars = str.toCharArray();
		int sz = chars.length;
		int i = (chars[0] == '-') ? 1 : 0;
		if (i == sz)
			return false;

		if (chars[i] == '.')
			return false;// 除了负号，第一位不能为'小数点'

		boolean radixPoint = false;
		for (; i < sz; i++) {
			if (chars[i] == '.') {
				if (radixPoint)
					return false;
				radixPoint = true;
			} else if (!(chars[i] >= '0' && chars[i] <= '9')) {
				return false;
			}
		}
		return true;
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

}
