package com.wang.web.controller;

import com.baomidou.mybatisplus.generator.config.IFileCreate;
import com.wang.web.service.ConcurrencyTestService;
import com.wang.web.service.transactionRollback.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author WangKanYou
 * @Date 2023/3/6 9:50
 * @描述:
 */
@RestController
@RequestMapping(value = "/test")
@Slf4j
public class TestController {
    private Integer i=20;

    @Autowired
    private ConcurrencyTestService concurrencyTestService;
    @Autowired
    private MainService mainService;
    @GetMapping("/log")
    public String testLog(){
        log.trace("这是trace日志");
        log.debug("这是debug日志");
        log.info("这是info日志");
        log.warn("这是warn日志");
        log.error("这是error日志");
        return "成功";
    }
    @GetMapping("/yaLi")
    public String testYaLi(){

        return concurrencyTestService.borrowBook(1,1);
    }

    @GetMapping("/Xc")
    public String testXc(){

        mainService.test1();
        return "";
    }
}
