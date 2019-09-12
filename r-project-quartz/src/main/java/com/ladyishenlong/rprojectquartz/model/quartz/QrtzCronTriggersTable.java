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
public class QrtzCronTriggersTable implements Serializable {

    @EmbeddedId
    private Key id;

    @Column(name = "TIME_ZONE_ID")
    private String timeZoneId;

}
