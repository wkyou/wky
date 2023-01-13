package com.wang.web.config;


import com.wang.cache.config.RedisConfig;
import com.wang.cache.redis.RedisClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author WangKanYou
 * @Date 2022/7/17 14:53
 * @描述:
 */
@Configuration
public class RedisService extends RedisConfig {
    @Bean
    public RedisClient getRedisClient(){
        return new RedisClient();
    }
}
