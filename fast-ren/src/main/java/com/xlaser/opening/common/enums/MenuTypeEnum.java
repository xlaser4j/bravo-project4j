package com.xlaser.opening.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * E: 菜单类型常量
 * </p>
 *
 * @package: com.xlaser.opening.common.enums
 * @author: Elijah.D
 * @time: CreateAt 2019/1/29 && 18:51
 * @description: 类型常量
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@Getter
@AllArgsConstructor
public enum MenuTypeEnum {
    /**
     * 目录
     */
    CATALOG(0),
    /**
     * 菜单
     */
    MENU(1),
    /**
     * 按钮
     */
    BUTTON(2);

    private final int value;
}