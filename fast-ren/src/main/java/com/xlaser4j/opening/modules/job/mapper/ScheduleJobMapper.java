package com.xlaser4j.opening.modules.job.mapper;

import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlaser4j.opening.modules.job.entity.ScheduleJobDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * M: 定时任务job持久层
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.job.mapper
 * @author: Elijah.D
 * @time: 2019/1/29 15:30
 * @description: job持久层
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
