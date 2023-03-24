package com.wang.web.service.seckill;

import com.wang.dao.entity.Stock;

import java.util.List;

/**
 * @Author WangKanYou
 * @Date 2023/3/20 9:31
 * @描述:
 */
public interface StockService {

    /**
     * 秒杀商品后-减少库存
     * @param name 商品名称
     */
    int decrByStock(String name);


    /**
     * 秒杀商品列表
     * @return List<Stock>
     */
    List<Stock> selectList();
}
