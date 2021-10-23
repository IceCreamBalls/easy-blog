package com.ice.easy.blog.user.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {
    /**
     * 生成token
     *
     * @param userinfo
     * @param salt
     * @param expire
     * @return
     */
    public static String generateTokenExpireInMinutes(JSONObject userinfo, String salt, int expire) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, expire);

        return JWT.create()
                .withClaim("username", userinfo.getString("username") == null ? "" : userinfo.getString("username"))
                .withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(salt));
    }

    /**
     *
     * @param token
     * @param salt
     * @return
     */
    public static JSONObject getInfoFromToken(String token, String salt) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(salt)).build();
        DecodedJWT verify = jwtVerifier.verify(token);

        JSONObject res = new JSONObject();
        res.put("username", verify.getClaim("username").asString());

        return  res;
    }
}
