package com.ch.until.often;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 
 * 功能描述：
 * 
 * @author Administrator
 * @Date Jul 19, 2008
 * @Time 9:47:53 AM
 * @version 1.0
 */
public class DateUtil {

	public static Date date = null;

	public static DateFormat dateFormat = null;

	public static Calendar calendar = null;

	/**
	 * 功能描述：格式化日期
	 * 
	 * @param dateStr
	 *            String 字符型日期
	 * @param format
	 *            String 格式
	 * @return Date 日期
	 */
	public static Date parseDate(String dateStr, String format) {
		try {
			dateFormat = new SimpleDateFormat(format);
			String dt = dateStr.replaceAll("-", "/");
			if ((!dt.equals("")) && (dt.length() < format.length())) {
				dt += format.substring(dt.length()).replaceAll("[YyMmDdHhSs]",
						"0");
			}
			date = (Date) dateFormat.parse(dt);
		} catch (Exception e) {
		}
		return date;
	}

	/**
	 * 功能描述：格式化日期
	 * 
	 * @param dateStr
	 *            String 字符型日期：YYYY-MM-DD 格式
	 * @return Date
	 */
	public static Date parseDate(String dateStr) {
		return parseDate(dateStr, "yyyy/MM/dd");
	}

	/**
	 * 功能描述：格式化输出日期
	 * 
	 * @param date
	 *            Date 日期
	 * @param format
	 *            String 格式
	 * @return 返回字符型日期
	 */
	public static String format(Date date, String format) {
		String result = "";
		try {
			if (date != null) {
				dateFormat = new SimpleDateFormat(format);
				result = dateFormat.format(date);
			}
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * 功能描述：
	 * 
	 * @param date
	 *            Date 日期
	 * @return
	 */
	public static String format(Date date) {
		return format(date, "yyyy/MM/dd");
	}

	/**
	 * 功能描述：返回年份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回年份
	 */
	public static int getYear(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 功能描述：返回月份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回月份
	 */
	public static int getMonth(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 功能描述：返回日份
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回日份
	 */
	public static int getDay(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 功能描述：返回小时
	 * 
	 * @param date
	 *            日期
	 * @return 返回小时
	 */
	public static int getHour(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 功能描述：返回分钟
	 * 
	 * @param date
	 *            日期
	 * @return 返回分钟
	 */
	public static int getMinute(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * 返回秒钟
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回秒钟
	 */
	public static int getSecond(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.SECOND);
	}

	/**
	 * 功能描述：返回毫秒
	 * 
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public static long getMillis(Date date) {
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.getTimeInMillis();
	}

	/**
	 * 功能描述：返回字符型日期
	 * 
	 * @param date
	 *            日期
	 * @return 返回字符型日期 yyyy/MM/dd 格式
	 */
	public static String getDate(Date date) {
		return format(date, "yyyy/MM/dd");
	}

	/**
	 * 功能描述：返回字符型时间
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回字符型时间 HH:mm:ss 格式
	 */
	public static String getTime(Date date) {
		return format(date, "HH:mm:ss");
	}

	/**
	 * 功能描述：返回字符型日期时间
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回字符型日期时间 yyyy/MM/dd HH:mm:ss 格式
	 */
	public static String getDateTime(Date date) {
		return format(date, "yyyy/MM/dd HH:mm:ss");
	}
	/**
	 * 功能描述：返回字符型日期时间
	 * 
	 * @param date
	 *            Date 日期
	 * @return 返回字符型日期时间 yyyy-MM-dd HH:mm:ss 格式
	 */
	public static String getDateTime1(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 功能描述：返回字符型日期时间
	 * @author chenhui
	 * @param date
	 *            Date 日期
	 * @return 返回字符型日期时间  格式自定义
	 */
	public static String getOneDateTime(Date date,String mode) {
		return format(date, mode);
	}

	/**
	 * String 转Date
	 * string 和 model 的格式必须一致，不然会报错
	 * @param string 字符串时间
	 * @param model 例如：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date getDateTimeByString(String string, String model){
		SimpleDateFormat sdf = new SimpleDateFormat(model);
		Date date = null;
		try {
			 date = sdf.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 功能描述：日期相加
	 * 
	 * @param date
	 *            Date 日期
	 * @param day
	 *            int 天数
	 * @return 返回相加后的日期
	 */
	public static Date addDate(Date date, int day) {
		calendar = Calendar.getInstance();
		long millis = getMillis(date) + ((long) day) * 24 * 3600 * 1000;
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

	/**
	 * 功能描述：日期相减
	 * 
	 * @param date
	 *            Date 日期
	 * @param date1
	 *            Date 日期
	 * @return 返回相减后的日期
	 */
	public static int diffDate(Date date, Date date1) {
		return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
	}
	/**
     * 
     * 计算两个日期相差的月份数
     * 
     * @param date1 日期1
     * @param date2 日期2
     * @param pattern  日期1和日期2的日期格式
     * @return  相差的月份数
     * @throws ParseException
     */
    public static int countMonths(String date1,String date2,String pattern) throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat(pattern);
        
        Calendar c1=Calendar.getInstance();
        Calendar c2=Calendar.getInstance();
        
        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));
        
        int year =c2.get(Calendar.YEAR)-c1.get(Calendar.YEAR);
        
        //开始日期若小月结束日期
        if(year<0){
            year=-year;
            return year*12+c1.get(Calendar.MONTH)-c2.get(Calendar.MONTH);
        }
       
        return year*12+c2.get(Calendar.MONTH)-c1.get(Calendar.MONTH);
    }
	/**
	 * 功能描述：取得指定月份的第一天
	 * 
	 * @param strdate
	 *            String 字符型日期
	 * @return String yyyy-MM-dd 格式
	 */
	public static String getMonthBegin(String strdate) {
		date = parseDate(strdate);
		return format(date, "yyyy-MM") + "-01";
	}

	/**
	 * 功能描述：取得指定月份的最后一天
	 * 
	 * @param strdate
	 *            String 字符型日期
	 * @return String 日期字符串 yyyy-MM-dd格式
	 */
	public static String getMonthEnd(String strdate) {
		date = parseDate(getMonthBegin(strdate));
		calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		return formatDate(calendar.getTime());
	}

	/**
	 * 功能描述：常用的格式化日期
	 * 
	 * @param date
	 *            Date 日期
	 * @return String 日期字符串 yyyy-MM-dd格式
	 */
	public static String formatDate(Date date) {
		return formatDateByFormat(date, "yyyy-MM-dd");
	}


	//todo:

	/**
	 * 格式化当前时间 "HH:mm:ss"
	 * @return
	 */
	public static String nowTime(){
		return nowTime(new Date());
	}

	/**
	 * 格式化日期时间 "HH:mm:ss"
	 * @param date 日期
	 * @return
	 */
	public static String nowTime(Date date){
		return formatDateByFormat(date, "HH:mm:ss");
	}

	/**
	 * 当前日期 "yyyy-MM-dd"
	 * @return
	 */
	public static String nowDate(){
		return nowDate(new Date());
	}

	/**
	 * 日期 "yyyy-MM-dd"
	 * @param date 日期
	 * @return
	 */
	public static String nowDate(Date date){
		return formatDateByFormat(date, "yyyy-MM-dd");
	}

	/**
	 * 格式化当前时间 "yyyy-MM-dd HH:mm"
	 * @return
	 */
	public static String nowDateTime(){
		return nowDateTime(new Date());
	}

	/**
	 * 格式化目标时间 "yyyy-MM-dd HH:mm"
	 * @param date 日期
	 * @return
	 */
	public static String nowDateTime(Date date){
		return formatDateByFormat(date,"yyyy-MM-dd HH:mm");
	}

	/**
	 * 格式化当前时间 "yyyy-MM-dd HH:mm:ss"
	 * @return
	 */
	public static String nowDateTimeSS(){
		return nowDateTimeSS(new Date());
	}

	/**
	 * 格式化目标时间 "yyyy-MM-dd HH:mm:ss"
	 * @param date 日期
	 * @return
	 */
	public static String nowDateTimeSS(Date date){
		return formatDateByFormat(date,"yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 格式化当前时间加上某段时间 "yyyy-MM-dd HH:mm"
	 * @param dates 要加上的时间  年，月，日
	 * @return
	 */
	public static String addDateTime(int... dates){
		Calendar calendar = Calendar.getInstance();
		return formatDateByFormat(addCalendarDate(calendar,dates).getTime(),"yyyy-MM-dd HH:mm");
	}

	/**
	 * 格式化某个时间加上一段时间 "yyyy-MM-dd HH:mm:ss"
	 * @param date 日期
	 * @param dates 要加上的时间  年，月，日
	 * @return
	 */
	public static String addDate(Date date,int... dates){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return formatDateByFormat(addCalendarDate(calendar,dates).getTime(),"yyyy-MM-dd HH:mm");
	}

	/**
	 * 格式化输出当前时间加上一段时间
	 * @param times 时间 时，分，秒
	 * @return
	 */
	public static String addDateTimeHM(int... times){
		Calendar calendar = Calendar.getInstance();
		return formatDateByFormat(addCalendarTime(calendar,times).getTime(),"yyyy-MM-dd HH:mm");
	}


	/**
	 * 格式化输出当前时间加上一段时间 "yyyy-MM-dd HH:mm"
	 * @param date 时间
	 * @param times 时间 时，分，秒
	 * @return
	 */
	public static String addDateTime(long date,int... times){
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);
		return nowDateTime(addCalendarTime(calendar,times).getTime());
	}

	/**
	 * 日期加上时间
	 * @param date 日期
	 * @param times 要加上的时间 时，分，秒
	 * @return
	 */
	public static Date addDateTime(Date date,int... times){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return addCalendarTime(calendar,times).getTime();
	}

	/**
	 * 日期加时间
	 * @param calendar 日期
	 * @param times 要加上的时间 时，分，秒
	 * @return
	 */
	public static Calendar addCalendarTime(Calendar calendar,int... times){
		if(times==null||times.length==0)return calendar;
		for (int i=0;i<times.length;++i){
			if(i==0)calendar.add(Calendar.HOUR_OF_DAY,times[i]);
			if(i==1)calendar.add(Calendar.MINUTE,times[i]);
			if(i==2)calendar.add(Calendar.SECOND,times[i]);
		}
		return calendar;
	}

	/**
	 * 日期加日期
	 * @param calendar 日期
	 * @param dates 日期 年，月，日
	 * @return
	 */
	public static Calendar addCalendarDate(Calendar calendar,int... dates){
		if(dates==null||dates.length==0)return calendar;
		for (int i=0;i<dates.length;++i){
			if(i==0)calendar.add(Calendar.YEAR,dates[i]);
			if(i==1)calendar.add(Calendar.MONTH,dates[i]);
			if(i==2)calendar.add(Calendar.DAY_OF_MONTH,dates[i]);
		}
		return calendar;
	}


	/**
	 * 功能描述：以指定的格式来格式化日期
	 * 
	 * @param date
	 *            Date 日期
	 * @param format
	 *            String 格式
	 * @return String 日期字符串
	 */
	public static String formatDateByFormat(Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
        return result;
	}
	 /**
     * 获取任意时间的下一个月
     * 描述:<描述函数实现的功能>.
     * @param repeatDate
     * @return
     */
    public static String getPreMonth(String repeatDate) {
        String lastMonth = "";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM");
        int year = Integer.parseInt(repeatDate.substring(0, 4));
        String monthsString = repeatDate.substring(5, 7);
        int month;
        if ("0".equals(monthsString.substring(0, 1))) {
            month = Integer.parseInt(monthsString.substring(1, 2));
        } else {
            month = Integer.parseInt(monthsString.substring(0, 2));
        }
        cal.set(year,month,Calendar.DATE);
        lastMonth = dft.format(cal.getTime());
        return lastMonth;
    }
    /**
     * 获取任意时间的上一个月
     * 描述:<描述函数实现的功能>.
     * @param repeatDate 格式2016-11
     * @return
     */
    public static String getLastMonth(String repeatDate) {
        String lastMonth = "";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM");
        int year = Integer.parseInt(repeatDate.substring(0, 4));
        String monthsString = repeatDate.substring(5, 7);
        int month;
        if ("0".equals(monthsString.substring(0, 1))) {
            month = Integer.parseInt(monthsString.substring(1, 2));
        } else {
            month = Integer.parseInt(monthsString.substring(0, 2));
        }
        cal.set(year,month-2,Calendar.DATE);
        lastMonth = dft.format(cal.getTime());
        return lastMonth;
    }
    
    
    /**
     * 
     * @param repeatDate 时间格式2016-11
     * @return 获取传入月的前12个月（月数的个数可自定义）
     */
    public static List<String> getLastMonthList(String repeatDate) {
    	List<String> list = new ArrayList<String>();
    	String lastMonth = "";
    	Calendar cal = Calendar.getInstance();
    	SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM");
    	int year = Integer.parseInt(repeatDate.substring(0, 4));
    	String monthsString = repeatDate.substring(5, 7);
    	int month;
    	if ("0".equals(monthsString.substring(0, 1))) {
    		month = Integer.parseInt(monthsString.substring(1, 2));
    	} else {
    		month = Integer.parseInt(monthsString.substring(0, 2));
    	}
    	for(int i = 1; i<13;i++){
    		cal.set(year,month-i,Calendar.DATE);
    		lastMonth = dft.format(cal.getTime());
    		list.add(lastMonth);
    	}
    	return list;
    }
    
	public static void main(String[] args) {
		Date d = new Date();
		// System.out.println(d.toString());
//		System.out.println(formatDate(d).toString());
		// System.out.println(getMonthBegin(formatDate(d).toString()));
		// System.out.println(getMonthBegin("2008/07/19"));
		// System.out.println(getMonthEnd("2008/07/19"));
		System.out.println(addDate(d,15).toString());
	}
	/**
     * 描述：将日期合并成 yyyy年mm月dd日格式 
     * @param olddate 时间格式2016-11-11 
     * 
     */
	public static String Specificdate(String olddate) {
        String year = olddate.substring(0, 4);
        String monthsString = olddate.substring(5, 7);
        String date = olddate.substring(8, 10);
        String newdate = year+"年"+monthsString+"月"+date+"日";
		return newdate;
	}
	/**
     * 描述：提取时间 
     * @param olddate 时间格式2016-11-11 13:19
     * 
     */
	public static String Specifictime(String olddate) {
		String newtime = olddate.substring(11,16);
		return newtime;
	}

	
	/**
	 * 计算日期的毫秒数  精确到分钟
	 * @param inVal  xx-xx-xx xx:xx:xx
	 * @return
	 */
	public static  long fromDateStringToLong(String inVal) { //此方法计算时间毫秒
		   Date date = null;   //定义时间类型       
		   SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		   try { 
		   date = inputFormat.parse(inVal); //将字符型转换成日期型
		   } catch (Exception e) { 
		   e.printStackTrace(); 
		   } 
		   return date.getTime();   //返回毫秒数
	   } 

	/**
	 * 计算日期的毫秒数  精确到日期
	 * @param inVal  xx-xx-xx xx:xx:xx
	 * @return
	 */   
   public static  long fromDateStringToLong1(String inVal) { //此方法计算时间毫秒
	   Date date = null;   //定义时间类型       
	   SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	   try { 
		   date = inputFormat.parse(inVal); //将字符型转换成日期型
	   } catch (Exception e) { 
		   e.printStackTrace(); 
	   } 
	   return date.getTime();   //返回毫秒数
	} 
		   

   /**
    * 两个时间相减的天数,忽略小时
    * @param s xx-xx-xx xx:xx:xx
    * @param e xx-xx-xx xx:xx:xx
    * @return
    */
   public static String subdated(String s,String e) { 
	
	   long startT=DateUtil.fromDateStringToLong1(s);
	   long endT=DateUtil.fromDateStringToLong1(e); 
	
	   long ss=(startT-endT)/(1000); //共计秒数
	   int hh=(int)ss/3600;  //共计小时数
	   int dd=(int)hh/24+1;   //共计天数
	   return dd+"";
   } 
   /**
    * 两个时间相减的小时数
    * @param s xx-xx-xx xx:xx:xx
    * @param e xx-xx-xx xx:xx:xx
    * @return
    */
   public static double subdateh(String s, String e) {
	   
	   long startT=DateUtil.fromDateStringToLong(s); 
	   long endT=DateUtil.fromDateStringToLong(e);  
	   System.out.println("s=="+s);
	   System.out.println("e=="+e);
	   long ss=(startT-endT)/(1000); //共计秒数
	   System.out.println("startT=="+startT);
	   System.out.println("endT=="+endT);
	   System.out.println("xx:"+(startT-endT));
	   double hh= (float)ss/3600;  //共计小时数
//       String format = String.format("%.1f", hh);
//       System.out.println("format = " + format);
//       return String.format("%.1f", hh);
       return hh;
   } 
   /**
    * 两个时间相减的分钟数
    * @param s xx-xx-xx xx:xx:xx
    * @param e xx-xx-xx xx:xx:xx
    * @return
    */
   public static String  subdatem(String s,String e) { 
	   
	   long startT=DateUtil.fromDateStringToLong(s); 
	   long endT=DateUtil.fromDateStringToLong(e);  
	   long ss=(startT-endT)/(1000); //共计秒数
	   int MM = (int)ss/60;   //共计分钟数
	   return MM+"";
   } 
	
   /** 
    * 获取指定日期的前几天
    * @param dateStr 制定的日期
    * @param addYear 
    * @param addMonth 
    * @param addDate 前几天数
    * @return 输入的时期格式为yyyy-MM-dd，输出的日期格式为yyyy-MM-dd 
    * @throws Exception 
    */  
   public static String getLastDay(String dateStr,int addYear, int addMonth, int addDate) throws Exception {  
         try {  
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         Date sourceDate = sdf.parse(dateStr);
         Calendar cal = Calendar.getInstance();  
         cal.setTime(sourceDate);  
         cal.add(Calendar.YEAR,addYear);  
         cal.add(Calendar.MONTH, addMonth);  
         cal.add(Calendar.DATE, addDate);  

         SimpleDateFormat returnSdf = new SimpleDateFormat("yyyy-MM-dd");
         String dateTmp = returnSdf.format(cal.getTime());  
         Date returnDate = returnSdf.parse(dateTmp);
         return dateTmp;  
         } catch (Exception e) {  
         e.printStackTrace();  
         throw new Exception(e.getMessage());  
         }  
         }   
}
