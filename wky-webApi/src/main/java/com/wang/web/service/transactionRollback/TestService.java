package com.wang.web.service.transactionRollback;

import com.wang.dao.mapper.DbBookMapper;
import com.wang.dao.mapper.DbBorrowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author WangKanYou
 * @Date 2023/3/17 11:08
 * @描述:
 */
@Service
public class TestService {
    @Resource
    private DbBorrowMapper dbBorrowMapper;
    @Resource
    private DbBookMapper dbBookMapper;


}
