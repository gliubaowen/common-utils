/**
 * 
 */
package com.lbw.common.utils.string;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author LiuBaoWen
 *
 */
public class ByteUtils {

	private ByteUtils() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * 获得指定文件的byte数组
	 * 
	 * @param filePath 文件路径
	 * @return 文件内容
	 */
	public static byte[] getBytes(String filePath) {
		byte[] buffer = null;
		File file = new File(filePath);
		try (FileInputStream fis = new FileInputStream(file);
				ByteArrayOutputStream bos = new ByteArrayOutputStream(1000)) {

			byte[] b = new byte[1000];
			int n;
			while ((n = fis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			buffer = bos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return buffer;
	}

	/**
	 * 根据byte数组，生成文件
	 * 
	 * @param bfile
	 * @param filePath
	 * @param fileName
	 */
	public static void saveFile(byte[] bfile, String filePath, String fileName) {
		File file = new File(filePath, fileName);
		try (FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos)) {
			File dir = new File(filePath);
			// 判断文件目录是否存在
			if (!dir.exists() && dir.isDirectory()) {
				dir.mkdirs();
			}
			bos.write(bfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
