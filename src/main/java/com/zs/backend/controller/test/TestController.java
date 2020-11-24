package com.zs.backend.controller.test;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zs.backend.entity.User;
import com.zs.backend.mapper.UserMapper;
import com.zs.backend.test.*;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    @Qualifier("testService2Impl")
    private TestService testService;

    @RequestMapping("getUser")
    public void GetUser() {
        OrderExtend orderExtend = new OrderExtend();
        orderExtend.setId(1l);
        orderExtend.setDriverId(3l);
        List<OrderExtend> orderExtends = new ArrayList<>();
        orderExtends.add(orderExtend);
        //this.set(orderExtends);
        log.info("------" + JSON.toJSONString(orderExtends));


        /*if(OrderStatusQueryEnum.DRIVER_ON_GOING_ALL.getValue().intValue ()== orderExtend.getStatus().intValue()){
            log.info("1111" );
        }else{
            log.info("222" );

        }
*/

        /*testService.add();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sex", 3).orderByDesc(Order.STATUS).orderByDesc(Order.CREATE_TIME);


        log.info("queryWrapper -----------------" + JSON.toJSONString(queryWrapper));
        List<User> users = userMapper.selectList(queryWrapper);
        log.info("------" + JSON.toJSONString(users));*/

    }

    private void set(List<OrderExtend> orderExtends ){
        for(OrderExtend orderExtend1 : orderExtends){
            orderExtend1.setStatus(1);
        }
    }


    private void setOrderExtend(OrderExtend orderExtend){
        orderExtend = new OrderExtend();
        orderExtend.setId(2l);
    }

    private OrderExtend setOrderExtend(){
        OrderExtend orderExtend = new OrderExtend();
        orderExtend.setId(2l);
        return orderExtend;
    }


    @PostMapping("order_score")
    public void orderScore(@RequestBody OrderScoreRequest orderScoreRequest) {
        //log.info("司机运单评价参数, {}", JSON.toJSONString(orderScoreRequest));
        OrderExtend orderExtend = new OrderExtend();
        BeanUtils.copyProperties(orderScoreRequest, orderExtend);


        this.calculationOrderScore(orderScoreRequest, orderExtend);
        log.info("司机运单评价参数, {}", JSON.toJSONString(orderExtend));

    }


    private void calculationOrderScore(OrderScoreRequest orderScoreRequest, OrderExtend orderExtend){
        JSONArrayWrapper jsonArrayWrapper = orderScoreRequest.getScoreInfo_2();
        BigDecimal scores = BigDecimal.ZERO;
        for (ScoreDTO score : jsonArrayWrapper.getData(ScoreDTO.class)) {
            if (score.getScoreItemId() != null) {
                scores = score.getScoreLevel().add(scores);
            }
        }
        orderExtend.setDriverScore(scores);
        orderExtend.setDriverScoreInfo(orderScoreRequest.getScoreInfo_2());
    }




}