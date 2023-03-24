package com.wang.web.service.seckill;

import com.wang.dao.entity.TOrder;
import com.wang.dao.mapper.TOrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author WangKanYou
 * @Date 2023/3/20 9:37
 * @描述:
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private TOrderMapper tOrderMapper;
    @Override
    public int saveOrder(TOrder order) {
        int insert = tOrderMapper.insert(order);
        return insert;
    }
}
