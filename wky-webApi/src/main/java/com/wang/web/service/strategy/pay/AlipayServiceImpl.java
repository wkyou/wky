package com.wang.web.service.strategy.pay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author WangKanYou
 * @Date 2023/1/12 11:36
 * @描述:
 */
@Slf4j
@Service
@Payment("alipay")
public class AlipayServiceImpl implements PayService{
    @Override
    public void init() {
        log.info("支付宝初始化完成");
    }

    @Override
    public PayResult unifiedOrder(PayEntity payEntity) {
        String msg="这里是支付宝下单支付接口，你支付的金额为："+payEntity.getPayAmount()+"---zfb4";
        return PayResult.Build.success(msg);
    }
}
