package com.wang.mq.consumer;

import com.wang.common.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author WangKanYou
 * @Date 2022/8/1 11:54
 * @描述:
 */
@Component
//使用queuesToDeclare属性，如果不存在则会创建队列
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.RABBITMQ_DEMO_TOPIC))
public class RabbitDemoConsumer {
    @RabbitHandler
    public void p(Map map){
        System.out.println("队列信息"+map.get("msgId"));
    }
}