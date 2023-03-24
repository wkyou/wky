package com.wang.webservice;

import com.wang.webservice.service.impl.HelloServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.Endpoint;

/**
 * @Author WangKanYou
 * @Date 2023/3/15 11:54
 * @描述:
 */
@SpringBootTest
public class Service {
    @Test
    public  void test(){
        Endpoint.publish("http://127.0.0.1:8080/helloWord",
                new HelloServiceImpl());
        System.out.println("发布服务成功，端口8010！！！！");
    }
}
