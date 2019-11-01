package com.wl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ����ʱ���ʽ������
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
	 * ���ڸ�ʽ :20160726200201001
	 * @return
	 */
	public static SimpleDateFormat getYyyyMMddHHmmSSS() {
		return new SimpleDateFormat("yyyyMMddHHmmssSSS");
	}
	
	/**
	  ��¼JAVA���ڸ�ʽת���и���ĸ����:
			��ĸ         ���ڻ�ʱ��Ԫ��         ��ʾ         ʾ��
			G         Era ��־��         Text         AD
			y         ��         Year         1996; 96
			M         ���е��·�         Month         July; Jul; 07
			w         ���е�����         Number         27
			W         �·��е�����         Number         2
			D         ���е�����         Number         189
			d         �·��е�����         Number         10
			F         �·��е�����         Number         2
			E         �����е�����         Text         Tuesday; Tue
			a         Am/pm ���         Text         PM
			H         һ���е�Сʱ����0-23��         Number         0
			k         һ���е�Сʱ����1-24��         Number         24
			K         am/pm �е�Сʱ����0-11��         Number         0
			h         am/pm �е�Сʱ����1-12��         Number         12
			m         Сʱ�еķ�����         Number         30
			s         �����е�����         Number         55
			S         ������         Number         978
			z         ʱ��         General time zone         Pacific Standard Time; PST; GMT-08:00
			Z         ʱ��         RFC 822 time zone         -0800
	 */
	
	/**���ڸ�ʽ :20160726*/
	public static SimpleDateFormat yyyyMMdd_1 = new  SimpleDateFormat("yyyyMMdd");
	
	/**���ڸ�ʽ :2016��07��26��*/
	public static SimpleDateFormat yyyyMMdd_2 = new  SimpleDateFormat("yyyy��MM��dd��");
	
	/**���ڸ�ʽ :2016-07-26*/
	public static SimpleDateFormat yyyyMMdd_3 = new  SimpleDateFormat("yyyy-MM-dd");
	
	/**���ڸ�ʽ :07-26-2016*/
	public static SimpleDateFormat yyyyMMdd_4 = new  SimpleDateFormat("MM-dd-yyyy");
	
	/**���ڸ�ʽ :2016/07/26*/
	public static SimpleDateFormat yyyyMMdd_5 = new  SimpleDateFormat("yyyy/MM/dd");
	
	/**���ڸ�ʽ :20160726200201*/
	public static SimpleDateFormat yyyyMMddHHmmss_1 = new  SimpleDateFormat("yyyyMMddHHmmss");
	
	/**���ڸ�ʽ :20160726200201001*/
	public static SimpleDateFormat yyyyMMddHHmmSSS = new  SimpleDateFormat("yyyyMMddHHmmssSSS");
	
	/**���ڸ�ʽ:2016-07-06 20:02:01*/
	public static SimpleDateFormat yyyyMMddHHmmss_2 = new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**���ڸ�ʽ:2016��07��06�� 20ʱ02��01��*/
	public static SimpleDateFormat yyyyMMddHHmmss_3 = new  SimpleDateFormat("yyyy��MM��dd�� HHʱmm��ss��");
	
	/**
	 * ��ʱ�������ڸ�ʽ20160203000000+0800
	 */
	public static final String TIME_FORMAT = "yyyyMMddHHmmssZ";
	
	public static SimpleDateFormat getTimeFormat() {
		SimpleDateFormat format = new SimpleDateFormat(TIME_FORMAT);
		return format;
	}
	
	/**
	 * ���ڸ�ʽ :2016��07��26��
	 * 
	 * @return
	 */
	public static SimpleDateFormat getYyyyMMdd_2() {
		return new SimpleDateFormat("yyyy��MM��dd��");
	}
	
	/**
	 * ���ݸ�ʽ���������ַ���
	 * 
	 * @param date
	 * @param sdf
	 * @return
	 */
	public static String getDateStr(Date date, SimpleDateFormat sdf) {
		return sdf.format(date);
	}
}
