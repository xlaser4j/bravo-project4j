package com.xlaser4j.opening.modules.job.schedule;

import com.xlaser4j.opening.common.enums.Status;
import com.xlaser4j.opening.common.exception.FastRenException;
import com.xlaser4j.opening.modules.job.config.ScheduleConfig;
import com.xlaser4j.opening.modules.job.entity.ScheduleJobDO;
import org.quartz.*;

/**
 * <p>
 * U: 定时任务job工具类
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.job.schedule
 * @author: Elijah.D
 * @time: 2019/1/29 19:34
 * @description: job工具类
 * @modified: Elijah.D
 */
public class ScheduleUtils {
    private static final String PREFIX = "TASK_";

    /**
     * 获取触发器key
     *
     * @param jobId 任务id
     * @return 触发器key
     */
    public static TriggerKey getTriggerKey(Long jobId) {
        return TriggerKey.triggerKey(PREFIX + jobId);
    }

    /**
     * 获取任务key
     *
     * @param jobId 任务id
     * @return 任务key
     */
    public static JobKey getJobKey(Long jobId) {
        return JobKey.jobKey(PREFIX + jobId);
    }

    /**
     * 获取cron触发器
     *
     * @param scheduler 定时任务主配置,生成在{@link ScheduleConfig}
     * @param jobId     任务id
     * @return 触发器
     */
    public static CronTrigger getCronTrigger(Scheduler scheduler, Long jobId) {
        try {
            return (CronTrigger)scheduler.getTrigger(getTriggerKey(jobId));
        } catch (SchedulerException e) {
            throw new FastRenException(Status.GET_TRIGGER_FAILED);
        }
    }

    /**
     * 创建定时任务
     *
     * @param scheduler 定时任务主配置
     * @param job       任务
     */
    public static void createScheduleJob(Scheduler scheduler, ScheduleJobDO job) {
        try {
            // 构建调度器 ==> 构建新的触发器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression()).withMisfireHandlingInstructionDoNothing();
            CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(getTriggerKey(job.getJobId())).withSchedule(scheduleBuilder).build();

            // 构建job信息,设置Map
            JobDetail jobDetail = JobBuilder.newJob(ScheduleJob.class).withIdentity(getJobKey(job.getJobId())).build();
            jobDetail.getJobDataMap().put(ScheduleJobDO.JOB_PARAM_KEY, job);

            scheduler.scheduleJob(jobDetail, cronTrigger);
        } catch (SchedulerException e) {
            throw new FastRenException(Status.CREATE_JOB_FAILED);
        }
    }

    /**
     * 更新定时任务
     *
     * @param scheduler 定时任务主配置
     * @param job       任务
     */
    public static void updateScheduleJob(Scheduler scheduler, ScheduleJobDO job) {
        try {
            CronTrigger trigger = getCronTrigger(scheduler, job.getJobId());

            // 按新的cronExpression表达式重新构建trigger
            TriggerKey triggerKey = getTriggerKey(job.getJobId());
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression()).withMisfireHandlingInstructionDoNothing();

            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            trigger.getJobDataMap().put(ScheduleJobDO.JOB_PARAM_KEY, job);

            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            throw new FastRenException(Status.UPDATE_JOB_FAILED);
        }
    }

    /**
     * 删除定时任务
     *
     * @param scheduler 定时任务主配置
     * @param job       任务
     */
    public static void startJob(Scheduler scheduler, ScheduleJobDO job) {
        try {
            JobDataMap map = new JobDataMap();
            map.put(ScheduleJobDO.JOB_PARAM_KEY, job);
            scheduler.triggerJob(getJobKey(job.getJobId()), map);
        } catch (SchedulerException e) {
            throw new FastRenException(Status.START_JOB_FAILED);
        }
    }

    /**
     * 暂停定时任务
     *
     * @param scheduler 定时任务主配置
     * @param jobId     任务id
     */
    public static void pauseJob(Scheduler scheduler, Long jobId) {
        try {
            scheduler.pauseJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            throw new FastRenException(Status.PAUSE_JOB_FAILED);
        }
    }

    /**
     * 重新恢复定时任务
     *
     * @param scheduler 定时任务主配置
     * @param jobId     任务id
     */
    public static void resumeJob(Scheduler scheduler, Long jobId) {
        try {
            scheduler.resumeJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            throw new FastRenException(Status.PAUSE_JOB_FAILED);
        }
    }

    /**
     * 删除定时任务
     *
     * @param scheduler 定时任务主配置
     * @param jobId     任务id
     */
    public static void deleteJob(Scheduler scheduler, Long jobId) {
        try {
            scheduler.deleteJob(getJobKey(jobId));
        } catch (SchedulerException e) {
            throw new FastRenException(Status.DELETE_JOB_FAILED);
        }
    }
}
