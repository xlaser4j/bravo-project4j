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

    /**
     * 通过存储过程新增部门信息(这里只是学习存储过程的调用方法),也可以通过service事务一次性执行下列语句
     * <p>
     * 1.新增dep,获取id(child)
     * 2.根据parentId获取dep_path(parent)
     * 3.更新新增的dep_path = parent_dep_path + . + child_id
     * 4.更新parent的is_parent = true
     * <p>
     * 注意存储过程的输入输出参数都必须在model中存在,这里返回值为void,但是department这个参数会在存储过程执行完之后,
     * 对其进行自动更新属性,比如存储过程中设置了insertId和count的值,这里就可以直接获取dep.getInsertId
     *
     * @param dep 部门信息
     * @return
     */
    void saveDepByProcedure(DepartmentDO dep);

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
     * @param dep 部门信息
     * @return
     */
    void deleteDepByProcedure(DepartmentDO dep);
}
