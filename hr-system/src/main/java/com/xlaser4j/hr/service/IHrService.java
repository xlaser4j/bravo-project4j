package com.xlaser4j.hr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlaser4j.hr.entity.HrDO;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @package: com.xlaser4j.hr.service
 * @author: Elijah.D
 * @time: 2020/2/9 17:28
 * @description:
 * @modified: Elijah.D
 */
public interface IHrService extends IService<HrDO>, UserDetailsService {
}
