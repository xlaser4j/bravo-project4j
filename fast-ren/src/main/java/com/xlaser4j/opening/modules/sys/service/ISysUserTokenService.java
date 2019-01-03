package com.xlaser4j.opening.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xlaser4j.opening.common.ApiResponse;
import com.xlaser4j.opening.modules.sys.entity.SysUserTokenDO;

/**
 * <p>
 * service: 系统用户Token
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.service
 * @author: Elijah.D
 * @time: 2018/10/11 19:40
 * @description: 服务类, token设置
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
