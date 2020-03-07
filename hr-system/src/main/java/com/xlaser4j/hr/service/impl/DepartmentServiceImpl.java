package com.xlaser4j.hr.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser4j.hr.common.Status;
import com.xlaser4j.hr.entity.DepartmentDO;
import com.xlaser4j.hr.entity.vo.TreeVO;
import com.xlaser4j.hr.mapper.DepartmentMapper;
import com.xlaser4j.hr.service.IDepartmentService;
import org.springframework.stereotype.Service;

import static com.xlaser4j.hr.common.Status.*;

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

    /**
     * 通过存储过程新增部门信息(这里只是学习存储过程的调用方法),也可以通过service事务一次性执行下列语句
     * <p>
     * 1.新增dep,获取id(child)
     * 2.根据parentId获取dep_path(parent)
     * 3.更新新增的dep_path = parent_dep_path + . + child_id
     * 4.更新parent的is_parent = true
     *
     * @param dep
     * @return
     */
    @Override
    public boolean saveDepByProcedure(DepartmentDO dep) {
        baseMapper.saveDepByProcedure(dep);
        return dep.getProcedureResult() > 0;
    }

    /**
     * 通过存储过程新增部门信息(这里只是学习存储过程的调用方法),也可以通过service事务一次性执行下列语句
     * <p>
     * 1.判断部门是否有子节点,有则不能删除
     * 2.判断部门是否有emp使用,有则不能删除
     * 3.删除部门信息
     * 4.判断删除部门的父级是否还有子节点,没有则更新isParent为false
     * <p>
     * 仍然需要使用dep对象传参,入参
     *
     * @param id depId
     * @return
     */
    @Override
    public Status deleteDepByProcedure(Integer id) {

        // 调用存储过程,仍然需要对象传/入参
        DepartmentDO dep = new DepartmentDO();
        dep.setId(id);
        baseMapper.deleteDepByProcedure(dep);

        // 根据producer返回结果,枚举错误
        int type = dep.getProcedureResult();
        if (type == -1) {
            return DELETE_DEP_PARENT_FAIL;
        } else if (type == -2) {
            return DELETE_DEP_EMP_FAIL;
        } else if (type == 1) {
            return DELETE_SUCCESS;
        } else {
            return DELETE_FAIL;
        }
    }
}
