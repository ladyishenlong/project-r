package com.ladyishenlong.rprojectquartz.model.quartz;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019/9/12 4:22 下午
 */
@Data
@Embeddable
public class Key implements Serializable {

    @Column(name = "SCHED_NAME")
    private String schedName;
    @Column(name = "TRIGGER_NAME")
    private String triggerName;
    @Column(name = "TRIGGER_GROUP")
    private String triggerGroup;

}
