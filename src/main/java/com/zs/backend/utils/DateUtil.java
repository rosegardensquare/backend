package com.zs.backend.utils;

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

    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String YMD_FORMAT = "yyyy-MM-dd";
    public static final String YMD = "yyyyMMdd";



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
