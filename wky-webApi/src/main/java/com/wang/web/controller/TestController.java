package com.wang.web.controller;

import lombok.extern.slf4j.Slf4j;
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
    @GetMapping("/log")
    public String testLog(){
        log.trace("这是trace日志");
        log.debug("这是debug日志");
        log.info("这是info日志");
        log.warn("这是warn日志");
        log.error("这是error日志");
        return "成功";
    }
}
