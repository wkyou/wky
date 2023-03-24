package com.wang.web.controller;

import com.wang.cache.redis.RedisClient;
import com.wang.web.service.seckill.MqStockServiceImpl;
import com.wang.web.service.seckill.StockService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author WangKanYou
 * @Date 2023/3/20 11:36
 * @描述:
 */
@RestController
@RequestMapping("secKill")
public class SecKillController {
    @Autowired
    private MqStockServiceImpl mqStockService;

    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private RedisClient redisClient;
    @PostMapping(value = "sec-kill")
    //@ApiOperation(value = "redis+消息队列进行秒杀实现", notes = "redis+消息队列进行秒杀实现")
    //@LimitNumber(value = 2)
    //@AccessLimit(seconds = 1,maxCount = 800)
    public String secKill(@RequestParam(value = "userName") String userName, @RequestParam(value = "stockName") String stockName) {
        return mqStockService.secKill(userName,stockName);
    }

    public static void main(String[] args) {
        System.out.println((int) Math.random());
    }

    private String lockValue;
    //分布式锁测试
    @GetMapping("/lock")
    public String lock(){
        //lockValue= UUID.randomUUID().toString();
        //while (true){
        //    boolean lock = redisClient.setLock("lockKey", lockValue,1, TimeUnit.SECONDS);
        //    if (lock){
        //        break;
        //    }else {
        //        //没有获取到锁在在此休眠1秒钟
        //        Thread.sleep(100);
        //    }

        RLock lockKey1 = redissonClient.getLock("lockKey");
        boolean lock=false;
        try {
            //lockKey1.lock();
            lock = redissonClient.getLock("lockKey").tryLock(1,TimeUnit.SECONDS);
            if (!lock) {
                System.out.println("没有获取到锁");
                return "";
            }
            //获取库存信息
            //Long count = redisClient.decrBy("count");
            int count =((int) redisClient.getObj("count"))-1;
            if (Objects.nonNull(count) && count>=0){
                System.out.println("下单成功，库存充足"+count);
                redisClient.setCacheObject("count",count);
                Thread.sleep(2000);
                return "下单成功，库存充足";
            }else {
                System.out.println("下单失败，库存不足");
                return "下单失败，库存不足";
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("解锁");
            if (lock){
                lockKey1.unlock();
            }

            //if (lockValue.equals(redisClient.getString("lockKey"))) {
            //    boolean lockKey = redisClient.unLock("lockKey");
            //    if (lockKey) {
            //        System.out.println("释放锁成功");
            //    } else {
            //        System.out.println("释放锁失败");
            //    }
            //}
        }
        return "";
    }
}
