package com.ibm.common.utils.cipher.ext;

import java.security.MessageDigest;

public class WLTMD5 {

	private String inStr;

	private MessageDigest md5; // java提供用于加密的类

	/* 下面是构造函数 */

	public WLTMD5(String inStr) {

		this.inStr = inStr;

		try {

			this.md5 = MessageDigest.getInstance("MD5");

		} catch (Exception e) {

		}

	}

	/* 下面是关键的md5算法 */

	public String compute() {

		char[] charArray = this.inStr.toCharArray();

		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)

			byteArray[i] = (byte) charArray[i];

		byte[] md5Bytes = this.md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {

			int val = ((int) md5Bytes[i]) & 0xff;

			if (val < 16)

				hexValue.append("0");

			hexValue.append(Integer.toHexString(val));

		}

		return hexValue.toString();

	}
}
