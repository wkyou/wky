package com.wang.dao.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author WangKanYou
 * @Date 2022/10/17 18:34
 * @描述:对账平台数据源
 */
@Configuration
@MapperScan(basePackages = {"com.wang.dao.mapper"}, sqlSessionFactoryRef = "wkyFactoryBean")
public class DataSourceWkyConfig {


    @Primary
    @Bean("wkyDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.wky")
    public DataSource dataSourceOne() {
        return new DruidDataSource();
    }


    @Primary
    @Bean("wkyFactoryBean")
    public MybatisSqlSessionFactoryBean factorOne(@Qualifier("wkyDataSource") DataSource dataSource){
        MybatisSqlSessionFactoryBean bean = new MybatisSqlSessionFactoryBean();
        bean.setTypeAliasesPackage("com.wang.dao.entity");
        bean.setDataSource(dataSource);
        bean.setMapperLocations(resolveMapperLocations());
        // 关键代码 设置 MyBatis-Plus 分页插件
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        Interceptor[] plugins = {paginationInterceptor};
        bean.setPlugins(plugins);
        return bean;
    }

    /**
     * 创建事务
     *@param dataSource
     *@return DataSourceTransactionManager
     */
    @Bean(name = "wkyTransactionManager")
    public DataSourceTransactionManager masterDataSourceTransactionManager(@Qualifier("wkyDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    public Resource[] resolveMapperLocations() {
        ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
        List<String> mapperLocations = new ArrayList<>();
        mapperLocations.add("classpath*:mapper/*.xml");
        List<Resource> resources = new ArrayList();
        if (mapperLocations != null) {
            for (String mapperLocation : mapperLocations) {
                try {
                    Resource[] mappers = resourceResolver.getResources(mapperLocation);
                    resources.addAll(Arrays.asList(mappers));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resources.toArray(new Resource[resources.size()]);
    }
}
