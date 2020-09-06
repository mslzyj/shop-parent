package com.shop.oauth.util;

import com.alibaba.fastjson.JSON;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @autor zyj
 * @date 2020/9/6 12:01
 */
public class AdminToken {

    /**
     * 管理员令牌发放，发给其它服务
     * @return
     */
    public static String createJWT(){
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
        Map<String,Object> map = new HashMap();
        map.put("company","shop");
        map.put("address","beijing");
        map.put("authorities", new String[]{"admin","oauth"});
        //要加密的数据，盐
        Jwt jwt = JwtHelper.encode(JSON.toJSONString(map), new RsaSigner(rsaPrivateKey));
        String jwtEncoded = jwt.getEncoded();
        return jwtEncoded;
    }

}
