package com.wang.cache.redis.bean;

/**
 * @Author WangKanYou
 * @Date 2022/7/17 21:58
 * @描述:
 */
public class UserKey implements KeyPrefix {
    private int expireSeconds;
    private String prefix;

    public UserKey(int expireSeconds, String prefix) {
        this.expireSeconds = expireSeconds;
        this.prefix = prefix;
    }

    @Override
    public int expireSeconds() {
        return expireSeconds;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" + prefix + ":";
    }
}
