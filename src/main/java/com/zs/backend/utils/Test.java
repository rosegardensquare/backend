package com.zs.backend.utils;

import com.google.common.collect.Lists;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Stream;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

public class Test {



    public static Date[] getDates(String year, String month) {
        int maxDate = 0;
        Date first = null;
        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
            first = sdf.parse(year + month);
            cal.setTime(first);
            maxDate = cal.getMaximum(Calendar.DAY_OF_MONTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Date[] dates = new Date[maxDate];
        for (int i = 1; i <= maxDate; i++) {
            dates[i - 1] = new Date(first.getTime());
            first.setDate(first.getDate() + 1);
        }
        return dates;
    }

    /*public static void main(String[] args) {
        Date[] dates = getDates("2013", "05");
        System.out.println("dates:" + dates);

    }*/


    public static void main2(String[] args) {
        System.out.println(getBetweenDate("2020-02-02", "2020-02-03"));
    }

    public static List<String> getBetweenDate(String start, String end) {
        List<String> list = new ArrayList<>();
        // LocalDate默认的时间格式为2020-02-02
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        long distance = ChronoUnit.DAYS.between(startDate, endDate);
        if (distance < 1) {
            return list;
        }
        Stream.iterate(startDate, d -> d.plusDays(1)).limit(distance + 1).forEach(f -> list.add(f.toString()));
        return list;
    }


    public static String format(String value, Object... paras) {
        return MessageFormat.format(value, paras);
    }



    public static void main(String[] args) {
        List<User> users = Lists.newArrayList(
            new User(1,"a","11"),
            new User(2,"b","22"));
        List<Integer> ids = users.stream().map(user -> user.getId()).collect(Collectors.toList());
        System.out.println("ids: " + ids);
        List<User> userList = users.stream().filter(user -> user.getId().equals("1")).collect(Collectors.toList());
        List<Integer> list = users.stream().map(user -> user.getId() + 1).collect(Collectors.toList());
        System.out.println("list: " + list);
    }

    @Data
    public static class ParamVo {
        private Date startTime;
        private Date endTime;
        private Boolean startFromScratch = false;

        private String startTimeStr;

    }

}

@NoArgsConstructor
@AllArgsConstructor
@Data
class User {
    Integer id;
    String name;
    String age;
}

@NoArgsConstructor
@AllArgsConstructor
@Data
class User2 {
    Integer id;
    String name;
    String age;
}
