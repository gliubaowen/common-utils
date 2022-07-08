/**
 * 
 */
package com.lbw.common.utils.tools;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author LiuBaoWen
 *
 */
@RunWith(JUnit4.class)
public class IdCardUtilsTest {

	String cardNo = null;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Test：" + "IdCardUtils" + ": start");
	}

	@Before
	public void before() {
		cardNo = "412324199805207246";
	}

	@After
	public void after() {
		cardNo = null;
	}

	@Test
	public void getCarInfoTest() {
		Map<String, Object> carInfo = IdCardUtils.getCarInfo(cardNo);
		System.out.println(carInfo);
		Map<String, Object> carInfoMap = Map.of("area", "412324", "month", "05", "year", "1998", "birth", "19980520",
				"day", "20");
		assertEquals("计算不正确", carInfoMap, carInfo);
	}

	@Test
	public void getBirthTest() {
		String birth = IdCardUtils.getBirth(cardNo);
		System.out.println("生日：" + birth);
		assertThat("生日计算不正确", birth, is("19980520"));
	}

	@Test
	public void getAgeTest() {
		int age = IdCardUtils.getAge(cardNo);
		System.out.println("年龄：" + age);
		assertEquals("年龄计算不正确", 25, age);
	}

	@Test
	public void getSexTest() {
		String sex = IdCardUtils.getSex(cardNo);
		System.out.println("性别：" + sex);
		assertEquals("性别计算不正确", "女", sex);
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("Test：" + "IdCardUtils" + ": end");
	}

}
