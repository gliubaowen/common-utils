package com.lbw.common.utils.cipher;

import java.security.MessageDigest;

/**
 * 加密工具类 BASE64,MD5,SHA,
 * 
 * @author LiuBaoWen
 *
 */
public class EncryptUtils {

	public static final String KEY_SHA = "SHA";
	public static final String KEY_MD5 = "MD5";

	/**
	 * MD5加密
	 * 
	 * @author LiuBaoWen
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptMD5(String dataStr) throws Exception {
		byte[] data = dataStr.getBytes();
		MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
		md5.update(data);
		return md5.digest();
	}

	/**
	 * SHA加密
	 * 
	 * @author LiuBaoWen
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public static byte[] encryptSHA(String dataStr) throws Exception {
		byte[] data = dataStr.getBytes();
		MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
		sha.update(data);
		return sha.digest();
	}

}
