package com.xlaser4j.opening.modules.job.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * <p>
 * C: 定时任务配置
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.job.config
 * @author: Elijah.D
 * @time: 2019/1/29 15:31
 * @description: 配置类
 * @modified: Elijah.D
 */
@Configuration
public class ScheduleConfig {
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource) {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        Properties prop = new Properties();

        // 使用群集功能时对每个实例使用相同的名称
        prop.put("org.quartz.scheduler.instanceName", "RenrenScheduler");

        // auto可以生成实例id
        prop.put("org.quartz.scheduler.instanceId", "AUTO");

        //线程池配置SimpleThreadPool,quartz内部自带简单线程配置
        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");

        // 1-100根据任务合理定义
        prop.put("org.quartz.threadPool.threadCount", "20");

        // 最小:Thread.MIN_PRIORITY (1)  最大:Thread.MAX_PRIORITY (10)   默认:Thread.NORM_PRIORITY (5)
        prop.put("org.quartz.threadPool.threadPriority", "5");

        // 使用jdbc
        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");

        // 开启集群配置(多个Quartz实例在用同一套数据库时)
        prop.put("org.quartz.jobStore.isClustered", "true");

        // 心跳检测集群中的任务执行失败状况
        prop.put("org.quartz.jobStore.clusterCheckinInterval", "15000");

        // JobStore能处理的错过触发的 Trigger 的最大数量。处理太多(超过几十个)导致数据库表被长时间锁定，妨碍未错过触发trigger执行的性能。
        prop.put("org.quartz.jobStore.maxMisfiresToHandleAtATime", "5");

        // 当任务错过触发时间时，延长触发时间的最大值
        prop.put("org.quartz.jobStore.misfireThreshold", "12000");

        // JDBCJobStore的“表前缀”属性是一个字符串，它等于在数据库中创建的Quartz表的前缀
        prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");

        prop.put("org.quartz.jobStore.selectWithLockSQL", "SELECT * FROM {0}LOCKS UPDLOCK WHERE LOCK_NAME = ?");

        // PgSQL数据库，需要打开此注释
        /// prop.put("org.quartz.jobStore.driverDelegateClass", "org.quartz.impl.jdbcjobstore.PostgreSQLDelegate");

        bean.setQuartzProperties(prop);
        bean.setDataSource(dataSource);
        bean.setSchedulerName("RenrenScheduler");
        bean.setStartupDelay(30);

        // 把spring上下文以key/value的方式存放在了quartz的上下文中了，可以用applicationContextKey得到对应的spring上下文
        bean.setApplicationContextSchedulerContextKey("applicationContextKey");

        //可选，QuartzScheduler 启动时更新己存在的Job，这样就不用每次修改targetObject后删除quartz_job_details表对应记录了
        bean.setOverwriteExistingJobs(true);

        //设置自动启动，默认为true
        bean.setAutoStartup(true);

        return bean;
    }
}
