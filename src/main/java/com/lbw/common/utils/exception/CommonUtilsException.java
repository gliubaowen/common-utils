/**
 * 
 */
package com.lbw.common.utils.exception;

import com.lbw.common.utils.constants.ConmonUtilsEnums;

/**
 * common-utils异常类
 * 
 * @author LiuBaoWen
 *
 */
public class CommonUtilsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4087292349412186395L;

	/** 错误编码 */
	private String errorCode;

	/**
	 * @param message 信息
	 */
	public CommonUtilsException(String message) {
		super(message);
	}

	/**
	 * @param conmonUtilsEnums 异常枚举
	 */
	public CommonUtilsException(ConmonUtilsEnums conmonUtilsEnums) {
		super(conmonUtilsEnums.getMessage());
		this.errorCode = conmonUtilsEnums.getErrorCode();
	}

	/**
	 * @param errorCode 错误编码
	 * @param message   信息
	 */
	public CommonUtilsException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * 
	 * @param errorCode 错误编码
	 * @param message   信息
	 * @param cause     异常
	 */
	public CommonUtilsException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	/**
	 * @param cause 异常
	 */
	public CommonUtilsException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message 信息
	 * @param cause   异常
	 */
	public CommonUtilsException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message            信息
	 * @param cause              异常
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CommonUtilsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * 获取错误编码
	 * 
	 * @return errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

}
