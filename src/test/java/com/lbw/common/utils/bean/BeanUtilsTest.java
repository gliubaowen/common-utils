/**
 * 
 */
package com.lbw.common.utils.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author LiuBaoWen
 *
 */
@RunWith(JUnit4.class)
public class BeanUtilsTest {

	@Test
	public void beanTest() {

		FromBean fromBean = new FromBean();
		ToBean toBean = new ToBean();
		BeanUtils.copyBean(fromBean, toBean);

	}

}
