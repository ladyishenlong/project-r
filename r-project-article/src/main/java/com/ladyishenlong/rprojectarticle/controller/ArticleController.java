package com.ladyishenlong.rprojectarticle.controller;

import com.ladyishenlong.rprojectarticle.model.ArticleIndexModel;
import com.ladyishenlong.rprojectarticle.service.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019-05-22 10:04
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleMapper articleMapper;

    @GetMapping("/findArticleIndexByUsername")
    public List<ArticleIndexModel> findArticleIndexByUsername(HttpServletRequest httpServletRequest) {
        String username = httpServletRequest.getHeader("username");
        return articleMapper.findArticleIndexByUsername(username);

    }


}
