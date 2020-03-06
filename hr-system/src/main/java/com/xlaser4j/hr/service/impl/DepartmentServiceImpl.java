package com.xlaser4j.hr.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser4j.hr.entity.DepartmentDO;
import com.xlaser4j.hr.entity.vo.TreeVO;
import com.xlaser4j.hr.mapper.DepartmentMapper;
import com.xlaser4j.hr.service.IDepartmentService;
import org.springframework.stereotype.Service;

/**
 * @package: com.xlaser4j.hr.service.impl
 * @author: Elijah.D
 * @time: 2020/2/9 17:29
 * @description:
 * @modified: Elijah.D
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, DepartmentDO> implements IDepartmentService {
    /**
     * 获取树形部门树
     *
     * @return
     */
    @Override
    public List<TreeVO> listDepsTrees() {

        // 通过mybatis的select语法形成递归调用,这里第一次递归调用最顶级-1
        return baseMapper.listDepsByParentId(-1);
    }
}
