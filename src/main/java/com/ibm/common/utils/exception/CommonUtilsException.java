/**
 * 
 */
package com.ibm.common.utils.exception;

/**
 * Common-Utils异常类
 * 
 * @author LiuBaoWen
 *
 */
public class CommonUtilsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 错误编码 */
	private String errorCode;

	/** get 错误编码 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode
	 */
	public CommonUtilsException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * @param message
	 */
	public CommonUtilsException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public CommonUtilsException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CommonUtilsException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CommonUtilsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
