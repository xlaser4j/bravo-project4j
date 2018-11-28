package com.xlasers.opening.modules.sys.oauth2;

import java.security.MessageDigest;
import java.util.UUID;

import com.xlasers.opening.common.enums.Status;
import com.xlasers.opening.common.exception.FastRenException;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>
 * generator: token生成器
 * </p>
 *
 * @package: com.xlasers.opening.modules.sys.oauth2
 * @author: Elijah.D
 * @time: CreateAt 2018/10/15 && 10:42
 * @description: 生成加密token
 * @copyright: Copyright © 2018 xlasers
 * @version: V1.0
 * @modified: Elijah.D
 */
@Slf4j
public class TokenGenerator {
    /**
     * 16进制数
     */
    private static final char[] HEX_CODE = "0123456789abcdef".toCharArray();

    private TokenGenerator() {
    }

    /**
     * <p> 生成token
     *
     * @return token 随机token
     */
    public static String generateToken() {

        return generateValue(UUID.randomUUID().toString());
    }

    /**
     * <p> 加密计算token
     *
     * @param data 随机token
     * @return res 加密值
     */
    public static String generateValue(String data) {

        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(data.getBytes());
            byte[] msgDigest = algorithm.digest();
            return toHexString(msgDigest);
        } catch (Exception e) {

            log.error("【TokenGenerator】生成Token失败 !");
            throw new FastRenException(Status.FAILED_CREATE_TOKEN);
        }
    }

    /**
     * To hex string string.
     *
     * <p> 生成16进制数
     *
     * @param data token字节
     * @return res 生成16进制
     */
    public static String toHexString(byte[] data) {

        if (data == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(data.length * 2);
        for (byte b : data) {
            builder.append(HEX_CODE[b >> 4 & 0xF]);
            builder.append(HEX_CODE[b & 0xF]);
        }

        return builder.toString();
    }
}
