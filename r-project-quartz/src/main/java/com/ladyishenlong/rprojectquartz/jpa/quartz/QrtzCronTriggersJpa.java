package com.ladyishenlong.rprojectquartz.jpa.quartz;

import com.ladyishenlong.rprojectquartz.model.quartz.Key;
import com.ladyishenlong.rprojectquartz.model.quartz.QrtzCronTriggersTable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author ruanchenhao
 * @Date 2019/9/12 4:25 下午
 */
public interface QrtzCronTriggersJpa extends JpaRepository<QrtzCronTriggersTable, Key> {
}
