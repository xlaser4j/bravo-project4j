package com.xlaser4j.opening.modules.sys.oauth2;

import lombok.AllArgsConstructor;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * The type token.
 *
 * @package: com.xlaser4j.opening.modules.sys.oauth2
 * @author: Elijah.D
 * @time: 2018/10/15 10:58
 * @description: token
 * @modified: Elijah.D
 */
@AllArgsConstructor
public class OauthToken implements AuthenticationToken {
    private static final long serialVersionUID = 7196595157510578548L;

    /**
     * The Token.
     */
    private final String token;

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {

        // return token;
        return getPrincipal();
    }
}
