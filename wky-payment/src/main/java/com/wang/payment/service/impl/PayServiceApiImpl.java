package com.wang.payment.service.impl;

import com.wang.payment.bean.request.OrderQueryParam;
import com.wang.payment.bean.request.PayOrder;
import com.wang.payment.bean.response.BusResult;
import com.wang.payment.payapi.PayService;
import com.wang.payment.service.PayServiceApi;
import com.wang.payment.service.PaymentContextService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author WangKanYou
 * @Date 2023/1/12 14:33
 * @描述:
 */
@Service
@Slf4j
public class PayServiceApiImpl implements PayServiceApi {
    @Resource
    private PaymentContextService paymentContextService;

    @Override
    public BusResult unifiedOrder(PayOrder payOrder) {
        String payType = payOrder.getPayType();
        PayService payService = paymentContextService.getContext(payType);
        return payService.unifiedOrderPC(payOrder);
    }

    @Override
    public BusResult orderQuery(OrderQueryParam orderQueryParam) {
        String payType = orderQueryParam.getPayType();
        PayService payService = paymentContextService.getContext(payType);
        return payService.orderQuery(orderQueryParam);
    }

    @Override
    public String test(String str) {
        log.info("我被调用了");
        return null;
    }
}
