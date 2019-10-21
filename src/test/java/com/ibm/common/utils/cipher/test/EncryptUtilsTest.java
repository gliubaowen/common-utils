package com.ibm.common.utils.cipher.test;

import static org.junit.Assert.assertArrayEquals;

import java.math.BigInteger;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.ibm.common.utils.cipher.DESEncryptUtils;
import com.ibm.common.utils.cipher.DHEncryptUtils;
import com.ibm.common.utils.cipher.DSAEncryptUtils;
import com.ibm.common.utils.cipher.EncryptUtils;
import com.ibm.common.utils.cipher.PBEEncryptUtils;
import com.ibm.common.utils.cipher.RSAEncryptUtils;

import junit.framework.TestCase;

/**
 * 加密测试类
 * 
 * @author LiuBaoWen
 *
 */
@RunWith(JUnit4.class)
public class EncryptUtilsTest extends TestCase {

	@Test
	public void SimpleEncryptTest() throws Exception {
		String inputStr = "简单加密";
		System.err.println("原文:\n" + inputStr);

		byte[] inputData = inputStr.getBytes();
		String code = EncryptUtils.encryptBASE64(inputData);

		System.err.println("BASE64加密后:\n" + code);

		byte[] output = EncryptUtils.decryptBASE64(code);

		String outputStr = new String(output);

		System.err.println("BASE64解密后:\n" + outputStr);

		// 验证BASE64加密解密一致性
		assertEquals(inputStr, outputStr);

		// 验证MD5对于同一内容加密是否一致
		assertArrayEquals(EncryptUtils.encryptMD5(inputData), EncryptUtils.encryptMD5(inputData));

		// 验证SHA对于同一内容加密是否一致
		assertArrayEquals(EncryptUtils.encryptSHA(inputData), EncryptUtils.encryptSHA(inputData));

		String key = EncryptUtils.initMacKey();
		System.err.println("Mac密钥:\n" + key);

		// 验证HMAC对于同一内容，同一密钥加密是否一致
		assertArrayEquals(EncryptUtils.encryptHMAC(inputData, key), EncryptUtils.encryptHMAC(inputData, key));

		BigInteger md5 = new BigInteger(EncryptUtils.encryptMD5(inputData));
		System.err.println("MD5:\n" + md5.toString(16));

		BigInteger sha = new BigInteger(EncryptUtils.encryptSHA(inputData));
		System.err.println("SHA:\n" + sha.toString(32));

		BigInteger mac = new BigInteger(EncryptUtils.encryptHMAC(inputData, inputStr));
		System.err.println("HMAC:\n" + mac.toString(16));
	}

	@Test
	public void DESEncryptTest() throws Exception {
		String inputStr = "DES12";
		String key = DESEncryptUtils.initKey("abc");
		System.err.println("原文:\t" + inputStr);

		System.err.println("密钥:\t" + key);

		byte[] inputData = inputStr.getBytes();
		inputData = DESEncryptUtils.encrypt(inputData, key);

		String encryptBASE64 = DESEncryptUtils.encryptBASE64(inputData);
		System.err.println("加密后:\t" + encryptBASE64);

		byte[] decryptBASE64 = DESEncryptUtils.decryptBASE64(encryptBASE64);

		byte[] outputData = DESEncryptUtils.decrypt(decryptBASE64, key);

		String outputStr = new String(outputData);

		System.err.println("解密后:\t" + outputStr);

	}

	@Test
	public void PBEEncryptTest() throws Exception {
		String inputStr = "abc";
		System.err.println("原文: " + inputStr);
		byte[] input = inputStr.getBytes();

		String pwd = "efg";
		System.err.println("密码: " + pwd);

		byte[] salt = PBEEncryptUtils.initSalt();

		byte[] data = PBEEncryptUtils.encrypt(input, pwd, salt);

		System.err.println("加密后: " + PBEEncryptUtils.encryptBASE64(data));

		byte[] output = PBEEncryptUtils.decrypt(data, pwd, salt);
		String outputStr = new String(output);

		System.err.println("解密后: " + outputStr);
		assertEquals(inputStr, outputStr);
	}

	private String publicKey;
	private String privateKey;

	/*
	 * @Before public void setUp() throws Exception { Map<String, Object> keyMap =
	 * RSAEncryptUtil.initKey();
	 * 
	 * publicKey = RSAEncryptUtil.getPublicKey(keyMap); privateKey =
	 * RSAEncryptUtil.getPrivateKey(keyMap); System.err.println("公钥: \n\r" +
	 * publicKey); System.err.println("私钥： \n\r" + privateKey); }
	 */

	@Test
	public void RSAEncryptTest() throws Exception {

		Map<String, Object> keyMap = RSAEncryptUtils.initKey();
		publicKey = RSAEncryptUtils.getPublicKey(keyMap);
		privateKey = RSAEncryptUtils.getPrivateKey(keyMap);
		System.err.println("公钥: \n\r" + publicKey);
		System.err.println("私钥： \n\r" + privateKey);

		System.err.println("公钥加密——私钥解密");
		String inputStr = "abc";
		byte[] data = inputStr.getBytes();

		byte[] encodedData = RSAEncryptUtils.encryptByPublicKey(data, publicKey);

		byte[] decodedData = RSAEncryptUtils.decryptByPrivateKey(encodedData, privateKey);

		String outputStr = new String(decodedData);
		System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
		assertEquals(inputStr, outputStr);

	}

