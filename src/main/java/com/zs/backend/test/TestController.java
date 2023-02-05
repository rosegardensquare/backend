package com.zs.backend.test;


import com.alibaba.fastjson.JSON;
import com.zs.backend.base.Result;
import com.zs.backend.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/a")
    public Result getMenuList(){
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "b.black.b", "rabbitMQ 未启动时，发送消息001");
        return Result.result(JSON.toJSON(rabbitTemplate));
    }
}
