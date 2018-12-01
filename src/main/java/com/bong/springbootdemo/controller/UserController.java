package com.bong.springbootdemo.controller;

import com.bong.springbootdemo.pojo.User;
import com.bong.springbootdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dabing
 * @create 2018/11/11
 * @since 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 添加用户
     * @return
     */
    @RequestMapping("/insert")
    public String insert() {
        User user = new User();
        user.setName("zhangsan");
        user.setPassword("123456");
        int result = this.userService.insert(user);
        if (result > 0) {
            return "success";
        } else {
            return "false";
        }


    }

}
