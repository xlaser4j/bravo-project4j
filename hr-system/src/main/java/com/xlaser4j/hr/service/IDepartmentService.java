package com.xlaser4j.hr.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlaser4j.hr.entity.DepartmentDO;
import com.xlaser4j.hr.entity.vo.TreeVO;

/**
 * @package: com.xlaser4j.hr.service
 * @author: Elijah.D
 * @time: 2020/2/9 17:28
 * @description:
 * @modified: Elijah.D
 */
public interface IDepartmentService extends IService<DepartmentDO> {
    /**
     * 获取树形部门树
     *
     * @return
     */
    List<TreeVO> listDepsTrees();
}
