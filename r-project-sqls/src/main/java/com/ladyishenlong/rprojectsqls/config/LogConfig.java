package com.ladyishenlong.rprojectsqls.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @Author ruanchenhao
 * @Date 2019-05-31 16:27
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryLog",
        transactionManagerRef = "transactionManagerLog",
        basePackages = {"com.ladyishenlong.rprojectsqls.jpa.log_jpa"}) //设置Repository所在位置
public class LogConfig {

    @Autowired
    private JpaProperties jpaProperties;

    @Resource
    private HibernateProperties hibernateProperties;

    @Autowired
    @Qualifier("logDataSource")
    private DataSource logDataSource;

    @Bean(name = "entityManagerLog")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryLog(builder).getObject().createEntityManager();
    }

    @Bean(name = "entityManagerFactoryLog")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryLog(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(logDataSource)
                .properties(getVendorProperties())
                .packages("com.ladyishenlong.rprojectsqls.model.log_model") //设置实体类所在位置
                .persistenceUnit("logPersistenceUnit")
                .build();
    }


    private Map getVendorProperties() {
        return hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings());
    }

    @Bean(name = "transactionManagerLog")
    PlatformTransactionManager transactionManagerLog(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryLog(builder).getObject());
    }

}
