package com.wang.cache.redis.bean;

public interface KeyPrefix {

	int expireSeconds();

	String getPrefix();

}
