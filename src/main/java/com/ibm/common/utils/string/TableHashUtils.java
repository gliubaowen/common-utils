package com.ibm.common.utils.string;

public class TableHashUtils {

	public static String getHashTable(String code) {
		try {
			return "0" + code.substring(9, 10);
		} catch (Exception e) {
			return "00";
		}
	}

	public static String getHashMember(String memberId) {
		try {
			return "0" + memberId.substring(memberId.length() - 1, memberId.length());
		} catch (Exception e) {
			return "00";
		}
	}

	public static Integer getHashMemberForInteger(String memberId) {
		try {
			return Integer.valueOf(memberId.substring(memberId.length() - 1, memberId.length()));
		} catch (Exception e) {
			return 0;
		}
	}

}
