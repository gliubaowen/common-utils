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

	@Test
	public void getCarInfoTest() {
		String cardNo = "";
		Map<String, Object> carInfo = IdCardUtils.getCarInfo(cardNo);
		System.out.println(carInfo);
	}

	@Test
	public void getBirthTest() {
		String cardNo = "";
		String birth = IdCardUtils.getBirth(cardNo);
		System.out.println(birth);
	}

	@Test
	public void getAgeTest() {
		String cardNo = "";
		int age = IdCardUtils.getAge(cardNo);
		System.out.println(age);
	}

	@Test
	public void getSexTest() {
		String cardNo = "";
		String sex = IdCardUtils.getSex(cardNo);
		System.out.println(sex);
	}

}
