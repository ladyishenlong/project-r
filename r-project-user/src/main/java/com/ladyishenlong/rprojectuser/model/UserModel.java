package com.ladyishenlong.rprojectuser.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019-05-16 11:32
 */
@Data
public class UserModel implements Serializable {

    private String username;
    private String password;
    private String roles;

}
