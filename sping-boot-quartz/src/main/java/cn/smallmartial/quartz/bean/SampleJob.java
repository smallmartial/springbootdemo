package cn.smallmartial.quartz.bean;

import cn.smallmartial.quartz.service.TestService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Author smallmartial
 * @Date 2020/4/19
 * @Email smallmarital@qq.com
 */
public class SampleJob  extends QuartzJobBean {

    //作业可以定义设置器以注入数据映射属性。常规豆也可以类似的方式注入，如以下示例所示：
    @Autowired
    private TestService testService;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        testService.test();
        System.out.println("    Hi! :" + jobExecutionContext.getJobDetail().getKey());
    }
}
