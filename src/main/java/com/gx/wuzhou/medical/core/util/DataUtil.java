/**
 * Copyright (C), 2019-2020, XXX有限公司
 * FileName: DataUtil
 * Author:   Administrator
 * Date:     2020/6/13 0013 15:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gx.wuzhou.medical.core.util;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2020/6/13 0013
 * @since 1.0.0
 */
public class DataUtil {
    public static final int DAY = 1;
    public static final int WEEK = 2;
    public static final int MONTH = 3;
    public static final int YEAR = 4;
    public static final String DFMT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String DFMT_YYYY_MM_DD = "yyyy-MM-dd";
    /**
     * 字符串转换为java.util.Date
     *
     * @param datetime
     * @return
     */
    public static java.util.Date parse(String datetime) {
        DateTime dateTime = new DateTime(datetime);
        return dateTime.toDate();
    }

    /**
     * 按格式输出日期的值
     *
     * @param jdkdate
     * @param pattern
     * @return
     */
    public static String format(Date jdkdate, String pattern) {
        DateTime datetime = null;
        if (jdkdate == null) {
            datetime = new DateTime(jdkdate);
        }
        DateTimeFormatter df = DateTimeFormat.forPattern(pattern);
        String dateStr = df.print(datetime);
        return dateStr;
    }

    public static String format(){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String data = df.format(date);
        return data;
    }

    /**
     * 计算特定日期是否在日期区间内
     * @param starttime-起始时间
     * @param endtime-终止时间
     * @return
     */
    public static boolean isBetween(String starttime, String endtime,
                                    String desctime) {

        DateTime begin = new DateTime(starttime);
        DateTime end = new DateTime(endtime);
        Interval i = new Interval(begin, end);
        boolean contained = i.contains(new DateTime(desctime));
        return contained;
    }
    /**
     * 日期是否大于当前系统时间
     * @param time
     * @return
     */
    public static boolean isAfterNow(String time){
        DateTime dateTime = new DateTime(time);
        return dateTime.isAfterNow();
    }
    /**
     * 日期是否小于当前系统时间
     * @param time
     * @return
     */
    public static boolean isBeforeNow(String time){
        DateTime dateTime = new DateTime(time);
        return dateTime.isBeforeNow();
    }

    /**
     * 获得日期差值
     *
     * @param starttime
     * @param endtime
     * @param dateType
     *            -{1:day,2:week,3:month,4:year}
     * @return
     */
    public static int diff(String starttime, String endtime, int dateType) {
        DateTime start = new DateTime(starttime);
        DateTime end = null;
        if (endtime == null) {
            end = new DateTime();
        } else {
            end = new DateTime(endtime);
        }
        Period period = new Period(start, end);
        int diffVal = -1;
        switch (dateType) {
            case DAY:
                diffVal = period.getDays();
                break;
            case WEEK:
                diffVal = period.getWeeks();
                break;
            case MONTH:
                diffVal = period.getMonths();
                break;
            case YEAR:
                diffVal = period.getYears();
                break;
            default:
                break;
        }
        return diffVal;

    }

    /**
     * 计算距离当前系统时间的年份数
     *
     * @param starttime
     * @return
     */
    public static int diffYear(String starttime) {
        return diff(starttime, null, YEAR);
    }
    /**
     * 获取年份
     * @param time
     * @return
     */
    public static int getYear(Date time){
        DateTime start=null;
        if(time==null){
            start= new DateTime();
        }else{
            start= new DateTime(time);
        }
        return start.getYear();
    }
}
