package com.lbw.common.utils.file;

import java.io.File;
import java.io.IOException;

import com.lbw.common.utils.constants.ConmonUtilsEnums;
import com.lbw.common.utils.exception.CommonUtilsException;

/**
 * 文件操作工具类
 * 
 * @author LiuBaoWen
 *
 */
public class FileUtils {

	/**
	 * 获取文件名后缀
	 * 
	 * @param path 文件名 或者 文件全路径
	 * @return
	 */
	public static String getSuffix(String path) {
		if ("".equals(path) || path == null)
			throw new CommonUtilsException(ConmonUtilsEnums.PATH_IS_NULL);
		return path.substring(path.lastIndexOf(".") + 1);
	}

	/**
	 * 简单获取path的文件名 只支持常规路径
	 * 
	 * @param filePath 文件全路径
	 * @return
	 */
	public static String getFileName(String filePath) {
		if ("".equals(filePath) || filePath == null)
			throw new CommonUtilsException(ConmonUtilsEnums.PATH_IS_NULL);
		return filePath.substring(filePath.lastIndexOf("/") + 1);
	}

	/**
	 * 简单获取path中的文件路径
	 * 
	 * @param filePath
	 * @return
	 */
	public static String getFilePath(String filePath) {
		if ("".equals(filePath) || filePath == null)
			throw new CommonUtilsException(ConmonUtilsEnums.PATH_IS_NULL);
		return filePath.substring(0, filePath.lastIndexOf("/"));
	}

	/**
	 * 根据path创建文件及目录
	 * 
	 * @param localFilePath
	 * @return
	 * @throws IOException
	 */
	public static void createPathAndFile(String localFilePath) throws IOException {
		String reportPathStr = getFilePath(localFilePath);
		File reportPath = new File(reportPathStr);
		File reportFile = new File(localFilePath);

		if (!reportPath.isDirectory()) {// 创建目录
			reportPath.mkdirs();
		} else if (!reportFile.exists()) { // 创建空文件
			reportFile.createNewFile();
		}
	}

}
