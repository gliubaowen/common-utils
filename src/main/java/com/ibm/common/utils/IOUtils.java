package com.ibm.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;

public class IOUtils {

	/**
	 * 
	 * <p>
	 * Description: 关闭IO流
	 * </p>
	 * @param iostreamObj  IO流对象
	 * @author 杨泽林
	 * @date 2012-8-9
	 */
	public static void closeIOStream(Object iostreamObj){
		 
		try {
			if(iostreamObj == null){
				return ;
			}else if(iostreamObj instanceof InputStream){
				((InputStream) iostreamObj).close();
			}else if(iostreamObj instanceof OutputStream){
				((OutputStream) iostreamObj).close();
			}else if(iostreamObj instanceof InputStreamReader){
				((InputStreamReader) iostreamObj).close();
			}else if(iostreamObj instanceof OutputStreamWriter){
				((OutputStreamWriter) iostreamObj).close();
			}else if(iostreamObj instanceof Reader){
				((Reader) iostreamObj).close();
			}else if(iostreamObj instanceof Writer){
				((Writer) iostreamObj).close();
			}else{
				throw new IllegalArgumentException("obj is not iostream, it can not close!");
			}
		} catch (IOException e) {
			throw new IllegalArgumentException("close iostream error:"+Tools.getStackTrace(e));
		}
		
	}
	
	public static void main(String[] args) {
		try {
			File f = new File("src/commo/utils/1.txt");
			PrintStream ps = new PrintStream(f);
			ps.print("111111111111");
			closeIOStream(ps);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
