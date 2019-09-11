package com.ladyishenlong.rprojectsqls.jpa.log_jpa;

import com.ladyishenlong.rprojectsqls.model.log_model.LogModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/9/11 1:25 下午
 */
@Slf4j
@Service
public class LogJpaImpl  {


    @Autowired
    @Qualifier("entityManagerFactoryLog")
    private EntityManager entityManager;


    public Object queryTest(String id) {
        String sql="select * from log_record where id = "+id;
        List<LogModel> logModels = entityManager
                .createNativeQuery(sql)
                .getResultList();
        return logModels;
    }


}
