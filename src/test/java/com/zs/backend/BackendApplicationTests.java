//package com.zs.backend;
//
//import com.zs.backend.config.RabbitMQConfig;
//import org.apache.commons.lang3.StringUtils;
//import org.junit.Test;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class BackendApplicationTests {
//
//    @Autowired
//    private RabbitTemplate template;
//
//    @Test
//    public void test_rabbitMQ_topic_publish() {
//       template.convertAndSend(RabbitMQConfig.EXCHANGE, "b.black.b", "消息001");
//        System.out.println("消息发送成功");
//    }
//
//}
