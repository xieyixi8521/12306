package com.xyx.common.config.component;

import cn.hutool.system.UserInfo;
import com.xyx.common.util.constant.RedisConst;
import com.xyx.common.util.json.JSONs;
import com.xyx.common.util.tools.ReqUtil;
import com.xyx.index12306.model.user.entry.TUser;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UserContext {
    @Autowired
    RedisTemplate redisTemplate;

    public TUser getUserAuth() {
        HttpServletRequest request = ReqUtil.getOldRequest();
        if (request == null) {
            return null;
        }
        TUser tUser = new TUser();
        //1、如果cookie中带了用户标识信息；
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("token".equalsIgnoreCase(name)) {
                    String tokenValue = cookie.getValue();
                    if (StringUtils.hasText(tokenValue)) {
                        //去redis查询这个token对应的用户信息
                        String json = (String) redisTemplate.opsForValue().get(RedisConst.LOGIN_USER + tokenValue);
                        tUser = JSONs.jsonStrToObj(json, TUser.class);

                    }
                }
            }
        }
        //2、如果cookie中没有 ，看header
        if (tUser == null) {
            //尝试去 请求头 中获取
            String token = request.getHeader("token"); //大小写无所谓
            if (StringUtils.hasText(token)) {
                //去redis查询这个token对应的用户信息
                String json = (String) redisTemplate.opsForValue().get(RedisConst.LOGIN_USER + token);
                tUser = JSONs.jsonStrToObj(json, TUser.class);

            }
        }

        return tUser;
    }

    public String getToken() {
        HttpServletRequest request = ReqUtil.getOldRequest();
        if (request == null) {
            return null;
        }
        String token = null;
        //1、如果cookie中带了用户标识信息；
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("token".equalsIgnoreCase(name)) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        //2、如果cookie中没有 ，看header
        if (!StringUtils.hasText(token)) {
            //尝试去 请求头 中获取
            token = request.getHeader("token"); //大小写无所谓
        }
        return token;
    }
}
