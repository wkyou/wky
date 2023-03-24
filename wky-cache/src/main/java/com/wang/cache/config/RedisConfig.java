package com.wang.cache.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import com.wang.cache.redis.RedisClient;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

/**
 * @Author WangKanYou
 * @Date 2022/7/17 14:40
 * @描述:
 */
@Configuration
public class RedisConfig{
    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private String redisPort;
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory jedisConnectionFactory) {
        //设置序列化
        GenericFastJsonRedisSerializer genericFastJsonRedisSerializer = new GenericFastJsonRedisSerializer();
        // 配置redisTemplate

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);// 设置连接池

        // RedisSerializer stringSerializer = new StringRedisSerializer();
        // key
        redisTemplate.setKeySerializer(new GenericToStringSerializer<>(Object.class)); // key序列化
        redisTemplate.setValueSerializer(genericFastJsonRedisSerializer); // value序列化

        // hash Key
        redisTemplate.setHashKeySerializer(new GenericToStringSerializer<>(Object.class)); // Hash key序列化
        redisTemplate.setHashValueSerializer(genericFastJsonRedisSerializer); // Hash value序列化
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public RedisMessageListenerContainer getRedisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory){
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        return container;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return new StringRedisTemplate(redisConnectionFactory);
    }

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://"+redisHost+":"+redisPort);
        //if (StringUtils.isBlank(password)) {
//            config.useSingleServer().setAddress("redis://" + redisHost + ":" + redisPort);
//        } else {
//            //TODO 发布打开下面的
//            config.useSingleServer().setAddress("redis://" + redisHost + ":" + redisPort).setPassword(password);
//        }

        return Redisson.create(config);
    }

}
