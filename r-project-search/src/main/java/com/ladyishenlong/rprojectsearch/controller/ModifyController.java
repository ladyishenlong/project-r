package com.ladyishenlong.rprojectsearch.controller;

import com.ladyishenlong.rprojectsearch.model.ArticleIndexModel;
import com.ladyishenlong.rprojectsearch.repository.ArticleIndexEs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019-05-24 09:55
 */
@RestController
@RequestMapping("/modify")
public class ModifyController {



    @Autowired
    private ArticleIndexEs articleIndexEs;


    @GetMapping("/importAll")
    public int importAll() {
        return 0;
    }


}
