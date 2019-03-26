package com.ibm.common.utils.string;

public class HashUtils {

	private static final String DEFAULT = "00";

	public static String getMemberHash(String memberId) {
		if (memberId == null) {
			return DEFAULT;
		}

		String hashValue = null;
		if (memberId.length() == 1) {
			hashValue = memberId;
		} else {
			hashValue = memberId.substring(memberId.length() - 1, memberId.length());
		}

		if (!("0".equals(hashValue) || "1".equals(hashValue) || "2".equals(hashValue) || "3".equals(hashValue)
				|| "4".equals(hashValue) || "5".equals(hashValue) || "6".equals(hashValue) || "7".equals(hashValue)
				|| "8".equals(hashValue) || "9".equals(hashValue))) {
			return DEFAULT;
		}
		return "0" + hashValue;
	}
}