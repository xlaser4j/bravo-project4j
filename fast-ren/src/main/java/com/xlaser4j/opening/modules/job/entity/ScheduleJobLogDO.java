package com.xlaser4j.opening.modules.job.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

/**
 * <p>
 * M: 定时任务日志log模型
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.job.entity
 * @author: Elijah.D
 * @time: 2019/1/29 15:30
 * @description: log实体
 * @modified: Elijah.D
 */
@Data
@Builder
@TableName("schedule_job_log")
public class ScheduleJobLogDO implements Serializable {
    private static final long serialVersionUID = -3638446892610602283L;

    /**
     * 日志id
     */
    @TableId
    private Long logId;

    /**
     * 任务id
     */
    private Long jobId;

    /**
     * spring bean名称
     */
    private String beanName;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 参数
     */
    private String params;

    /**
     * 任务状态    0：成功    1：失败
     */
    private Integer status;

    /**
     * 失败信息
     */
    private String error;

    /**
     * 耗时(单位：毫秒)
     */
    private Integer times;

    /**
     * 创建时间
     */
    private Long createTime;
}
