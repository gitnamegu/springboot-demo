package com.bong.springbootdemo.mapper.user;

import com.bong.springbootdemo.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author dabing
 * @create 2018/11/15
 * @since 1.0.0
 */
@Repository
public interface IUserMapper {

    int insert(User user);
}
