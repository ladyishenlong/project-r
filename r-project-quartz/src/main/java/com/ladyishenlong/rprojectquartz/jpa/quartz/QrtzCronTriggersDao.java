package com.ladyishenlong.rprojectquartz.jpa.quartz;

import com.ladyishenlong.rprojectquartz.model.primary.ArticleTable;
import com.ladyishenlong.rprojectquartz.model.quartz.QrtzCronTriggersTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019/9/16 2:02 下午
 */
@Service
public class QrtzCronTriggersDao {

    /**
     * 多数据源配置时候，指定数据源
     */
//    @PersistenceContext
    @Autowired
    @Qualifier("quartzEntityManagerFactory")
    private EntityManager entityManager;


    public Object test() {
        String sql = "select * from QRTZ_CRON_TRIGGERS";
        List<QrtzCronTriggersTable> articleIndexModels = entityManager
                .createNativeQuery(sql,QrtzCronTriggersTable.class)
                .getResultList();
        return articleIndexModels;
    }


}
