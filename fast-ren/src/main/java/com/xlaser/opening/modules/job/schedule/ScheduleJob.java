package com.xlaser.opening.modules.job.schedule;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.util.StrUtil;
import com.xlaser.opening.common.util.SpringContextHolder;
import com.xlaser.opening.modules.job.entity.ScheduleJobDO;
import com.xlaser.opening.modules.job.entity.ScheduleJobLogDO;
import com.xlaser.opening.modules.job.service.IScheduleJobLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * <p>
 * S: 定时任务类
 * </p>
 *
 * @package: com.xlaser.opening.modules.job.schedule
 * @author: Elijah.D
 * @time: CreateAt 2019/2/18 && 15:43
 * @description: 定时任务
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@Slf4j
public class ScheduleJob extends QuartzJobBean {
    private final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5, new BasicThreadFactory.Builder().namingPattern("Job-Thread-%d").build());

    /**
     * 任务实际调度
     *
     * @param context 全局任务
     */
    @Override
    protected void executeInternal(JobExecutionContext context) {
        ScheduleJobDO job = (ScheduleJobDO) context.getMergedJobDataMap().get(ScheduleJobDO.JOB_PARAM_KEY);

        // 构建定时任务log对象,记录任务相关状态信息,后续保存
        IScheduleJobLogService jobLogService = SpringContextHolder.getBean(IScheduleJobLogService.class);
        ScheduleJobLogDO jobLog = ScheduleJobLogDO.builder().jobId(job.getJobId())
                .beanName(job.getBeanName()).methodName(job.getMethodName())
                .params(job.getParams()).createTime(System.currentTimeMillis())
                .build();

        // 定时任务执行
        TimeInterval interval = new TimeInterval();
        log.info("【ScheduleJob】:定时任务开始执行,任务ID: {}", job.getJobId());
        try {
            ScheduleRunnable task = new ScheduleRunnable(job.getBeanName(), job.getMethodName(), job.getParams());
            Future<?> future = executor.submit(task);
            future.get();
            jobLog.setStatus(0);
            jobLog.setTimes((int) interval.intervalMs());
            log.info("【ScheduleJob】:定时任务执行成功! 任务ID: {},耗时: {}", job.getJobId(), interval.intervalMs());
        } catch (Exception e) {
            log.error("【ScheduleJob】:定时任务执行失败! 任务ID: {},错误原因: {}", job.getJobId(), e.getMessage());
            jobLog.setStatus(1);
            jobLog.setTimes((int) interval.intervalMs());
            jobLog.setError(StrUtil.sub(e.toString(), 0, 1000));
        } finally {
            jobLogService.save(jobLog);
        }
    }
}
