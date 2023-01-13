package com.wang.web.controller;

import com.wang.web.service.strategy.pay.PayEntity;
import com.wang.web.service.strategy.pay.PayResult;
import com.wang.web.service.strategy.pay.PayServiceApi;
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
    public PayResult unifiedOrder(@RequestBody PayEntity payEntity){
        return payServiceApi.unifiedOrder(payEntity);
    }

}
