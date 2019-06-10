package com.ladyishenlong.rprojecthystrix.impl;

import com.ladyishenlong.rprojecthystrix.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @Author ruanchenhao
 * @Date 2019-06-10 17:15
 * <p>
 * 熔断情况下，返回
 */
@Service
public class TestImpl implements TestService {


    @Override
    public String hello() {
        return "调用失败";
    }

}
