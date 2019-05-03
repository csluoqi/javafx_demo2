package com.yh.quartz.scheduler;

import com.yh.quartz.job.JobDemo;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author lq
 * 创建时间 2019/4/18 16:12
 **/
public class HelloJobSchedulerDemo {
    public static void main(String[] args) throws SchedulerException {
        //scheduler
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();

        //job
        JobDetail jobDetail = JobBuilder.newJob(JobDemo.class)
                .withIdentity("job1", "job1Group")
                .build();

        //trigger
        //
        Trigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("Trigger1", "triggergroup1")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * * * ?"))
                .build();

        defaultScheduler.scheduleJob(jobDetail,cronTrigger);

        defaultScheduler.start();
    }
}
