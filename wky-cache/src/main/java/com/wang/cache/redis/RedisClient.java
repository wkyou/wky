package com.wang.cache.redis;

import com.alibaba.fastjson.JSON;
import com.wang.cache.redis.bean.KeyPrefix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisClient {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 获取单个对象
     */
    @SuppressWarnings("unchecked")
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        try {
            String realKey = prefix.getPrefix() + key;

            if (clazz == String.class) {
                return (T) this.getString(realKey);
            } else {
                return (T) this.getObj(realKey);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取当个对象
     */
    public <T> List<T> hashGet(KeyPrefix prefix, String key, Class<T> clazz) {
        String str = this.get(prefix, key, String.class);
        return JSON.parseArray(str, clazz);
    }

    /**
     * 设置对象
     */
    public <T> boolean hashSet(KeyPrefix prefix, String key, T value) {
        String str = JSON.toJSONString(value);
        return this.set(prefix, key, str);
    }


    /**
     * 设置对象
     */
    public <T> boolean set(KeyPrefix prefix, String key, T value) {
        try {
            String realKey = prefix.getPrefix() + key;
            int seconds = prefix.expireSeconds();
            if (value instanceof String) {
                this.setString(realKey, (String) value, seconds);
            } else {
                this.setObject(realKey, value, seconds);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断key是否存在
     */
    public boolean exists(KeyPrefix prefix, String key) {
        String realKey = prefix.getPrefix() + key;
        return redisTemplate.hasKey(realKey);
    }

    public Set<String> likeExists(KeyPrefix prefix, String key) {
        Set<String> result = null;

        try {
            String realKey = prefix.getPrefix() + key;
            String patternKey = realKey + "*";
            result = this.scan(patternKey);
            //关闭游标
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public Set<String> scan(String patternKey) {
        Cursor cursor = null;
        Set<String> result = null;
        try {
            ScanOptions options = ScanOptions.scanOptions()
                    //指定每次扫描key的数量
                    .count(5000)
                    .match(patternKey).build();

            cursor = redisTemplate.executeWithStickyConnection((RedisCallback<ConvertingCursor<byte[], String>>)
                    redisConnection -> new ConvertingCursor(redisConnection.scan(options),
                            (Converter<byte[], String>) source -> new String(source, StandardCharsets.UTF_8)));
            result = new HashSet<>();
            while (cursor.hasNext()) {
                result.add(cursor.next().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    public long ttl(KeyPrefix prefix, String key) {
        String realKey = prefix.getPrefix() + key;
        return redisTemplate.getExpire(realKey, TimeUnit.SECONDS);
    }

    /**
     * 增加值
     */
    public Long incr(KeyPrefix prefix, String key) {
        String realKey = prefix.getPrefix() + key;
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(realKey, redisTemplate.getConnectionFactory());
        return entityIdCounter.getAndIncrement();
    }

    /**
     * 减少值
     */
    public Long decr(KeyPrefix prefix, String key) {
        String realKey = prefix.getPrefix() + key;
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(realKey, redisTemplate.getConnectionFactory());
        return entityIdCounter.getAndDecrement();
    }

    /**
     * 删除key
     */
    public boolean delete(KeyPrefix prefix, String key) {
        String realKey = prefix.getPrefix() + key;
        return redisTemplate.delete(realKey);
    }

    /**
     * 模糊删除key
     */
    public void deleteLike(KeyPrefix prefix, String key) {
        String realKey = prefix.getPrefix() + key;
        Set<String> keysList = stringRedisTemplate.keys("*" + realKey + "*");
        stringRedisTemplate.delete(keysList);
    }


    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    public String getString(String key) {
        return key == null ? null : stringRedisTemplate.opsForValue().get(key);
    }

    public Object getObj(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     *
     * @param key     键
     * @param value   值
     * @param seconds 过期时间
     * @return true成功 false失败
     */
    private void setString(String key, String value, int seconds) {
        if (seconds > 0) {
            stringRedisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
        } else {
            stringRedisTemplate.opsForValue().set(key, value);
        }
    }

    private void setObject(String key, Object value, int seconds) {
        if (seconds > 0) {
            redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
        } else {
            redisTemplate.opsForValue().set(key, value);
        }
    }

    public void putMessage(String channel, String message) {
        System.out.println(channel + "----" + message);
        redisTemplate.convertAndSend(channel, message);
    }

    /**
     * 对指定key的键值减一
     * @param key 键
     * @return Long
     */
    public Long decrBy(String key) {
        return redisTemplate.opsForValue().decrement(key);
    }

    public Long incrBy(String key) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        return entityIdCounter.getAndIncrement();
    }


    public <T> void setCacheObject(final String key, final T value)
    {
        redisTemplate.opsForValue().set(key, value);
    }
    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key 缓存的键值
     * @param value 缓存的值
     * @param timeout 时间
     * @param timeUnit 时间颗粒度
     */
    public <T> void setCacheObject(final String key, final T value, final Integer timeout, final TimeUnit timeUnit)
    {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    //设置锁
    public boolean setLock(String key, String value,Integer timeout,TimeUnit timeUnit){
        return redisTemplate.opsForValue().setIfAbsent(key,value,timeout,timeUnit);
    }

    public boolean setLock(String key, String value){
        return redisTemplate.opsForValue().setIfAbsent(key,value);
    }

    public boolean unLock(String key){
        return redisTemplate.delete(key);
    }


}
