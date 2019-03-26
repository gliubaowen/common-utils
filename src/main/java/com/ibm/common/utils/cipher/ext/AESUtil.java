package com.ibm.common.utils.cipher.ext;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {

	private static String password = "bl.com";

	private static byte[] bKey;

	public static void main(String[] args) throws Exception {
		// 加密
		String text = "hello world";
//        String password = getAutoCreateAESKey();
//        System.out.println(password);

		// 该秘钥需要通过一个key来进行生产
		password = "";
		String dKey = getAutoCreateAESKey(password);
		System.out.println("生成的秘钥:" + dKey);

		String b = getAESEncode(dKey, text);

//        System.out.println(byteArr2HexStr(b));

		String a = getAESDecode(dKey, b);
		System.out.println(a);

	}

	/**
	 * 生成密钥 自动生成AES128位密钥
	 * 
	 * @throws Exception
	 */
	public static String getAutoCreateAESKey(String password) throws Exception {
		KeyGenerator kg = KeyGenerator.getInstance("AES");

		// 要生成多少位，只需要修改这里即可128, 192或256
		kg.init(128, new SecureRandom(password.getBytes()));
		SecretKey sk = kg.generateKey();
		bKey = sk.getEncoded();

		return byteArr2HexStr(bKey);

	}

	/**
	 * 加密 使用对称密钥进行加密 keyFilePath 密钥存放路径 text 要加密的字节数组 加密后返回一个字节数组
	 * 
	 * @throws Exception
	 */
	public static String getAESEncode(String dKey, String value) throws Exception {
//    	getAutoCreateAESKey(dKey);

		byte[] text = value.getBytes("utf-8");
		SecretKeySpec sKeySpec = new SecretKeySpec(hexStr2ByteArr(dKey), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
		byte[] bjiamihou = cipher.doFinal(text);

		return byteArr2HexStr(bjiamihou);
	}

	/**
	 * 解密 使用对称密钥进行解密 keyFilePath 密钥存放路径 text 要解密的字节数组 解密后返回一个字节数组
	 * 
	 * @throws Exception
	 */
	public static String getAESDecode(String dKey, String value) throws Exception {
//    	byte[] text = hexStr2ByteArr(value);
//    	System.out.println(text.toString());
		SecretKeySpec sKeySpec = new SecretKeySpec(hexStr2ByteArr(dKey), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, sKeySpec);
		byte[] bjiemihou = cipher.doFinal(hexStr2ByteArr(value));
//        String result = byteArr2HexStr(bjiemihou);
		return new String(bjiemihou);

	}

	public static String byteArr2HexStr(byte[] arrB) throws Exception {
		int iLen = arrB.length;
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			while (intTmp < 0) {
				intTmp = intTmp + 256;
			}
			if (intTmp < 16) {
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16));
		}
		return sb.toString();
	}

	public static byte[] hexStr2ByteArr(String strIn) throws Exception {
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;

		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

}
