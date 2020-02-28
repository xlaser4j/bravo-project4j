package com.xlaser4j.hr.entity.vo;

import lombok.Data;

/**
 * @package: com.xlaser4j.hr.entity.vo
 * @author: Elijah.D
 * @time: 2020/2/28 22:28
 * @description:
 * @modified: Elijah.D
 */
@Data
public class Meta {
    /**
     * 前端vue组件切换时,是否保存(默认是自动销毁重建,对于tab页的切换,可能不需要自动销毁创建,浪费性能)
     */
    private Boolean keepAlive;

    private Boolean requireAuth;
}
