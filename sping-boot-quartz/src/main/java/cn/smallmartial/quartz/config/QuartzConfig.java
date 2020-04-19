package cn.smallmartial.quartz.config;

import cn.smallmartial.quartz.bean.SampleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author smallmartial
 * @Date 2020/4/19
 * @Email smallmarital@qq.com
 */
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail uploadTaskDetail() {
        return JobBuilder.newJob(SampleJob.class).withIdentity("mjtTask").storeDurably().build();
    }

    @Bean
    public Trigger uploadTaskTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail())
                .withIdentity("mjtTask")
                .withSchedule(scheduleBuilder)
                .build();
    }
}