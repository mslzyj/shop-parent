package com.shop.user.service.impl;

import com.shop.user.dao.UserMapper;
import com.shop.user.pojo.User;
import com.shop.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @autor zyj
 * @date 2020/8/23 21:49
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(String username) {
        return  userMapper.selectByPrimaryKey(username);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectAll();
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void delete(String username) {
        userMapper.deleteByPrimaryKey(username);
    }
}
