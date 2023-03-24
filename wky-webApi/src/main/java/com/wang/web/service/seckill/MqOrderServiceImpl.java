package com.wang.web.service.seckill;

import com.rabbitmq.client.Channel;
import com.wang.dao.entity.TOrder;
import com.wang.dao.mapper.StockMapper;
import com.wang.dao.mapper.TOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author WangKanYou
 * @Date 2023/3/20 9:51
 * @描述:队列消费
 */
@Service
@Slf4j
public class MqOrderServiceImpl {
    @Resource
    private OrderService orderService;

    @Resource
    private StockService stockService;


    /**
     * MQ监听订单消息队列，并消费
     * @param order
     */
    @RabbitListener(queues = MqSecKillConfig.ORDER_QUEUE, containerFactory = "rabbitListenerContainerFactory")
    @Transactional(rollbackFor = Exception.class)
    public void saveOrder(Message message, TOrder order, Channel channel) throws IOException {
        log.info("收到订单消息，订单用户为：{}，商品名称为：{}", order.getOrderUser(), order.getOrderName());
        /**
         * 调用数据库orderService创建订单信息
         */
        order.setCreateBy(order.getOrderUser());
        order.setCreateDate(LocalDateTime.now());
        order.setUpdateBy(order.getOrderUser());
        order.setUpdateDate(LocalDateTime.now());
        order.setDelFlag("0");
        int i = orderService.saveOrder(order);
        int j = stockService.decrByStock(order.getOrderName());
        if (i>0 && j>0){
            //消费成功
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
            log.info("消费订单成功，订单用户为：{}，商品名称为：{}", order.getOrderUser(), order.getOrderName());
        }else {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,true);
            log.info("消费订单失败，订单用户为：{}，商品名称为：{}", order.getOrderUser(), order.getOrderName());
        }
    }
}
