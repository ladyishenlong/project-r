package com.ladyishenlong.rprojectarticle.service;

import com.ladyishenlong.rprojectarticle.model.ArticleIndexModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * @Author ruanchenhao
 * @Date 2019-05-22 10:10
 * <p>
 * 数据库查询 mybatis
 */
@Mapper
@Component
public interface ArticleMapper {


    @Select("select * from article_index where username= #{username} ")
    List<ArticleIndexModel> findArticleIndexByUsername(String username);



    // 如果不存在就插入，如果存在就更新
    @Insert("insert into article_index(id, username, title, author)" +
            "values (#{id}, #{username}, #{title}, #{author})" +
            "on duplicate key update id= #{id},username=#{username}," +
            "title=#{title},author=#{author}")
    int insert(String id, String username, String title, String author);

    /**
     * 批量插入
     * @param students
     * @return
     */
    @InsertProvider(type = Provider.class, method = "batchInsert")
    int batchInsert(List<ArticleIndexModel> students);


    class Provider{
        /* 批量插入 */
        public String batchInsert(Map map) {
            List<ArticleIndexModel> indexModelList = (List<ArticleIndexModel>) map.get("list");
            StringBuilder sb = new StringBuilder();

            sb.append("INSERT INTO article_index (id, username, title, author) VALUES ");
            MessageFormat mf = new MessageFormat(
                    "(#'{'list[{0}].id}, #'{'list[{0}].username}, " +
                            "#'{'list[{0}].title}), #'{'list[{0}].author})"
            );

            for (int i = 0; i < indexModelList.size(); i++) {
                sb.append(mf.format(new Object[] {i}));
                if (i < indexModelList.size() - 1)
                    sb.append(",");
            }
            return sb.toString();
        }

    }


}
