package com.wang.payment.payapi;

import com.wang.payment.bean.request.OrderQueryParam;
import com.wang.payment.bean.request.PayOrder;
import com.wang.payment.bean.response.BusResult;

/**
 * @Author WangKanYou
 * @Date 2023/1/12 14:04
 * @描述:  这里主要是封装支付所使用的方法
 */
public interface PayService<O> {

    //小程序支付下单
    BusResult unifiedOrderApplet(PayOrder payOrder);

    //网站H5支付
    BusResult unifiedOrderH5(PayOrder payOrder);

    //当面扫码支付
    BusResult unifiedOrderPC(PayOrder payOrder);

    //支付订单查询接口
    BusResult orderQuery(OrderQueryParam orderQueryParam);
}
