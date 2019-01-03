package com.xlaser.opening.common;

import java.io.Serializable;
import java.math.RoundingMode;
import java.util.List;

import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * <p>
 * util: 分页工具类
 * </p>
 *
 * @package: com.xlaser.opening.common.util
 * @author: Elijah.D
 * @time: CreateAt 2019/1/3 && 10:33
 * @description: page分页辅助类
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@Data
public class PageResponse implements Serializable {
    private static final long serialVersionUID = -6032798161426027600L;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 当前页数
     */
    private int currentPage;

    /**
     * 每页记录数
     */
    private int pageSize;

    /**
     * 总页数
     */
    private int pages;

    /**
     * 列表数据
     */
    private List<?> list;

    /**
     * 分页构造
     *
     * @param total  总条数
     * @param pageSize    分页大小
     * @param currentPage 当前分页
     * @param list        列表数据
     */
    public PageResponse(long total, int pageSize, int currentPage, List<?> list) {
        this.total = total;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.list = list;
        pages = (int) NumberUtil.div(total, pageSize, 0, RoundingMode.UP);
    }

    /**
     * 分页构造
     *
     * @param page 分页模型
     */
    public PageResponse(IPage<?> page) {
        total = page.getTotal();
        pageSize = (int) page.getSize();
        pages = (int) page.getPages();
        currentPage = (int) page.getCurrent();
        list = page.getRecords();
    }
}
