package com.xlaser4j.hr.controller.sys;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.xlaser4j.hr.common.ApiResponse;
import com.xlaser4j.hr.entity.PositionDO;
import com.xlaser4j.hr.service.IPositionService;
import org.springframework.web.bind.annotation.*;

import static com.xlaser4j.hr.common.Status.*;

/**
 * @package: com.xlaser4j.hr.controller.sys
 * @author: Elijah.D
 * @time: 2020/3/3 16:50
 * @description: 职位相关, 不再使用vo,同时部分逻辑直接写在controller
 * @modified: Elijah.D
 */
@RestController
@RequestMapping("/sys/basic/positions")
public class PositionController {
    private final IPositionService service;

    public PositionController(IPositionService service) {
        this.service = service;
    }

    /**
     * 获取职位列表
     *
     * @return list
     */
    @GetMapping
    public ApiResponse<List<PositionDO>> listPositions() {
        return new ApiResponse<List<PositionDO>>().ofSuccess(service.list());
    }

    /**
     * 新增职位
     *
     * @param position
     * @return
     */
    @PostMapping
    public ApiResponse<String> savePositions(@RequestBody PositionDO position) {
        position.setEnabled(true);
        position.setCreateAt(new Date());
        boolean flag = service.save(position);
        return flag ? new ApiResponse<String>().ofStatus(SAVE_SUCCESS) : new ApiResponse<String>().ofStatus(SAVE_FAIL);
    }

    /**
     * 编辑职位
     *
     * @param position
     * @return
     */
    @PutMapping
    public ApiResponse<String> updatePositionById(@RequestBody PositionDO position) {
        boolean flag = service.updateById(position);
        return flag ? new ApiResponse<String>().ofStatus(UPDATE_SUCCESS) : new ApiResponse<String>().ofStatus(UPDATE_FAIL);
    }

    /**
     * 删除职位信息
     *
     * @param id positionId
     * @return
     */
    @DeleteMapping("/{id}")
    public ApiResponse<String> deletePositionById(@PathVariable Integer id) {
        boolean flag = service.removeById(id);
        return flag ? new ApiResponse<String>().ofStatus(DELETE_SUCCESS) : new ApiResponse<String>().ofStatus(DELETE_FAIL);
    }

    /**
     * 批量删除职位信息
     *
     * @return
     */
    @DeleteMapping
    public ApiResponse<String> deletePositionByIds(@RequestBody Integer[] ids) {
        boolean flag = service.removeByIds(Arrays.asList(ids));
        return flag ? new ApiResponse<String>().ofStatus(DELETE_SUCCESS) : new ApiResponse<String>().ofStatus(DELETE_FAIL);
    }
}
