/*
 * Copyright (C), 2002-2012, 苏宁易购电子商务有限公司
 * FileName: Md5Encode.java
 * Author:  88232606
 * Date: 2012-9-12    
 * History: 
 * <author>    <time>      <version>   <desc>
 *  修改人姓名    修改时间               版本号               描述
 */
package com.ibm.common.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
/**
 * 
 * 
 * 功能描述： 加密类
 * @author 作者88232606
 * 2012-9-13 上午9:58:50
 * @version 1.0.0
 * 2012-9-13 上午9:58:50
 */
public class Md5Encode {
    /**
     * 
     * 功能描述：
     * 输入参数：<按照参数定义顺序> 
     * @param 参数说明
     * 返回值:  类型 <说明> 
     * @return 返回值
     * @throw 异常描述
     * @see 需要参见的其它内容
     */
    private static String encodePassword(String rawPass, String algorithm) {
        MessageDigest messageDigest = getMessageDigest(algorithm);
        byte[] digest;
        try {
            digest = messageDigest.digest(rawPass.getBytes("UTF-8"));
        }catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 not supported!");
        }
        return new String(Hex.encodeHex(digest));
    }
    
    /**
     * 
     * 功能描述:根据密钥与字符串对其进行加密
     * 输入参数：<按照参数定义顺序> 
     * @param 参数说明
     * 返回值:  类型 <说明> 
     * @return 返回值
     * @throw 异常描述
     * @see 需要参见的其它内容
     */
    public static String encrypt(String sourceString, String key) {
        return encodePassword(sourceString + key, "MD5");
    }    
    
    /**
     * 
     * 功能描述：
     * 输入参数：<按照参数定义顺序> 
     * @param 参数说明
     * 返回值:  类型 <说明> 
     * @return 返回值
     * @throw 异常描述
     * @see 需要参见的其它内容
     */
    private static MessageDigest getMessageDigest(String algorithm){
        try {
            return MessageDigest.getInstance(algorithm);
        }catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException("No such algorithm [" + algorithm + "]");
        }
    }
    
    public static String encodeByMD5(String str) {
    	String result = "";  
    	try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");  
			md5.update((str).getBytes("UTF-8"));  
			byte b[] = md5.digest();  
			  
			int i;  
			StringBuffer buf = new StringBuffer("");  
			  
			for(int offset=0; offset<b.length; offset++){  
			    i = b[offset];  
			    if(i<0){  
			        i+=256;  
			    }  
			    if(i<16){  
			        buf.append("0");  
			    }  
			    buf.append(Integer.toHexString(i));  
			}  
			  
			result = buf.toString().toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    	return result;
    }
    
    
    public static void main(String[] args) {
		System.out.println(Md5Encode.encodeByMD5("a123"));
	}
}
