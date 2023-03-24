package com.wang.payment.payapi;

import com.wang.payment.annotation.Payment;
import com.wang.payment.bean.request.OrderQueryParam;
import com.wang.payment.bean.request.PayOrder;
import com.wang.payment.bean.response.BusResult;
import com.wang.payment.config.WxPayConfig;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author WangKanYou
 * @Date 2023/1/12 11:40
 * @描述:
 */
@Slf4j
@Payment("wechat")
public class WechatPayServiceImpl implements PayService {
    private WxPayConfig wxPayConfig;
    public WechatPayServiceImpl(WxPayConfig wxPayConfig) {
        this.wxPayConfig=wxPayConfig;
    }


    @Override
    public BusResult unifiedOrderApplet(PayOrder payOrder) {
        String msg="这里是微信下单支付接口，你支付的金额为：";

        return null;
    }

    @Override
    public BusResult unifiedOrderH5(PayOrder payOrder) {
        return null;
    }

    @Override
    public BusResult unifiedOrderPC(PayOrder payOrder) {
        return null;
    }

    @Override
    public BusResult orderQuery(OrderQueryParam orderQueryParam) {
        return null;
    }
}
