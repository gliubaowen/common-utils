/**
 * 
 */
package com.ibm.common.utils.bean.test;

import com.ibm.common.utils.bean.BeanUtils;

import junit.framework.TestCase;

/**
 * @author LiuBaoWen
 *
 */
public class BeanUtilsTest extends TestCase {

	public void Test() {

		FromBean fromBean = new FromBean();
		ToBean toBean = new ToBean();
		BeanUtils.copyBean(fromBean, toBean);

	}

}
