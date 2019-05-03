package com.yh.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * @author lq
 * 创建时间 2019/4/18 16:18
 **/
public class MyJobListener implements JobListener {


    private String name;
    public MyJobListener(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        System.out.println("监听名称"+this.name);
        return this.name;
    }

    @Override
    public void jobToBeExecuted(JobExecutionContext jobExecutionContext) {
        System.out.println("Job名称"+jobExecutionContext.getJobDetail().getKey().getName());
        System.out.println("将要触发时被执行");

    }

    @Override
    public void jobExecutionVetoed(JobExecutionContext jobExecutionContext) {
        System.out.println("Job名称"+jobExecutionContext.getJobDetail().getKey().getName());
        System.out.println("将要触发时被执行但是被否决");
    }

    @Override
    public void jobWasExecuted(JobExecutionContext jobExecutionContext, JobExecutionException e) {
        System.out.println("Job名称"+jobExecutionContext.getJobDetail().getKey().getName());
        System.out.println("执行完成");
    }
}
