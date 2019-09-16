package com.ladyishenlong.rprojectquartz.jpa.primary;

import com.ladyishenlong.rprojectquartz.model.primary.ArticleTable;
import org.hibernate.query.Query;
import org.hibernate.sql.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/9/16 1:57 下午
 */
@Service
public class ArticleDao {

    /**
     * 多数据源配置时候，指定数据源
     */
//    @PersistenceContext //无多数据源时候
    @Autowired
    @Qualifier("primaryEntityManagerFactory")
    private EntityManager entityManager;


    public Object test() {
        String sql = "select * from article";

        List<ArticleTable> articleIndexModels = entityManager

                //将查询结果赋值给实体类
                .createNativeQuery(sql, ArticleTable.class)
                .getResultList();

        return articleIndexModels;
    }


    /**
     * 改动数据库操作必须放在事务之中
     * 增删改 操作相似
     * @return
     */
    @Transactional
    public Object test2() {
        String sql = "insert into article(id, content) values ('12334','搞事情')";
        entityManager
                .createNativeQuery(sql)
                .executeUpdate();
        return "执行成功";
    }


}
