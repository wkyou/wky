package com.wang.web;

import com.wang.cache.redis.RedisClient;
import com.wang.dao.entity.Stock;
import com.wang.web.service.seckill.StockService;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author WangKanYou
 * @Date 2022/7/15 23:45
 * @描述:
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})
public class WebapiApplication implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(WebapiApplication.class,args);
    }

    @Autowired
    private RedisClient redisClient;
    @Autowired
    private StockService stockService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Stock> stockList = stockService.selectList();
        for (Stock stockItem : stockList) {
            redisClient.setCacheObject(stockItem.getName(),stockItem.getStock(),3600, TimeUnit.SECONDS);
        }
        redisClient.setCacheObject("count",100,3600, TimeUnit.SECONDS);
    }
}
