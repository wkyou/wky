package com.wang.web.controller;

import com.wang.payment.bean.request.OrderQueryParam;
import com.wang.payment.bean.request.PayOrder;
import com.wang.payment.bean.response.BusResult;
import com.wang.payment.service.PayServiceApi;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author WangKanYou
 * @Date 2023/1/12 14:35
 * @描述:
 */
@RestController
@RequestMapping("/payApi")
public class PaymentController {
    @Resource
    private PayServiceApi payServiceApi;
    @PostMapping("/unifiedOrder")
    public BusResult unifiedOrder(@RequestBody PayOrder payEntity){
        OrderQueryParam orderQueryParam = new OrderQueryParam();
        orderQueryParam.setPayType(payEntity.getPayType());
        BusResult busResult = payServiceApi.unifiedOrder(payEntity);
        return payServiceApi.orderQuery(orderQueryParam);
        //return payServiceApi.unifiedOrder(payEntity);
    }

}
