package com.ladyishenlong.rprojectsqls.jpa.jlcredit_jpa;

import com.ladyishenlong.rprojectsqls.model.jlcredit_model.ArticleIndexModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019-05-22 10:10
 */
@Repository
public interface ArticleIndexJpa extends JpaRepository<ArticleIndexModel,String> {


    List<ArticleIndexModel> findAllByUsername(String username);

}
