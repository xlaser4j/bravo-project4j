package com.xlaser4j.opening.modules.job.service;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlaser4j.opening.common.PageResponse;
import com.xlaser4j.opening.modules.job.entity.ScheduleJobDO;

/**
 * <p>
 * S: 定时任务job服务
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.job.service
 * @author: Elijah.D
 * @time: 2019/1/29 15:32
 * @description: job接口
 * @modified: Elijah.D
 */
public interface IScheduleJobService extends IService<ScheduleJobDO> {
    /**
     * 获取定时任务列表
     *
     * @param params 搜索条件参数
     * @return list结果集
     */
    PageResponse listScheduleJob(Map<String, Object> params);

    /**
     * 保存定时任务
     *
     * @param scheduleJob 定时任务
     */
    void saveScheduleJob(ScheduleJobDO scheduleJob);

    /**
     * 更新定时任务
     *
     * @param scheduleJob 定时任务
     */
    void updateScheduleJob(ScheduleJobDO scheduleJob);

    /**
     * 批量删除定时任务
     *
     * @param jobIds 任务id
     */
    void deleteBatchScheduleJob(Long[] jobIds);

    /**
     * 批量更新定时任务状态
     *
     * @param jobIds 任务id
     * @param status 任务状态
     * @return 更新数量
     */
    int updateBatchScheduleJob(Long[] jobIds, int status);

    /**
     * 立即执行
     *
     * @param jobIds 任务id
     */
    void startScheduleJob(Long[] jobIds);

    /**
     * 暂停运行
     *
     * @param jobIds 任务id
     */
    void pauseScheduleJob(Long[] jobIds);

    /**
     * 恢复运行
     *
     * @param jobIds 任务id
     */
    void resumeScheduleJob(Long[] jobIds);
}
