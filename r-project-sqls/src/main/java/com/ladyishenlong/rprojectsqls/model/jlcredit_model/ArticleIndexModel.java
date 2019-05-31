package com.ladyishenlong.rprojectsqls.model.jlcredit_model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019-05-22 10:07
 */
@Data
@Entity
@Table(name = "article_index")
public class ArticleIndexModel implements Serializable {

    @Id
    private String id;
    private String username;
    private String title;
    private String author;
}

