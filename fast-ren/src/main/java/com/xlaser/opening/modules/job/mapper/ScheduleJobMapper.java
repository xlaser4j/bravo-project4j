package com.xlaser.opening.modules.job.mapper;

import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlaser.opening.modules.job.entity.ScheduleJobDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * M: 定时任务job持久层
 * </p>
 *
 * @package: com.xlaser.opening.modules.job.mapper
 * @author: Elijah.D
 * @time: CreateAt 2019/1/29 && 15:30
 * @description: job持久层
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@Mapper
public interface ScheduleJobMapper extends BaseMapper<ScheduleJobDO> {
    /**
     * 批量更新定时任务状态
     *
     * @param map 参数
     * @return 更新数量
     */
    int updateBatchStatus(Map<String, Object> map);
}
