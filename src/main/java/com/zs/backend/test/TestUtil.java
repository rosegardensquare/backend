package com.zs.backend.test;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.*;

@Slf4j
public class TestUtil {

    public static void main(String[] args) {
        A a = new A();
        System.out.println("a = " + JSON.toJSONString(a));

        int i = 1;
        Integer ii = 3;
        setI(i, ii, a);
        System.out.println("i = " + i);
        System.out.println("ii = " + ii);
        System.out.println("a = " + JSON.toJSONString(a));

        List<Integer> l = new ArrayList<>();


    }



    public static void setI(int i, Integer ii, A a){
        i = 2;
        ii = 2;
        a.setName("111");
    }


// 这是有问题的
    // log.info("运单评分，orderExtendDTO{}", JSONUtils.toJSONString(orderExtendDTO));

    public  static void main1(String[] args) {
        final int I = 0;
        System.out.println(I);
        OrderExtendDTO orderExtendDTO = new OrderExtendDTO();
        orderExtendDTO.setDriverId(2l);
        int i = 0;
        setOrder(orderExtendDTO, i);
        //log.info("orderExtendDTO：{}", JSON.toJSONString(orderExtendDTO)); // orderExtendDTO{"driverId":2}
        //log.info("i = {}", i); // i = 0
        float f = 2.123456789012f; //f = 2.1234567
        log.info("f = {}", f);
        double d = 2.0123456789011111111111;// d = 2.012345678901111
        log.info("d = {}", d);

        int ii = Integer.parseInt("16",16);
        log.info("ii = {}", ii);

    }

    // 引用数据类型作为参数，传递的是对象的地址；基本数据类型传递的是值
    private static void setOrder(OrderExtendDTO orderExtendDTO, int i){
        orderExtendDTO = new OrderExtendDTO();
        orderExtendDTO.setDriverId(3l);
        i = 1;
    }
}


@Getter
@AllArgsConstructor
enum OrderStatusEnum{
    WAITING_TAKE(1, "待接单");

    private Integer value;
    private String name;

    public static OrderStatusEnum valueOf(Integer value) {
        for (OrderStatusEnum orderStatusEnum : OrderStatusEnum.values()) {
            if (orderStatusEnum.getValue().equals(value)) {
                return orderStatusEnum;
            }
        }
        return null;
    }
}

class A{
    private String id  = "1";
    private String name;

    private int a ;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}