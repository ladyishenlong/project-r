package com.ladyishenlong.rprojectsqls.controller;

import com.ladyishenlong.rprojectsqls.jpa.jlcredit_jpa.ArticleIndexJpa;
import com.ladyishenlong.rprojectsqls.jpa.log_jpa.LogJpa;
import com.ladyishenlong.rprojectsqls.model.jlcredit_model.ArticleIndexModel;
import com.ladyishenlong.rprojectsqls.model.log_model.LogModel;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/getArticleIndexList")
    public List<ArticleIndexModel> getArticleIndexList() {
        return articleIndexJpa.findAllByUsername("123");
    }

    @GetMapping("/getLog")
    public List<LogModel> getLog() {
        return logJpa.findAll();
    }

}
