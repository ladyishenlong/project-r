package com.ladyishenlong.rprojectquartz.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.quartz.QuartzDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author ruanchenhao
 * @Date 2019/9/12 3:27 下午
 */
@Configuration
public class DataSourceConfig {

    @Primary //主数据库
    @Bean(name = "primarySource")//将该对象放入spring容器
    @Qualifier("primarySource")//寻找spring容器该名字的对象
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primarySource() {
        return DataSourceBuilder.create().build();
    }


    @QuartzDataSource
    @Bean(name = "quartzSource")
    @Qualifier("quartzSource")
    @ConfigurationProperties(prefix = "spring.datasource.quartz")
    public DataSource quartzSource() {
        return DataSourceBuilder.create().build();
    }


}
