package com.dpm.resource.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author liuxiaoxin
 * @Descrpition
 * @Date 2018/4/30
 * @Modified By:
 */
public class JWTUtils {
    /**
     * 生成Token
     *
     * @param json
     * @return
     * @throws Exception
     */
    private static final HashMap<String, Object> header = new HashMap<String, Object>() {
        {
            put("alg", "HS256");
            put("typ", "JWT");
        }
    };

    /**
     * 生成Token
     * @param json
     * @param expiresMin
     * @param secret
     * @return
     * @throws Exception
     */
    public static String createToken(JSONObject json, int expiresMin, String secret) throws Exception {
        Date iatDate = new Date();

        Calendar expiresDate = Calendar.getInstance();
        expiresDate.setTime(iatDate);
        expiresDate.add(Calendar.MINUTE, expiresMin);

        JWTCreator.Builder builder = JWT.create().withHeader(header).withIssuedAt(iatDate).withExpiresAt(expiresDate.getTime());
        json.forEach((key, value) -> builder.withClaim(key, String.valueOf(value)));

        return builder.sign(Algorithm.HMAC256(secret));
    }

}
