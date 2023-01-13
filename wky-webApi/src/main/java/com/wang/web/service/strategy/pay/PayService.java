package com.wang.web.service.strategy.pay;

/**
 * @Author WangKanYou
 * @Date 2023/1/12 14:04
 * @描述:  这里主要是封装支付所使用的方法
 */
public interface PayService {

    void init();
    //支付下单
    PayResult unifiedOrder(PayEntity payEntity);
}
