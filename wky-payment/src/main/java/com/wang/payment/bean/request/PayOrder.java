package com.wang.payment.bean.request;

import lombok.Data;

/**
 * @Author WangKanYou
 * @Date 2023/3/15 16:02
 * @描述:
 */
@Data
public class PayOrder {
    /**
     * 商品描述
     */
    private String description;

    /**
     * 商户订单号
     */
    private String out_trade_no;

    /**
     *通知地址
     */
    private String notify_url;

    /**
     * 附加数据
     */

    /**
     * 付款金额
     */
    private Integer payAmount;

    /**
     * 支付类型
     */
    private String payType;

    /**
     * 用户标识
     */
    private String 	openid;

}
