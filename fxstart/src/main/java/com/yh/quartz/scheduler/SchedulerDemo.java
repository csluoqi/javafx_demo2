package com.yh.quartz.scheduler;

import com.yh.quartz.Constant;
import com.yh.quartz.job.JobDemo;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author lq
 * 创建时间 2019/4/18 15:10
 **/
public class SchedulerDemo {
    public static void main(String[] args) throws SchedulerException {
        //scheduler
        Scheduler scheduler1 = StdSchedulerFactory.getDefaultScheduler();

        //获取scheduler的第二种方式
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler2 = stdSchedulerFactory.getScheduler();


        JobDetail jobDetail1 = JobBuilder.newJob(JobDemo.class)
                .withIdentity("job1", "jobGroup")
                .build();

        Trigger trigger4 = TriggerBuilder.newTrigger()
                .withIdentity("trigger", "triggerGroup")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/2 * * * * ?")//每秒钟都执行一次
                )
                //.startAt(startDate)//调度开始时间
                //.endAt(endDate)//调度结束时间
                .build();

        //功能1.打印调度执行是时间
        Date scheduler2date = scheduler2.scheduleJob(jobDetail1, trigger4);
        System.out.println("打印调度执行是时间" + LocalDateTime.now().format(Constant.yyyyMMddHHmmss));


        //功能2.启动
        scheduler2.start();

        //功能3 挂起
        //scheduler2.standby();
        //被挂起之后再起启动会出现任务扎堆的情况
//    2019-04-18 15:41:43,050 [main] INFO org.quartz.core.QuartzScheduler.start(QuartzScheduler.java:575) method:start Scheduler DefaultQuartzScheduler_$_NON_CLUSTERED started.
//    2019-04-18 15:41:43,051 [main] INFO org.quartz.core.QuartzScheduler.standby(QuartzScheduler.java:613) method:standby Scheduler DefaultQuartzScheduler_$_NON_CLUSTERED paused.
//    数据同步任务执行中。。。2019-04-18 15:41:43
//    2019-04-18 15:41:53,051 [main] INFO org.quartz.core.QuartzScheduler.start(QuartzScheduler.java:575) method:start Scheduler DefaultQuartzScheduler_$_NON_CLUSTERED started.
//    数据同步任务执行中。。。2019-04-18 15:41:53
//    数据同步任务执行中。。。2019-04-18 15:41:53
//    数据同步任务执行中。。。2019-04-18 15:41:53
//    数据同步任务执行中。。。2019-04-18 15:41:53
//    数据同步任务执行中。。。2019-04-18 15:41:53
//    数据同步任务执行中。。。2019-04-18 15:41:54
//    数据同步任务执行中。。。2019-04-18 15:41:56
//    数据同步任务执行中。。。2019-04-18 15:41:58
//    数据同步任务执行中。。。2019-04-18 15:42:00
//    数据同步任务执行中。。。2019-04-18 15:42:02
//    数据同步任务执行中。。。2019-04-18 15:42:04


//    scheduler2.standby();
//    try {
//        Thread.sleep(10000);
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    }

        //功能4 关闭，注意关闭之后不能再启动

        scheduler2.shutdown();//true表示等待所有的job执行完毕之后，再关闭Scheduler
                              //false 表示直接关闭Scheduler
        scheduler2.start();
    }
}
