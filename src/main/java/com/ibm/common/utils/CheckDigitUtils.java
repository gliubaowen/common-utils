package com.ibm.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CheckDigitUtils {
	//获得卡的验证码位 
	public static int getCheckDigit(long digits) { 
		int i = (int) Math.pow(10, 24);
		int k = 0;
		long computeDigits = 0l;
		long temp2 = digits;
		for(int j=(int) Math.pow(10, 24);j>10;j=j/10){
			long temp1 = temp2/j;//234 --2
			temp2 = digits%j;//234 --2
			if(k%2!=0){//奇数
				computeDigits = computeDigits + temp1 * 3l;
			}else{
				computeDigits = computeDigits + temp1;
			}
			
		}
		int j = 10 - (i % 10);
		return j;
    }

	//获得卡的验证码位
	public static char getCheckDigit(String digits) {
		 if(digits == null || digits.trim().length() == 0
	                || !digits.matches("\\d+")) {
	            throw new IllegalArgumentException("digits code must be number!");
	        }
		char[] chs = digits.trim().toCharArray();
		int s = 0;
		

       // char[] chs = nonCheckCodeCardId.trim().toCharArray();
      
        for(int i = 0; i <= chs.length - 1; i++) {
            int k = chs[i] - '0';
            if(i % 2 != 0) {
            	s = s + k;
            }else{
            	s = s + k * 3;
            	
            }        
        }
        return (s % 10 == 0) ? '0' : (char)((10 - s % 10) + '0');
    }
	
	
	public static void main(String[] args) {
		String digits = "9363724401008075721110000";
		System.out.print(getCheckDigit(digits));
	}
	/**
	 * 一維码 :
	 * 1-2 固定 93
	 * 3-18 会员卡号
	 * 19-21 cvv
	 * 22-25 有效期(Default 0000)
	 * 26 验证码
	 * 输入卡号生产一維码
	 * @param cardNo
	 * @return
	 */
	
	public static String getBarCode(String cardNo,String cvv){
		String  START_DIGIT = "93";
		String  TIME = "0000";
		String digits = START_DIGIT.concat(cardNo).concat(cvv).concat(TIME);
		String checkDigit = String.valueOf(getCheckDigit(digits));
		return digits.concat(checkDigit);
		
	}
	
	
	
    /**
     *生成验证码
     * @return
     */
    public static char getBankCardCheckCode(String nonCheckCodeCardId) {
        if(nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0
                || !nonCheckCodeCardId.matches("\\d+")) {
            throw new IllegalArgumentException("card code must be number!");
        }
        char[] chs = nonCheckCodeCardId.trim().toCharArray();
        int luhmSum = 0;
        for(int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if(j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;            
        }
        return (luhmSum % 10 == 0) ? '0' : (char)((10 - luhmSum % 10) + '0');
    }	
    
    

	/**
	 * 生成CVV号
	 * */
    public static String makeCvvCode(String cardNum,Date cardCreateTime,String type){
    		String cvv=null;
    		
    		int newCodeNum = Integer.parseInt(cardNum.substring(13,16));
    		if("1".equals(type)){
    			 newCodeNum = Integer.parseInt(cardNum.substring(19,22));
    		}
    		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
    		String time = sdf.format(cardCreateTime);
    		int timeNum = Integer.parseInt(time.substring(1,2)+time.substring(3,4)+time.substring(5,6));
    		cvv = String.valueOf(newCodeNum^timeNum);
    		if(Integer.valueOf(cvv) == 1000){
    			cvv="999";
    		}
    		if(Integer.valueOf(cvv)>1000){
    			cvv=cvv.substring(1,4);
    		}
    		
    		cvv = String.format("%03d", Long.parseLong(cvv));
    		return cvv;
    }
}
