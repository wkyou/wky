package com.wang.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author WangKanYou
 * @Date 2022/7/25 17:32
 * @描述:
 */
@Configuration
@ComponentScan("com.wang.dao.config") // 1. 多模块项目需要扫描的包
public class DaoBean {
}
