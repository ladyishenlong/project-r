package com.ladyishenlong.rprojectsqls.model.log_model;

import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019-05-31 16:29
 */
@Data
@Entity
@Table(name = "log_record")
public class LogModel implements Serializable {
    @Id
    private int id;
    private int code;
    private String message;
}
