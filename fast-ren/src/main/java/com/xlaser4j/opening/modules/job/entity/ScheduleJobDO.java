package com.xlaser4j.opening.modules.job.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>
 * M: 定时job模型
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.job.entity
 * @author: Elijah.D
 * @time: 2019/1/29 15:30
 * @description: job实体
 * @modified: Elijah.D
 */
@Data
@TableName("schedule_job")
public class ScheduleJobDO implements Serializable {
    /**
     * 任务调度参数key
     */
    public static final String JOB_PARAM_KEY = "JOB_PARAM_KEY";

    private static final long serialVersionUID = 2676402663538732818L;

    /**
     * 任务id
     */
    @TableId
    private Long jobId;

    /**
     * spring bean名称
     */
    @NotBlank(message = "bean名称不能为空")
    private String beanName;

    /**
     * 方法名
     */
    @NotBlank(message = "方法名称不能为空")
    private String methodName;

    /**
     * 参数
     */
    private String params;

    /**
     * cron表达式
     */
    @NotBlank(message = "cron表达式不能为空")
    private String cronExpression;

    /**
     * 任务状态
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Long createTime;
}
