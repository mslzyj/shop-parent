package com.shop.user.service;

import com.shop.user.pojo.User;

import java.util.List;

/**
 * @autor zyj
 * @date 2020/8/23 21:49
 */
public interface UserService {

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    User findById(String username);

    /***
     * 查询所有用户
     * @return
     */
    List<User> findAll();


    /***
     * 注册用户
     * @param user
     */
    void add(User user);

    /***
     * 修改
     * @param user
     */
    void update(User user);

    /***
     * 删除
     * @param username
     */
    void delete(String username);

}
