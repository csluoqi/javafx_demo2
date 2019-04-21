package com.yh.scheduler;

import com.yh.job.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author lq
 * 创建时间 2019/4/17 0:03
 **/
public class HelloSchedulerDemo {

    public static void main(String[] args) throws SchedulerException {
        //JOb
        JobDataMap jobDataMap1 = new JobDataMap();
        jobDataMap1.put("jobName","数据同步！");
        jobDataMap1.put("myMsg1","喝水");
        jobDataMap1.put("myMsg2","喝水时间"+System.currentTimeMillis());
        JobDataMap jobDataMap2 = new JobDataMap();
        jobDataMap2.put("triggerName","数据同步触发器！");
//        jobDataMap2.put("myMsg1","吃饭");
//        jobDataMap2.put("myMsg2","吃菜");
        JobDetail detail = JobBuilder.newJob(HelloJob.class).withIdentity("hello1", "group1")
                .usingJobData("jobdetail_job_data","Job传参！！！")
                .usingJobData(jobDataMap1)
                .build();

        System.out.println("任务名： "+detail.getKey().getName());
        System.out.println("任务类名： "+detail.getJobClass().getName());
        System.out.println("组名称： "+detail.getKey().getGroup());//默认为DEFAULT
        //Trigger
        SimpleTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
                .usingJobData("trigger_job_data","触发器传参---触发！！")
                .usingJobData(jobDataMap2)
                .build();
        //Scheduler

        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();

        //调度关联任务和触发器
        defaultScheduler.scheduleJob(detail,trigger);
        defaultScheduler.start();
    }
}
