package com.xlasers.opening.modules.sys.service;

import java.util.Collection;
import java.util.List;

import cn.hutool.core.lang.Dict;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xlasers.opening.modules.FastRenApplicationTests;
import com.xlasers.opening.modules.sys.entity.SysMenuDO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * sys: 权限相关测试类
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.service
 * @author: Elijah.D
 * @time: CreateAt 2018/12/28 && 17:17
 * @description: 测试plus相关
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@Slf4j
public class ServiceTests extends FastRenApplicationTests {
    @Autowired
    ISysMenuService menuService;

    /**
     * 测试map查询
     */
    @Test
    public void testByMap() {

        Collection<SysMenuDO> buttons = menuService.listByMap(Dict.create().set("type", 2));
        Assert.assertEquals(20, buttons.size());
        log.error("【buttons】:{}", buttons);

        Collection<SysMenuDO> catalog = menuService.listByMap(Dict.create().set("type", 0));
        Assert.assertEquals(1, catalog.size());
        log.error("【catalog】:{}", catalog);

        // type = 0
        Collection<SysMenuDO> menuOne = menuService.listByMap(Dict.create().set("parent_id", 0));
        Assert.assertEquals(1, menuOne.size());
        log.error("【menuOne】:{}", menuOne);

        // type = 1
        Collection<SysMenuDO> menuTwo = menuService.listByMap(Dict.create().set("type", 1));
        Assert.assertEquals(8, menuTwo.size());
        log.error("【menuTwo】:{}", menuTwo);

        // 同时满足的条件
        Collection<SysMenuDO> menu = menuService.listByMap(Dict.create().set("parent_id", 0).set("type", 1));
        Assert.assertEquals(0, menu.size());
        log.error("【menu】:{}", menu);
    }

    /**
     * 测试query查询
     */
    @Test
    public void testByWrapper() {
        QueryWrapper<SysMenuDO> query = new QueryWrapper<>();
        query.eq("type", 2);
        List<SysMenuDO> buttons = menuService.list(query);
        Assert.assertEquals(20, buttons.size());
        log.error("【buttons】:{}", buttons);

        query.eq("menu_id", 10);
        buttons = menuService.list(query);
        Assert.assertEquals(1, buttons.size());
        log.error("【buttons】:{}", buttons);
    }
}
