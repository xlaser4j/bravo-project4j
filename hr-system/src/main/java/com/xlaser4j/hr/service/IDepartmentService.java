package com.xlaser4j.hr.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlaser4j.hr.common.Status;
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

    /**
     * 通过存储过程新增部门信息(这里只是学习存储过程的调用方法),也可以通过service事务一次性执行下列语句
     * <p>
     * 1.新增dep,获取id(child)
     * 2.根据parentId获取dep_path(parent)
     * 3.更新新增的dep_path = parent_dep_path + . + child_id
     * 4.更新parent的is_parent = true
     *
     * @param department
     * @return
     */
    boolean saveDepByProcedure(DepartmentDO department);

    /**
     * 通过存储过程新增部门信息(这里只是学习存储过程的调用方法),也可以通过service事务一次性执行下列语句
     * <p>
     * 1.判断部门是否有子节点,有则不能删除
     * 2.判断部门是否有emp使用,有则不能删除
     * 3.删除部门信息
     * 4.判断删除部门的父级是否还有子节点,没有则更新isParent为false
     *
     * @param id depId
     * @return
     */
    Status deleteDepByProcedure(Integer id);
}
