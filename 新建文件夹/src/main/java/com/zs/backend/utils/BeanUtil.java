package com.zs.backend.utils;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Throwables;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;


import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BeanUtil {

    private static final Logger log = LoggerFactory.getLogger(BeanUtil.class);
    private static Logger logger = LoggerFactory.getLogger(BeanUtil.class);

    public BeanUtil() {
    }


    public static <T, R> List<R> beanCopyPropertiesForList(List<T> sourceList, Class<R> targetCls) {
        if (sourceList == null) {
            return null;
        } else {
            Assert.notNull(targetCls, "target class can not null");
            List<R> targetList = new ArrayList();
            if (!sourceList.isEmpty()) {
                Iterator var3 = sourceList.iterator();

                while(var3.hasNext()) {
                    T source = (T) var3.next();
                    targetList.add(beanCopyProperties(source, targetCls));
                }
            }

            return targetList;
        }
    }

    public static <R> R beanCopyProperties(Object source, Class<R> targetCls) {
        try {
            if (source == null) {
                return null;
            } else {
                Assert.notNull(targetCls, "target class can not null");
                R target = targetCls.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(source, target);
                return target;
            }
        } catch (Exception var3) {
            log.error(Throwables.getStackTraceAsString(var3));
            return null;
        }
    }


    public static void main(String[] args) {

        Date d = new Date(Duration.ofDays(1).getSeconds() * 1000L - 1);
        System.out.println("args = " + DateUtil.dateToString(d, DateUtil.DEFAULT_FORMAT));
    }


    @Data
    static class Order {

        private Long id;
        private String name;

    }

    @Data
    static class SysAbnormalPageListReq {

        private Date reportQueryEndTime;

        public Date getReportQueryEndTime() {
            return reportQueryEndTime == null ? null
                    : new Date(reportQueryEndTime.getTime() + Duration.ofDays(1).getSeconds() * 1000L - 1);
        }

    }

    @Data
    static class SysAbnormalPageListReqs {

        private Date reportQueryEndTime;



    }


}