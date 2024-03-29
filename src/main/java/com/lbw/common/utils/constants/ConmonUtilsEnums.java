package com.lbw.common.utils.constants;

/**
 * Exception 枚举类
 *
 * @author LiuBaoWen
 *
 */
public enum ConmonUtilsEnums {

	/**  */
	PATH_IS_NULL("0001", "文件路径为空");

	ConmonUtilsEnums(String errorCode, String message) {
		this.errorCode = errorCode;
		this.message = message;
	}

	/** 错误编码 */
	private String errorCode;
	/** 错误信息 */
	private String message;

	public String getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

}
