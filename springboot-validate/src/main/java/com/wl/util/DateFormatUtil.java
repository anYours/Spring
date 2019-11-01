package com.wl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间格式工具类
 */
public class DateFormatUtil {

	public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	public static final String yyyyMMdd = "yyyyMMdd";
	public static final String MS_TIME_FORMAT = "yyyyMMddHHmmssSSSZ";
	public static final String YYYYMMDDThhmmsssssZ = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	

	public static Date parse(String dateStr) throws ParseException {
		return getDefaultFormat().parse(dateStr);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss 
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return getDefaultFormat().format(date);
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static SimpleDateFormat getDefaultFormat() {
		SimpleDateFormat format = new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss);
		return format;
	}
	
	/**
	 * yyyyMMdd
	 * @return
	 */
	public static SimpleDateFormat getPureDigitalDateFormat() {
		SimpleDateFormat format = new SimpleDateFormat(yyyyMMdd);
		return format;
	}
	
	public static final String yyyy_MM_dd = "yyyy-MM-dd";
	
	/**
	 * yyyy-MM-dd
	 * 
	 * @return
	 */
	public static SimpleDateFormat getyyyy_MM_ddDateFormat() {
		SimpleDateFormat format = new SimpleDateFormat(yyyy_MM_dd);
		return format;
	}
	
	/** 
	 * 日期格式 :20160726200201001
	 * @return
	 */
	public static SimpleDateFormat getYyyyMMddHHmmSSS() {
		return new SimpleDateFormat("yyyyMMddHHmmssSSS");
	}
	
	/**
	  附录JAVA日期格式转换中各字母含义:
			字母         日期或时间元素         表示         示例
			G         Era 标志符         Text         AD
			y         年         Year         1996; 96
			M         年中的月份         Month         July; Jul; 07
			w         年中的周数         Number         27
			W         月份中的周数         Number         2
			D         年中的天数         Number         189
			d         月份中的天数         Number         10
			F         月份中的星期         Number         2
			E         星期中的天数         Text         Tuesday; Tue
			a         Am/pm 标记         Text         PM
			H         一天中的小时数（0-23）         Number         0
			k         一天中的小时数（1-24）         Number         24
			K         am/pm 中的小时数（0-11）         Number         0
			h         am/pm 中的小时数（1-12）         Number         12
			m         小时中的分钟数         Number         30
			s         分钟中的秒数         Number         55
			S         毫秒数         Number         978
			z         时区         General time zone         Pacific Standard Time; PST; GMT-08:00
			Z         时区         RFC 822 time zone         -0800
	 */
	
	/**日期格式 :20160726*/
	public static SimpleDateFormat yyyyMMdd_1 = new  SimpleDateFormat("yyyyMMdd");
	
	/**日期格式 :2016年07月26日*/
	public static SimpleDateFormat yyyyMMdd_2 = new  SimpleDateFormat("yyyy年MM月dd日");
	
	/**日期格式 :2016-07-26*/
	public static SimpleDateFormat yyyyMMdd_3 = new  SimpleDateFormat("yyyy-MM-dd");
	
	/**日期格式 :07-26-2016*/
	public static SimpleDateFormat yyyyMMdd_4 = new  SimpleDateFormat("MM-dd-yyyy");
	
	/**日期格式 :2016/07/26*/
	public static SimpleDateFormat yyyyMMdd_5 = new  SimpleDateFormat("yyyy/MM/dd");
	
	/**日期格式 :20160726200201*/
	public static SimpleDateFormat yyyyMMddHHmmss_1 = new  SimpleDateFormat("yyyyMMddHHmmss");
	
	/**日期格式 :20160726200201001*/
	public static SimpleDateFormat yyyyMMddHHmmSSS = new  SimpleDateFormat("yyyyMMddHHmmssSSS");
	
	/**日期格式:2016-07-06 20:02:01*/
	public static SimpleDateFormat yyyyMMddHHmmss_2 = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**日期格式:2016年07月06日 20时02分01秒*/
	public static SimpleDateFormat yyyyMMddHHmmss_3 = new  SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
	
	/**
	 * 待时区的日期格式20160203000000+0800
	 */
	public static final String TIME_FORMAT = "yyyyMMddHHmmssZ";
	
	public static SimpleDateFormat getTimeFormat() {
		SimpleDateFormat format = new SimpleDateFormat(TIME_FORMAT);
		return format;
	}
	
	/**
	 * 日期格式 :2016年07月26日
	 * 
	 * @return
	 */
	public static SimpleDateFormat getYyyyMMdd_2() {
		return new SimpleDateFormat("yyyy年MM月dd日");
	}
	
	/**
	 * 根据格式返回日期字符串
	 * 
	 * @param date
	 * @param sdf
	 * @return
	 */
	public static String getDateStr(Date date, SimpleDateFormat sdf) {
		return sdf.format(date);
	}
}
