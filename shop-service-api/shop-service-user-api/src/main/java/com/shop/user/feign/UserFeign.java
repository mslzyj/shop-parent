package com.shop.user.feign;

import com.shop.user.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @autor zyj
 * @date 2020/8/23 21:42
 */
@FeignClient(name = "user")
public interface UserFeign {

    @GetMapping("/user/load/{username}")
    User findUserInfo(@PathVariable("username") String username);
}
