package com.ladyishenlong.rprojectsearch.repository;

import com.ladyishenlong.rprojectsearch.model.ArticleIndexModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author ruanchenhao
 * @Date 2019-05-24 09:25
 */
@Repository
public interface ArticleIndexEs extends ElasticsearchCrudRepository<ArticleIndexModel,String> {



    Iterable<ArticleIndexModel> findAllByUsername(String username);


}
