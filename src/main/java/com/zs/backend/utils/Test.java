package com.zs.backend.utils;

import lombok.Data;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Stream;

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
        String s ;
    }

    @Data
    public static class ParamVo {
        private Date startTime;
        private Date endTime;
        private Boolean startFromScratch = false;

        private String startTimeStr;

    }

}



  class User {
    String name;
    String age;

      public String getName() {
          return name;
      }

      public void setName(String name) {
          this.name = name;
      }

      public String getAge() {
          return age;
      }

      public void setAge(String age) {
          this.age = age;
      }
  }
