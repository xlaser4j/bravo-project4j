package com.xlaser4j.hr.service.impl;

import com.xlaser4j.hr.entity.EmployeeDO;
import com.xlaser4j.hr.mapper.EmployeeMapper;
import com.xlaser4j.hr.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @package: com.xlaser4j.hr.service.impl
 * @author: Elijah.D
 * @time: 2020/2/9 17:29
 * @description:
 * @modified: Elijah.D
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, EmployeeDO> implements IEmployeeService {

}
