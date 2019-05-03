package com.yh.quartz.listener;

import org.quartz.*;

/**
 * @author lq
 * 创建时间 2019/4/18 17:36
 **/
public class MySchedulerListener implements SchedulerListener {

    @Override
    public void jobScheduled(Trigger trigger) {
        System.out.println("部署JobDetail。。。"+trigger.getKey().getName());
    }

    @Override
    public void jobUnscheduled(TriggerKey triggerKey) {
        System.out.println("卸载JobDetail。。。"+triggerKey.getName());
    }

    @Override
    public void triggerFinalized(Trigger trigger) {
        System.out.println("当一个Trigger来到了再也不会触发的状态时调用这个方法，除非这个job具有持久性，否则他就会从Scheduler中移除"+trigger.getKey().getName());
    }

    @Override
    public void triggerPaused(TriggerKey triggerKey) {
        System.out.println("trigger被暂停了。。。"+triggerKey.getName());
    }

    @Override
    public void triggersPaused(String s) {
        System.out.println("trigger被暂停了。。。"+s);
    }

    @Override
    public void triggerResumed(TriggerKey triggerKey) {
        System.out.println("有trigger或者trigger从暂停中恢复了");
    }

    @Override
    public void triggersResumed(String s) {
        System.out.println("有trigger或者trigger从暂停中恢复了"+s);
    }

    @Override
    public void jobAdded(JobDetail jobDetail) {
        System.out.println("有job被加入了");
    }

    @Override
    public void jobDeleted(JobKey jobKey) {
        System.out.println("有job被移除了");
    }

    @Override
    public void jobPaused(JobKey jobKey) {
        System.out.println("有job被暂停了");
    }

    @Override
    public void jobsPaused(String s) {
        System.out.println("有任务被暂停了");

    }

    @Override
    public void jobResumed(JobKey jobKey) {
        System.out.println("有任务被重启了");
    }

    @Override
    public void jobsResumed(String s) {
        System.out.println("有任务被重启了");
    }

    @Override
    public void schedulerError(String s, SchedulerException e) {
        System.out.println("调度出现错误");
    }

    @Override
    public void schedulerInStandbyMode() {
        System.out.println("scheduler处于挂起状态");
    }

    @Override
    public void schedulerStarted() {
        System.out.println("scheduler 被启动了");
    }

    @Override
    public void schedulerStarting() {
        System.out.println("scheduler 正在启动");
    }

    @Override
    public void schedulerShutdown() {
        System.out.println("scheduler关闭");
    }

    @Override
    public void schedulerShuttingdown() {
        System.out.println("scheduler 正在关闭");
    }

    @Override
    public void schedulingDataCleared() {
        System.out.println("scheduler 数据被清除");
    }
}
