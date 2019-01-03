package com.xlaser4j.opening.modules.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlaser4j.opening.modules.sys.entity.SysUserTokenDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 系统用户Token Mapper 接口
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.mapper
 * @author: Elijah.D
 * @time: 2018/10/11 17:03
 * @description:
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
