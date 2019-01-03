package com.xlaser.opening.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlaser.opening.common.ApiResponse;
import com.xlaser.opening.modules.sys.entity.SysUserTokenDO;

/**
 * <p>
 * service: 系统用户Token
 * </p>
 *
 * @package: com.xlaser.opening.modules.sys.service
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 19:40
 * @description: 服务类, token设置
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
public interface ISysUserTokenService extends IService<SysUserTokenDO> {
    /**
     * 登陆生成token
     *
     * @param id 用户id
     * @return res token信息
     */
    ApiResponse createToken(Long id);

    /**
     * 退出登陆,修改token
     *
     * @param id 用户id
     */
    void updateToken(Long id);
}
