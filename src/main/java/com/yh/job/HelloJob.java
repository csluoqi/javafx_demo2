package com.yh.job;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lq
 * 创建时间 2019/4/17 0:00
 **/
public class HelloJob implements Job {

    public String myMsg1;
    public String myMsg2;
    public void setMyMsg1(String myMsg1) {
        this.myMsg1 = myMsg1;
    }
    public void setMyMsg2(String myMsg2) {
        this.myMsg2 = myMsg2;
    }

    /**
     * 验证每次调度器运行时，它在调用execute方法前会创建一个新的job实例，当调用完成后，关联的job对象实例会被释放，释放的实例会被垃圾回收机制回收。
     * ps，使用了反射
     */
    public HelloJob(){
        System.out.println("HelloJob init "+new Date());
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        System.out.println("打印job jobDataMap");
        for(JobDataMap.Entry entry :jobDataMap.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

        JobDataMap jobDataMap1 = jobExecutionContext.getTrigger().getJobDataMap();
        System.out.println("打印Trigger jobDataMap");
        for(JobDataMap.Entry entry : jobDataMap1.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

        System.out.println("--------------");
        //获取其他信息
        System.out.println("本次次执行时间 ： "+jobExecutionContext.getFireTime());

        System.out.println("前一次执行时间 ： "+jobExecutionContext.getPreviousFireTime());
        System.out.println("下一次执行时间 ： "+jobExecutionContext.getNextFireTime());
        System.out.println("--------------");
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("正在进行数据备份");

        //测试myMsg1，测试myMsg1
        System.out.println(myMsg1);
        System.out.println(myMsg2);
    }
}
