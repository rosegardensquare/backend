package com.zs.backend.utils.RabbitMQ;

/**
 * 常量
 */
public class RMQConstans {


    public static final String HELLO_WORLD_QUEUE_NAME = "hello_world_queue";
    //public static final String QUEUE_HOST = "hello_world_queue";
    public static final String PUB_SUB_QUEUE_NAME_1 = "pub_sub_queue_name_1";
    public static final String PUB_SUB_QUEUE_NAME_2 = "pub_sub_queue_name_2";
    public static final String PUB_SUB_EXCHANGE_NAME = "pub_sub_exchange_name";

    public static final String ROUTING_QUEUE_NAME_1 = "routing_queue_name_1";
    public static final String ROUTING_QUEUE_NAME_2 = "routing_queue_name_2";
    public static final String ROUTING_EXCHANGE_NAME = "routing_exchange_name";
    public static final String ROUTING_EXCHANGE_ROUTING_KEY_1 = "info";
    public static final String ROUTING_EXCHANGE_ROUTING_KEY_2 = "error";

    public static final String TOPIC_ROUTING_KEY_1 = "*.info.*";
    public static final String TOPIC_ROUTING_KEY_2 = "error.#";
    public static final String TOPIC_QUEUE_NAME_1 = "topic_queue_name_1";
    public static final String TOPIC_QUEUE_NAME_2 = "topic_queue_name_2";
    public static final String TOPIC_EXCHANGE_NAME = "topic_exchange_name";


}
