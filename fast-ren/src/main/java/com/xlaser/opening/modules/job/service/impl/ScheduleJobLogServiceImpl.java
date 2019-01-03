package com.xlaser.opening.modules.job.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser.opening.modules.job.entity.ScheduleJobLogDO;
import com.xlaser.opening.modules.job.mapper.ScheduleJobLogMapper;
import com.xlaser.opening.modules.job.service.IScheduleJobLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * I: 定时任务log服务实现类
 * </p>
 *
 * @package: com.xlaser.opening.modules.sys.service.impl
 * @author: Elijah.D
 * @time: CreateAt 2019/1/29 && 16:14
 * @description: log实现类
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@Service
@AllArgsConstructor
public class ScheduleJobLogServiceImpl extends ServiceImpl<ScheduleJobLogMapper, ScheduleJobLogDO> implements IScheduleJobLogService {
    private final ScheduleJobLogMapper jobLogMapper;
}
