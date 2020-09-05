package com.shop.oauth;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

public class CreateJWTTest {

    /**
     * 测试加密
     */
    @Test
    public void createJWT(){
        //基于私钥生成jwt
        //1. 创建一个秘钥工厂
        //1: 指定私钥的位置
        ClassPathResource classPathResource = new ClassPathResource("shop1234.jks");
        //2: 指定秘钥库的密码
        String keyPass = "shop1234";
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(classPathResource,keyPass.toCharArray());

        //2. 基于工厂获取私钥   别名和密码
        String alias = "shop1234";
        String password = "shop1234";
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias, password.toCharArray());
        //将当前的私钥转换为rsa私钥  获取私钥
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();

        //3.生成jwt
        Map<String,String> map = new HashMap();
        map.put("company","shop");
        map.put("address","beijing");
        //要加密的数据，盐
        Jwt jwt = JwtHelper.encode(JSON.toJSONString(map), new RsaSigner(rsaPrivateKey));
        String jwtEncoded = jwt.getEncoded();
        System.out.println(jwtEncoded);
    }

    @Test
    public void testParseToken(){
        //jwt令牌
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJhZGRyZXNzIjoiYmVpamluZyIsImNvbXBhbnkiOiJzaG9wIn0.FhwTaPfYInMhpVEuHhUqSlml2R3O-BveDNdhWcGmEPV-eafiHN8doGSrPM1XdvLAj0esELuzA5qzmUG4JOmUIfTD1YLUOpKL-VI5eCVyplrGcJSaXoIKsrFox3jEHzc7hGVYc4qWs2Y6XwvJDXSjYkoIJ1edGfa7ky4Hw7srDC0S3p8HdFu1Ed6xPB7bcLfcZ_W9nIiCbIaunl7se1F6KudIfS0f3eJXwTCvfZ3Z0lO_Ulq-qnSxJn_Q9yNZfLxLfo10rkYWYPMVre7UadNQYafsdOjN8YyW7pHy01y80fMH3-QVjv8R7FTlXTlh27-6sU7nZRvDSdKyCZMIVnvFbA";
        String publicKey = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnTCHXiq8WaBq0L61pk5o4Zodle7hMFoEopYrKHIYs1bfxWB9GJbT/qrvrEZRsWqUQNvXEh2tbM0KFwlHWHCMNVnmcgXNF6et1hZ+ybtkoqjXjOH1RvLJH3LrVMPfPlyb22AhWpzJiLI8/1ydU2BA+CUuYGQOMHVMQxwRo+F0Tgjd4ZsGIrpSyiQFdBJ/A5SWWFhCWYGjzWKFZeePA6FpHXsdNX8EUzTQhpcNX4t79amJGok7t4F4Hy4m3yT7EKa87vYFNbT2SehJG6ZnRJLkfz0TXBg3oI/D8shHnY20vMbRfnmfXWxNM3ZgrTSnmc8I++dWxLPDcvfu05W9xkLywwIDAQAB-----END PUBLIC KEY-----";
        Jwt jwt = JwtHelper.decodeAndVerify(
          token,
          new RsaVerifier(publicKey)
        );
        String claims = jwt.getClaims();
        System.out.println(claims);
    }
}
