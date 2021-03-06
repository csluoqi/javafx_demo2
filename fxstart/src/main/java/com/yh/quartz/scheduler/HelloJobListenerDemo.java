package com.yh.quartz.scheduler;

import com.yh.quartz.job.JobDemo;
import com.yh.quartz.listener.MyJobListener;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;

/**
 * @author lq
 * 创建时间 2019/4/18 16:12
 **/
public class HelloJobListenerDemo  {
    public static void main(String[] args) throws SchedulerException {
        //scheduler
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();

        //job
        JobDetail jobDetail = JobBuilder.newJob(JobDemo.class)
                .withIdentity("job1", "job1Group")
                .build();

        //trigger
        //
        Trigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("Trigger1", "triggergroup1")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * * * ?"))
                .build();

        defaultScheduler.scheduleJob(jobDetail,cronTrigger);
        //全局监听器
       // defaultScheduler.getListenerManager().addJobListener(new MyJobListener("12323"),EverythingMatcher.allJobs());
        //局部监听器
        defaultScheduler.getListenerManager()
                .addJobListener(new MyJobListener("123456765432"),
                        KeyMatcher.keyEquals(JobKey.jobKey("job2", "job1Group")));
        defaultScheduler.start();
    }
}
