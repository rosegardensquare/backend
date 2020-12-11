package com.zs.backend.utils;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 张帅
 * @date 2020-12-11
 * 日期工具类
 */
public class DateUtil {

    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String YMD_FORMAT = "yyyy-MM-dd";


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

    public static void main(String[] args) {
        System.out.println(dateToString(new Date(), DEFAULT_FORMAT));
    }
}
