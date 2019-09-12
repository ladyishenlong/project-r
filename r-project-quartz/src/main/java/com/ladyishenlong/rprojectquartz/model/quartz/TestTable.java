package com.ladyishenlong.rprojectquartz.model.quartz;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019/9/12 4:30 下午
 */
@Entity
@Data
@Table(name = "TEST_TABLE")
public class TestTable implements Serializable {

    @Id
    private int id;
    private String name;
}
