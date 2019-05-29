package com.ladyishenlong.rprojectjava.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author ruanchenhao
 * @Date 2019-05-28 17:11
 * springboot 使用线程
 *
 * 通过@Async注解表明该方法是一个异步方法，
 * 如果注解在类级别，表明该类下所有方法都是异步方法，
 * 而这里的方法自动被注入使用ThreadPoolTaskExecutor 作为 TaskExecutor
 *
 */
@Slf4j
@Service
public class AsyncTaskService {


    @Async
    public void executeAsyncTask(Integer i) {
        log.info("执行异步任务：" + i);
    }

    @Async
    public void executeAsyncTaskPlus(Integer i) {
        log.info("执行异步任务+1：" + (i + 1));
    }


}
