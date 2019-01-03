package com.xlaser4j.opening.modules.sys.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xlaser4j.opening.modules.sys.entity.SysUserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper: 系统用户
 * </p>
 *
 * @package: com.xlaser4j.opening.modules.sys.mapper
 * @author: Elijah.D
 * @time: 2018/10/11 17:01
 * @description: 持久层, 系统用户
 * @modified: Elijah.D
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserDO> {
    /**
     * <p> 获取用户下权限id集合
     *
     * @param id 用户id
     * @return list 权限集合
     */
    List<Long> selectMenuIdsByUserId(Long id);

    /**
     * <p> 获取用户权限name集合
     *
     * @param id 用户id
     * @return list 权限集合
     */
    List<String> selectPermsByUserId(Long id);
}
