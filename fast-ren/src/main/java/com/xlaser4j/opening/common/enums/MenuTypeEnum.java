package com.xlaser4j.opening.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 * E: 菜单类型常量
 * </p>
 *
 * @package: com.xlaser4j.opening.common.enums
 * @author: Elijah.D
 * @time: 2019/1/29 18:51
 * @description: 类型常量
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