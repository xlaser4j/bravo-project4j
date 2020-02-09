package com.xlaser4j.hr.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
@TableName("joblevel")
public class JoblevelDO extends Model<JoblevelDO> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 职称名称
     */
    private String name;

    @TableField("titleLevel")
    private String titleLevel;

    @TableField("createDate")
    private LocalDateTime createDate;

    private Boolean enabled;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
