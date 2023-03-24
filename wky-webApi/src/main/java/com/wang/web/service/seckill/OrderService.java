package com.wang.web.service.seckill;

import com.wang.dao.entity.TOrder;

/**
 * @Author WangKanYou
 * @Date 2023/3/20 9:32
 * @描述:
 */
public interface OrderService {

    /**
     * 订单保存
     * @param order 实体
     */
    int saveOrder(TOrder order);
}
