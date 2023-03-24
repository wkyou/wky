package com.wang.payment.service;

import com.wang.payment.bean.request.OrderQueryParam;
import com.wang.payment.bean.request.PayOrder;
import com.wang.payment.bean.response.BusResult;

/**
 * @Author WangKanYou
 * @Date 2023/1/12 11:32
 * @描述: 暴露给外部调用的支付接口
 */
public interface PayServiceApi{

    /**
     * 支付下单接口
     * @param payOrder
     * @return
     */
    BusResult unifiedOrder(PayOrder payOrder);

    /**
     *
     * @param
     * @return
     */
    BusResult orderQuery(OrderQueryParam orderQueryParam);
    //查询支付状态

    String test(String str);
}
