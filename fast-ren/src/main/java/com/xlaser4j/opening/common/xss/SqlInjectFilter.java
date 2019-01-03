package com.xlaser4j.opening.common.xss;

import java.util.List;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import com.xlaser4j.opening.common.enums.Status;
import com.xlaser4j.opening.common.exception.FastRenException;

/**
 * <p>
 * filter: 过滤sql防止注入攻击
 * </p>
 *
 * @package: com.xlaser4j.opening.common.xss
 * @author: Elijah.D
 * @time: 2019/1/3 15:26
 * @description: 用于sql过滤
 * @modified: Elijah.D
 */
public class SqlInjectFilter {
    /**
     * sql注入预检查
     *
     * @param sql sql语句
     * @return 校验后的结果
     */
    public static String validateSql(String sql) {

        if (StrUtil.isBlank(sql)) {
            return null;
        }

        // 特殊字符
        sql = StrUtil.replace(sql, ",", "");
        sql = StrUtil.replace(sql, ";", "");
        sql = StrUtil.replace(sql, "\"", "");
        sql = StrUtil.replace(sql, "\\", "");

        // 非法关键字
        List<String> keywords = Lists.newArrayList("master", "truncate", "insert", "select", "delete", "update", "declare", "alert", "drop");

        String finalSql = sql;
        keywords.forEach(o -> {
            if (ObjectUtil.equal(StrUtil.indexOf(finalSql, o, 0, true), -1)) {
                throw new FastRenException(Status.ILLEGAL_SQL_WORDS);
            }
        });

        return sql;
    }
}
