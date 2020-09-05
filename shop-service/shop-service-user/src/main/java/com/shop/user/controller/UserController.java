package com.shop.user.controller;

import com.shop.entity.Result;
import com.shop.entity.StatusCode;
import com.shop.user.pojo.User;
import com.shop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @autor zyj
 * @date 2020/8/23 21:50
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     *
     * @param username
     * @return
     */
    @GetMapping("/load/{username}")
    public User findUserInfo(@PathVariable("username") String username){
        User user = userService.findById(username);
        return user;
    }

    /**
     * 查询所有用户
     * @return
     */
    public Result findAll(){
        List<User> userList = userService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",userList) ;
    }

    /**
     * 根据姓名查询
     * @param username
     * @return
     */
    @GetMapping("{username}")
    public Result findById(@PathVariable String username){
        User user = userService.findById(username);
        return new Result(true,StatusCode.OK,"查询成功",user);
    }


}
