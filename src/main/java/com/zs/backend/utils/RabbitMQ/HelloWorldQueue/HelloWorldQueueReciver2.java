package com.zs.backend.utils.RabbitMQ.HelloWorldQueue;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;
import com.rabbitmq.client.Envelope;
import com.zs.backend.utils.RabbitMQ.ConnectionUtil;
import com.zs.backend.utils.RabbitMQ.RMQConstans;
import java.io.IOException;

public class HelloWorldQueueReciver2 {
    public static void main(String[] args) throws Exception{

        //通过rabbitmq工具类得到连接
        Connection connection= ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        /*
         *   启动一个消费者，并返回一个消费者标识, 这个方法是由服务端主动 PUSH 过来，消费者接收到消息后进行处理。
         *   第一参数：队列名称
         *   第二参数：autAck.if true: 接收消息后应答；if false：不应答。
         *   第三参数：deliverCallback。当一个消息发送过来后的回调接口
         *   第四参数：cancleCallback.当一个消费者取消订阅时的回调接口
         */
        channel.basicQos(1);
        channel.basicConsume(RMQConstans.HELLO_WORLD_QUEUE_NAME, false,  new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    //获取消息数据
                    String bodyStr = new String(body, "UTF-8");
                    System.out.println("HelloWorldQueue消费者2，接收消息：  " + bodyStr);
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }
            }
        );

//        /**
//         * 第一个参数：队列名称
//         * 第二个参数：autoAcK, 接收后是否主动应答
//         */
//        GetResponse getResponse = channel.basicGet(RMQConstans.HELLO_WORLD_QUEUE_NAME, true);
//        String bodyStr = new String(getResponse.getBody(), "UTF-8");
//        System.out.println("HelloWorldQueue消费者，接收消息：  " + bodyStr);
    }

}
