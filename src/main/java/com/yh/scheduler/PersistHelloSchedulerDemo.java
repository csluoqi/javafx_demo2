package com.yh.scheduler;

import com.yh.job.PersistHelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author lq
 * 创建时间 2019/4/17 16:55
 **/
public class PersistHelloSchedulerDemo {
    public static void main(String[] args) throws SchedulerException {
        //scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //job
        JobDetail jobDetail = JobBuilder.newJob(PersistHelloJob.class).usingJobData("count", 0)
                .build();
        //trigger
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger", "triggerGroup")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever())
                .build();

        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();

    }
}
