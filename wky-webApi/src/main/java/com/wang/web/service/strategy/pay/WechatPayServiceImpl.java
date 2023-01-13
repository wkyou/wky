package com.wang.web.service.strategy.pay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author WangKanYou
 * @Date 2023/1/12 11:40
 * @描述:
 */
@Slf4j
@Service
@Payment("wechat")
public class WechatPayServiceImpl implements PayService {
    @Override
    public void init() {
        log.info("微信初始化完成");
    }

    @Override
    public PayResult unifiedOrder(PayEntity payEntity) {
        String msg="这里是微信下单支付接口，你支付的金额为："+payEntity.getPayAmount();
        return PayResult.Build.success(msg);
    }
}
