package com.wang.web.service.impl;

import com.wang.web.annotation.AvoidRepeatSubmit;
import com.wang.web.service.AvoidRepeatSubmitService;
import org.springframework.stereotype.Service;

/**
 * @Author WangKanYou
 * @Date 2022/8/17 14:19
 * @描述:
 */
@Service
public class AvoidRepeatSubmitServiceImpl implements AvoidRepeatSubmitService {
    @AvoidRepeatSubmit
    @Override
    public String test(int age,String name) {
        System.out.println("姓名："+name+"----年龄："+age);
        System.out.println("AvoidRepeatSubmitServiceImpl.test()");
        return "我是test(s)";
    }
}
