package com.xlaser4j.hr.controller.sys;

import java.util.ArrayList;
import java.util.List;

import com.xlaser4j.hr.common.ApiResponse;
import com.xlaser4j.hr.common.Status;
import com.xlaser4j.hr.entity.DepartmentDO;
import com.xlaser4j.hr.entity.vo.TreeVO;
import com.xlaser4j.hr.service.IDepartmentService;
import org.springframework.web.bind.annotation.*;

import static com.xlaser4j.hr.common.Status.SAVE_FAIL;
import static com.xlaser4j.hr.common.Status.SAVE_SUCCESS;

/**
 * @package: com.xlaser4j.hr.controller.sys
 * @author: Elijah.D
 * @time: 2020/3/3 16:50
 * @description: 职位相关, 不再使用vo,同时部分逻辑直接写在controller
 * @modified: Elijah.D
 */
@RestController
@RequestMapping("/sys/basic/deps")
public class DepartmentController {
    private final IDepartmentService service;

    public DepartmentController(IDepartmentService service) {
        this.service = service;
    }

    /**
     * 获取部门列表树形数据
     *
     * @return list
     */
    @GetMapping("/tree")
    public ApiResponse<List<TreeVO>> listDepsTrees() {
        return new ApiResponse<List<TreeVO>>().ofSuccess(service.listDepsTrees());
    }

    /**
     * 新增部门
     * <p>
     * 这里需要返回新增的部门信息,构建成TreeVO用于前端渲染页面,直接concat到到部门树形上:listDepsTrees
     * <p>
     * 同时初始化children为空数组,否则前端连续新增挂在到children时还需要判断是否为null
     *
     * @param dep
     * @return
     */
    @PostMapping
    public ApiResponse<?> saveDep(@RequestBody DepartmentDO dep) {
        boolean flag = service.saveDepByProcedure(dep);
        TreeVO newNode = new TreeVO(dep.getInsertId(), dep.getName(), new ArrayList<>());
        return flag ? new ApiResponse<TreeVO>().ofStatus(SAVE_SUCCESS, newNode) : new ApiResponse<Void>().ofStatus(SAVE_FAIL);
    }

    /**
     * 删除部门信息
     *
     * @param id depId
     * @return
     */
    @DeleteMapping("/{id}")
    public ApiResponse<Void> deleteDep(@PathVariable Integer id) {
        Status status = service.deleteDepByProcedure(id);
        return new ApiResponse<Void>().ofStatus(status);
    }
}
