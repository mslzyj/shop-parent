package com.shop.oauth.util;

import java.io.Serializable;

/**
 * 封装对象存储登录返回的数据  方法：
 * com.shop.oauth.service.impl
 * .AuthServiceImpl#login(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
 * 返回的数据的封装
 */
public class AuthToken implements Serializable{

    //令牌信息 jwt
    String accessToken;
    //刷新token(refresh_token)
    String refreshToken;
    //jwt短令牌
    String jti;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }
}