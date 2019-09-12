package com.ladyishenlong.rprojectquartz.service;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ruanchenhao
 * @Date 2019/9/12 10:41 上午
 */
@Service
public class JobAndTriggerService {

    @Autowired
    private Scheduler scheduler;

    public void pauseJob(String jobClassName, String jobGroupName) throws SchedulerException {
        scheduler.pauseJob(JobKey.jobKey(jobClassName, jobGroupName));
    }

    public void resumeJob(String jobClassName, String jobGroupName) throws SchedulerException {
        scheduler.resumeJob(JobKey.jobKey(jobClassName, jobGroupName));
    }


}
