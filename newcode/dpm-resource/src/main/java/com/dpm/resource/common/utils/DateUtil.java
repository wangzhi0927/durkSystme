package com.dpm.resource.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_TIME_PATTERN1 = "yyyyMMddHHmmss";
	public static final String MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
	public static final String HOUR_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_PATTERN = "yyyy-MM-dd";
	public static final String DATE_PATTERN1 = "yyyyMMdd";
	public static final String MONTH_PATTERN = "yyyy-MM";
	public static final String YEAR_PATTERN = "yyyy";
	public static final String MINUTE_ONLY_PATTERN = "mm";
	public static final String HOUR_ONLY_PATTERN = "HH";

	public static String getCurrentDateTime() {
		SimpleDateFormat df = new SimpleDateFormat(DATE_TIME_PATTERN1);// 设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间
	}
	
	public static String getCurrentDate() {
		SimpleDateFormat df = new SimpleDateFormat(DATE_PATTERN1);// 设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间
	}
	
	public static String getCurrentDate(String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);// 设置日期格式
		return df.format(new Date());// new Date()为获取当前系统时间
	}
	
	public static int getCurrentYear(){
	 	Calendar cale = Calendar.getInstance();  
        return cale.get(Calendar.YEAR);  
	}
	
	public static int getCurrentMonth(){
	 	Calendar cale = Calendar.getInstance();  
        return cale.get(Calendar.MONTH) + 1;  
	}

	public static int getCurrentDay(){
	 	Calendar cale = Calendar.getInstance();  
        return cale.get(Calendar.DATE);
	}

}
