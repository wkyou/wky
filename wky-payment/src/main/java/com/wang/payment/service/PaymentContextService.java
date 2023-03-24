package com.wang.payment.service;

import com.wang.payment.payapi.PayService;

/**
 * @Author WangKanYou
 * @Date 2023/1/12 14:10
 * @描述: 获取对应的支付实现类bean
 */
public interface PaymentContextService {
    /**
     * 根据支付方式获取处理上下文
     *
     * @param payType
     * @return
     */
    PayService getContext(String payType);
}
