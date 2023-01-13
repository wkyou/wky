package com.wang.web.service;

/**
 * @Author WangKanYou
 * @Date 2022/8/1 11:11
 * @描述:
 */
public interface RabbitMQService {

    String sendMsg(String msg) throws Exception;
}
