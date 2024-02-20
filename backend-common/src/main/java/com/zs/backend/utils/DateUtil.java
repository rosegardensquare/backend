package com.zs.backend.utils;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

/**
 * @author 张帅
 * @date 2020-12-11
 * 日期工具类
 */
public class DateUtil {
    public static final String YMDHMS = "yyyyMMddHHmmss";
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String YMD_FORMAT = "yyyy-MM-dd";
    public static final String YMD = "yyyyMMdd";


    public static Date minuteOperation(Date date, int minute) {
        if (date != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(12, minute);
            return cal.getTime();
        } else {
            return null;
        }
    }


    public static long between(Date start, Date end, TimeUnit unit) {
        if (start != null && end != null) {
            unit = unit == null ? TimeUnit.DAYS : unit;
            long duration = start.getTime() - end.getTime();
            return unit.convert(duration, TimeUnit.MILLISECONDS);
        } else {
            return 0L;
        }
    }

    public static Date getDateByLongDate(Long millis) {
        if (millis == null) {
            return new Date();
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(millis);
            return cal.getTime();
        }
    }

    public static String getFormatDate(Date date, String format) {
        if (format == null || format.equals("")) {
            format = "yyyy-MM-dd HH:mm:ss";
        }

        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.format(date);
        } else {
            return null;
        }
    }

    /**
     * date 转 string
     * @param date
     * @param format
     * @return
     */
    public static String dateToString(Date date, String format) {
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }

        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(format);
            return df.format(date);
        } else {
            return null;
        }
    }

    public static Date getDateByString(String date, String format) {
        if (StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }

        if (!StringUtils.isEmpty(date)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);

            try {
                return sdf.parse(date);
            } catch (ParseException var4) {
                throw new RuntimeException("转换为日期类型错误：DATE：" + date + "  FORMAT:" + format);
            }
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Date dd= new Date(1609344000000l);

        System.out.println(dateToString(dd, DEFAULT_FORMAT));

        Date d = new Date(1609344000000l + Duration.ofDays(1).getSeconds() * 1000L - 1);
        System.out.println(dateToString(d, DEFAULT_FORMAT));
    }


}
