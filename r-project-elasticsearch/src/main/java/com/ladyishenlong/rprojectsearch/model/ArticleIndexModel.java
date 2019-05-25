package com.ladyishenlong.rprojectsearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019-05-22 10:07
 */

@Data
@Document(indexName = "article_index")
public class ArticleIndexModel implements Serializable {
    @Id
    private String id;
    private String username;
    private String title;
    private String author;
}
