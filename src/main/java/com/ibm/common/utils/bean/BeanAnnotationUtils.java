package com.ibm.common.utils.bean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.ibm.common.annotation.BeanField;

/**
 * 
 * @author LiuBaoWen
 *
 */
public abstract class BeanAnnotationUtils {

	/**
	 * 属性Field按注解排序
	 * 
	 * @author LiuBaoWen
	 * @param fields
	 * @return
	 */
	public static List<Field> getOrderedBeanField(Field[] fields) {
		// 用来存放所有的属性域
		List<Field> fieldList = new ArrayList<Field>(fields.length);
		// 过滤带有注解的Field
		for (Field f : fields) {
			if (f.getAnnotation(BeanField.class) != null) {
				f.setAccessible(true);
				fieldList.add(f);
			}
		}
		// 这个比较排序的语法依赖于java 1.8
		fieldList.sort(Comparator.comparingInt(m -> m.getAnnotation(BeanField.class).order()));
		return fieldList;
	}

	/**
	 * 属性Field按注解排序
	 * 
	 * @author LiuBaoWen
	 * @param fields
	 * @return
	 */
	public static List<Field> getOrderedDoubleBeanField(Field[] fields) {
		// 用来存放所有的属性域
		List<Field> fieldList = new ArrayList<Field>(fields.length);
		// 过滤带有注解的Field
		for (Field f : fields) {
			if (f.getAnnotation(BeanField.class) != null) {
				f.setAccessible(true);
				fieldList.add(f);
			}
		}
		// 这个比较排序的语法依赖于java 1.8
		fieldList.sort(Comparator.comparingDouble(m -> m.getAnnotation(BeanField.class).order()));
		return fieldList;
	}

}
