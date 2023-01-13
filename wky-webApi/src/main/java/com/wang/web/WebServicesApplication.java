package com.wang.web;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @Author WangKanYou
 * @Date 2022/7/15 23:45
 * @描述:
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MybatisAutoConfiguration.class})
public class WebServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebServicesApplication.class,args);
    }
}
