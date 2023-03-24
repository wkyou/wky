package com.wang.webservice.service.impl;

import com.wang.webservice.service.HelloService;
import org.springframework.stereotype.Controller;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @Author WangKanYou
 * @Date 2023/3/15 11:47
 * @描述:
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return null; //支付
    }
}
