package com.ladyishenlong.rprojectquartz.config;


import com.ladyishenlong.rprojectquartz.jobs.MyJob;
import com.ladyishenlong.rprojectquartz.jobs.MyJob2;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author ruanchenhao
 * @Date 2019/9/11 4:37 下午
 */
@Configuration
public class QuartzTaskConfig {

    @Bean
    public JobDetail uploadTaskDetail() {
        return JobBuilder
                .newJob(MyJob.class).withIdentity("MyJob","Jobs")
                .storeDurably()
                .build();
    }


    //指定具体的定时任务类
    @Bean
    public JobDetail uploadTaskDetail2() {
        return JobBuilder
                .newJob(MyJob2.class).withIdentity("MyJob2","Jobs")
                .storeDurably()
                .build();
    }


    @Bean
    public Trigger uploadTaskTrigger() {
        //每隔5秒执行一次
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                .cronSchedule("*/5 * * * * ?");
        // 返回任务触发器
        return TriggerBuilder
                .newTrigger()
                .forJob(uploadTaskDetail())
                .withIdentity("MyJob")
                .withSchedule(scheduleBuilder)
                .build();
    }


    @Bean
    public Trigger uploadTaskTrigger2() {
        //每隔5秒执行一次
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                .cronSchedule("*/5 * * * * ?");
        // 返回任务触发器
        return TriggerBuilder
                .newTrigger()
                .forJob(uploadTaskDetail2())
                .withIdentity("MyJob2")
                .withSchedule(scheduleBuilder)
                .build();
    }


}
