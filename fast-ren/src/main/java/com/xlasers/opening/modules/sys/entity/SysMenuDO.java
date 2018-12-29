package com.xlasers.opening.modules.sys.entity;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 菜单管理
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.model
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 13:58
 * @description: 菜单管理
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@Data
@TableName("sys_menu")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMenuDO extends Model<SysMenuDO> {
    private static final long serialVersionUID = 1L;

    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

    /**
     * 父菜单ID，一级菜单为0
     */
    @NotNull(message = "【新增/修改菜单】异常! 上级id不能为空 !")
    private Long parentId;

    /**
     * 菜单名称
     */
    @NotBlank(message = "【新增/修改菜单】异常! 菜单名称不能为空 !")
    private String name;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String perms;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    @Min(value = 0, message = "【新增/修改菜单】异常! 菜单类型错误-> 0:目录, 1:菜单, 2:按钮 !")
    @Max(value = 2, message = "【新增/修改菜单】异常! 菜单类型错误-> 0:目录, 1:菜单, 2:按钮 !")
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 构建树形结构
     */
    @TableField(exist = false)
    private List<?> treeList;

    /**
     * 返回权限列表时的父级名称
     */
    @TableField(exist = false)
    private String parentName;

    @Override
    protected Serializable pkVal() {
        return menuId;
    }
}
