package com.ladyishenlong.rprojecthystrix.service;

import com.ladyishenlong.rprojecthystrix.impl.TestImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author ruanchenhao
 * @Date 2019-06-10 17:12
 */
@FeignClient(value = "r-project-test",fallback = TestImpl.class)
public interface TestService {

    @GetMapping("/test/hello")
     String hello();
}
