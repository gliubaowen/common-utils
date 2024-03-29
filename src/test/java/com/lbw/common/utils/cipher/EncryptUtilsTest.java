package com.lbw.common.utils.cipher;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * 加密测试类
 * 
 * @author LiuBaoWen
 *
 */
@RunWith(JUnit4.class)
public class EncryptUtilsTest extends Assert {

	@Test
	public void testEncryptMD5() {

		try {
			byte[] encryptMD5 = EncryptUtils.encryptMD5("hello111");
			System.out.println(encryptMD5.toString());
			assertEquals("[B@880ec60", encryptMD5.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testEncryptSHA() {
		try {
			byte[] encryptMD5 = EncryptUtils.encryptSHA("hello");
			System.out.println(encryptMD5);
			assertEquals("[B@880ec60", encryptMD5.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
