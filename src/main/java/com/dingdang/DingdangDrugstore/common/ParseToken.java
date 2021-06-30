package com.dingdang.DingdangDrugstore.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.dingdang.DingdangDrugstore.error.BusinessException;
import com.dingdang.DingdangDrugstore.error.EmBusinessError;

/**
 * @author Kyrie17
 * @version 1.0
 * @date 2021/4/4 13:01
 */
public class ParseToken {

    public static Long getUserId(String token) throws BusinessException {
        // 执行认证
        if (token == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        // 获取 token 中的 user id
        Long userId;
        try {
            userId =  Long.valueOf(JWT.decode(token).getAudience().get(0));
        } catch (JWTDecodeException j) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        return userId;
    }
}
