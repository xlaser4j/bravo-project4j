package com.xlaser4j.opening.modules.job.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser4j.opening.common.PageResponse;
import com.xlaser4j.opening.common.enums.ScheduleStatusEnum;
import com.xlaser4j.opening.common.query.PageQuery;
import com.xlaser4j.opening.modules.job.entity.ScheduleJobDO;
import com.xlaser4j.opening.modules.job.mapper.ScheduleJobMapper;
import com.xlaser4j.opening.modules.job.schedule.ScheduleUtils;
import com.xlaser4j.opening.modules.job.service.IScheduleJobService;
import lombok.AllArgsConstructor;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.springframework.stereotype.Service;

/**
 * <p>
 * I: 定时任务job服务实现类
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.service.impl
 * @author: Elijah.D
 * @time: 2019/1/29 17:19
 * @description: job实现类
 * @modified: Elijah.D
 */
@Service
@AllArgsConstructor
public class ScheduleJobServiceImpl extends ServiceImpl<ScheduleJobMapper, ScheduleJobDO> implements IScheduleJobService {
    private final Scheduler scheduler;

    /**
     * 项目启动时，初始化定时器
     */
    @PostConstruct
    public void init() {
        List<ScheduleJobDO> jobs = list(null);
        jobs.forEach(o -> {
            CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler, o.getJobId());
            if (cronTrigger == null) {
                ScheduleUtils.createScheduleJob(scheduler, o);
            } else {
                ScheduleUtils.updateScheduleJob(scheduler, o);
            }
        });
    }

    /**
     * 获取定时任务列表
     *
     * @param params 搜索条件参数
     * @return list结果集
     */
    @Override
    public PageResponse listScheduleJob(Map<String, Object> params) {
        String beanName = (String)params.get("beanName");

        IPage<ScheduleJobDO> page = page(
                new PageQuery<ScheduleJobDO>(params).getPage(),
                new QueryWrapper<ScheduleJobDO>().like(StrUtil.isNotBlank(beanName), "bean_name", beanName)
        );

        return new PageResponse(page);
    }

    /**
     * 保存定时任务
     *
     * @param scheduleJob 定时任务
     */
    @Override
    public void saveScheduleJob(ScheduleJobDO scheduleJob) {
        scheduleJob.setCreateTime(System.currentTimeMillis());
        scheduleJob.setStatus(ScheduleStatusEnum.NORMAL.getValue());
        save(scheduleJob);

        ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
    }

    /**
     * 更新定时任务
     *
     * @param scheduleJob 定时任务
     */
    @Override
    public void updateScheduleJob(ScheduleJobDO scheduleJob) {

        ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
        updateById(scheduleJob);
    }

    /**
     * 批量删除定时任务
     *
     * @param jobIds 任务id
     */
    @Override
    public void deleteBatchScheduleJob(Long[] jobIds) {
        for (Long jobId : jobIds) {
            ScheduleUtils.deleteJob(scheduler, jobId);
        }
        removeByIds(Arrays.asList(jobIds));
    }

    /**
     * 批量更新定时任务状态
     *
     * @param jobIds 任务id
     * @param status 任务状态
     * @return 更新数量
     */
    @Override
    public int updateBatchScheduleJob(Long[] jobIds, int status) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("list", jobIds);
        map.put("status", status);

        return baseMapper.updateBatchStatus(map);
    }

    /**
     * 立即执行
     *
     * @param jobIds 任务id
     */
    @Override
    public void startScheduleJob(Long[] jobIds) {
        for (Long jobId : jobIds) {
            ScheduleUtils.startJob(scheduler, getById(jobId));
        }
        updateBatchScheduleJob(jobIds, ScheduleStatusEnum.NORMAL.getValue());
    }

    /**
     * 暂停运行
     *
     * @param jobIds 任务id
     */
    @Override
    public void pauseScheduleJob(Long[] jobIds) {
        for (Long jobId : jobIds) {
            ScheduleUtils.pauseJob(scheduler, jobId);
        }
    }

    /**
     * 恢复运行
     *
     * @param jobIds 任务id
     */
    @Override
    public void resumeScheduleJob(Long[] jobIds) {
        for (Long jobId : jobIds) {
            ScheduleUtils.resumeJob(scheduler, jobId);
        }
    }
}
