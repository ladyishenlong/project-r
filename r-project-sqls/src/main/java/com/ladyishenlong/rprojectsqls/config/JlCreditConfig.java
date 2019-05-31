package com.ladyishenlong.rprojectsqls.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
 * @Date 2019-05-31 14:51
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryJlCredit",
        transactionManagerRef = "transactionManagerJlCredit",
        basePackages = {"com.ladyishenlong.rprojectsqls.jpa.jlcredit_jpa"}) //设置Repository所在位置
public class JlCreditConfig {

    @Autowired
    private JpaProperties jpaProperties;

    @Resource
    private HibernateProperties hibernateProperties;

    @Autowired
    @Qualifier("jlCreditDataSource")
    private DataSource jlCreditDataSource;

    @Primary
    @Bean(name = "entityManagerJlCredit")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryJlCredit(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactoryJlCredit")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryJlCredit(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(jlCreditDataSource)
                .properties(getVendorProperties())
                .packages("com.ladyishenlong.rprojectsqls.model.jlcredit_model") //设置实体类所在位置
                .persistenceUnit("jlcreditPersistenceUnit")
                .build();
    }

    private Map getVendorProperties() {
        return hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings());
    }

    @Primary
    @Bean(name = "transactionManagerJlCredit")
    public PlatformTransactionManager transactionManagerJlCredit(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryJlCredit(builder).getObject());
    }


}
