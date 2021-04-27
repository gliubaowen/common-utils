/**
 * 
 */
package com.lbw.common.utils.tools;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author LiuBaoWen
 *
 */
@RunWith(JUnit4.class)
public class IdCardUtilsTest {

	String cardNo = "412324199805207246";

	@Test
	public void getCarInfoTest() {
		Map<String, Object> carInfo = IdCardUtils.getCarInfo(cardNo);
		System.out.println(carInfo);
	}

	@Test
	public void getBirthTest() {
		String birth = IdCardUtils.getBirth(cardNo);
		System.out.println("生日：" + birth);
	}

	@Test
	public void getAgeTest() {
		int age = IdCardUtils.getAge(cardNo);
		System.out.println("年龄：" + age);
	}

	@Test
	public void getSexTest() {
		String sex = IdCardUtils.getSex(cardNo);
		System.out.println("性别：" + sex);
	}

}
