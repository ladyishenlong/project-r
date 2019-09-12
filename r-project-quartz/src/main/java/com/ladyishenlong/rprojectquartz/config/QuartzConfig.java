package com.ladyishenlong.rprojectquartz.config;

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
import java.util.Objects;

/**
 * @Author ruanchenhao
 * @Date 2019/9/12 3:47 下午
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "quartzEntityManagerFactory",
        transactionManagerRef = "quartzTransactionManager",
        basePackages = {"com.ladyishenlong.rprojectquartz.jpa.quartz"}) //设置Repository所在位置
public class QuartzConfig {
    
        @Autowired
        private JpaProperties jpaProperties;

        @Resource
        private HibernateProperties hibernateProperties;

        @Autowired
        @Qualifier("quartzSource")
        private DataSource quartzDataSource;

        @Bean(name = "quartzEntityManager")
        public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
            return Objects.requireNonNull(quartzEntityManagerFactory(builder).getObject()).createEntityManager();
        }

        @Bean(name = "quartzEntityManagerFactory")
        public LocalContainerEntityManagerFactoryBean quartzEntityManagerFactory(EntityManagerFactoryBuilder builder) {
            return builder
                    .dataSource(quartzDataSource)
                    .properties(hibernateProperties.determineHibernateProperties(
                            jpaProperties.getProperties(), new HibernateSettings()))
                    .packages("com.ladyishenlong.rprojectquartz.model.quartz") //设置实体类所在位置
                    .persistenceUnit("quartzPersistenceUnit")
                    .build();
        }


        
        @Bean(name = "quartzTransactionManager")
        public PlatformTransactionManager quartzTransactionManager(EntityManagerFactoryBuilder builder) {
            return new JpaTransactionManager(quartzEntityManagerFactory(builder).getObject());
        }


}
