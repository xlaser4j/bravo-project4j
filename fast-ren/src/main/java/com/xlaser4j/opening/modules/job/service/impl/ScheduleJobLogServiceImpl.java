package com.xlaser4j.opening.modules.job.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser4j.opening.modules.job.entity.ScheduleJobLogDO;
import com.xlaser4j.opening.modules.job.mapper.ScheduleJobLogMapper;
import com.xlaser4j.opening.modules.job.service.IScheduleJobLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * I: 定时任务log服务实现类
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.service.impl
 * @author: Elijah.D
 * @time: 2019/1/29 16:14
 * @description: log实现类
 * @modified: Elijah.D
 */
@Service
@AllArgsConstructor
public class ScheduleJobLogServiceImpl extends ServiceImpl<ScheduleJobLogMapper, ScheduleJobLogDO> implements IScheduleJobLogService {
    private final ScheduleJobLogMapper jobLogMapper;
}
