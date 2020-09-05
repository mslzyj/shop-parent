package com.shop.oauth.service;


import com.shop.oauth.util.AuthToken;

public interface AuthService {

    AuthToken login(String username, String password, String clientId, String clientSecret);
}