	@Test
	public void RSAEncryptTestSign() throws Exception {

		Map<String, Object> keyMap = RSAEncryptUtils.initKey();
		publicKey = RSAEncryptUtils.getPublicKey(keyMap);
		privateKey = RSAEncryptUtils.getPrivateKey(keyMap);
		System.err.println("公钥: \n\r" + publicKey);
		System.err.println("私钥： \n\r" + privateKey);

		System.err.println("私钥加密——公钥解密");
		String inputStr = "sign";
		byte[] data = inputStr.getBytes();

		byte[] encodedData = RSAEncryptUtils.encryptByPrivateKey(data, privateKey);

		byte[] decodedData = RSAEncryptUtils.decryptByPublicKey(encodedData, publicKey);

		String outputStr = new String(decodedData);
		System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
		assertEquals(inputStr, outputStr);

		System.err.println("私钥签名——公钥验证签名");
		// 产生签名
		String sign = RSAEncryptUtils.sign(encodedData, privateKey);
		System.err.println("签名:\r" + sign);

		// 验证签名
		boolean status = RSAEncryptUtils.verify(encodedData, publicKey, sign);
		System.err.println("状态:\r" + status);
		assertTrue(status);

	}

	public void DHEncryptTest() throws Exception {
		// 生成甲方密钥对儿
		Map<String, Object> aKeyMap = DHEncryptUtils.initKey();
		String aPublicKey = DHEncryptUtils.getPublicKey(aKeyMap);
		String aPrivateKey = DHEncryptUtils.getPrivateKey(aKeyMap);

		System.err.println("甲方公钥:\r" + aPublicKey);
		System.err.println("甲方私钥:\r" + aPrivateKey);

		// 由甲方公钥产生本地密钥对儿
		Map<String, Object> bKeyMap = DHEncryptUtils.initKey(aPublicKey);
		String bPublicKey = DHEncryptUtils.getPublicKey(bKeyMap);
		String bPrivateKey = DHEncryptUtils.getPrivateKey(bKeyMap);

		System.err.println("乙方公钥:\r" + bPublicKey);
		System.err.println("乙方私钥:\r" + bPrivateKey);

		String aInput = "abc ";
		System.err.println("原文: " + aInput);

		// 由甲方公钥，乙方私钥构建密文
		byte[] aCode = DHEncryptUtils.encrypt(aInput.getBytes(), aPublicKey, bPrivateKey);

		// 由乙方公钥，甲方私钥解密
		byte[] aDecode = DHEncryptUtils.decrypt(aCode, bPublicKey, aPrivateKey);
		String aOutput = (new String(aDecode));

		System.err.println("解密: " + aOutput);

		assertEquals(aInput, aOutput);

		System.err.println(" ===============反过来加密解密================== ");
		String bInput = "def ";
		System.err.println("原文: " + bInput);

		// 由乙方公钥，甲方私钥构建密文
		byte[] bCode = DHEncryptUtils.encrypt(bInput.getBytes(), bPublicKey, aPrivateKey);

		// 由甲方公钥，乙方私钥解密
		byte[] bDecode = DHEncryptUtils.decrypt(bCode, aPublicKey, bPrivateKey);
		String bOutput = (new String(bDecode));

		System.err.println("解密: " + bOutput);

		assertEquals(bInput, bOutput);
	}

	@Test
	public void DSAEncryptTest() throws Exception {
		String inputStr = "abc";
		byte[] data = inputStr.getBytes();

		// 构建密钥
		Map<String, Object> keyMap = DSAEncryptUtils.initKey();

		// 获得密钥
		String publicKey = DSAEncryptUtils.getPublicKey(keyMap);
		String privateKey = DSAEncryptUtils.getPrivateKey(keyMap);

		System.err.println("公钥:\r" + publicKey);
		System.err.println("私钥:\r" + privateKey);

		// 产生签名
		String sign = DSAEncryptUtils.sign(data, privateKey);
		System.err.println("签名:\r" + sign);

		// 验证签名
		boolean status = DSAEncryptUtils.verify(data, publicKey, sign);
		System.err.println("状态:\r" + status);
		assertTrue(status);

	}

	/*
	 * @Test public void ECCEncryptTest() throws Exception { String inputStr =
	 * "abc"; byte[] data = inputStr.getBytes();
	 * 
	 * Map<String, Object> keyMap = ECCEncryptUtil.initKey();
	 * 
	 * String publicKey = ECCEncryptUtil.getPublicKey(keyMap); String privateKey =
	 * ECCEncryptUtil.getPrivateKey(keyMap); System.err.println("公钥: \n" +
	 * publicKey); System.err.println("私钥： \n" + privateKey);
	 * 
	 * byte[] encodedData = ECCEncryptUtil.encrypt(data, publicKey);
	 * 
	 * byte[] decodedData = ECCEncryptUtil.decrypt(encodedData, privateKey);
	 * 
	 * String outputStr = new String(decodedData); System.err.println("加密前: " +
	 * inputStr + "\n\r" + "解密后: " + outputStr); assertEquals(inputStr, outputStr);
	 * }
	 */

}
