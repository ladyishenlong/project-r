package com.ladyishenlong.rprojectsqls.jpa.jlcredit_jpa;

import com.ladyishenlong.rprojectsqls.model.jlcredit_model.ArticleIndexModel;
import com.ladyishenlong.rprojectsqls.model.log_model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/9/11 2:03 下午
 */
@Service
public class ArticleIndexJpaImpl {

    /**
     * 多数据源配置时候，指定数据源
     */
//    @PersistenceContext
    @Autowired
    @Qualifier("entityManagerFactoryJlCredit")
    private EntityManager entityManager;


    public Object test() {
        String sql = "select * from article_index where username=123";
        List<ArticleIndexModel> articleIndexModels = entityManager
                .createNativeQuery(sql)
                .getResultList();
        return articleIndexModels;
    }



}
