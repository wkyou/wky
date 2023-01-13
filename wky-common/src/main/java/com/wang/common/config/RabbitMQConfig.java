package com.wang.common.config;
/**
 * @Author WangKanYou
 * @Date 2022/8/1 10:47
 * @描述:
 */
public class RabbitMQConfig {

    //创建─个公共的配置类，定义一些配置信息
    /**
     * RabbitMQ的队列主题名称
     */
    public static final String RABBITMQ_DEMO_TOPIC = "rabbitmqDemoTopic";
    /**
     * RabbitMQ的DIRECT交换机名称
     */
    public static final String RABBITMQ_DEMO_DIRECT_EXCHANGE = "rabbitmqDemoDirectExchange";
    /**
     * RabbitMo的DIRECT交换机和队列绑定的匹配键 DirectRouting
     */
    public static final String RABBITMQ_DEMO_DIRECT_ROUTING = "rabbitmqDemoDirectRouting";
}

