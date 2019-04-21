package com.yh.job;

import com.yh.Constant;
import org.quartz.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author lq
 * 创建时间 2019/4/18 15:10
 **/
public class JobDemo  implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("数据同步任务执行中。。。" +
                LocalDateTime.now().format(Constant.yyyyMMddHHmmss));
    }

}
