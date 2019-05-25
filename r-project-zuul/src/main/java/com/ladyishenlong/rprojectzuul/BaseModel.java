package com.ladyishenlong.rprojectzuul;

import lombok.Data;
import org.springframework.data.domain.PageRequest;

import java.io.Serializable;

/**
 * @Author ruanchenhao
 * @Date 2019-05-25 20:06
 */
@Data
public class BaseModel<T> implements Serializable {

    private int code;
    private String message;

    private T data;

}
