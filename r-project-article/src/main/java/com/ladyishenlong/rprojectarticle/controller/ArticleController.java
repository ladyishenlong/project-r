package com.ladyishenlong.rprojectarticle.controller;

import com.ladyishenlong.rprojectarticle.model.ArticleIndexModel;
import com.ladyishenlong.rprojectarticle.service.ArticleMapper;
import com.ladyishenlong.rprojectarticle.service.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author ruanchenhao
 * @Date 2019-05-22 10:04
 * <p>
 * mybatis 调用存储过程参考 https://blog.csdn.net/feng_tai_jun/article/details/80681224
 */
@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleRepository articleRepository;


    @PostMapping("/insert")
    public int insert(@RequestBody ArticleIndexModel model) {
        return articleMapper.insert(model.getId(), model.getUsername()
                , model.getTitle(), model.getAuthor());
    }


    /***
     * @return
     * jlcredit_jpa 分页查询
     */
    @GetMapping("/findArticleIndexByUsernameOnMongodb")
    public ResponseEntity findArticleIndexByUsernameOnMongodb(@RequestParam("page") int page,
                                                              @RequestParam("size") int size) {
        //Sort sort = new Sort(Sort.Direction.DESC, "id");//根据id排序
        log.info("----测试----");
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(articleRepository.findByUsername("123", pageable));
    }


    /***
     * 可以将 mongodb 作为缓存而存在
     * @param httpServletRequest
     * @return
     */
    @GetMapping("/findArticleIndexByUsername")
    public List<ArticleIndexModel> findArticleIndexByUsername(HttpServletRequest httpServletRequest) {
//        String username = httpServletRequest.getHeader("username");

        String username = "123";
        List<ArticleIndexModel> models = articleRepository.findAllByUsername(username);

        if (models == null || models.isEmpty()) {
            log.info("mongodb 没有数据 从数据库查询 ");
            models = articleMapper.findArticleIndexByUsername(username);

            if (models != null && !models.isEmpty()) {
                log.info("数据库中查询到了数据 保存到 mongodb 中");
                articleRepository.saveAll(models);
            }
        } else log.info("mongodb 获取了数据：{}", models.size());

        return models;
    }


}
