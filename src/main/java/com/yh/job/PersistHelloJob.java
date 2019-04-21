package com.yh.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

/**
 * @author lq
 * 创建时间 2019/4/17 16:50
 **/
@PersistJobDataAfterExecution //多次job调用期间可以持有一些状态信息，比如实现累加功能
public class PersistHelloJob implements Job {

    public  Integer count;
    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        count++;
        jobExecutionContext.getJobDetail().getJobDataMap().put("count",count);
        System.out.println("Count当前值："+count);
    }
}
