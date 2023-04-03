package com.yjh.config;

import com.yjh.quartz.MyQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail printJobDetail() {// 这个是工作明细函数，里面需要绑定具体工作的
        // 绑定具体的工作
        return JobBuilder.newJob(MyQuartz.class).storeDurably().build();
    }

    @Bean
    public Trigger printJobTrigger() {// 这个是触发器，里面需要绑定工作明细的
        // 绑定对应的工作明细
        // "0/15 * * * * ?" 这个从后面开始读取，问号是指匹配前面的就行，这个位置其实是指代星期的
        // "0秒/每15秒 任意分 任意时 任意日 任意月 "
        ScheduleBuilder<? extends Trigger> scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(printJobDetail()).withSchedule(scheduleBuilder).build();
    }
}
