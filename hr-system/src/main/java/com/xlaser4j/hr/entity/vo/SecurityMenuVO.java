package com.xlaser4j.hr.entity.vo;

import java.util.List;

import com.xlaser4j.hr.entity.RoleDO;
import lombok.Data;

/**
 * @package: com.xlaser4j.hr.entity.vo
 * @author: Elijah.D
 * @time: 2020/2/29 11:20
 * @description: 权限控制vo
 * @modified: Elijah.D
 */
@Data
public class SecurityMenuVO {
    /**
     * 后端url对应的ant模式pattern,方便security匹配路径判断角色信息
     */
    private String url;

    /**
     * url所需要的角色信息
     */
    private List<RoleDO> roles;
}
