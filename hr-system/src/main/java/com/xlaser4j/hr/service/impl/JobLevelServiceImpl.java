package com.xlaser4j.hr.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser4j.hr.entity.JobLevelDO;
import com.xlaser4j.hr.mapper.JobLevelMapper;
import com.xlaser4j.hr.service.IJobLevelService;
import org.springframework.stereotype.Service;

/**
 * @package: com.xlaser4j.hr.service.impl
 * @author: Elijah.D
 * @time: 2020/2/9 17:29
 * @description:
 * @modified: Elijah.D
 */
@Service
public class JobLevelServiceImpl extends ServiceImpl<JobLevelMapper, JobLevelDO> implements IJobLevelService {
}
