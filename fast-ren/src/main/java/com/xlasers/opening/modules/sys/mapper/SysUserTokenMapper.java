package com.xlasers.opening.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlasers.opening.modules.sys.entity.SysUserTokenDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统用户Token Mapper 接口
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.mapper
 * @author: Elijah.D
 * @time: CreateAt 2018/10/11 && 17:03
 * @description:
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@Mapper
public interface SysUserTokenMapper extends BaseMapper<SysUserTokenDO> {
    /**
     * Select userToken by token.
     *
     * @param token
     * @return tokenInfo
     */
    SysUserTokenDO selectUserTokenByToken(String token);
}
