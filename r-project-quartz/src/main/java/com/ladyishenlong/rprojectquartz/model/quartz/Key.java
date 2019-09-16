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
public class Key implements Serializable {

    private String schedName;
    private String triggerName;
    private String triggerGroup;

}
