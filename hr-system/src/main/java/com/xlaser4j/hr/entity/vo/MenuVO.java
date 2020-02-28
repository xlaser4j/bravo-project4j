package com.xlaser4j.hr.entity.vo;

import java.util.List;

import lombok.Data;

/**
 * @package: com.xlaser4j.hr.entity.vo
 * @author: Elijah.D
 * @time: 2020/2/29 11:20
 * @description:
 * @modified: Elijah.D
 */
@Data
public class MenuVO {
    private Integer id;

    /**
     * 访问url
     */
    private String url;

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
     * 上级id
     */
    private Integer parentId;

    /**
     * 封装meta方便vue调用
     */
    private Meta meta;

    /**
     * 子菜单集合
     */
    private List<MenuVO> children;
}
