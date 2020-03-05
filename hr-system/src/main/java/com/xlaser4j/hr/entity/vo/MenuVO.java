package com.xlaser4j.hr.entity.vo;

import java.util.List;

import lombok.Data;

/**
 * @package: com.xlaser4j.hr.entity.vo
 * @author: Elijah.D
 * @time: 2020/3/5 11:20
 * @description: 权限控制返回的三级树形结构
 * @modified: Elijah.D
 */
@Data
public class MenuVO {
    /**
     * xml中的collection才能完成一对多映射关系,需要返回必要的关联id
     */
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 子菜单集合
     */
    private List<MenuVO> children;
}
