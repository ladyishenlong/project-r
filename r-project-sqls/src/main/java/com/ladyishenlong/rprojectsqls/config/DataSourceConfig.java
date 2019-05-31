package com.ladyishenlong.rprojectsqls.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @Author ruanchenhao
 * @Date 2019-05-24 14:59
 * <p>
 * 多数据库数据源的配置
 */
@Configuration
public class DataSourceConfig {

    @Primary //主数据库
    @Bean(name = "jlCreditDataSource")//将该对象放入spring容器
    @Qualifier("jlCreditDataSource")//寻找spring容器该名字的对象
    @ConfigurationProperties(prefix = "spring.datasource.jlcredit")
    public DataSource JLCreditDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "logDataSource")
    @Qualifier("logDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.log")
    public DataSource logDataSource() {
        return DataSourceBuilder.create().build();
    }


//    @Bean(name = "shopDataSource")
//    @Qualifier("shopDataSource")
//    @ConfigurationProperties(prefix = "spring.shop.datasource")
//    public DataSource shopDataSource() {
//        return DataSourceBuilder.create().build();
//    }

}
