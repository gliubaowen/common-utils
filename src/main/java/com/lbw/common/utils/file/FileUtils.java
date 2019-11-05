package com.lbw.common.utils.file;

import java.io.File;
import java.io.IOException;

/**
 * 文件操作工具类
 * 
 * @author LiuBaoWen
 *
 */
public class FileUtils {

	/**
	 * 获取文件后缀
	 * 
	 * @param path 文件名 或者 文件全路径
	 * @return
	 */
	public static String getSuffix(String path) {
		if ("".equals(path) || path == null) {
			return null;
		}
		return path.substring(path.lastIndexOf(".") + 1);
	}

	/**
	 * 简单获取path的文件名 只支持常规路径
	 * 
	 * @param filePath 文件全路径
	 * @return
	 */
	public static String getFileName(String filePath) {
		if ("".equals(filePath) || filePath == null) {
			return null;
		}
		return filePath.substring(filePath.lastIndexOf("/") + 1);
	}

	/**
	 * 简单获取path中的文件路径
	 * 
	 * @param filePath
	 * @return
	 */
	public static String getFilePath(String filePath) {
		if ("".equals(filePath) || filePath == null) {
			return null;
		}
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
		// 创建目录
		if (!reportPath.isDirectory()) {
			reportPath.mkdirs();
		}
		// 创建空文件
		if (!reportFile.exists()) {
//			logger.info("Excel文件：{}不存在,创建此文件", localFilePath);
			reportFile.createNewFile();
		}

	}

}
