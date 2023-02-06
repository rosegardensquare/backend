package com.zs.backend.test.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.zs.backend.base.Result;
import com.zs.backend.config.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class RabbitMQTestController {

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
     * 生产者的 confirm 机制
     * 如果写错了生产者的交换机名称，就会进入else 中
     * @return
     */
    @GetMapping("/confirm")
    public Result confirm(){
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if(ack){
                    System.out.println("消息已经送达到交换机！！");
                }else{
                    System.out.println("消息没有送达到Exchange，需要做一些补偿操作！！retry！！！");
                }
            }
        });

        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, "rabbitMQ。。。。。。", new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                // 设置消息的唯一标识
                message.getMessageProperties().setCorrelationId("123");
                return message;
            }
        });
        return Result.result(JSON.toJSON(rabbitTemplate));
    }

    /**
     * 生产者的 return 机制
     * 如果写错了路由规则名称，就会进入return 回调中
     * @return
     */
    @GetMapping("/returns")
    public Result returns(){
        rabbitTemplate.setReturnCallback(new ReturnCallback() {
            @Override
            public void returnedMessage(Message message, int i, String s, String s1, String s2) {
                String msg = new String(message.getBody());
                System.out.println("消息：" + msg + "路由队列失败！！做补救操作！！");
            }
        });

        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, "rabbitMQ。。。。。。", new MessagePostProcessor() {
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
