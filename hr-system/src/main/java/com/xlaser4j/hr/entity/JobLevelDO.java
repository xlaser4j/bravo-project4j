package com.xlaser4j.hr.entity;

import java.io.Serializable;
import java.util.Date;

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
@TableName("job_level")
public class JobLevelDO extends Model<JobLevelDO> {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 职称名称
     */
    private String name;

    /**
     * 职称级别
     * <p>
     * 数据库字段使用enum枚举类型处理,前后端仍然是字符串交互,前端写死枚举列表选择
     */
    private String level;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 是否启用
     */
    private Boolean enabled;

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
