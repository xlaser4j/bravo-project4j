package com.xlaser.opening.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * E: 定时任务状态常量
 * </p>
 *
 * @package: com.xlaser.opening.common.enums
 * @author: Elijah.D
 * @time: CreateAt 2019/1/29 && 18:52
 * @description: 状态常量
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@Getter
@AllArgsConstructor
public enum ScheduleStatusEnum {
    /**
     * 正常
     */
    NORMAL(0),
    /**
     * 暂停
     */
    PAUSE(1);

    private final int value;
}
