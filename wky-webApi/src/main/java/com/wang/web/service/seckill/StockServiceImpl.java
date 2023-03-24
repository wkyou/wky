package com.wang.web.service.seckill;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wang.dao.entity.Stock;
import com.wang.dao.mapper.StockMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author WangKanYou
 * @Date 2023/3/20 9:37
 * @描述:
 */
@Service
public class StockServiceImpl implements StockService{
    @Resource
    private StockMapper stockMapper;
    @Override
    public int decrByStock(String name) {
        Stock stock = stockMapper.selectOne(new QueryWrapper<Stock>().eq("name", name));
        stock.setStock(stock.getStock()-1);
        int i = stockMapper.updateById(stock);
        if( i<= 0){
            throw new RuntimeException("减少库存失败");
        }
        return i;
    }

    @Override
    public List<Stock> selectList() {
        return stockMapper.selectList(new QueryWrapper<>());
    }
}
