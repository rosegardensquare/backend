package com.zs.backend.test;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class TestUtil {

    private static final BigDecimal DEFALUT_SCORE = new BigDecimal(5.00);

    private static final String DIC_SCORE_CODE = "khpjdm";

    private static final int DEFALUT_SCORE_DAY = 7;

    public static void main(String[] args) {

        List<Order> orders = new ArrayList<>();
        Order order_1 = new Order();
        order_1.setId(1l);
        orders.add(order_1);

        List<OrderExtend> noScoreOrderExtends = new ArrayList<>();
        Map<Long, OrderExtend> orderIdAndNScoreExtend = noScoreOrderExtends.stream().collect(Collectors.toMap(OrderExtend::getId, orderExtend -> orderExtend));

        List<OrderExtend> orderExtends = new ArrayList<>();

        JSONArrayWrapper jsonArrayWrapper = new JSONArrayWrapper();
        jsonArrayWrapper.setData(orders);


        orders.stream().forEach(order ->{
            OrderExtend orderExtend = new OrderExtend();
            orderExtend.setId(order.getId());
            orderExtend.setShipperScore(DEFALUT_SCORE);
            orderExtend.setDriverScore(DEFALUT_SCORE);

            orderExtend.setDriverScoreInfo(new JSONArrayWrapper(jsonArrayWrapper.getData()));
            orderExtend.setShipperScoreInfo(new JSONArrayWrapper(jsonArrayWrapper.getData()));

            orderExtend.setShipperId(order.getShipperCid());
            orderExtend.setDriverId(order.getDriverId());
            orderExtend.setIsDriverScore(1);
            orderExtend.setIsShipperScore(1);
            orderExtends.add(orderExtend);
        });


        System.out.println("orderExtends = " + JSON.toJSONString(orderExtends));
    }
}
