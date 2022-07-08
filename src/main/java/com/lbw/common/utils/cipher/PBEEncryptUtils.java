package com.lbw.common.utils.cipher;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 * PBE安全编码组件
 * 
 * @author LiuBaoWen
 * @version 1.0
 * @since 1.0
 */
public class PBEEncryptUtils {

	private PBEEncryptUtils() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * 支持以下任意一种算法
	 * 
	 * <pre>
	 * PBEWithMD5AndDES 
	 * PBEWithMD5AndTripleDES 
	 * PBEWithSHA1AndDESede
	 * PBEWithSHA1AndRC2_40
	 * </pre>
	 */
	public static final String ALGORITHM = "PBEWITHMD5andDES";

	/**
	 * 转换密钥<br>
	 * 
	 * @param password
	 * @return
	 * @throws Exception
	 */
	private static Key toKey(String password) throws Exception {
		PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
		return keyFactory.generateSecret(keySpec);
	}

	/**
	 * 加密
	 * 
	 * @param data     数据
	 * @param password 密码
	 * @param salt     盐
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] data, String password, byte[] salt) throws Exception {

		Key key = toKey(password);

		PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 100);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);

		return cipher.doFinal(data);

	}

	/**
	 * 解密
	 * 
	 * @param data     数据
	 * @param password 密码
	 * @param salt     盐
	 * @return
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] data, String password, byte[] salt) throws Exception {

		Key key = toKey(password);

		PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 100);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

		return cipher.doFinal(data);

	}
}
