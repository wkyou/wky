package com.wang.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wang.dao.entity.DbBook;
import com.wang.dao.entity.DbBorrow;
import com.wang.dao.mapper.DbBookMapper;
import com.wang.dao.mapper.DbBorrowMapper;
import com.wang.web.service.ConcurrencyTestService;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author WangKanYou
 * @Date 2023/3/9 14:11
 * @描述:
 */
@Service
@Slf4j
public class ConcurrencyTestServiceImpl implements ConcurrencyTestService {
    @Resource
    private DbBorrowMapper dbBorrowMapper;
    @Resource
    private DbBookMapper dbBookMapper;
    @Override
    public String borrowBook(int uid, int bid) {
        DbBook book = dbBookMapper.selectOne(new QueryWrapper<DbBook>().eq("bid", bid));
        Integer count = book.getCount();
        if (count != 0) {
            DbBorrow dbBorrow = new DbBorrow();
            dbBorrow.setBid(bid);
            dbBorrow.setUid(uid);
            int insert = dbBorrowMapper.insert(dbBorrow);
            if (insert>0){
                book.setCount(count-1);
                dbBookMapper.update(book,new QueryWrapper<DbBook>().eq("bid",bid));
                log.info("语文书本剩余的数量："+count);
            }
        }
        return null;
    }
}
