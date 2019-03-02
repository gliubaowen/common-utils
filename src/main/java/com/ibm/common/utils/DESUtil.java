package com.ibm.common.utils;

import java.security.Key;
import java.security.Security;
import java.util.UUID;

import javax.crypto.Cipher;

/**
 * DES加密解密
 * 
 * @author terence
 *
 */
public class DESUtil {
	// 默认加密秘钥
	private static String strDefaultKey = "bl.com";

	private Cipher encryptCipher = null;

	private Cipher decryptCipher = null;

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

	public DESUtil() throws Exception {
		this(strDefaultKey);
	}

	/**
	 * 
	 * @param strKey 加密秘钥
	 * 
	 * @throws Exception
	 */
	@SuppressWarnings("restriction")
	public DESUtil(String strKey) throws Exception {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		Key key = getKey(strKey.getBytes());
		encryptCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		encryptCipher.init(Cipher.ENCRYPT_MODE, key);

		decryptCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		decryptCipher.init(Cipher.DECRYPT_MODE, key);
	}

	public byte[] encrypt(byte[] arrB) throws Exception {
		return encryptCipher.doFinal(arrB);
	}

	/**
	 * 加密
	 * 
	 * @param 需要加密字符
	 */
	public String encrypt(String strIn) throws Exception {
		return byteArr2HexStr(encrypt(strIn.getBytes()));
	}

	public byte[] decrypt(byte[] arrB) throws Exception {
		return decryptCipher.doFinal(arrB);
	}

	/**
	 * 解密
	 * 
	 * @param 需要解密字符
	 */
	public String decrypt(String strIn) throws Exception {
		return new String(decrypt(hexStr2ByteArr(strIn)));
	}

	private Key getKey(byte[] arrBTmp) throws Exception {
		byte[] arrB = new byte[8];

		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
			arrB[i] = arrBTmp[i];
		}
		// 秘钥 DES 算法名称
		Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");

		return key;
	}

    public static void main(String[] args){
        try {
        	long start=System.currentTimeMillis();
            DESUtil desUtil = new DESUtil();
//            UUIDGenerator UUIDGenerator = new UUIDGenerator();
//            
//            //System.out.println("uuid=>"+uuid);
//            UUID uuid=UUIDGenerator.generateId("123");
            UUID t = UUID.randomUUID();
            System.out.println("uuid=>"+t.toString());
            //String md5=MD5.MD5Str(t.toString());
            String md5=t.toString();
            System.out.println("md5=>"+md5);
       
            String encryted=desUtil.encrypt("m:t:h:"+"df66ac92ae35e331");
            System.out.println("encryted=>"+encryted);
            System.out.println("decrypt=>"+desUtil.decrypt(encryted));
            System.out.println(encryted);
                
            long end=System.currentTimeMillis();
            System.out.println(end-start);

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
