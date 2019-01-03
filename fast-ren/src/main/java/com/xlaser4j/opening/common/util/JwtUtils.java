package com.xlaser4j.opening.common.util;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * The type Jwt utils.
 *
 * @package: com.xlaser4j.opening.modules.app.util
 * @author: Elijah.D
 * @time: 2018/10/15 8:48
 * @description:
 * @modified: Elijah.D
 */
@Slf4j
@Component
@ConfigurationProperties(prefix = "fastren.jwt")
public class JwtUtils {
    /**
     * The Secret.
     */
    private String secret;

    /**
     * The Expire.
     */
    private long expire;

    /**
     * The Header.
     */
    private String header;

    /**
     * Generate token string.
     *
     * <p>创建token
     *
     * @param userId the user id
     * @return token string
     */
    public String generateToken(Long userId) {

        Date startTime = new Date();
        Date expireTime = new Date(startTime.getTime() + expire * 1000);

        return Jwts
                .builder()
                .setHeaderParam("typ", "JWT")
                .setIssuedAt(startTime)
                .setExpiration(expireTime)
                .setSubject(userId + "")
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * Gets claim by token.
     *
     * <p>获取声明
     *
     * @param token
     * @return the claim
     */
    public Claims getClaimByToken(String token) {

        try {
            return Jwts
                    .parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.debug("validate is token error ", e);
            return null;
        }
    }

    /**
     * Is token expired boolean.
     *
     * <p>验证 token 是否过期
     *
     * @param termination time
     * @return the boolean
     */
    public boolean isTokenExpired(Date termination) {

        return termination.before(new Date());
    }
}
