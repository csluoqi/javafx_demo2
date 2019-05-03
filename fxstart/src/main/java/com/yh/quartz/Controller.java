package com.yh.quartz;


import org.quartz.TriggerUtils;
import org.quartz.impl.triggers.CronTriggerImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Controller {

    /**
     * @param cronExpression cron表达式
     * @param numTimes       下一(几)次运行的时间
     * @return
     */
    public static List<String> getRecentExecTime(String cronExpression,Calendar startCalendar,Calendar endCalendar, Integer numTimes) {
        List<String> list = new ArrayList<>();
        try {
            CronTriggerImpl cronTrigger = new CronTriggerImpl();
            cronTrigger.setCronExpression(cronExpression);
            // 这里写要准备猜测的cron表达式
            Date now = startCalendar.getTime();
            // 把统计的区间段设置为从现在到2年后的今天（主要是为了方法通用考虑，如那些1个月跑一次的任务，如果时间段设置的较短就不足20条)
            // 这个是重点，一行代码搞定
            List<Date> dates = TriggerUtils.computeFireTimesBetween(cronTrigger, null, now, endCalendar.getTime());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for(int i = 0; i < dates.size(); i++) {
                // 这个是提示的日期个数
                if(i < numTimes) {
                    list.add(dateFormat.format(dates.get(i)));
                }else {
                    break;
                }
            }
        } catch(ParseException e) {
            e.printStackTrace();
        }
        return list;
    }



    public static void main(String[] args) {
        //getRecentExecTime("0 0 0,10 * * ? ",5);
    }
}
