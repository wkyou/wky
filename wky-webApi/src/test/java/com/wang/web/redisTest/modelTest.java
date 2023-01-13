package com.wang.web.redisTest;

import com.wang.cache.redis.RedisClient;
import com.wang.cache.redis.bean.UserKey;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author WangKanYou
 * @Date 2022/7/17 14:37
 * @描述:
 */
@SpringBootTest
public class modelTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisClient redisClient;
    @Test
    public void test1(){
        UserKey userKey = new UserKey(100,"user");
        redisClient.set(userKey,"kan","你好呀");
        System.out.println(redisClient.get(userKey,"kan",String.class));
    }
}
