package com.wang.web.service.strategy.pay;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author WangKanYou
 * @Date 2023/1/12 14:33
 * @描述:
 */
@Service
public class PayServiceApiImpl implements PayServiceApi {
    @Resource
    private PaymentContextService paymentContextService;

    @Override
    public PayResult unifiedOrder(PayEntity payEntity) {
        String payType = payEntity.getPayType();
        PayService payService = paymentContextService.getContext(payType);
        return payService.unifiedOrder(payEntity);
    }
}
