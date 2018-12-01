package com.bong.springbootdemo.service.impl;

import com.bong.springbootdemo.mapper.user.IUserMapper;
import com.bong.springbootdemo.pojo.User;
import com.bong.springbootdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dabing
 * @create 2018/11/15
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public int insert(User user) {
        return this.userMapper.insert(user);
    }
}
