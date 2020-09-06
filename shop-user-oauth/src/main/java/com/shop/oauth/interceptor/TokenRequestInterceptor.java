package com.shop.oauth.interceptor;

import com.shop.oauth.util.AdminToken;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * @autor zyj
 * @date 2020/9/6 11:55
 */
@Configuration
public class TokenRequestInterceptor implements RequestInterceptor {

    /**
     * fegin执行之前进行拦截
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        //生成admin令牌
        String token = AdminToken.createJWT();
        requestTemplate.header("Authoriztion","bear " + token);
    }
}
