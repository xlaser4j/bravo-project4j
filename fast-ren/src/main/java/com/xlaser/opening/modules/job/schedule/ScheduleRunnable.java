package com.xlaser.opening.modules.job.schedule;

import java.lang.reflect.Method;

import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.xlaser.opening.common.enums.Status;
import com.xlaser.opening.common.exception.FastRenException;
import com.xlaser.opening.common.util.SpringContextHolder;

/**
 * <p>
 * R: 定时任务线程
 * </p>
 *
 * @package: com.xlaser.opening.modules.job.schedule
 * @author: Elijah.D
 * @time: CreateAt 2019/2/18 && 17:07
 * @description: 线程执行类
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
public class ScheduleRunnable implements Runnable {
    /**
     * 定时任务目标对象
     */
    private final Object target;

    /**
     * 定时任务方法
     */
    private final Method method;

    /**
     * 定时任务方法参数
     */
    private final String params;

    /**
     * 构造器: 初始化定时任务相关参数
     *
     * @param beanName   对象名
     * @param methodName 方法名
     * @param params     方法参数
     */
    public ScheduleRunnable(String beanName, String methodName, String params) {
        target = SpringContextHolder.getBean(beanName);
        this.params = params;

        if (StrUtil.isBlank(params)) {
            method = ReflectUtil.getMethod(target.getClass(), methodName);
        } else {
            method = ReflectUtil.getMethod(target.getClass(), methodName, String.class);
        }
    }

    /**
     * 调用定时任务方法
     */
    @Override
    public void run() {
        try {
            if (StrUtil.isBlank(params)) {
                ReflectUtil.invoke(target, method);
            } else {
                ReflectUtil.invoke(target, method, params);
            }
        } catch (UtilException e) {
            throw new FastRenException(Status.SCHEDULE_JOB_FAILED);
        }
    }
}
