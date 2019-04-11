package com.ibm.common.utils.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * java Bean Field annotation
 * 
 * @author LiuBaoWen
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BeanField {

	/* 标注属性的顺序 */
	int order();

}
