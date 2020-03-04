package com.xlaser4j.hr.controller.sys;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.xlaser4j.hr.common.ApiResponse;
import com.xlaser4j.hr.entity.JobLevelDO;
import com.xlaser4j.hr.service.IJobLevelService;
import org.springframework.web.bind.annotation.*;

import static com.xlaser4j.hr.common.Status.*;

/**
 * @package: com.xlaser4j.hr.controller.sys
 * @author: Elijah.D
 * @time: 2020/3/4 16:50
 * @description: 职称相关, 不再使用vo,同时部分逻辑直接写在controller
 * @modified: Elijah.D
 */
@RestController
@RequestMapping("/sys/basic/levels")
public class JobLevelController {
    private final IJobLevelService service;

    public JobLevelController(IJobLevelService service) {
        this.service = service;
    }

    /**
     * 获取职称列表
     *
     * @return list
     */
    @GetMapping
    public ApiResponse<List<JobLevelDO>> listJobLevels() {
        return new ApiResponse<List<JobLevelDO>>().ofSuccess(service.list());
    }

    /**
     * 新增职称
     *
     * @param level
     * @return
     */
    @PostMapping
    public ApiResponse<String> saveJobLevel(@RequestBody JobLevelDO level) {
        level.setEnabled(true);
        level.setCreateAt(new Date());
        boolean flag = service.save(level);
        return flag ? new ApiResponse<String>().ofStatus(SAVE_SUCCESS) : new ApiResponse<String>().ofStatus(SAVE_FAIL);
    }

    /**
     * 编辑职称
     *
     * @param level
     * @return
     */
    @PutMapping
    public ApiResponse<String> updateJobLevelById(@RequestBody JobLevelDO level) {
        boolean flag = service.updateById(level);
        return flag ? new ApiResponse<String>().ofStatus(UPDATE_SUCCESS) : new ApiResponse<String>().ofStatus(UPDATE_FAIL);
    }

    /**
     * 删除职称信息
     *
     * @return
     */
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteJobLevelById(@PathVariable Integer id) {
        boolean flag = service.removeById(id);
        return flag ? new ApiResponse<String>().ofStatus(DELETE_SUCCESS) : new ApiResponse<String>().ofStatus(DELETE_FAIL);
    }

    /**
     * 批量删除职称信息
     *
     * @return
     */
    @DeleteMapping
    public ApiResponse<String> deleteJobLevelByIds(@RequestBody Integer[] ids) {
        boolean flag = service.removeByIds(Arrays.asList(ids));
        return flag ? new ApiResponse<String>().ofStatus(DELETE_SUCCESS) : new ApiResponse<String>().ofStatus(DELETE_FAIL);
    }
}
