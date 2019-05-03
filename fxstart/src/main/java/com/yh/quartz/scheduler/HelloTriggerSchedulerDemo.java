package com.yh.quartz.scheduler;

import com.yh.quartz.job.HelloTriggerJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lq
 * 创建时间 2019/4/17 17:15
 **/
public class HelloTriggerSchedulerDemo {
    public static void main(String[] args) throws SchedulerException {
        //scheduler
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        //job
        JobDetail jobDetail = JobBuilder.newJob(HelloTriggerJob.class)
                .withIdentity("job","jobGroup").usingJobData("count", 0).build();
        //trigger

        Date date = new Date(System.currentTimeMillis());
        System.out.println("date-------"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        Date startDate = new Date(date.getTime()+3000);
        Date endDate   = new Date(date.getTime() + 10000);

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger", "triggerGroup")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(4).repeatForever())//调度间隔
                .startAt(startDate)//调度开始时间
                .endAt(endDate)//调度结束时间
                .build();
        //scheduler.scheduleJob(jobDetail,trigger);

        //SimpleTrigger中 在指定的时间触发一次调度
        Trigger trigger1 = TriggerBuilder.newTrigger()
                .withIdentity("trigger", "triggerGroup")
                .startAt(startDate)//调度开始时间
                //.endAt(endDate)//调度结束时间
                .build();
        //scheduler.scheduleJob(jobDetail,trigger1);

        //SimpleTrigger中，指定时间间隔内触发指定次数的调度
        Trigger trigger2 = TriggerBuilder.newTrigger()
                .withIdentity("trigger", "triggerGroup")
                //每5秒执行一次，执行三次
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5)
                        .withRepeatCount(-1)//默认值是0表示执行一次，-1表示无限次执行
                )
                //.startAt(startDate)//调度开始时间
                //.endAt(endDate)//调度结束时间
                .build();
       // scheduler.scheduleJob(jobDetail,trigger2);

        //SimpleTrigger中当结束时间和重复次数并存时，withrepeateCount无效
        Trigger trigger3 = TriggerBuilder.newTrigger()
                .withIdentity("trigger", "triggerGroup")
                //每5秒执行一次，执行三次
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5)
                        .withRepeatCount(-1)//默认值是0表示执行一次，-1表示无限次执行
                )
                .startAt(startDate)//调度开始时间
                .endAt(endDate)//调度结束时间，当结束时间和重复次数并存时，withrepeateCount无效。
                .build();
       // scheduler.scheduleJob(jobDetail,trigger3);

        //CronTrigger

        Trigger trigger4= TriggerBuilder.newTrigger()
                .withIdentity("trigger", "triggerGroup")
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ?")
                        .withMisfireHandlingInstructionDoNothing()//每秒钟都执行一次
                )
                //.startAt(startDate)//调度开始时间
                //.endAt(endDate)//调度结束时间
                .build();
        scheduler.scheduleJob(jobDetail,trigger4);

        scheduler.start();

    }
}
