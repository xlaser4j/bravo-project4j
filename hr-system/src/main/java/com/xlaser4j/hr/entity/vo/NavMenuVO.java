package com.xlaser4j.hr.entity.vo;

import java.util.List;

import lombok.Data;

/**
 * @package: com.xlaser4j.hr.entity.vo
 * @author: Elijah.D
 * @time: 2020/2/29 11:20
 * @description: 前端导航栏vo
 * @modified: Elijah.D
 */
@Data
public class NavMenuVO {
    /**
     * 必须返回parent.id主键,xml中的collection才能完成一对多映射关系
     */
    private Integer id;

    /**
     * 跳转路径
     */
    private String path;

    /**
     * vue组件名称
     */
    private String component;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 图标信息
     */
    private String iconCls;

    /**
     * 是否启用菜单
     */
    private Boolean enabled;

    /**
     * 封装meta方便vue调用
     */
    private Meta meta;

    /**
     * 子菜单集合
     */
    private List<NavMenuVO> children;
}
