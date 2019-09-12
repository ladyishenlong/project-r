package com.ladyishenlong.rprojectquartz.jpa.primary;

import com.ladyishenlong.rprojectquartz.model.primary.ArticleTable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author ruanchenhao
 * @Date 2019/9/12 4:06 下午
 */
public interface ArticleJpa extends JpaRepository<ArticleTable,String> {
}
