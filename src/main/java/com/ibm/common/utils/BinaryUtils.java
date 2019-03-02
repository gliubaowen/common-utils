package com.ibm.common.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class BinaryUtils {

	public String getBinary(List<String> binaryList) {
		int size = binaryList == null ? 0 : binaryList.size();
		if (size == 0) {
			return "00000000";
		}
		int count = 0;
		int length = 0;
		for (int i = 0; i < size; i++) {
			String binaryStr = binaryList.get(i);
			if (length == 0) {
				length = binaryStr.length();
			} else {
				if (length < binaryStr.length()) {
					length = binaryStr.length();
				}
			}
			count = count + Integer.valueOf(binaryStr, 2);
		}
		String countStr = String.valueOf(Integer.toBinaryString(count));
		int countLength = countStr.length();
		if (countLength < length) {
			size = length - countLength;
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < size; i++) {
				sb.append("0");
			}
			sb.append(countStr);
			return sb.toString();
		}
		return countStr;
	}

	public List<String> getBinary(String binaryStr, int length) {
		List<String> retList = new ArrayList<String>();

		if (length < binaryStr.length()) {
			throw new RuntimeException("");
		}
		int left = length - binaryStr.length();
		StringBuffer binartSb = new StringBuffer();
		for (int i = 0; i < left; i++) {
			binartSb.append("0");
		}
		binartSb.append(binaryStr);

		char[] arr = binartSb.toString().toCharArray();
		for (int i = 0; i < length; i++) {

			StringBuffer sb = new StringBuffer();
			for (int m = 0; m < i; m++) {
				sb.append("0");
			}
			sb.append(arr[i]);
			for (int m = length - 1; m > i; m--) {
				sb.append("0");
			}
			retList.add(sb.toString());
		}
		return retList;
	}

	public List<String> getBinary(String binaryStr) {
		return getBinary(binaryStr, binaryStr.length());
	}

	public String getBinaryDB(String binaryStr, int length) {

		if (length < binaryStr.length()) {
			throw new RuntimeException("");
		}
		int left = length - binaryStr.length();
		StringBuffer binartSb = new StringBuffer();
		for (int i = 0; i < left; i++) {
			binartSb.append("0");
		}
		binartSb.append(binaryStr);
		return binartSb.toString().replace("0", "_");
	}

	public String getBinaryDB(String binaryStr) {
		return getBinaryDB(binaryStr, binaryStr.length());
	}

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(new BinaryUtils().getBinary("00101011"));
		System.out.println(new Date().getTime() - date.getTime());
	}

}
