package com.ladyishenlong.rprojectarticle.service;

import com.ladyishenlong.rprojectarticle.model.ArticleIndexModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019-05-22 10:10
 */
@Mapper
@Component
public interface ArticleMapper {


    @Select("select * from article_index where username= #{username} ")
    List<ArticleIndexModel> findArticleIndexByUsername(String username);

}
