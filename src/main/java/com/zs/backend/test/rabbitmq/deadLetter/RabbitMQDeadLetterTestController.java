package com.zs.backend.test.rabbitmq.deadLetter;

import com.alibaba.fastjson.JSON;
import com.zs.backend.base.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/deadLetter_test")
public class RabbitMQDeadLetterTestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/a")
    public Result test01(){
        rabbitTemplate.convertAndSend(DeadLetterConfig.NORMAL_EXCHANGE,
            DeadLetterConfig.NORMAL_ROUTING_KEY, "测试死信队列，生产者，正常发消息，给消息设置过期时间", new MessagePostProcessor() {
                @Override
                public Message postProcessMessage(Message message) throws AmqpException {
                    return message;
                }
            });
        return Result.result(JSON.toJSON("测试死信队列，发送成功"));
    }
}
