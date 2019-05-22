package com.ladyishenlong.rprojectarticle.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019-05-22 10:07
 */

@Data
public class ArticleIndexModel implements Serializable {
    @Id
    private String id;
    private String username;
    private String title;
    private String author;
}
