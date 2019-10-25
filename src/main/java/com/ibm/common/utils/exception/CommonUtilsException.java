/**
 * 
 */
package com.ibm.common.utils.exception;

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
	 * @param message
	 */
	public CommonUtilsException(String message) {
		super(message);
	}

	/**
	 * @param errorCode
	 */
	public CommonUtilsException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * 
	 * @param errorCode
	 * @param message
	 * @param cause
	 */
	public CommonUtilsException(String errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
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

	/** get 错误编码 */
	public String getErrorCode() {
		return errorCode;
	}

}
