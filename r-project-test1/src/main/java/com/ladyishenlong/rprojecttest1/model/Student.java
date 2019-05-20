package com.ladyishenlong.rprojecttest1.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019-05-17 15:52
 */
@Data
@Document(indexName = "student")
public class Student implements Serializable {
    @Id
    private String id;
    private String name;

}
