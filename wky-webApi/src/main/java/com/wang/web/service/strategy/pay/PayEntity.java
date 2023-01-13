package com.wang.web.service.strategy.pay;

import lombok.Data;

/**
 * @Author WangKanYou
 * @Date 2023/1/12 11:34
 * @描述: 支付测试实体
 */
@Data
public class PayEntity {
    private Integer payAmount;
    private String payType;
}
