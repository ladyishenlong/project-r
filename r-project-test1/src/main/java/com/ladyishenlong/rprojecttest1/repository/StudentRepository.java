package com.ladyishenlong.rprojecttest1.repository;

import com.ladyishenlong.rprojecttest1.model.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;


/**
 * @Author ruanchenhao
 * @Date 2019-05-17 15:56
 */
@Repository
public interface StudentRepository extends ElasticsearchCrudRepository<Student,String> {




}
