package com.xlaser.opening.modules.sys.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlaser.opening.common.ApiResponse;
import com.xlaser.opening.modules.sys.entity.SysUserTokenDO;
import com.xlaser.opening.modules.sys.mapper.SysUserTokenMapper;
import com.xlaser.opening.modules.sys.oauth2.TokenGenerator;
import com.xlaser.opening.modules.sys.service.ISysUserTokenService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * iml: 系统用户Token
 * </p>
 *
 * @package: com.xlaser.opening.modules.sys.service.impl
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 19:43
 * @description: 实现类, 系统token
 * @copyright: Copyright © 2018 xlaser
 * @version: V1.0
 * @modified: Elijah.D
 */
@Service
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenMapper, SysUserTokenDO> implements ISysUserTokenService {
    /**
     * token有效期24小时
     */
    private static final long TOKEN_VALID_TIME = 24 * 60 * 60 * 1000L;

    /**
     * 登陆生成token
     *
     * @param id 用户id
     * @return res token信息
     */
    @SuppressWarnings("ConstantConditions")
    @Override
    public ApiResponse createToken(Long id) {

        String token = TokenGenerator.generateToken();
        Long expireTime = DateUtil.current(false) + TOKEN_VALID_TIME;

        SysUserTokenDO userToken = getById(id);
        if (ObjectUtil.isNull(userToken)) {
            SysUserTokenDO newUserToken = new SysUserTokenDO().setUserId(id).setUpdateTime(DateUtil.current(false)).setToken(token).setExpireTime(expireTime);
            save(newUserToken);
        } else {
            userToken.setToken(token).setUpdateTime(DateUtil.current(false)).setExpireTime(expireTime);
            updateById(userToken);
        }

        return ApiResponse.ofSuccess(JSONUtil.createObj().put("token", token).put("expire", expireTime));
    }

    /**
     * 退出登陆,修改token
     *
     * @param id 用户id
     */
    @Override
    public void updateToken(Long id) {
        String token = TokenGenerator.generateToken();
        SysUserTokenDO userToken = new SysUserTokenDO().setUserId(id).setUpdateTime(DateUtil.current(false)).setToken(token);
        updateById(userToken);
    }
}
