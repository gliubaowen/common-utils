package com.ibm.common.utils.cipher.ext;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * MD5加密,生成随机密码
 * 
 * @author terence
 *
 */
public class Encript {
	// 随机的数字到字符的映射数组
	private final static String[] hexDigits = { "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G",
			"H", "K", "M", "N", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "a", "b", "c", "d", "e", "f", "g", "h",
			"k", "m", "n", "q", "r", "s", "t", "u", "v", "w", "x", "y" };

	/** 把inputString加密 */
	public static String md5(String inputStr) {
		return encodeByMD5(inputStr);
	}

	/**
	 * 验证输入的密码是否正确
	 * 
	 * @param password    真正的密码（加密后的真密码）
	 * @param inputString 输入的字符串
	 * @return 验证结果，boolean类型
	 */
	public static boolean authenticatePassword(String password, String inputString) {
		if (password.equals(encodeByMD5(inputString))) {
			return true;
		} else {
			return false;
		}
	}

	/** 对字符串进行MD5编码 */
	private static String encodeByMD5(String originString) {
		if (originString != null) {
			try {
				// 创建具有指定算法名称的信息摘要
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				// 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
				byte[] results = md5.digest(originString.getBytes());
				// 将得到的字节数组变成字符串返回
				String result = byteArrayToHexString(results);
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 轮换字节数组为随机的字符串
	 * 
	 * @param b 字节数组
	 * @return 随机的字符串
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	// 将一个字节转化成随机的字符串
	private static String byteToHexString(byte b) {
		int n = b;

		if (n < 0)
			n = 256 + n;
		int d1 = n / 47;
		int d2 = n % 47;
		return hexDigits[d1] + hexDigits[d2];
	}

	/**
	 * 获取num数秘钥
	 * 
	 * @param num 位数
	 */
	public static String getSecretKey(int num) {
		String secretKey = "";

		String md5Val = md5(UUID.randomUUID().toString());
		char[] md5L = md5Val.toCharArray();
		int len = md5L.length;

		for (int i = 0; i < num; i++) {
			// 数组范围内,获取随机数
			int random = (int) (Math.random() * len);
			// 组装随机密码
			secretKey += md5L[random];
		}

		return secretKey;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 99999; i++) {
			System.out.println(getSecretKey(6));
		}

		/*
		 * String md5Val = md5("测试aaaa"); System.out.println(md5Val);
		 * System.out.println(getSecretKey(6));
		 */
	}
}
