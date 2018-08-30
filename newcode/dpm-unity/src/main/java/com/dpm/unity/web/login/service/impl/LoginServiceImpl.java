package com.dpm.unity.web.login.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dpm.resource.common.enity.LoginUserInfo;
import com.dpm.resource.common.enity.TUserInfo;
import com.dpm.resource.common.utils.UUIDUtils;
import com.dpm.unity.common.token.JwtTokenService;
import com.dpm.unity.web.feigns.IUserFeignClient;
import com.dpm.unity.web.login.pojo.UserKey;
import com.dpm.unity.web.login.service.ILoginService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.Map;


@Service("loginServiceImpl")
@Primary

public class LoginServiceImpl implements ILoginService {


    @Autowired
    IUserFeignClient IUserFeignClient;
    @Autowired
    JwtTokenService jwtTokenService;


    private static final String CHARSET = "utf-8";

    /**
     * 用户登录接口
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    @Override
    public LoginUserInfo doLogin(TUserInfo userInfo) throws Exception {
        LoginUserInfo loginUserInfo = new LoginUserInfo();
        UserKey userKey = new UserKey();
        userKey.setPrefix(UUIDUtils.getUUID());//每次登录都标记为新设备
        userKey.setUserCode(userInfo.getUserCode());
        userKey.setPassword(DigestUtils.md5Hex(userInfo.getPassword()));

        JSONObject claims = new JSONObject();
        String userKeyString = new BASE64Encoder().encode(JSON.toJSONString(userKey).getBytes(CHARSET));
        claims.put("userkey", userKeyString);

        loginUserInfo.setToken(jwtTokenService.createToken(claims));
        loginUserInfo.setAutoLogin(false);
        userInfo.setPassword(userKey.getPassword());
        loginUserInfo.setUserInfo(userInfo);
        return IUserFeignClient.doLogin(loginUserInfo);
    }


    @Override
    public String getRefreshToken(String token) {
        return IUserFeignClient.getLoginToken(jwtTokenService.getTokenUserKey(token));
    }

    /**
     * 用户自动登录接口
     *
     * @param token
     * @return
     * @throws Exception
     */
    @Override
    public LoginUserInfo autoLogin(String token) throws Exception {

        LoginUserInfo loginUserInfo = new LoginUserInfo();

        DecodedJWT decodedJWT = JWT.decode(token);
        Map<String, Claim> claimMap = decodedJWT.getClaims();
        String userKey = claimMap.get("userkey").asString();
        BASE64Decoder decoder = new BASE64Decoder();
        UserKey userKeyObject = JSONObject.parseObject(new String(decoder.decodeBuffer(userKey), CHARSET), UserKey.class);
        TUserInfo tUserInfo = new TUserInfo();
        tUserInfo.setUserCode(userKeyObject.getUserCode());
        tUserInfo.setPassword(userKeyObject.getPassword());

        JSONObject claims = new JSONObject();
        claims.put("userkey", userKey);

        loginUserInfo.setToken(jwtTokenService.createToken(claims));
        loginUserInfo.setAutoLogin(true);
        loginUserInfo.setUserInfo(tUserInfo);

        return IUserFeignClient.doLogin(loginUserInfo);
    }

    /**
     * 用户登出接口
     *
     * @param token
     */
    @Override
    public void doLogout(String token) {
        IUserFeignClient.doLogout(token);
    }

}
