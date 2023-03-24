package com.wang.web.service.transactionRollback;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author WangKanYou
 * @Date 2023/3/17 11:11
 * @描述:
 */
@Service
public class MainService {

    @Resource
    private SonService sonService;

    //@MainTransaction(3)//调用的方法中sonMethod1/sonMethod2/sonMethod3使用@Async开启了线程, 所以参数为: 3
    //@Transactional(rollbackFor = Exception.class)
    public void test1() {
        System.out.println("test1线程名称"+Thread.currentThread().getName());
        sonService.sonMethod1("路飞", Thread.currentThread());
        sonService.sonMethod2("索隆", "山治", Thread.currentThread());
        sonService.sonMethod3("娜美", Thread.currentThread());
        sonService.sonMethod4("罗宾");
    }
}
