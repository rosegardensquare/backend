package com.zs.backend.test;


import com.alibaba.fastjson.JSON;
import com.zs.backend.base.Result;
import com.zs.backend.config.RabbitMQConfig;
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
@RequestMapping("/test")
public class TestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * convertAndSend(String exchange, String routingKey, Object object)
     * 直接发送消息
     * @return
     */
    @GetMapping("/a")
    public Result test01(){
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "b.black.b", "rabbitMQ 未启动时，发送消息001");
        return Result.result(JSON.toJSON(rabbitTemplate));
    }

    /**
     * convertAndSend(String exchange, String routingKey, Object 消息， , MessagePostProcessor messagePostProcessor)
     * 发送消息时候，可以带上其他参数,比如：唯一标识
     * @return
     */
    @GetMapping("/b")
    public Result test02(){
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "b.black.b", "rabbitMQ 未启动时，发送消息002", new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                // 设置消息的唯一标识
                message.getMessageProperties().setCorrelationId("123");
                return message;
            }
        });
        return Result.result(JSON.toJSON(rabbitTemplate));
    }
}
