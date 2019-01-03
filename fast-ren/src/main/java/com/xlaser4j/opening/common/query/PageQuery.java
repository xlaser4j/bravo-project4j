package com.xlaser4j.opening.common.query;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xlaser4j.opening.common.xss.SqlInjectFilter;
import lombok.Getter;

/**
 * <p>
 * query: 通用分页查询参数
 * </p>
 *
 * @package: com.xlaser4j.opening.common.util
 * @author: Elijah.D
 * @time: 2019/1/3 15:12
 * @description: 用于分页查询
 * @modified: Elijah.D
 */
@Getter
public class PageQuery<T> extends LinkedHashMap<String, Object> {
    private static final String CURRENT_PAGE = "currentPage";

    private static final String PAGE_SIZE = "pageSize";

    private static final long serialVersionUID = -8002003340382219100L;

    /**
     * mybatis-plus分页参数
     */
    private final Page<T> page;

    /**
     * 当前页码
     */
    private int currentPage = 1;

    /**
     * 每页条数
     */
    private int pageSize = 10;

    public PageQuery(Map<String, Object> params) {
        putAll(params);

        // 当前页码
        Object paramCurrentPage = params.get(CURRENT_PAGE);
        if (ObjectUtil.isNotNull(paramCurrentPage)) {
            currentPage = (int)paramCurrentPage;
        }

        // 分页大小
        Object paramPageSize = params.get(PAGE_SIZE);
        if (ObjectUtil.isNotNull(paramPageSize)) {
            pageSize = (int)paramPageSize;
        }

        // todo
        put("offset", (currentPage - 1) * pageSize);
        put("page", currentPage);
        put("limit", pageSize);

        // sql注入: 排序字段
        String sidx = String.valueOf(params.get("sidx"));
        sidx = SqlInjectFilter.validateSql(sidx);

        // sql注入: 排序规则
        String order = String.valueOf(params.get("order"));
        order = SqlInjectFilter.validateSql(order);
        put("sidx", sidx);
        put("order", order);

        page = new Page<>(currentPage, pageSize);
        if (!StrUtil.isAllBlank(sidx, order)) {
            if (StrUtil.equals("ASC", order, true)) {
                page.setAsc(sidx);
            } else {
                page.setDesc(sidx);
            }
        }
    }
}
