package com.ladyishenlong.rprojectsearch.controller;

import com.ladyishenlong.rprojectsearch.model.ArticleIndexModel;
import com.ladyishenlong.rprojectsearch.repository.ArticleIndexEs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019-05-24 09:08
 *
 * 对外仅提供查询的接口
 * 增删改 仅仅通过队列从其他服务进行操作
 *
 */
@RestController
@RequestMapping("/search")
public class SearchController {


    @Autowired
    private ArticleIndexEs articleIndexEs;

    /**
     * 获取 Elasticsearch 之中所有的信息
     * @return
     */
    @GetMapping("/findAll")
    public Iterable<ArticleIndexModel> findAll(){
        return articleIndexEs.findAll();
    }











}
