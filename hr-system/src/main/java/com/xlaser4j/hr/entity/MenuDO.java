package com.xlaser4j.hr.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @package: com.xlaser4j.hr.entity
 * @author: Elijah.D
 * @time: 2020/2/9 17:27
 * @description:
 * @modified: Elijah.D
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("menu")
public class MenuDO extends Model<MenuDO> {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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
     * 菜单是否启用
     */
    private Boolean enabled;

    /**
     * 图标信息
     */
    @TableField("icon_cls")
    private String iconCls;

    /**
     * 上级id
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 组件是否自动销毁
     */
    @TableField("keep_alive")
    private Boolean keepAlive;

    /**
     * 是否需要权限
     */
    @TableField("require_auth")
    private Boolean requireAuth;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
