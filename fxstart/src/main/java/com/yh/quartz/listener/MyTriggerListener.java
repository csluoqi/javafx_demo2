package com.yh.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

/**
 * @author lq
 * 创建时间 2019/4/18 16:56
 **/
public class MyTriggerListener implements org.quartz.TriggerListener {
    @Override
    public String getName() {

        return getClass().getSimpleName();
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext jobExecutionContext) {
        System.out.println("触发开始时执行");

    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext jobExecutionContext) {
        System.out.println("投票阶段");
        //TriggerListener 给了一个选择权job的执行，假如这个方法返回true，这个job将不会为此次trigger触发。
        return false;


    }

    @Override
    public void triggerMisfired(Trigger trigger) {
        System.out.println("错过触发时执行");
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext jobExecutionContext, Trigger.CompletedExecutionInstruction completedExecutionInstruction) {
        System.out.println("触发完成时执行");
    }
}
