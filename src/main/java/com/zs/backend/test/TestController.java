package com.zs.backend.test;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.zs.backend.entity.User;
import com.zs.backend.service.IOrderDao;
import com.zs.backend.service.IOrderExtendDao;
import com.zs.backend.service.UserService;
import com.zs.backend.test.model.Order;
import com.zs.backend.test.model.OrderExtend;
import com.zs.backend.test.model.ScoreDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private IOrderDao orderDao;

    @Autowired
    private IOrderExtendDao orderExtendDao;

    @RequestMapping("/")
    public void login(@RequestBody User userModel) {
        List<Long> noScoreOrderIds = new ArrayList<>();
        noScoreOrderIds.add(1829l);
        QueryWrapper<OrderExtend> noScoreExtendQueryWrapper = new QueryWrapper<OrderExtend>()
                .in(Order.ID, noScoreOrderIds);
        List<OrderExtend> noScoreOrderExtends = orderExtendDao.list(noScoreExtendQueryWrapper);
        Map<Long, OrderExtend> orderIdAndNoScoreExtend = noScoreOrderExtends.stream().collect(Collectors.toMap(OrderExtend::getId, orderExtend -> orderExtend));


        QueryWrapper<Order> orderWrapper = new QueryWrapper<Order>()
                .eq(Order.DEL, "0")
                .in(Order.STATUS, Lists.newArrayList( new Integer(5),
                        new Integer(6)))
                .apply("TIMESTAMPDIFF(day,sign_time, NOW())> {0}", 7);

        orderWrapper.eq(Order.ID, Lists.newArrayList( new Integer(5),
                new Integer(6)));


        List<Order> orders = orderDao.list(orderWrapper);

        List<Long> orderIds = orders.stream().map(e -> e.getId()).collect(Collectors.toList());
        QueryWrapper<OrderExtend> scoreExtendQueryWrapper = new QueryWrapper<OrderExtend>()
                .in(Order.ID, orderIds).eq(OrderExtend.IS_DRIVER_SCORE, "1").eq(OrderExtend.IS_SHIPPER_SCORE, "1");
        List<OrderExtend> scoreOrderExtends = orderExtendDao.list(scoreExtendQueryWrapper);

        List<Long> scoreOrderIds = scoreOrderExtends.stream().map(e -> e.getId()).collect(Collectors.toList());

        orders = orders.stream().filter(order -> !scoreOrderExtends.contains(order.getId())).collect(Collectors.toList());



        this.saveOrUpdateExtends(orders, noScoreOrderExtends);

    }


    private static final BigDecimal DEFALUT_SCORE = new BigDecimal(5.00);


    private Boolean saveOrUpdateExtends(List<Order> orders, List<OrderExtend> noScoreOrderExtends){

        Map<Long, OrderExtend> orderIdAndNoScoreExtend = noScoreOrderExtends.stream().collect(Collectors.toMap(OrderExtend::getId, orderExtend -> orderExtend));
        log.info("saveOrUpdateExtends. orderIdAndNoScoreExtend: {}", JSON.toJSONString(orderIdAndNoScoreExtend) );
        JSONArrayWrapper jsonArrayWrapper = new JSONArrayWrapper();
        List<ScoreDTO> scoreInfos = new ArrayList<>();
        ScoreDTO scoreDTO = new ScoreDTO();
        scoreDTO.setScoreItemCode("1");
        scoreDTO.setScoreLevel(DEFALUT_SCORE);
        scoreInfos.add(scoreDTO);
        jsonArrayWrapper.setData(scoreInfos);
        List<OrderExtend> orderExtends = new ArrayList<>();
        for (Order order : orders) {
            OrderExtend orderExtend = new OrderExtend();
            orderExtend.setId(order.getId());
            orderExtend.setShipperId(order.getShipperCid());
            orderExtend.setDriverId(order.getDriverId());
            orderExtend.setIsDriverScore(1);
            orderExtend.setIsShipperScore(1);
            orderExtend.setScoreDriverId(order.getDriverId());
            orderExtend.setScoreShipperId(order.getShipperCid());

            if(orderIdAndNoScoreExtend.get(order.getId()) != null){
                if(orderIdAndNoScoreExtend.get(order.getId()).getIsShipperScore() == null){
                    orderExtend.setShipperScore(DEFALUT_SCORE);
                    orderExtend.setShipperScoreInfo(new JSONArrayWrapper(jsonArrayWrapper.getData()));
                    orderExtend.setShipperScoreTime(new Date());
                }
                if(orderIdAndNoScoreExtend.get(order.getId()).getIsDriverScore() == null){
                    orderExtend.setDriverScore(DEFALUT_SCORE);
                    orderExtend.setDriverScoreInfo(new JSONArrayWrapper(jsonArrayWrapper.getData()));
                    orderExtend.setDriverScoreTime(new Date());
                }
            }else{
                orderExtend.setShipperScore(DEFALUT_SCORE);
                orderExtend.setShipperScoreInfo(new JSONArrayWrapper(jsonArrayWrapper.getData()));
                orderExtend.setDriverScore(DEFALUT_SCORE);
                orderExtend.setDriverScoreInfo(new JSONArrayWrapper(jsonArrayWrapper.getData()));
                orderExtend.setDriverScoreTime(new Date());
                orderExtend.setShipperScoreTime(new Date());
            }
            orderExtends.add(orderExtend);
        }

        Boolean result = orderExtendDao.saveOrUpdateBatch(orderExtends);
        return result;
    }






}
