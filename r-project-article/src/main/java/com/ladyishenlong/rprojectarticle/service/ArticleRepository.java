package com.ladyishenlong.rprojectarticle.service;

import com.ladyishenlong.rprojectarticle.model.ArticleIndexModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019-05-22 14:48
 */
@Service
public interface ArticleRepository extends MongoRepository<ArticleIndexModel,String> {


     List<ArticleIndexModel> findAllByUsername(String username);



}
