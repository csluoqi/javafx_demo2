package com.yh.quartz.job;

import org.quartz.*;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author lq
 * 创建时间 2019/4/17 17:14
 **/
public class HelloTriggerJob implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("数据同步。。。当前时间" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

        JobKey jobKey = jobExecutionContext.getTrigger().getJobKey();
        System.out.println("jobKey.getName():  "+jobKey.getName());
        System.out.println("jobKey.getGroup(): "+jobKey.getGroup());

        TriggerKey key = jobExecutionContext.getTrigger().getKey();
        System.out.println("key.getName():  "+key.getName());
        System.out.println("key.getGroup(): "+key.getGroup());

        System.out.println("调度开始时间：" + jobExecutionContext.getTrigger().getStartTime());
        System.out.println("调度结束时间："+jobExecutionContext.getTrigger().getEndTime());
    }

}
