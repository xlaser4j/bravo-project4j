package com.xlaser4j.hr.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("hr_role")
public class HrRoleDO extends Model<HrRoleDO> {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * hrId
     */
    private Integer hid;

    /**
     * roleId
     */
    private Integer rid;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
