package com.ladyishenlong.rprojectquartz.jobs;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Author ruanchenhao
 * @Date 2019/9/11 4:45 下午
 */

@Slf4j
public class MyJob2 extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("---- 这里是执行定时任务的逻辑2 ----");
    }
}
