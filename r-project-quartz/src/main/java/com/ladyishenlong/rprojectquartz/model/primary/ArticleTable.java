package com.ladyishenlong.rprojectquartz.model.primary;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019/9/12 4:05 下午
 */
@Entity
@Data
@Table(name = "article")
public class ArticleTable implements Serializable {
    @Id
    private String id;
    private String content;

}
