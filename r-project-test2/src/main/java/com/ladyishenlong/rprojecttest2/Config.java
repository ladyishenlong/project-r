package com.ladyishenlong.rprojecttest2;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Author ruanchenhao
 * @Date 2019-06-03 17:06
 */
@Data
@RefreshScope //自动刷新配置文件,放在controller里面会有bug
@Component
public class Config {
    //这个值是从git的配置文件获得的参数
    @Value("${testConfig}")
    private String testConfig;
}
