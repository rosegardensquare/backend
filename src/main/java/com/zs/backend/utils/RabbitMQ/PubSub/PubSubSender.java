package com.zs.backend.utils.RabbitMQ.PubSub;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ReturnListener;
import com.zs.backend.utils.RabbitMQ.ConnectionUtil;
import com.zs.backend.utils.RabbitMQ.RMQConstans;
import java.io.IOException;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 发布订阅模式
 */
public class PubSubSender {

    public static void main(String[] args) throws Exception{

        Connection connection= ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        String message="PubSub_msg";
//        // 声明交换机名称、类型
        channel.exchangeDeclare(RMQConstans.PUB_SUB_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
//        // 构建队列1
        channel.queueDeclare(RMQConstans.PUB_SUB_QUEUE_NAME_1, false, false, false, null);
//        // 绑定交换机和队列
        channel.queueBind(RMQConstans.PUB_SUB_QUEUE_NAME_1, RMQConstans.PUB_SUB_EXCHANGE_NAME,
            RMQConstans.ROUTING_EXCHANGE_ROUTING_KEY_1);

        channel.queueDeclare(RMQConstans.PUB_SUB_QUEUE_NAME_1, false, false, false, null);
        // 开启发布确认模式
        channel.confirmSelect();

        /**
         * deliveryTag ： 是在消费端手动设置ack 时，设置的消息id
         * mutiple : 消费端手动ack 时，设置的是否批量确认
         */
        ConfirmCallback ackCallback = (long deliveryTag, boolean mutiple )->{
            System.out.println("发布/确认模式,发送成功");
        };
        // 发布确认模式：发送失败的回调函数
        ConfirmCallback nackCa = (long deliveryTag, boolean mutiple)->{
            System.out.println("发布/确认模式，发布消息失败" );
        };
        // 发布确认模式：注册监听器监听，异步通知
        channel.addConfirmListener(ackCallback, nackCa);

        channel.basicPublish(RMQConstans.PUB_SUB_EXCHANGE_NAME, RMQConstans.ROUTING_EXCHANGE_ROUTING_KEY_1,
            false,null,
            message.getBytes("UTF-8"));

        System.out.println("PubSub生产者,发送的消息："+ message);

        //关闭资源

        channel.close();

        connection.close();

    }


}
