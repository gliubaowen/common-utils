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
 * @Class Name NumUtils
 * @Author lihf
 * @Create In 2014年10月22日
 */
public class NumUtils {
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * 
	 * @param strLength
	 * @return
	 */
	public static String getFixLenthString(int strLength) {

		// Random rm = new Random();
		SecureRandom rm = new SecureRandom();

		// 获得随机数
		double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);

		// 将获得的获得随机数转化为字符串
		String fixLenthString = String.valueOf(pross);

		// 返回固定的长度的随机数
		return fixLenthString.substring(1, strLength + 1);
	}

	public static void main(String[] args) {
		int i = 0;
		while (i < 20) {
			System.out.println(getFixLenthString(6));
			i++;
		}
	}
}
