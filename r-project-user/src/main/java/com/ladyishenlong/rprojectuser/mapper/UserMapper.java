package com.ladyishenlong.rprojectuser.mapper;

import com.ladyishenlong.rprojectuser.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Author ruanchenhao
 * @Date 2019-05-20 10:00
 * mybatis 查询数据库
 */
@Component
@Mapper
public interface UserMapper {


    @Select("select * from user where username = #{username} ")
    UserModel findByUsername(String username);

}
