package com.wang.web.controller;
import com.wang.web.annotation.AvoidRepeatSubmit;
import com.wang.web.service.AvoidRepeatSubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author WangKanYou
 * @Date 2022/8/17 11:06
 * @描述:防止接口重复请求
 */
@RestController
public class AvoidRepeatSubmitController {
    @Autowired
    private AvoidRepeatSubmitService avoidRepeatSubmitService;
    @GetMapping("/test")
    @AvoidRepeatSubmit(expire = 10)
    public String test(){
        System.out.println("test");
        String test = avoidRepeatSubmitService.test(1,"s");
        return test;
    }
}
