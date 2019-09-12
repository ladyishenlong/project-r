package com.ladyishenlong.rprojectquartz.controller;

import com.ladyishenlong.rprojectquartz.service.JobAndTriggerService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ruanchenhao
 * @Date 2019/9/12 10:09 上午
 */
@Slf4j
@RestController
@RequestMapping("/job")
public class QuartzController {

    @Autowired
    private JobAndTriggerService jobAndTriggerService;

    /**
     * 暂停定时任务
     *
     * @param jobClassName
     * @param jobGroupName
     * @throws SchedulerException
     */
    @GetMapping("/pause")
    public void pauseJob(@RequestParam("jobClassName") String jobClassName,
                         @RequestParam("jobGroupName") String jobGroupName)
            throws SchedulerException {
        jobAndTriggerService.pauseJob(jobClassName, jobGroupName);
    }

    /**
     * 重启定时任务
     *
     * @param jobClassName
     * @param jobGroupName
     * @throws SchedulerException
     */
    @GetMapping("/resume")
    public void resumeJob(@RequestParam("jobClassName") String jobClassName,
                          @RequestParam("jobGroupName") String jobGroupName)
            throws SchedulerException {
        jobAndTriggerService.resumeJob(jobClassName, jobGroupName);
    }

}
