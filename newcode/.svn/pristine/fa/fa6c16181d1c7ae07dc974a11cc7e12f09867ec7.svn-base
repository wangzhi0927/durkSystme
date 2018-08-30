package com.dpm.web.common.token;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dpm.resource.common.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Map;

/**
 * @Author liuxiaoxin
 * @Descrpition
 * @Date 2018/4/30
 * @Modified By:
 */
@Component("jwtTokenService")
@PropertySource(value = "classpath:config/config.properties")
public class JwtTokenService {

    @Value("${jwt.expires.min}")
    private int expiresMinute;

    @Value("${jwt.secret}")
    private String secretKey;

    /**
     * 生成Token
     *
     * @param json
     * @return
     * @throws Exception
     */
    public String createToken(JSONObject json) throws Exception {
        return JWTUtils.createToken(json, expiresMinute, secretKey);
    }

    /**
     * 过期Token去Redis中校验，符合校验返回新Token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public String verifyRefreshToken(String token, String orginToken) throws Exception {
        if (StringUtils.isEmpty(token))
            throw new TokenExpiredException("token校验失败");
        DecodedJWT decodedJWT = JWT.decode(token);
        //token失效
        if (decodedJWT.getExpiresAt().before(new Date())) {
            String userKey = getTokenUserKey(token);
            String orginUserKey = getTokenUserKey(orginToken);
            if (userKey.equals(orginUserKey)) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("userkey", userKey);
                return createToken(jsonObject);
            }
            throw new TokenExpiredException("登陆信息已过期");
        } else {
            return token;
        }
    }

    public String getTokenUserKey(String token) {
        DecodedJWT decodedJWT = JWT.decode(token);
        Map<String, Claim> claimMap = decodedJWT.getClaims();
        return claimMap.get("userkey").asString();
    }
}
