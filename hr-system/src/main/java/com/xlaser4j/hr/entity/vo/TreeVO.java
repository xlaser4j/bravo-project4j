package com.xlaser4j.hr.entity.vo;

import java.util.List;

import lombok.Data;

/**
 * @package: com.xlaser4j.hr.entity.vo
 * @author: Elijah.D
 * @time: 2020/3/5 11:20
 * @description: 权限控制返回的三级树形结构&部门多级树形结构
 * @modified: Elijah.D
 */
@Data
public class TreeVO {
    /**
     * 权限:通过collection直接返回多级树形结构,条件是结构相同,这里的权限都是三级,所以可以通过collection返回!
     * <p>
     * 部门:通过递归实现多级树形结构,不使用collection是因为树形的结构不固定,可能有任意组合层级,因此只能递归构建!
     * <p>
     * 注意:可以通过mybatis的递归语法很方便实现递归操作,避免代码逻辑递归!
     */
    private Integer id;

    /**
     * 菜单/部门名称
     */
    private String name;

    /**
     * 子菜单/子部门集合
     */
    private List<TreeVO> children;
}
