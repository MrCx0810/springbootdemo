package com.ch.until.often;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by：童俊旗
 * Date：2017/2/28
 * Time: 13:57
 */
public class OftenTool {
    /*
    createTime：2017/2/28
    Description:判断字符串是否为空
    @param str：判断的字符串
    @return Boolean
     */
    public static boolean IsNull(String str){
        if(str == null || str.length() < 1){
            return true;
        }
        return false;
    }
    /*
        createTime: 2017/2/28
        Description: 正则检查电话号码是否合法
        @param phone:电话号码
        @return Boolean
     */
    public static boolean isPhoneNumber(String phoneNumber){
        String rex = "^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$";
        Pattern p = Pattern.compile(rex);
        Matcher m = p.matcher(phoneNumber);
        return m.matches();
    }
    /*
        createTime: 2017/2/28
        Description: MD5加密
        @param str：加密字符串
        @return String：加密后的字符串
     */
    public static String md5Encode(String inStr)throws Exception{
        MessageDigest md5 = null;
        md5 = MessageDigest.getInstance("MD5");
        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
    /*
        createTime: 2017/2/28
        Description: 获取本地时间
        @param Str：时间格式
        @return String ：获取的时间
     */
    public static String getTime(String str){
        SimpleDateFormat sdf = new SimpleDateFormat(str);
        Date date = new Date();
        return sdf.format(date);
     }
    /*
     *  createTime: 2017/2/28
        Description: 获取两个数中的最大值
        @param num1 num2
        @return int
     */
    public static int getMax(int num1,int num2){
    	return num1>num2?num1:num2;
    }
    /*
     *  createTime: 2017/2/28
        Description: 获取两个数中的最小值
        @param num1 num2
        @return int
     */
    public static int getMin(int num1,int num2){
    	return num1<num2?num1:num2;
    }
    /*
     * 保留两位小数
     * @param double
     * @return double
     */
    public static double getTwoNum(Double f){
    	if(f == null){
    		return 0.0;
    	}
    	BigDecimal   b   =   new   BigDecimal(f);  
    	double   f1   =   b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    	return f1;
    }
}
