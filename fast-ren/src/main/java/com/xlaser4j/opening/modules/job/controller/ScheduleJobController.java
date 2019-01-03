package com.xlaser4j.opening.modules.job.controller;

import java.util.Map;

import com.xlaser4j.opening.common.ApiResponse;
import com.xlaser4j.opening.common.PageResponse;
import com.xlaser4j.opening.modules.job.entity.ScheduleJobDO;
import com.xlaser4j.opening.modules.job.service.IScheduleJobService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * C: 定时任务job控制
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.job.controller
 * @author: Elijah.D
 * @time: 2019/1/29 15:31
 * @description: job控制器
 * @modified: Elijah.D
 */
@RestController
@RequestMapping("/schedule")
@AllArgsConstructor
public class ScheduleJobController {
    private final IScheduleJobService jobService;

    /**
     * 分页获取job列表
     *
     * @param params 参数集合
     * @return list结果集
     */
    @GetMapping("/jobs")
    public ApiResponse listSchedules(@RequestParam Map<String, Object> params) {

        PageResponse response = jobService.listScheduleJob(params);
        return ApiResponse.ofSuccess(response);
    }

    /**
     * 获取job信息
     *
     * @param jobId 主键
     * @return 实体DO
     */
    @GetMapping("/job/{jobId}")
    public ApiResponse getSchedule(@PathVariable("jobId") Long jobId) {

        ScheduleJobDO response = jobService.getById(jobId);
        return ApiResponse.ofSuccess(response);
    }
}
