package com.ladyishenlong.rprojectquartz.model.quartz;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019/9/12 4:10 下午
 */
@Entity
@Data
@Table(name = "QRTZ_CRON_TRIGGERS")
@IdClass(Key.class)
public class QrtzCronTriggersTable implements Serializable {

    @Id
    @Column(name = "SCHED_NAME")
    private String schedName;
    @Id
    @Column(name = "TRIGGER_NAME")
    private String triggerName;
    @Id
    @Column(name = "TRIGGER_GROUP")
    private String triggerGroup;

    @Column(name = "TIME_ZONE_ID")
    private String timeZoneId;

}
