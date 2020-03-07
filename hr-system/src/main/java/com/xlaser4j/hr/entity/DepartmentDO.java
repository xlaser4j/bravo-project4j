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
@TableName("department")
public class DepartmentDO extends Model<DepartmentDO> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 父级部门id
     */
    @TableField("parent_id")
    private Integer parentId;

    /**
     * 层级路径id,用于搜索
     */
    @TableField("dep_path")
    private String depPath;

    /**
     * 是否启用
     */
    private Boolean enabled;

    /**
     * 是否有下级(最后一级)
     */
    @TableField("is_parent")
    private Boolean parent;

    /**
     * 存储过程调用返回值接收(用于判断是否新增成功)
     */
    @TableField(exist = false)
    private Integer procedureResult;

    /**
     * 存储过程调用返回值接收(用于返回前端,动态加载tree)
     */
    @TableField(exist = false)
    private Integer insertId;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
