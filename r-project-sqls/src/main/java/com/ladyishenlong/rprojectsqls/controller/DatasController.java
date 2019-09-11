package com.ladyishenlong.rprojectsqls.controller;

import com.ladyishenlong.rprojectsqls.jpa.jlcredit_jpa.ArticleIndexJpa;
import com.ladyishenlong.rprojectsqls.jpa.jlcredit_jpa.ArticleIndexJpaImpl;
import com.ladyishenlong.rprojectsqls.jpa.log_jpa.LogJpa;
import com.ladyishenlong.rprojectsqls.jpa.log_jpa.LogJpaImpl;
import com.ladyishenlong.rprojectsqls.model.jlcredit_model.ArticleIndexModel;
import com.ladyishenlong.rprojectsqls.model.log_model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019-05-31 14:44
 */
@ResponseBody
@RestController
public class DatasController {

    @Autowired
    private ArticleIndexJpa articleIndexJpa;

    @Autowired
    private LogJpa logJpa;

    @Autowired
    private LogJpaImpl logjpaImpl;

    @Autowired
    private ArticleIndexJpaImpl  articleIndexJpaImpl;

    @GetMapping("/getArticleIndexList")
    public Object getArticleIndexList() {
        return articleIndexJpaImpl.test();
//        return articleIndexJpa.findAllByUsername("123");
    }

    @GetMapping("/getLog")
    public Object getLog() {
        return logjpaImpl.queryTest("1");
//        return logJpa.findAll();
    }



}
