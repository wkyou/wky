package com.wang.web.service.strategy.pay;

/**
 * @Author WangKanYou
 * @Date 2023/1/12 11:32
 * @描述: 暴露给外部调用的支付接口
 */
public interface PayServiceApi {

    /**
     * 支付下单接口
     * @param payEntity
     * @return
     */
    PayResult unifiedOrder(PayEntity payEntity);
}
