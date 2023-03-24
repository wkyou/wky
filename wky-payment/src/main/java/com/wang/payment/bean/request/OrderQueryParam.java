package com.wang.payment.bean.request;

import lombok.Data;

/**
 * @Author WangKanYou
 * @Date 2023/3/16 17:34
 * @描述:
 */
@Data
public class OrderQueryParam {
    /**
     * 支付类型
     */
    private String payType;
}
