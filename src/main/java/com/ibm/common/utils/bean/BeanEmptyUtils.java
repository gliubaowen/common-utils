package com.ibm.common.utils.bean;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @Desc 判断对象是否为空的相关工具类
 * @author LiuBaoWen
 *
 */
public class BeanEmptyUtils {

	/**
	 * @Desc 判断对象为null, null-true, notnull-false
	 * @param obj
	 * @return boolean
	 */
	public static boolean isNull(Object obj) {
		return obj == null;
	}

	/**
	 * @Desc 判断对象不为null, notnull-true, null-false
	 * @param obj
	 * @return boolean
	 */
	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}

	/**
	 * 
	 * 方法描述 判断Map集合是null或者空 返回true 否则返回false
	 *
	 * @param list
	 * @return
	 */
	/*public static boolean isNull(Map<Object, Object> map) {
		if (map == null || map.isEmpty()) {
			return true;
		}
		return false;
	}*/
	
	/**
	 * 
	 * @Desc 判断Map集合非null 非空 返回true 否则返回false
	 *
	 * @param list
	 * @return
	 */
	/*public static boolean isNotNull(Map<Object, Object> map) {
		if (map != null && !map.isEmpty()) {
			return true;
		}
		return false;
	}*/


	/**
	 * 
	 * @Desc 判断Map集合非null 非空 返回true 否则返回false
	 *
	 * @param list
	 * @return
	 */
	/*public static boolean isNotNull(List<?> list) {
		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;
	}*/

	/**
	 * 
	 * 方法描述 判断Map集合是null或者空 返回true 否则返回false
	 *
	 * @param list
	 * @return
	 */
	/*public static boolean isNull(List<?> list) {
		if (list == null || list.isEmpty()) {
			return true;
		}
		return false;
	}*/

	
	/**
	 * @Desc 判断对象为空 
	 * @param obj
	 * @return boolean
	 */
	public static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;
		else if (obj instanceof CharSequence)
			return ((CharSequence) obj).length() == 0;
		else if (obj instanceof Collection)
			return ((Collection<?>) obj).isEmpty();
		else if (obj instanceof Map)
			return ((Map<?, ?>) obj).isEmpty();
		else if (obj.getClass().isArray())
			return Array.getLength(obj) == 0;

		return false;
	}

	/**
	 * @Desc 判断对象不为空
	 * @param obj
	 * @return boolean
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

	/**
	 * 
	 * @param array
	 * @return
	 */
	@Deprecated
	public static boolean isNullOrEmptyArray(Object[] array) {
		if (array == null) {
			return true;
		}
		if (array.length == 0) {
			return true;
		}
		boolean eachItemIsNull = true;
		for (Object item : array) {
			if (item != null) {
				eachItemIsNull = false;
			}
		}
		return eachItemIsNull;
	}

	/**
	 * 
	 * @param list
	 * @return
	 */
	@Deprecated
	public static boolean isNullOrEmptyList(List<?> list) {
		if (list == null) {
			return true;
		}
		if (list.isEmpty()) {
			return true;
		}
		boolean eachItemIsNull = true;
		for (Object item : list) {
			if (item != null) {
				eachItemIsNull = false;
			}
		}
		return eachItemIsNull;
	}
    
}


