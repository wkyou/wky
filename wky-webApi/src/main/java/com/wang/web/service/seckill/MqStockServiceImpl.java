package com.wang.web.service.seckill;

import com.wang.cache.redis.RedisClient;
import com.wang.dao.entity.TOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @Author WangKanYou
 * @Date 2023/3/20 10:09
 * @描述:
 */
@Service
@Slf4j
public class MqStockServiceImpl {

    @Resource
    private RedisClient redisClient;

    @Resource
    private RabbitTemplate rabbitTemplate;

    private boolean flag=false;
    /**
     * 使用redis+消息队列进行秒杀实现
     *
     * @param userName  用户名称
     * @param stockName 商品名称
     * @return String
     */
    public String secKill(String userName, String stockName) {
        log.info("参加秒杀的用户是：{}，秒杀的商品是：{}", userName, stockName);
        String message = "";
        if (flag){
            return  message = "用户：" + userName + "商品的库存量没有剩余,秒杀结束";
        }
        //redis中key对应的value减一
        Long decrByResult = redisClient.decrBy(stockName);
        if (Objects.nonNull(decrByResult) && decrByResult >= 0) {
            /**
             * 说明该商品的库存量有剩余，可以进行下订单操作
             */
            log.info("用户：{}， 秒杀该商品：{}，库存余量{}，可以进行下订单操作", userName, stockName, decrByResult);
            //1.发消息给订单消息队列，创建订单 2.发消息给库存消息队列，将库存数据减一 3.将订单保存到redis 实现限购功能
            TOrder order = new TOrder();
            order.setOrderUser(userName);
            order.setOrderName(stockName);
            rabbitTemplate.convertAndSend(MqSecKillConfig.ORDER_EXCHANGE,MqSecKillConfig.ORDER_ROUTING_KEY,order);
            message = "用户" + userName + "秒杀" + stockName + "成功";
            limitNumber(userName,stockName);
        } else {
            flag=true;
            /**
             * 说明该商品的库存量没有剩余，直接返回秒杀失败的消息给用户
             */
            log.info("用户：{}秒杀时商品的库存量没有剩余,秒杀结束", userName);
            message = "用户：" + userName + "商品的库存量没有剩余,秒杀结束";
        }
        return message;
    }

    private void limitNumber(String userName, String stockName) {
        String key = userName + ":" + stockName + ":number";
        redisClient.incrBy(key);
    }

}
