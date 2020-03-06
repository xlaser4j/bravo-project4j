package com.xlaser4j.hr.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlaser4j.hr.entity.DepartmentDO;
import com.xlaser4j.hr.entity.vo.TreeVO;

/**
 * @package: com.xlaser4j.hr.mapper
 * @author: Elijah.D
 * @time: 2020/2/9 17:34
 * @description:
 * @modified: Elijah.D
 */
public interface DepartmentMapper extends BaseMapper<DepartmentDO> {
    /**
     * 获取树形部门树
     *
     * @param parentId 父级id
     * @return
     */
    List<TreeVO> listDepsByParentId(Integer parentId);
}
